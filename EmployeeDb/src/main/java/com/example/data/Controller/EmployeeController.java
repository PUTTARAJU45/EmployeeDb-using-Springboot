package com.example.data.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.data.Module.Employee;
import com.example.data.Service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;

	@PostMapping("/save")
	ResponseEntity<Employee> addEmployee(@RequestBody Employee e) {

		return new ResponseEntity<Employee>(service.addEmployee(e), HttpStatus.CREATED);
	}

	@GetMapping("/getid")
	ResponseEntity<Employee> getByaEid(@RequestHeader Integer eid) {
		return new ResponseEntity<Employee>(service.getByEid(eid), HttpStatus.FOUND);

	}

	@GetMapping("/getsal")
	ResponseEntity<List<Employee>> getBySal(Double sal) {

		return new ResponseEntity<List<Employee>>(service.getBySal(sal), HttpStatus.FOUND);
	}

	@PutMapping("/update")
	ResponseEntity<Employee> updateEmployee(@RequestBody Employee e) {

		return new ResponseEntity<Employee>(service.updateEmployee(e), HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	ResponseEntity<Employee> deleteByEid(@RequestParam Integer Eid) {

		return new ResponseEntity<Employee>(service.deleteByEId(Eid), HttpStatus.OK);
	}
}
