package com.java.spring.emp.registration.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.java.spring.emp.registration.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	Optional<Employee> findByempno(long empno);
	List<Employee> findByempname(String empname);
}
