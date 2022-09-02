package com.cts.resttemplate;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProjectRestTemplate implements CommandLineRunner {
	private static final Log LOGGER = LogFactory.getLog(RestTemplate.class);

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run method invoked");
		 Date date = new Date();
		 ProjectDTO project = new ProjectDTO(4, "BakeNbake", 1450.0, 10, 30, date, "Surabhi");
		 addProject(project);
		 getProjectDetails(3);
		 updateProject(project);
		 deleteProject(4);
	}
	
	public void getProjectDetails(Integer projectId) {//4
		String url = "http://localhost:8080/pms/{projectId}";
		//step1step 
		RestTemplate restTemplate = new RestTemplate();
		//restTemplate.
		// getForObject 1-url, 2. return datatype  3. path variable
		ProjectDTO projectDTO = restTemplate.getForObject(url, ProjectDTO.class,projectId);
		LOGGER.info(projectDTO);
		LOGGER.info("\n");
	}

	public void addProject(ProjectDTO project) {
		String url = "http://localhost:8080/pms/";
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.postForObject(url, project, String.class);
		LOGGER.info(response);
		LOGGER.info("\n");
	}

	public void updateProject(ProjectDTO projectDTO) {
		String url = "http://localhost:8080/pms/";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(url, projectDTO, projectDTO.getProjectId());
		LOGGER.info("Project updated successfully");
		LOGGER.info("\n");
	}

	public void deleteProject(Integer projectId) {
		String url = "http://localhost:8080/pms/{projectId}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url, projectId);
		LOGGER.info("Project deleted successfully");
		LOGGER.info("\n");
	}


}
