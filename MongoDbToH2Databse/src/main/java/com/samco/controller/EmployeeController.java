package com.samco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samco.model.EmployeeMongo;
import com.samco.repository.EmployeeMongoRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeMongoRepository employeeMongoRepository;
	
	@PostMapping("/add")
	public EmployeeMongo addEmployee(@RequestBody EmployeeMongo employeeMongo) {
		return employeeMongoRepository.add(employeeMongo);
	}
	
	@GetMapping("/get")
	public List<EmployeeMongo> getEmployee(EmployeeMongo employeeMongo){
		return employeeMongoRepository.get();
	}
}
