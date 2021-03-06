package com.lassons;

import com.lassons.domain.Approval;
import com.lassons.entity.Address;
import com.lassons.entity.Customer;
import com.lassons.entity.WebLogin;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan
//@EnableJpaRepositories(basePackages = {"com.lassons.repository"})
//@ComponentScan("com.lassons")

public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		Customer customer  = new Customer();
        Approval approval = new Approval();
        ArrayList<Approval> appList = new ArrayList<>();
        appList.add(approval);
        appList.add(approval);

		ArrayList<Address> addList = new ArrayList<>();

		addList.add(new Address());
		customer.setAddressList(addList);
        customer.setWeblogin(new WebLogin());


		ObjectMapper mapper = new ObjectMapper();
		try
		{
			//mapper.writeValue(new File("/Users/petejayakant/customer.json"), customer); // converts java to json.
            mapper.writeValue(new File("/Users/petejayakant/approvals.json"), appList); // converts java to json.
		} catch (JsonGenerationException e)
		{
			e.printStackTrace();
		} catch (JsonMappingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
