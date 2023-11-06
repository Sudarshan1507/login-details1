package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.LoginDetails;
import com.mindgate.main.service.LoginDetailsServiceInterface;

@RestController
@RequestMapping("loginapi")
public class LoginDetailsController {

	@Autowired
	private LoginDetailsServiceInterface loginDetailsServiceInterface;

	@RequestMapping(value = "login/details", method = RequestMethod.POST)
	public LoginDetails getLoginDetailsByLoginId(@RequestBody LoginDetails details) {
		return loginDetailsServiceInterface.getLoginDetailsByLoginId(details);
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public List<LoginDetails> getAllLogin() {
		return loginDetailsServiceInterface.getAllLogin();
	}
	
	@RequestMapping(value = "login/details", method = RequestMethod.PUT)
	public LoginDetails updateLoginDetails(@RequestBody LoginDetails details) {
		return loginDetailsServiceInterface.updateLoginDetails(details);
	}
	// http://localhost:8081/employeeapi/employees
//	@RequestMapping(value = "employees", method = RequestMethod.GET)
//	public List<Employee> allEmployees() {
//		return employeeServiceInterface.getAllEmployee();
//	}
//
//	@RequestMapping(value = "employees/employee", method = RequestMethod.POST)
//	public boolean addEmployee(@RequestBody Employee employee) {
//		return employeeServiceInterface.addNewEmployee(employee);
//	}
//
//	@RequestMapping(value = "employees/{employeeId}", method = RequestMethod.GET)
//	public Employee getEmployee(@PathVariable int employeeId) {
//		return employeeServiceInterface.getEmployeeByEmployeeId(employeeId);
//	}
//
//	@RequestMapping(value = "employees/{employeeId}", method = RequestMethod.DELETE)
//	public boolean delete(@PathVariable int employeeId) {
//		return employeeServiceInterface.deleteEmployee(employeeId);
//	}
//
//	@RequestMapping(value = "employees/employee", method = RequestMethod.PUT)
//	public Employee updateEmployees(@RequestBody Employee employee) {
//		return employeeServiceInterface.updateEmployee(employee);
//	}
}
