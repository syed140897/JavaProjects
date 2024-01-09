package com.creativemind.FileBatchUploadProcess.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creativemind.FileBatchUploadProcess.Entity.CustomerDetail;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerDetail, Integer>{

}
