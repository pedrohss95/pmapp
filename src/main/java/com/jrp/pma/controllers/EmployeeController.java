package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping()
	public String displayEmployees(Model model) {
		// return list of all employees
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("employees", employees);
		return "employee/list-employees";

	}

	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {

		Employee anEmployee = new Employee();
		model.addAttribute("employee", anEmployee);

		return "employee/new-employee";
	}

	@PostMapping("/save")
	public String registerEmployee(Employee employee, Model model) {
		empRepo.save(employee);

		return "redirect:/employees/new";
	}


}
