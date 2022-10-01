package com.infoware.assignment.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.infoware.assignment.dao.ContactRepository;
import com.infoware.assignment.dao.EmployeeRepository;
import com.infoware.assignment.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository repository;
	private ContactRepository contactRepository;
	
	public EmployeeServiceImpl(EmployeeRepository repository, ContactRepository contactRepository) {
		super();
		this.repository = repository;
		this.contactRepository = contactRepository;
	}

	@Override
	public Employee getEmployee(int id) {
		Optional<Employee> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Page<Employee> getEmployee(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	@Override
	public String addEmployee(Employee employee) {
		employee.getContacts().stream().forEach(contact -> contact.setEmployee(employee));
		repository.save(employee);
		return "Successful";
	}

	@Override
	public String updateEmployee(Employee employee) {
		if (repository.findById(employee.getId()).isPresent()) {
			employee.getContacts().stream().forEach(contact -> contact.setEmployee(employee));
			repository.save(employee);
			return "Successful";
		}
		return "Employee not present";
	}
	
	@Override
	public String updateEmployeeContact(Employee employee) {
		if (repository.findById(employee.getId()).isPresent()) {
			contactRepository.deleteByEmployee(employee);
			employee.getContacts().stream().forEach(contact -> contact.setEmployee(employee));
			repository.save(employee);
			return "Successful";
		}
		return "Successful";
	}

	@Override
	public String deleteEmployee(int id) {
		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
			return "Successful";
		}
		return "Employee not found";
	}

}
