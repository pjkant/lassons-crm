package com.lassons.service;

import com.lassons.entity.Customer;
import com.lassons.entity.WebLogin;
import com.lassons.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by pjkant on 1/10/16.
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private  UserRepository repository;

	@Inject
	public UserServiceImpl(final UserRepository repository) {
		this.repository = repository;
	}


	@Override
	@Transactional
	public Customer save(final Customer user) {

		return repository.save(user);
	}

	@Override
	public Customer find(final Customer user ) {
		 return repository.findOne(user.getCustId());

	}

}
