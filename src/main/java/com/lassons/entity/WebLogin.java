package com.lassons.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Parameter;


/**
 * Created by pjkant on 1/10/16.
 */


@Entity
public class WebLogin {


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="userName", nullable=false, updatable = false,unique = true)
	@NotNull
	@Size(max=50)
	private String userName;

	@Column(name = "password", nullable = false)
	@NotNull
	@Size(max = 64)
	private String password;

    @Id
    @Column(name="customer_id", unique=true, nullable=false)
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="customer"))
    private Long customerId;


   // public Customer getCustomer() {
    //    return customer;
    //}

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @OneToOne
    @PrimaryKeyJoinColumn
    //@JsonIgnore
    //@JsonManagedReference
    private Customer customer;





}