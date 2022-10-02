package com.infoware.assignment.constroller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.infoware.assignment.entity.Employee;
import com.infoware.assignment.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeService service;

	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	@GetMapping("/get/{id}")
	public Employee getEmpoyee(@PathVariable int id) {
		return service.getEmployee(id);
	}

	@GetMapping("/get")
	@ResponseBody
	public Page<Employee> getEmployeeList(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		Pageable pageable = PageRequest.of(page, limit);
		return service.getEmployee(pageable);
	}

	@PostMapping("/add")
	public String addEmployee(@RequestBody Employee employee) {
		System.out.println(employee.getContacts());
		return service.addEmployee(employee);
	}

	@PostMapping("/update")
	public String updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}

	@PostMapping("/updateContacts")
	public String updateEmployeeContact(@RequestBody Employee employee) {
		return service.updateEmployeeContact(employee);
	}

	@PostMapping("delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return service.deleteEmployee(id);
	}
}
