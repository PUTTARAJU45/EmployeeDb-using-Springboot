package com.example.data.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.data.Module.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	@Query("select e from Employee e  where sal=?1")
List<Employee> findBySal(Double sal);
	
//	@Query("select e from Employee e  where phno=?1")
//	List<Employee> findByPhono(long phono);
}
