package com.java.spring.emp.registration.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name="department_master")
public class DepartmentMaster {

	@Id
	@Column(name="code",length = 2,nullable = false)
	private String code;
	@Column(name="description",length = 30,nullable = false)
	private String description;
	@OneToMany(fetch = FetchType.EAGER,mappedBy="departmentMaster",cascade = CascadeType.ALL)
    private Set<Employee> employees;
}
