package com.example.demo.interfaces;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

import com.example.demo.dto.ResponseDTO;

@FeignClient(name="posts", url="https://jsonplaceholder.typicode.com")
public interface GetClient {
	
	public List<ResponseDTO> getAll();

}
