package com.creativemind.EmployeeDataSpring.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creativemind.EmployeeDataSpring.Entity.EmployeeDetailList;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetailList, Integer>{

}
