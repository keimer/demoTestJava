package com.example.demo.controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDTO;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/usuario")
@Slf4j
public class RestApiController {
		
	@GetMapping("/all")
	//@ResponseBody
	public Optional<HttpResponse<String>> getAll() {
		
		String url = "https://63076d52c0d0f2b8012f51cb.mockapi.io/api/v1/usuarios";
		log.info("Inicio petición :  '"+ url +"'");
		try {
			HttpClient cliente = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(url))
					.GET()
					.build();
	        	
			HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
			if(response.statusCode() != 200) {
				log.info("Resultado EstatusCode: " + response.statusCode());
				log.info("Resultado petición : " + url + " = " + response.body() + "\n");
			} else {
				log.info("Resultado EstatusCode: " + response.statusCode());
				log.info("Resultado petición : " + url + " = " + response.body() + "\n");
				
				Gson gson = new Gson();
				ResponseDTO[] data = gson.fromJson(response.body(), ResponseDTO[].class);
				
				System.out.println(data[0].getAvatar());
				System.out.println(data[0].getCreatedAt());
				System.out.println(data[0].getName());
				System.out.println(data[0].getId());
				
				List<ResponseDTO> list = Arrays.asList(data);
				//list.stream().filter((i) -> i.getName().contains(url) )
				
				
		        return Optional.of(response);
			}
		} catch (Exception e) {
			log.error("Error en la llamada: ", e);
		}
		return Optional.empty();
		
	}
}
