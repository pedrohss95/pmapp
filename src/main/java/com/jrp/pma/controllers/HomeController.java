package com.jrp.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.dto.ProjectStatus;
import com.jrp.pma.entities.Project;

@Controller
public class HomeController {
	
	@Value("${version}")
	private String version;

	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		model.addAttribute("currentVersion", version);
		
		Map<String, Object> map = new HashMap<>();
		
		// return all projects
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projects", projects);
		
		//return projects by stage
		List<ProjectStatus> projectData = proRepo.projectStage();
		
		//Converting projectData Object in JSON
		ObjectMapper objectMapper = new ObjectMapper();
		String projectDataStr = objectMapper.writeValueAsString(projectData);
		model.addAttribute("projectStrCounter", projectDataStr);
		
		// return all employees
		List<EmployeeProject> employeesProjectCounter = empRepo.employeeProjects();
		model.addAttribute("employeesList", employeesProjectCounter);
		
		return "main/home";
	}
}
