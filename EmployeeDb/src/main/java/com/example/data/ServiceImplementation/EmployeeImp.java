package com.example.data.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.data.Module.Employee;
import com.example.data.Repo.EmployeeRepo;
import com.example.data.Service.EmployeeService;

@Service
public class EmployeeImp implements EmployeeService {
	@Autowired
	EmployeeRepo repo;

	@Override
	public Employee addEmployee(Employee e) {
		return repo.save(e);
	}


	@Override
	public Employee getByEid(Integer eid) {
		
		return repo.findById(eid).orElseThrow(()-> new ResourceNotFound("Employee", "Eid", eid));

	}


	@Override
	public List<Employee> getBySal(Double sal) {

		return repo.findBySal(sal);
	}


	@Override
	public Employee updateEmployee(Employee e) {
		Employee e1 =repo.findById(e.getEid()).orElse(null);
		if(e1!=null) {
			e1.setName(e.getName());
			e1.setPhono(e.getPhono());
			e1.setSal(e.getSal());
			return repo.save(e1);
		}else {
			throw new ResourceNotFound("Employee", "Eid", e.getEid());
		}
	
	}


	@Override
	public Employee deleteByEId(Integer Eid) {
	Employee e=repo.findById(Eid).orElse(null);
	if(e!=null) {
		repo.deleteById(Eid);
		return e;
	}else {
		throw new ResourceNotFound("Employee", "Eid",Eid);

	}
		
	}


	
		
		

	

	

}
