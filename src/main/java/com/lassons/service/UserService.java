package com.lassons.service;

import com.lassons.entity.Customer;
import com.lassons.entity.WebLogin;

/**
 * Created by pjkant on 1/10/16.
 */
public interface UserService {

	Customer save(Customer user);
	Customer find(Customer user);
}
