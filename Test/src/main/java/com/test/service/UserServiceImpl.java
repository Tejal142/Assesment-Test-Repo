package com.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.User;

@Service
public class UserServiceImpl implements UserService{


	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<User> userDetailsAll() {
	//	List<User> users = userRepo.findAll();
		return null;
	}

	@Override
	public User update(User user, long parseLong) {
		Optional<User> opContactEntity = userRepo.findById(parseLong);
		User uEntity = opContactEntity.get();
		uEntity.setBody("1800Flowers");
		uEntity.setTitle("1800Flowers");
		uEntity = userRepo.save(uEntity);
			return uEntity;
		}

	@Override
	public List<User> getAllUsersData() {
		List<User> userData = (List<User>) userRepo.findAll();
		return userData;
	}
		
}
