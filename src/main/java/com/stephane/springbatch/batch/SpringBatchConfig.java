package com.stephane.springbatch.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.stephane.springbatch.domain.Geolocation;
                                                                                                       
@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private ItemReader<Geolocation> geolocationItemReader;
	
	@Autowired
	private ItemProcessor<Geolocation, Geolocation> geolocationItemProcessor;
	
	@Autowired
	private ItemWriter<Geolocation> geolocationItemWriter;
	
	@Bean
	public Job job() {
		Step step1 = stepBuilderFactory.get("step1")
				.<Geolocation, Geolocation>chunk(50)
				.reader(geolocationItemReader)
				.processor(geolocationItemProcessor)
				.writer(geolocationItemWriter)
				.build();		
		
		return jobBuilderFactory.get("job")
				.start(step1)
				.build();
	}
	
	@Bean
	public FlatFileItemReader<Geolocation> getFlatFileItemReader(@Value("${inputFile}") Resource inputFile) {
		FlatFileItemReader<Geolocation> itemReader = new FlatFileItemReader<>();
		itemReader.setName("FFIR1");
		itemReader.setLinesToSkip(1);
		itemReader.setResource(inputFile);
		itemReader.setLineMapper(getLineMapper());
		return itemReader;
	}
	
	@Bean
	public LineMapper<Geolocation> getLineMapper() {
		DefaultLineMapper<Geolocation> lineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("id", "longitude", "latitude", "cityName");
		lineMapper.setLineTokenizer(lineTokenizer);
		BeanWrapperFieldSetMapper<Geolocation> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Geolocation.class);
		lineMapper.setFieldSetMapper(fieldSetMapper);		
		return lineMapper;
	}
	
}
