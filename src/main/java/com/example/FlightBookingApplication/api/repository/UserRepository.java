package com.example.FlightBookingApplication.api.repository;

import java.util.HashMap;
import java.util.Map;

import com.example.FlightBookingApplication.api.models.Users;

public class UserRepository {
	private static final UserRepository instance = new UserRepository();

	public static UserRepository getInstance() {
		return instance;
	}

	private final Map<String, Users> userMap;

	private UserRepository() {
		userMap = new HashMap();
	}

	public String addUser(Users user) {
		userMap.put(user.getUserId(), user);
		return userMap.get(user.getUserId()).getUserId();
	}

	public Map<String, Users> getAllUsers() {
		return new HashMap(userMap);
	}

	public Users getUserById(String userId) {
		return userMap.get(userId);
	}
}
