package com.stephane.springbatch.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stephane.springbatch.service.ApplicationService;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
public class ApplicationController {
	
	//@Autowired
	//private ApplicationService applicationService;
	
	@Autowired
	private	JobLauncher jobLauncher;
	
	@Autowired
	private	Job job;
	
	@GetMapping("executeJob")
	public BatchStatus executeJob() throws Exception {
		//return applicationService.executeJob();
		Map<String, JobParameter> parameters = new HashMap<>();
		System.out.println("Map<String, JobParameter> parameters = new HashMap<>()");
		parameters.put("time", new JobParameter(System.currentTimeMillis()));
		System.out.println("parameters.put(\"time\", new JobParameter(System.currentTimeMillis()))");
		JobParameters jobParameters = new JobParameters(parameters);
		System.out.println("JobParameters jobParameters = new JobParameters(parameters)");
		JobExecution jobExecution = jobLauncher.run(job, jobParameters);
		System.out.println("JobExecution jobExecution = jobLauncher.run(job, jobParameters)");
		
		while(jobExecution.isRunning()) {
			System.out.println(".....");
		}
		
		return jobExecution.getStatus();
	}
		
}
