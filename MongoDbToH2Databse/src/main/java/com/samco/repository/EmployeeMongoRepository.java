package com.samco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.samco.model.Employee;
import com.samco.model.EmployeeMongo;

@Repository
public class EmployeeMongoRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public EmployeeMongo add(EmployeeMongo employeeMongo) {
		return mongoTemplate.save(employeeMongo);
	}
	
	public List<EmployeeMongo> get(){
		return mongoTemplate.findAll(EmployeeMongo.class);
	}
}
