package com.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pma.entities.Project;

public interface IProjectRepository extends CrudRepository<Project, Long> {
	//you need to provide the type (Object) and the id for that type
	//consider the interface a way to interact with the db
	//you can create custom queries here that can be executed on the h2 database
	@Override
	public List<Project> findAll();
}
