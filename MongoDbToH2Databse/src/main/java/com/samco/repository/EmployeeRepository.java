package com.samco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.samco.model.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int save(Employee employee) {
		return jdbcTemplate.update("INSERT INTO EMPLOYEE(ID,NAME,AGE,CITY)VALUES(?,?,?,?)",
				new Object[] { employee.getId(), employee.getName(), employee.getAge(), employee.getCity() });
	}

	public List<Employee> get() {
		return jdbcTemplate.query("SELECT * FROM EMPLOYEE", BeanPropertyRowMapper.newInstance(Employee.class));
	}

}
