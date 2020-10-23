package com.stephane.springbatch.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.stephane.springbatch.domain.Geolocation;

@Component
public class GeolocationItemProcessor implements ItemProcessor<Geolocation, Geolocation> {

	@Override
	public Geolocation process(Geolocation geolocation) throws Exception {
		return geolocation;  
	}

}
 
