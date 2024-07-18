package com.example.demo.employeeserviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.serivce.EmployeeService;

@Service
public class EmployeeServicesImplement implements EmployeeService  {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee addData(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> fetEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee updatEmployee(Employee employee) {
		Employee e1 = employeeRepository.findById(employee.getId()).get();
		e1.setName(employee.getName());
		e1.setCity(employee.getCity());
		e1.setSalary(employee.getSalary());
		e1.setDept(employee.getDept());
		
		return employeeRepository.save(e1);
	}

	@Override
	public void delete(int id) {
		employeeRepository.deleteById(id);
	}

}
