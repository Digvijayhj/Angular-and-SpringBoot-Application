package com.employee.form.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.form.model.Employee;
import com.employee.form.service.EmployeeServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> employees = employeeServiceImpl.getAllEmployee();
		return ResponseEntity.ok(employees);
	}

	@PostMapping("/add")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee newEmployee =  employeeServiceImpl.createEmployee(employee);
		return ResponseEntity.ok(newEmployee);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		Employee employee = employeeServiceImpl.getEmployeeById(id);
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee){
		Employee updatedEmployee = employeeServiceImpl.updateEmployeeById(id, employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
		Map<String, Boolean> response = employeeServiceImpl.deleteEmployee(id);
		return ResponseEntity.ok(response);	
	}
}
