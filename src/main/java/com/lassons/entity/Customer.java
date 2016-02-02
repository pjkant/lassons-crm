package com.lassons.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.xml.ws.WebEndpoint;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by pjkant on 1/17/16.
 */
@Entity
@Table(name="CUSTOMER")


public class Customer {

	public Long getCustId() {
		return id;
	}

	public void setCustId(Long custId) {
		this.id = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {

		return country;
	}

    public Collection<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(Collection<Address> addressList) {
        this.addressList = addressList;
    }

    @ElementCollection
    @JoinTable(name="user_address")
	private Collection<Address> addressList = new ArrayList<Address>();


    public WebLogin getWeblogin() {
        return weblogin;
    }

    public void setWeblogin(WebLogin weblogin) {
        this.weblogin = weblogin;
    }


    @OneToOne(mappedBy="customer", cascade=CascadeType.ALL)
    //@JsonBackReference
    private WebLogin weblogin;


	public void setCountry(String country) {
		this.country = country;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMERS_SEQ")
    @SequenceGenerator(name = "CUSTOMERS_SEQ", sequenceName = "CUSTOMERS_SEQ")
	private Long id;

	private String firstName;
	private String lastName;
	private String country;


}
