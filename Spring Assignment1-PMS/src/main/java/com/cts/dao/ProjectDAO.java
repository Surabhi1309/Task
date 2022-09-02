package com.cts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.enitity.Project;

@Repository
public interface ProjectDAO extends JpaRepository<Project, Integer>{

}
