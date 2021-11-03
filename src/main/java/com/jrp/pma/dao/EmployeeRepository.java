package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Override
	public List<Employee> findAll();

	@Query(nativeQuery = true, value = "SELECT E.FIRST_NAME as firstName, E.LAST_NAME as lastName, COUNT(PE.EMPLOYEE_ID) AS projectCounter "
			+ "FROM EMPLOYEE E LEFT JOIN PROJECT_EMPLOYEE PE ON PE.EMPLOYEE_ID = E.EMPLOYEE_ID "
			+ "GROUP BY E.FIRST_NAME, E.LAST_NAME ORDER BY 3 DESC;")
	public List<EmployeeProject> employeeProjects();
}
