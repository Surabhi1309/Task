package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.enitity.Project;
import com.cts.service.ProjectService;

@RestController
@RequestMapping("/pms")
public class ProjectController {
	@Autowired
	ProjectService projectService;
	
	@GetMapping("/")
	public List<Project> getAllProjects(){
		return projectService.getAllProject();
	}
	@GetMapping("/{projectId}")
	public Project getProject(@PathVariable String projectId) {
		
		return projectService.getProjectDetail(Integer.parseInt(projectId));
	}
	@PostMapping
	public String addProject(@RequestBody Project pro) {
		return projectService.addProjectDetails(pro);
	}
	@PutMapping
	public String updateProject(@RequestBody Project pro) {
		return projectService.updateProjectDetails(pro);
	}
	@DeleteMapping("/{projectId}")
	public String deleteProject(@PathVariable String projectId) {
		
		return projectService.deleteProjectDetails(Integer.parseInt(projectId));
	}

}
