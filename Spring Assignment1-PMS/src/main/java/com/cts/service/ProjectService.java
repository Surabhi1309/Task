package com.cts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.ProjectDAO;
import com.cts.enitity.Project;

@Service
public class ProjectService {
	@Autowired
	ProjectDAO projectDAO;
	
	public List<Project> getAllProject() {
		List<Project> allProjects = new ArrayList<Project>();
		projectDAO.findAll().forEach(project->allProjects.add(project));
		return allProjects;		
		
	}
	public String addProjectDetails(Project p) {
		projectDAO.save(p);
		return "Project saved successfully";
	}
	public String updateProjectDetails(Project p) {
		Optional<Project> optional = projectDAO.findById(p.getProjectId());
		if(optional.isPresent())
		projectDAO.save(p);
		else
			return "No Project found with id "+p.getProjectId();
		return "Project updated successfully";
	}
	public String deleteProjectDetails(int projectId) {
		Optional<Project> optional = projectDAO.findById(projectId);
		if(optional.isPresent())
		projectDAO.deleteById(projectId);
		else
			return "No Project found with id "+projectId;
		return "project deleted successfully";
	}
	public Project getProjectDetail(int projectId) {
		Optional<Project> pro = projectDAO.findById(projectId);
		Project p = null;
		if(pro.isPresent())
			p = pro.get();
		return p;
	}
	

}
