package com.stephane.springbatch.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.stephane.springbatch.domain.Geolocation;

@CrossOrigin("*")
@RepositoryRestResource
public interface GeolocationRepository extends JpaRepository<Geolocation, Long> {

	public Geolocation findByCityName(String cityName);
	
}
