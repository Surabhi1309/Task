package com.cts;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.ProjectedPayload;

import com.cts.enitity.Project;
import com.cts.service.ProjectService;

@SpringBootApplication
public class ProjectManagementApplication {
	@Autowired
	ProjectService projectService;

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}
//	 @Bean
//	    public CommandLineRunner CommandLineRunnerBean() {
//	        return (args) -> {
//	            System.out.println("Saving one project in database");
//	            Date date = new Date();
//	            Project project = new Project(2, "banking", 1000.0, 5, 3, date, "Sapna");
//	            projectService.addProjectDetails(project);
//
//	        };
//	    }
}
