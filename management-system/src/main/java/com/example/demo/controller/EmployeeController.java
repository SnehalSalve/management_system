package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.employeeserviceimplement.EmployeeServicesImplement;
import com.example.demo.entity.Employee;

@RestController
@RequestMapping("/Home")
public class EmployeeController {

	EmployeeServicesImplement employeeServicesImplement;
	
	public EmployeeController(EmployeeServicesImplement employeeServicesImplement) {
		super();
		this.employeeServicesImplement = employeeServicesImplement;
	}
	
	@GetMapping("/data")
	public ResponseEntity<List<Employee>> data(){
		List<Employee> l1 = employeeServicesImplement.fetEmployees();
		return new ResponseEntity<>(l1,HttpStatus.OK);		
	}
	
	@PostMapping("/save")
	public ResponseEntity<Employee> dataadd(@RequestBody Employee employee){
		Employee e1 = employeeServicesImplement.addData(employee);
		return new ResponseEntity<>(e1,HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updatEntity(@PathVariable("id") int id, @RequestBody Employee employee){
		employee.setId(id);
		Employee e1 = employeeServicesImplement.updatEmployee(employee);
		return new ResponseEntity<>(e1,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletEntity(@PathVariable ("id") int id){
		employeeServicesImplement.delete(id);
	return new ResponseEntity<>("Data deleted",HttpStatus.OK);
		
	}
	
}
