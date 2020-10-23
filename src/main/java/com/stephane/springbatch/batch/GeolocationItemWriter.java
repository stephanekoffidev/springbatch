package com.stephane.springbatch.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stephane.springbatch.dao.GeolocationRepository;
import com.stephane.springbatch.domain.Geolocation;

@Component
public class GeolocationItemWriter implements ItemWriter<Geolocation> {
	
	@Autowired
	GeolocationRepository geolocationRepository;

	@Override
	public void write(List<? extends Geolocation> items) throws Exception {
		geolocationRepository.saveAll(items);
	}

}
