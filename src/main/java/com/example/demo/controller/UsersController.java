package com.example.demo.controller;

import com.example.demo.aspects.MarcaAop;
import com.example.demo.entity.CustomUserRecord;
import com.example.demo.service.IUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
@RequiredArgsConstructor
public class UsersController {

    private final IUser iUser;

    @MarcaAop
    @GetMapping("/users/all")
    public ResponseEntity<List<CustomUserRecord>> getUsers(@RequestParam(name = "createdAt") boolean filterByCreatedAt,
                                                           @RequestParam(name = "id") boolean filterById) {
        return ResponseEntity.ok(iUser.getUsers(filterByCreatedAt, filterById));
    }

}
