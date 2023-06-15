package com.example.data.Service;

import java.util.List;

import com.example.data.Module.Employee;

public interface EmployeeService {
	Employee addEmployee(Employee e);
    Employee getByEid(Integer eid);
	
	List<Employee> getBySal(Double sal);
Employee updateEmployee(Employee e);

Employee deleteByEId(Integer Eid);
	
}
