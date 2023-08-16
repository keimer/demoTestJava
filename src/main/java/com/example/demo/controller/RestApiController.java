package com.example.demo.controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.interfaces.GetClient;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/usuario")
@Slf4j
public class RestApiController implements GetClient {
	
	private static final String URL = "https://63076d52c0d0f2b8012f51cb.mockapi.io/api/v1/usuarios";
	
	@GetMapping("/all")
	public List<ResponseDTO> getAll() {
		
		log.info("Inicio petición :  '"+ URL +"'");
		try {
			HttpClient cliente = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(URL))
					.GET()
					.build();
	        	
			HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
			if(response.statusCode() != 200) {
				log.info("Resultado EstatusCode: " + response.statusCode());
				log.info("Resultado petición : " + URL + " = " + response.body() + "\n");
			} else {
				log.info("Resultado EstatusCode: " + response.statusCode());
				log.info("Resultado petición : " + URL + " = " + response.body() + "\n");
				
				Gson gson = new Gson();
				ResponseDTO[] data = gson.fromJson(response.body(), ResponseDTO[].class);
								
				List<ResponseDTO> list = Arrays.asList(data);
				List<ResponseDTO> filterList = list.stream()
						.filter((i) -> i.getName().contains("Mitchell") || i.getName().contains("Harris"))
						.map(i->i)
						.collect(Collectors.toList());
				
				List<ResponseDTO> orderList = filterList.stream().sorted(Comparator.comparing(ResponseDTO::getId)).map(i->i).collect(Collectors.toList());
				return orderList;
				
			}
		} catch (Exception e) {
			log.error("Error en la llamada: ", e);
		}
		return null;
	}
}
