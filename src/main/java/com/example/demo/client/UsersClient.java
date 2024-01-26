package com.example.demo.client;

import com.example.demo.entity.UserRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "Users-Client", url = "https://64f651fc2b07270f705e62c0.mockapi.io",
path = "/v1/users")
public interface UsersClient {

    @GetMapping
    List<UserRecord> getAllUsers();

}