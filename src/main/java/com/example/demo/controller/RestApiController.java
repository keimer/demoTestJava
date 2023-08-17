package com.example.demo.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.interfaces.IFeignClient;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/usuario")
@Slf4j
public class RestApiController implements IFeignClient {
	
	private static final String URL = "https://63076d52c0d0f2b8012f51cb.mockapi.io/api/v1/usuarios";
	
	@Autowired
	IFeignClient feignClient;
	
	@GetMapping("/all")
	public List<ResponseDTO> getAll() {
		
		log.info("Inicio petición :  '"+ URL +"'");
		try {
			
			List<ResponseDTO> listTest = feignClient.getAll();
			List<ResponseDTO> filterList = listTest.stream()
						.filter((i) -> i.getName().contains("Mitchell") || i.getName().contains("Harris"))
						.map(i->i)
						.collect(Collectors.toList());
				
			List<ResponseDTO> orderList = filterList.stream()
					.sorted(Comparator.comparing(ResponseDTO::getId))
					.map(i->i)
					.collect(Collectors.toList());
			return orderList;
				
		} catch (Exception e) {
			log.error("Error en la llamada: ", e);
		}
		return null;
	}
}
