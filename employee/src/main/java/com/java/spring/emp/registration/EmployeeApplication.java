package com.java.spring.emp.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.java.spring.emp.registration.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {

	}
}

