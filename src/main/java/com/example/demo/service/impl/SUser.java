package com.example.demo.service.impl;

import com.example.demo.client.UsersClient;
import com.example.demo.entity.CustomUserRecord;
import com.example.demo.entity.UserRecord;
import com.example.demo.service.IUser;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor

public class SUser implements IUser {

    private static final Function<List<UserRecord>, List<UserRecord>> filterByHarrysContains = users ->
            users.stream()
                    .filter(user -> user.name().contains("Harris"))
                    .collect(Collectors.toList());

    private static final Function<List<UserRecord>, List<CustomUserRecord>> wrapperMapUserList = users ->
            users.stream()
                    .map(user -> new CustomUserRecord(user.rut(), user.name()))
                    .collect(Collectors.toList());

    private final UsersClient usersClient;

    @Override
    public List<CustomUserRecord> getUsers(boolean filterByCreatedAt, boolean filterById) {
        var usuarios = usersClient.getAllUsers();
        var usersHarry = filterByHarrysContains.apply(usuarios);
        if(filterByCreatedAt) {
            usersHarry = usersHarry.stream()
                    .sorted(Comparator.comparing(UserRecord :: createdAt))
                    .collect(Collectors.toList());
        }
        if(filterById) {
            usersHarry = usersHarry.stream()
                    .sorted(Comparator.comparing(UserRecord :: id))
                    .collect(Collectors.toList());
        }
        var userMapped = wrapperMapUserList.apply(usersHarry);
        return userMapped;
    }

}