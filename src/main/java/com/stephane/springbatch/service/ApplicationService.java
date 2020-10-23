package com.stephane.springbatch.service;

import org.springframework.batch.core.BatchStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephane.springbatch.batch.BatchExecution;

@Service
public class ApplicationService {
	
	//@Autowired
	private BatchExecution batchExecution;
	
	public BatchStatus executeJob() {
		try {
			return batchExecution.load();
		} catch (Exception e) {
			throw new RuntimeException("BatchExecutionException");
		}
	}
	
}
