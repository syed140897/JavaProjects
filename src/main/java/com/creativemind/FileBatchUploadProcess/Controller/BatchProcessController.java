package com.creativemind.FileBatchUploadProcess.Controller;

import java.io.File;
import java.io.IOException;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.creativemind.FileBatchUploadProcess.Service.BatchProcessService;

@RestController
public class BatchProcessController {

	@Autowired 
	BatchProcessService service;
	
	private final String TEMP_STORAGE="E:\\BatchTEMPFILE\\";
	
	@GetMapping("/customer")
	public void CustomerfileProcesser(@RequestPart("file") MultipartFile[] file) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException, IllegalStateException, IOException {
       for(MultipartFile files:file) {
	   String fileName=files.getOriginalFilename();
       File fileImport=new File(TEMP_STORAGE+fileName);
       files.transferTo(fileImport);
       service.customerFileUpload(fileImport);
       System.out.println("Enter File" +files.getOriginalFilename());
       }
	}
	}	


