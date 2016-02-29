package com.lassons.controller;

import com.lassons.domain.Approval;
import com.lassons.entity.Customer;
import com.lassons.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

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

    @CrossOrigin
    @RequestMapping(value = "/loadApprovals", method = RequestMethod.GET)
    public  @ResponseBody
    List loadApprovals() {
        List<Approval> approvalList = new ArrayList<>();
        Approval approval = new Approval();
        approval.setCustomerId("111111");
        approval.setAuthorize("P");
        approval.setKey("CommVol Adjust");
        approval.setNewValue("200.00");
        approval.setOldValue("90.00");
        approval.setRequestedBy("Pete J");
        approval.setRequestDate(new Date());
        approval.setCountry("US");
        approval.setCommentFlag(false);
        approvalList.add(approval);



        approval = new Approval();
        approval.setCustomerId("222222");
        approval.setAuthorize("P");
        approval.setKey("CommVol Adjust");
        approval.setNewValue("245.00");
        approval.setOldValue("12.00");
        approval.setRequestedBy("Pete J");
        approval.setRequestDate(new Date());
        approval.setCountry("US");
        approval.setCommentFlag(false);
        approvalList.add(approval);


        approval = new Approval();
        approval.setCustomerId("333333");
        approval.setAuthorize("P");
        approval.setKey("Qual Adjust");
        approval.setNewValue("2340.99");
        approval.setOldValue("14091.11");
        approval.setRequestedBy("Mike H");
        approval.setRequestDate(new Date());
        approval.setCountry("FR");
        approval.setCommentFlag(false);
        approvalList.add(approval);

        approval = new Approval();
        approval.setCustomerId("444444");
        approval.setAuthorize("P");
        approval.setKey("Qual Adjust");
        approval.setNewValue("200.00");
        approval.setOldValue("90.00");
        approval.setRequestedBy("AnnMarie ");
        approval.setRequestDate(new Date());
        approval.setCountry("TH");
        approval.setCommentFlag(false);
        approvalList.add(approval);



        approval = new Approval();
        approval.setCustomerId("555555");
        approval.setAuthorize("P");
        approval.setKey("Comm Adjust");
        approval.setNewValue("189.00");
        approval.setOldValue("12.00");
        approval.setRequestedBy("Jason w");
        approval.setRequestDate(new Date());
        approval.setCountry("PH");
        approval.setCommentFlag(false);
        approvalList.add(approval);

        approval = new Approval();
        approval.setCustomerId("666666");
        approval.setAuthorize("P");
        approval.setKey("CommVol Adjust");
        approval.setNewValue("200.00");
        approval.setOldValue("90.00");
        approval.setRequestedBy("David F");
        approval.setCountry("ID");
        approval.setRequestDate(new Date());
        approval.setCommentFlag(false);
        approvalList.add(approval);


        approval = new Approval();
        approval.setCustomerId("777777");
        approval.setAuthorize("P");
        approval.setKey("CommVol Adjust");
        approval.setNewValue("2900.00");
        approval.setOldValue("80.00");
        approval.setRequestedBy("Zach B");
        approval.setCountry("ID");
        approval.setRequestDate(new Date());
        approval.setCommentFlag(false);
        approvalList.add(approval);

        approval = new Approval();
        approval.setCustomerId("888888");
        approval.setAuthorize("P");
        approval.setKey("CommVol Adjust");
        approval.setNewValue("200.00");
        approval.setOldValue("90.00");
        approval.setRequestedBy("Charlie ");
        approval.setCountry("FR");
        approval.setRequestDate(new Date());
        approval.setCommentFlag(false);
        approvalList.add(approval);
        return approvalList;
    }


	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public  @ResponseBody
	Customer createUser(@RequestBody @Valid final Customer user) {
        user.getWeblogin().setCustomer(user);

		return userService.save(user);
	}

    @CrossOrigin
    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public  @ResponseBody
    Map dataDump(@RequestBody @Valid final List<Approval> approvals) {
        Map<String,String> response = new HashMap<>();

        if(approvals!=null) {

            approvals.forEach(app -> {
                System.out.print(app.getCustomerId());
                System.out.print(":");
                System.out.print(app.getAuthorize());
                System.out.println();
            });
        }
        response.put("errorCode","0");
        response.put("message", "SUCCESS");
        return response;

    }

}
