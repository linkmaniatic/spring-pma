package com.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pma.entities.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Long> {

	@Override
	public List<Employee> findAll();
}
