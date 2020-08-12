
package org.techhub.controller;

import java.util.List;
import java.util.Map;
import org.techhub.model.*;
import org.techhub.service.RegisterService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestCtrl {

	@Autowired
	RegisterService registerService;

	@RequestMapping("/")
	public String homePage() {
		return "index";
	}

	@RequestMapping("/register")
	public String registerPage() {
		return "welcome";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public String welcomePage(Register register, Map map) {
		boolean b = registerService.isRegister(register);
		if (b) {
			map.put("msg", "Record Save Successfully.........");
		} else {
			map.put("msg", "Some problem is there................");
		}
		return "welcome";
	}
	// <jsp:useBean

	@RequestMapping("/viewrecords")
	public String viewAllRecords(Map map) {
		List<Register> list = registerService.getAllRecords();
		map.put("users", list);

		return "viewrecord";
	}

	@RequestMapping("/search") // end point //string,model,xml,string
	@ResponseBody
	public String searchRecord(HttpServletRequest request, Map map) {
		String name = request.getParameter("n");
		List<Register> list = registerService.getUserByName(name);
		String str = "";
		str = str + "<table border='5'>";
		str = str + "<tr><th>NAME</th><th>EMAIL</th><th>CONTACT</th><th>DELETE</th><th>UPDATE</th></tr>";

		for (Register r : list) {
			str = str + "<tr><td>" + r.getName() + "</td><td>" + r.getEmail() + "</td><td>" + r.getContact()
					+ "</td><td><a href=''>Delete</a></td><td><a href=''>Update</a></td></tr>";
		}
		str = str + "</table>";
		map.put("users", list);
		return str;// response generated on event ajax of but in the form of web page/
	}

	@RequestMapping("/del")
	public ModelAndView deleteRecord(HttpServletRequest request) {
		Integer userid = Integer.parseInt(request.getParameter("userid"));
		boolean b = registerService.isDeleteRecord(userid);
		ModelAndView view = new ModelAndView();
		if (b) {
			List<Register> list = registerService.getAllRecords();

			view.addObject("users", list);
			view.setViewName("viewrecord");

		}
		return view;
	}
	// if we want to return the different type of data
	// from from request mapping with @Controller annotation
	// we need to use the @ResponseBody annotation with request mapping
	// @ResponseBody annotation help us to return any type data to the view
	// from controller
	// when we use the @ResponseBody with request mapping
	// then your request mapping work as restful web api
	// what is the api (application programing interface)
	// what is the benifit of api ?

}
