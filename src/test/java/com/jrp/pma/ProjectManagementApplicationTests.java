package com.jrp.pma;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Project;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProjectManagementApplicationTests {

	@Autowired
	ProjectRepository proRepo;
	
	

//	@Test
//	public void ifNewProjSavedSucessfully() {
//		Project newProject = new Project("Project Test", "COMPLETED", "Project test passed");
//		proRepo.save(newProject);
//
//		assertEquals(1, proRepo.findAll().size());
//	}

// previous code existing

//	public ProjectManagementApplicationTests() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	@Test
//	void contextLoads() {
//	}

}
