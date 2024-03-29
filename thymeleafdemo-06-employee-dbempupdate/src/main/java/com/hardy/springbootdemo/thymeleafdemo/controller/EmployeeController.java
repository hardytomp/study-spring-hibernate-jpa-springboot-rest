package com.hardy.springbootdemo.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.io.TempDir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hardy.springbootdemo.thymeleafdemo.entity.Employee;
import com.hardy.springbootdemo.thymeleafdemo.service.EmployeeService;



@Controller
@RequestMapping("employees")
public class EmployeeController {

	private EmployeeService empSvc;
	
	@Autowired
	public EmployeeController(EmployeeService empSvc) {
		this.empSvc = empSvc;
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		List<Employee> theEmployees = empSvc.findAllEmployee();
		theModel.addAttribute("employees", theEmployees);
		return "employees/list-employees";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Employee emp =new Employee();
		
		theModel.addAttribute("employee",emp);
		return "employees/employee-form";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForIpdate(@RequestParam("employeeId") int id,Model model) {
		
		//get the employee from the svc
		Employee emp =empSvc.findById(id);
		//set employee as a model attribute to prepopulate the form
		model.addAttribute("employee",emp);
		
		//send over to our form
		return "employees/employee-form";
		
	}
	
	
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		empSvc.save(theEmployee);
		return "redirect:/employees/list";
	}
}
