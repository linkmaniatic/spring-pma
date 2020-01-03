package com.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pma.dao.IProjectRepository;
import com.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired //creates an instance of the interface or object, instead of us creating the instance
	IProjectRepository proRep; //creating and instance of the repository db

	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		model.addAttribute("project", aProject); //this must be the same as th:object in the html.
		return "projects/NewProject";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) { //by sending project, when 
		// this should handle saving to the db.
		proRep.save(project);
		
		//Its a good practice to redirect to prevent duplicate submissions
		return "redirect:/";
	}
}
