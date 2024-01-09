package com.creativemind.FileBatchUploadProcess.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchProcessService {
	
	@Autowired
	public JobLauncher jobLauncher;
	@Autowired
	public Job job;
	
	public void customerFileUpload(File fileImport) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
		JobParameters jobParameters=new JobParametersBuilder()
				.addString("FileImport", fileImport.getAbsolutePath())
				.addLong("startAt", System.currentTimeMillis())
				                       .toJobParameters();

		JobExecution jobExecution=jobLauncher.run(job,jobParameters);
        if(jobExecution.getExitStatus().equals(ExitStatus.COMPLETED)) {
        	try {
				Files.deleteIfExists(Paths.get(fileImport.getAbsolutePath()));
				System.out.println("File SuccessFully Deleted");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("File Deleted Failed");
			}
        }
		
	}

}
