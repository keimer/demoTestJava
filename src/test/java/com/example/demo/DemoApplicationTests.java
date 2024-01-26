package com.example.demo;

import com.example.demo.controller.UsersController;
import com.example.demo.entity.CustomUserRecord;
import com.example.demo.service.IUser;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@InjectMocks
	private UsersController usersController;

	@Mock
	private IUser iUser;

	@Test
	void contextLoads() {
		Mockito.when(iUser.getUsers(Mockito.any(), Mockito.any())).thenReturn(
				List.of(new CustomUserRecord("", "")));
		var response = usersController.getUsers(false, false);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

}