package com.nttdata.ems.repository;

import org.springframework.data.repository.CrudRepository;

import com.nttdata.ems.model.Employee;

// interface extending crud repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	
}
