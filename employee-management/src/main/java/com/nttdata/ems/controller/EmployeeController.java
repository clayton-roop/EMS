package com.nttdata.ems.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.ems.exception.EmployeeNotFoundException;
import com.nttdata.ems.model.Employee;
import com.nttdata.ems.service.EmployeeService;
import com.nttdata.ems.service.GenerateEmployeePdf;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private final Logger Logger = LogManager.getLogger(EmployeeController.class.getName());

	@Autowired
	private EmployeeService employeeService;

	// displaying list of all employees

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployees();
	}

	// displaying employee by id
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable int id) throws EmployeeNotFoundException {
		if (id <= 0) {
			throw new EmployeeNotFoundException("Invalid  Employee Id");
		}
		Employee emp = employeeService.getEmployee(id);

		return emp;
	}

	// displaying employee by id in pdf
	@GetMapping("/generatePdf/{id}")
	public Employee generatePDFEmployee(@PathVariable int id) throws FileNotFoundException {
		Employee emp = employeeService.getEmployee(id);
		// employeeService.readandPopulatePdf(emp);
		GenerateEmployeePdf.generatePdf(emp);
		return emp;
	}

	// inserting employee
	@PostMapping("/employees")
	public void addEmployees(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		employeeService.getAllEmployees();
		Logger.info("Employee Created");
	}

	// updating employee by id
	@PutMapping("/{id}")
	public void updateEmployee(@RequestBody Employee e, @PathVariable int id) {
		employeeService.updateEmployee(e, id);
	}

	// deleting all employees
	@DeleteMapping("/employees")
	public void deleteAllEmployees() {
		employeeService.deleteAllEmployees();
	}

	// deleting employee by id
	@DeleteMapping("/{id}")
	public void deleteEmployeeByID(@RequestBody Employee e, @PathVariable int id) {
		employeeService.deleteEmployeeByID(id);
	}

	// updating/ patching employee by id
	@PatchMapping("/{id}")
	public void patchEmployeeByID(@RequestBody Employee e, @PathVariable int id) {
		employeeService.patchEmployee(e, id);
	}
}
