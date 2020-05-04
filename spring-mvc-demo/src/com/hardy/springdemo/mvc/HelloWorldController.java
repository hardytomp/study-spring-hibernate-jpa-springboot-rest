package com.hardy.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")  //parent mapping
public class HelloWorldController {
	
	// need a controller method to show the initial form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloWorld";
	}
	
	//new a controller method to reaf form data and add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letShoutDude(HttpServletRequest request,Model model) {
		System.out.println(request.toString());
		//read the data from html form
		String theName = request.getParameter("studentName");
		//conver the data to all caps
		theName.toUpperCase();
		//create message
		String result = "  Yo!  "+theName;
		//add message to the model
		model.addAttribute("message",result);
		return "helloWorld";
	}

	
	@RequestMapping("/processFormVersionThree")
	public String processVersionFormThree(@RequestParam("studentName") String theName,Model model) {

		//conver the data to all caps
		theName.toUpperCase();
		//create message
		String result = "  Hey bouy this is making me crazy!  "+theName;
		//add message to the model
		model.addAttribute("message",result);
		return "helloWorld";
	}	
}
