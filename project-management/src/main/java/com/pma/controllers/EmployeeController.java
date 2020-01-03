package com.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pma.dao.IEmployeeRepository;
import com.pma.entities.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	IEmployeeRepository empRep;
	
	@RequestMapping("/new")
	public String showEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee); //this sets a link between the object and the HTML part that needs to full up the object
		return "employees/Employee";		
	}
	
	@PostMapping("/save")
	public String saveEmployeeForm(Employee employee, Model model) {
		
		//save employee on the db
		empRep.save(employee);
		
		//Redirect
		return "redirect:/";
	}

}
