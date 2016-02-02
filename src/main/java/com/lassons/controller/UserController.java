package com.lassons.controller;

import com.lassons.entity.Customer;
import com.lassons.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by pjkant on 1/10/16.
 */


@RestController
@RequestMapping(value = "/user")
public class UserController {


//	@Autowired
	private  UserService userService;

	@Autowired
	public UserController(final UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public  @ResponseBody
	Customer findUser(@PathVariable("id") Long id) {
		Customer user = new Customer();
		user.setCustId(id);
		return userService.find(user);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public  @ResponseBody
	Customer createUser(@RequestBody @Valid final Customer user) {
        user.getWeblogin().setCustomer(user);

		return userService.save(user);
	}

}
