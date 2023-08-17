package com.example.demo.interfaces;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.ResponseDTO;

@FeignClient(name="get", url="https://63076d52c0d0f2b8012f51cb.mockapi.io/api/v1/usuarios")
public interface IFeignClient {
	
	@GetMapping()
	public List<ResponseDTO> getAll();

}
