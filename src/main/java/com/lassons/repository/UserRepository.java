package com.lassons.repository;

import com.lassons.entity.Customer;
import com.lassons.entity.WebLogin;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by pjkant on 1/10/16.
 */
public interface UserRepository  extends CrudRepository<Customer, Long> {
}
