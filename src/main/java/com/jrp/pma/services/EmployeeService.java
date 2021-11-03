package com.jrp.pma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	//field injection type
	//@Qualifier("staffRespositoryImpl1")
	//@Autowired
	IStaffRepository empRepo;
	
	
	// constructor injection type 
	//qualifier need to be included in the parameters
//	public EmployeeService(IStaffRepository empRepo) {
//		super();
//		this.empRepo = empRepo;
//	}
//	
//	//setter injection type	
	@Qualifier("staffRespositoryImpl1")
	@Autowired
	public void setEmpRepo(IStaffRepository empRepo) {
		this.empRepo = empRepo;
	}
	
	
}
