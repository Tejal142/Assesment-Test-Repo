package com.test.service;

import java.util.List;

import com.test.entity.User;

public interface UserService {

	public List<User> userDetailsAll();

	public User update(User user, long parseLong);

	public List<User> getAllUsersData();

	

}
