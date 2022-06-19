package com.java.spring.emp.registration.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.java.spring.emp.registration.exception.ResourceNotFoundException;
import com.java.spring.emp.registration.model.Employee;
import com.java.spring.emp.registration.repository.EmployeeRepository;

@CrossOrigin("*")
@RestController
//@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository emprepository;
	
	@RequestMapping(value = "/employees",method = RequestMethod.GET)
	public List<Employee> getEmpByEmpNo(){
		return emprepository.findAll();
	}
	
	@RequestMapping(value = "/employees",method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {
		System.out.println(employee.getDepartment_code());
		return emprepository.save(employee);
	}
	
	//@GetMapping("{empno}")
	@RequestMapping(value = "/employees/{empno}")
	public ResponseEntity<Employee> getEmployeeByEmpNo(@PathVariable long empno){
		Employee emp= emprepository.findByempno(empno).orElseThrow(()-> new ResourceNotFoundException("Emp not exist with emp no:"+empno));
		return ResponseEntity.ok(emp);
	}
	

	@RequestMapping(value = "/employees/empname/{empname}")
	public ResponseEntity<List<Employee>> getEmployeeByEmpName(@PathVariable String empname) {
		return new ResponseEntity<List<Employee>>(emprepository.findByempname(empname), HttpStatus.OK);
	}
	
}
