package com.employee.form.service;

import java.util.List;
import java.util.Map;

import com.employee.form.model.Employee;

public interface EmployeeService {
	 
	List<Employee> getAllEmployee();
	
	Employee createEmployee(Employee employee);
	
	Employee getEmployeeById(Long id);
	
	Employee updateEmployeeById(Long id, Employee employee);
	
	Map<String, Boolean> deleteEmployee(Long id);

}
