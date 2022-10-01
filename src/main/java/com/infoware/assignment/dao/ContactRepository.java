package com.infoware.assignment.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infoware.assignment.entity.Contact;
import com.infoware.assignment.entity.Employee;

public interface ContactRepository extends JpaRepository<Contact, Long> {

	@Transactional
	public void deleteByEmployee(Employee employee);

}
