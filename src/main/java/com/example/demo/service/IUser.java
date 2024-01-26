package com.example.demo.service;

import com.example.demo.entity.CustomUserRecord;

import java.util.List;

public interface IUser {

    List<CustomUserRecord> getUsers(boolean filterByCreatedAt, boolean filterById);

}