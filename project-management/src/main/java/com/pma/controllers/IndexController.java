package com.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pma.dao.IEmployeeRepository;
import com.pma.dao.IProjectRepository;
import com.pma.entities.Employee;
import com.pma.entities.Project;

@Controller
public class IndexController {
	
	@Autowired
	IProjectRepository proRepo;
	@Autowired
	IEmployeeRepository empRepo;
	
	@GetMapping("/")
	public String index(Model model) {
		
		//Project model mapping
		List<Project> projects = proRepo.findAll(); // Querying the db to find "all" the items in project table.
		model.addAttribute("projects", projects);
		
		//Employee model mapping 
		List<Employee> employee = empRepo.findAll();
		model.addAttribute("employee", employee);
		
		
		return "main/Index";
	}
}
