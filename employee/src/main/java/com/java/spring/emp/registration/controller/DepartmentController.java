package com.java.spring.emp.registration.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.java.spring.emp.registration.model.DepartmentMaster;
import com.java.spring.emp.registration.repository.DepartmentRepositiory;


@CrossOrigin("*")
@RestController
public class DepartmentController {

	@Autowired
	private DepartmentRepositiory deptrepository;
	
	@RequestMapping(value = "/departments",method = RequestMethod.GET)
	public List<DepartmentMaster> getDept(){
		return deptrepository.findAll();
	}
}
