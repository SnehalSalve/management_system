package com.example.demo.serivce;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {

	Employee addData(Employee employee);
	List<Employee> fetEmployees();
	Employee updatEmployee(Employee employee);
	void delete(int id);
	
}
