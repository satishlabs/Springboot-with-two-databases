package com.satish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.satish.model.Employee;
import com.satish.model.User;
import com.satish.repository.EmployeeRepository;
import com.satish.repository.UserRepository;

@SpringBootApplication
public class SpringBootAppWithTwoDbApplication implements CommandLineRunner{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppWithTwoDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inside run...");
		Employee emp = new Employee("Satish", 33, 55000);
		employeeRepository.insert(emp);
		System.out.println("Employee record inserted successfully in frist database...");
		
		User user = new User("Ms", "ms@sap.com", "Male");
		userRepository.insert(user);
		System.out.println("User record inserted successfully in second database...");
		
	}

}
