package com.creativemind.EmployeeDataSpring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.creativemind.EmployeeDataSpring.Entity.EmployeeDetailList;
import com.creativemind.EmployeeDataSpring.Service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService empservice;
	@PostMapping("/AddEmployee")
	public ResponseEntity<EmployeeDetailList> saveEmployee(@RequestBody EmployeeDetailList employee){
		return empservice.saveEmp(employee);
	}
	
	@GetMapping("/FetchEmployee")
	public ResponseEntity<List<EmployeeDetailList>> fetchEmployee(){
		return empservice.fetchEmp();
	}
	
	@PutMapping("/UpdateEmployee/{id}")
	public ResponseEntity<EmployeeDetailList> updateEmployee(@PathVariable Integer id,@RequestBody 
			                                                   EmployeeDetailList emp){
		return empservice.updateEmp(id,emp);
	}
	
	@DeleteMapping("/DeleteEmployee/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable Integer id){
          return empservice.deleteEmp(id);
}
	
	
	
}
