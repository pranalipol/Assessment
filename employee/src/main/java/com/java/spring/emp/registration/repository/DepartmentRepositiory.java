package com.java.spring.emp.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.spring.emp.registration.model.DepartmentMaster;

public interface DepartmentRepositiory extends JpaRepository<DepartmentMaster, String> {

}
