package com.jinchen.spring.service;

import com.jinchen.spring.model.Employee;

public class EmployeeService { // Service class to work with the Employee bean

	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
