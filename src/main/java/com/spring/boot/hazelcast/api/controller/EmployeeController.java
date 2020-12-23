package com.spring.boot.hazelcast.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.hazelcast.api.model.Employee;
import com.spring.boot.hazelcast.api.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/getAllemployees")
	public List<Employee> getEmployees() {
		return service.getAllEmployees();
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public Employee getEmployee(@PathVariable("id") int id) {
		return service.getEmployeeById(id);
	}
	
	@RequestMapping(value = "/deleteEmployeeById/{id}",method = RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable("id") int id) {
		return service.deleteEmployee(id);
	}
	
	@RequestMapping(value = "insertEmployee",method = RequestMethod.POST , consumes = "application/json")
	public Employee insertEmployee(@RequestBody Employee emp) {
		System.out.println(emp.getAge());
		return service.insertEmployee(emp);
	}
	
}
