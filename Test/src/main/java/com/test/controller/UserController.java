package com.test.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.User;
import com.test.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/userDetailsDataCount", produces = MediaType.APPLICATION_JSON_VALUE)
	public int getAllUsersDataCount(@RequestBody List<User> usersReq) {
		List<User> userData = usersReq;

		int userDataCount = userData.size();
		System.out.println("Count list-----" + userDataCount);
		return userDataCount;
	}

	@GetMapping(value = "/userUniqueIds", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getuserUniqueIdsCount(@RequestBody List<User> usersReq, int ArrayList) {
		List<User> userData = usersReq;

		List<User> UniqueNumbers = userData.stream().distinct().collect(Collectors.toList());
		System.out.println("Unique Values of ArrayList" + UniqueNumbers);

		for (int i = 0; i < UniqueNumbers.size(); ++i) {
			System.out.println(UniqueNumbers.get(i));
			long returnUserIds = UniqueNumbers.get(0).getUserId();
			ArrayList<Integer> uniqueIds = new ArrayList<>();
			uniqueIds.add((int) returnUserIds);
		}
		return UniqueNumbers;

	}

	@GetMapping(value = "/userDetailsData", produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<User> getAllUsersData(@RequestBody List<User> usersReq) {
		List<User> userDataRes = this.userService.getAllUsersData();
		Set<User> inputSet = new HashSet<User>(userDataRes);
		return inputSet;

	}

	@PutMapping(value = "/usersForUpdate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> update(@RequestBody List<User> usersReq) {
		List<User> userData = usersReq;
		User userupdated = new User();

		for (int i = 0; i < userData.size(); ++i) {
			System.out.println(userData.get(i));
			if (userupdated.getId() == 4) {
				userupdated.setBody("1800Flowers");
				userupdated.setTitle("1800Flowers");
				userData.add(userupdated);
				System.out.println("Updated json with title and body :" + userupdated);
			}
		}
		return userData;

	}

}
