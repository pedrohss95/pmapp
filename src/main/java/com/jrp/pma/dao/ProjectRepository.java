package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.dto.ProjectStatus;
import com.jrp.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	
	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery = true, value = "SELECT STAGE AS LABEL, COUNT(*) AS VALUE FROM PROJECT "
			+ "GROUP BY STAGE")
	public List<ProjectStatus> projectStage();
}
