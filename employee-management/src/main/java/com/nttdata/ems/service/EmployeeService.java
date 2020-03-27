package com.nttdata.ems.service;

import java.io.FileNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.ems.model.Employee;
import com.nttdata.ems.repository.EmployeeRepository;

// employee service class
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@SuppressWarnings("unused")
	@Autowired
	private GenerateEmployeePdf generateEmployeePdf;

	// fetching all employees
	public List<Employee> getAllEmployees() {
		List<Employee> emps = (List<Employee>) employeeRepository.findAll();
		return emps;
	}

	// fetching employee by id
	public Employee getEmployee(int id) {
		return employeeRepository.findOne(id);
	}

	// inserting employee
	public void addEmployee(Employee e) {
		employeeRepository.save(e);
	}

	// updating employee by id
	public void updateEmployee(Employee emp, int id) {
		if (id == emp.getEmployeeID()) {
			employeeRepository.save(emp);
		}
	}

	// deleting all employees
	public void deleteAllEmployees() {
		employeeRepository.deleteAll();
	}

	// deleting employee by id
	public void deleteEmployeeByID(int id) {
		employeeRepository.delete(id);
	}

	// patching/updating employee by id
	public void patchEmployee(Employee emp, int id) {
		if (id == emp.getEmployeeID()) {
			employeeRepository.save(emp);
		}
	}

	public void readandPopulatePdf(Employee emp) throws FileNotFoundException {

		GenerateEmployeePdf.generatePdf(emp);
	}
}
