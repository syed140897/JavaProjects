package com.creativemind.EmployeeDataSpring.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.creativemind.EmployeeDataSpring.Entity.EmployeeDetailList;
import com.creativemind.EmployeeDataSpring.Repo.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository emprepo;

	
	public ResponseEntity<EmployeeDetailList> saveEmp(EmployeeDetailList emp) {
		return ResponseEntity.ok(emprepo.save(emp));
		
	}

	public ResponseEntity<List<EmployeeDetailList>> fetchEmp() {
			return ResponseEntity.ok(emprepo.findAll());
	}

	public ResponseEntity<EmployeeDetailList> updateEmp(Integer id, EmployeeDetailList emp) {
		EmployeeDetailList employee=(emprepo.findById(id)).get();
		if(emp.getName()!=null) {
			employee.setName(emp.getName());
		}
		if(emp.getSalary()!=null) {
			employee.setSalary(emp.getSalary());
		}
		if(emp.getRole()!=null) {
			employee.setRole(emp.getRole());
		}
		if(emp.getFresher()!=null) {
			employee.setFresher(emp.getFresher());
		}
		return ResponseEntity.ok(emprepo.save(employee));
	}

	public ResponseEntity<?> deleteEmp(Integer id) {
		EmployeeDetailList employee=emprepo.findById(id).get();
		emprepo.delete(employee);
		return ResponseEntity.ok(HttpStatus.ACCEPTED);
	}
}
