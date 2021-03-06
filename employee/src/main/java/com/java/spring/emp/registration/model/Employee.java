package com.java.spring.emp.registration.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")
public class Employee {
	
	 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empno", nullable = false, unique = true, length = 10)
	private long empno;
	
	@Column(name="empname",nullable = false, length = 100)
	private String empname;
	
	private String department_code;
	
	@Column(name="dateofjoining",nullable = false, length = 10)
	private String dateofjoining;
	
	@Column(name="salary",nullable = false, length = 10)
	private float salary;
	
	@ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "department_code",insertable = false,updatable = false,referencedColumnName = "code")
   private DepartmentMaster departmentMaster;
}
