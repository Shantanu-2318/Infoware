package com.infoware.assignment.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.infoware.assignment.entity.Employee;

public interface EmployeeService {
	Employee getEmployee(int id);

	Page<Employee> getEmployee(Pageable pageable);

	String addEmployee(Employee employee);

	String updateEmployee(Employee employee);

	String updateEmployeeContact(Employee employee);

	String deleteEmployee(int id);
}
