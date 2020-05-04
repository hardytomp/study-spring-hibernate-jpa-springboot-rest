package com.hardy.springdemo.mvc;

import javax.xml.bind.annotation.XmlRegistry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		//create a new student obj
		Student theStudent = new Student();
		//add student to the model
		theModel.addAttribute("student",theStudent);
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		//log input data
		System.out.println("student Data"+theStudent.getLastName()+" "+theStudent.getFirstName());
		return "student-confirmation";
	}
}
