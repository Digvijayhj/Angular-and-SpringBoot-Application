package com.employee.form.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.form.exception.ResourceNotFoundException;
import com.employee.form.model.Employee;
import com.employee.form.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee createEmployee(Employee employee) {	
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("No such Employee record found for Employee Id: " + id));
		return employee;
	}

	@Override
	public Employee updateEmployeeById(Long id, Employee employee) {
		Employee updatedEmployee = employeeRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("No such Employee record found for Employee Id: " + id));
		updatedEmployee.setName(employee.getName());
		updatedEmployee.setEmailId(employee.getEmailId());
		updatedEmployee.setDesignation(employee.getDesignation());
		Employee updatedRecord = employeeRepository.save(updatedEmployee);
		return updatedRecord;
		
	}

	@Override
	public Map<String, Boolean> deleteEmployee(Long id) {
		Employee employee = employeeRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("No such Employee record found for Employee Id: " + id));
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", true);
		return response;
	}
	
	
}
