package com.creativemind.FileBatchUploadProcess.Config;


import lombok.AllArgsConstructor;
import lombok.Value;

import java.io.File;

import org.springframework.aot.nativex.NativeConfigurationWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.creativemind.FileBatchUploadProcess.Entity.CustomerDetail;
import com.creativemind.FileBatchUploadProcess.Repo.CustomerRepo;

@Configuration
@AllArgsConstructor
public class CustomerBatchProcess {
	
	@Autowired
	CustomerRepo customerRepo;

	 @Bean
	 public Job jobProcess(JobRepository jobRepository ,PlatformTransactionManager platformTransactionManager,
			 FlatFileItemReader<CustomerDetail> itemReader) {
		return new JobBuilder("Job_Process", jobRepository).incrementer(new RunIdIncrementer())
				    .start(stepProcess(jobRepository,platformTransactionManager,itemReader))
				    .build();
	}
	@Bean
	public Step stepProcess(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager,
			FlatFileItemReader<CustomerDetail> itemReader) {
		return new StepBuilder("Step_Process", jobRepository).<CustomerDetail,CustomerDetail>
		           chunk(10, platformTransactionManager).reader(itemReader)
		           .processor(new ItemProcesser())
		           .writer(itemWriter()).build();
	}
	@Bean
	@StepScope
	 FlatFileItemReader<CustomerDetail> itemReader(@org.springframework.beans.factory.annotation.Value("#{jobParameters[FileImport]}") String file){
		FlatFileItemReader<CustomerDetail> flatFileItemReader=new FlatFileItemReader<CustomerDetail>();
		flatFileItemReader.setResource(new FileSystemResource(new File(file)));
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setName("Item_Reader");
		flatFileItemReader.setLineMapper(linemapperprocess());
		
		return flatFileItemReader;
		
		
	}
    
	private LineMapper<CustomerDetail> linemapperprocess() {
		DefaultLineMapper<CustomerDetail> defaultLineMapper=new DefaultLineMapper<CustomerDetail>();
		
		DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setNames("firstName","lastName","email","gender","contactNo","country","dob");
		lineTokenizer.setStrict(false);
		
		BeanWrapperFieldSetMapper<CustomerDetail> fieldSetMapper=new BeanWrapperFieldSetMapper<CustomerDetail>();
		fieldSetMapper.setTargetType(CustomerDetail.class);
		
	    defaultLineMapper.setFieldSetMapper(fieldSetMapper);
	    defaultLineMapper.setLineTokenizer(lineTokenizer);
		return defaultLineMapper;
	}
	 
	@Bean
	 ItemProcesser processer() {
		return new ItemProcesser();
	}
	@Bean
	 RepositoryItemWriter<CustomerDetail> itemWriter(){
		RepositoryItemWriter<CustomerDetail> writer=new RepositoryItemWriter<CustomerDetail>();
		writer.setRepository(customerRepo);
		writer.setMethodName("save");
			
		return writer;
	}
}
