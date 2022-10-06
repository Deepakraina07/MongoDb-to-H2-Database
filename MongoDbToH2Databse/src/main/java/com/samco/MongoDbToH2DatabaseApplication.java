package com.samco;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.samco.model.Employee;
import com.samco.model.EmployeeMongo;
import com.samco.repository.EmployeeMongoRepository;
import com.samco.repository.EmployeeRepository;

@SpringBootApplication
public class MongoDbToH2DatabaseApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbToH2DatabaseApplication.class, args);
	}

	@Autowired
	EmployeeMongoRepository employeeMongoRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		List<EmployeeMongo> employees = employeeMongoRepository.get();
		Map<Integer, EmployeeMongo> emp = new HashMap<Integer, EmployeeMongo>();
		for(EmployeeMongo input:employees) {
			emp.put(input.getId(), input);
			Employee empl = new Employee();
			empl.setId(input.getId());
			empl.setName(input.getName());
			empl.setAge(input.getAge());
			empl.setCity(input.getCity());
			employeeRepository.save(empl);
			System.out.println(empl);
		}
		
	}
}
