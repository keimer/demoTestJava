package com.example.demo.interfaces;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

import com.example.demo.dto.ResponseDTO;

@FeignClient(name="get", url="https://63076d52c0d0f2b8012f51cb.mockapi.io/api/v1/usuarios")
public interface GetClient {
	
	public List<ResponseDTO> getAll();

}
