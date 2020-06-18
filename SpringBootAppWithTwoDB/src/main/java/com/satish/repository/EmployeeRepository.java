package com.satish.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.satish.model.Employee;

@Repository
public class EmployeeRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplateOne;
	
	public void insert(Employee employee) {
		String sql = "INSERT INTO EMPLOYEE "+" (NAME,AGE,SALAY) VALUES(?,?,?)";
		KeyHolder holder = new GeneratedKeyHolder();
		
		jdbcTemplateOne.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, employee.getName());
				ps.setInt(2, employee.getAge());
				ps.setInt(3, employee.getSalary());
				return ps;
			}
		},holder);
		
		int generatedEmployeeId = holder.getKey().intValue();
		System.out.println("Generated EmployeeId =:  "+generatedEmployeeId);
	}
}
