package com.spring.boot.hazelcast.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.spring.boot.hazelcast.api.model.Employee;
import com.spring.boot.hazelcast.api.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Cacheable(cacheNames = {"employees-cache"})
	public List<Employee> getAllEmployees(){
		System.out.println("Hitting database for first time for getting all employees");
		return employeeRepository.findAll();
	}
	
	@Cacheable(value = "employees-cache",key="#id")
	public Employee getEmployeeById(int id) {
		System.out.println("Hitting database for first time for getting employee id:" + id);
		return employeeRepository.findById(id).orElse(null);
	}
	
	@CacheEvict(value="employees-cache")
	public String deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		return "Employee with id" + id + " deleted successfully";
	}
	
	@CachePut(value="employees-cache",key="#result.id")
	public Employee insertEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}
	

}
