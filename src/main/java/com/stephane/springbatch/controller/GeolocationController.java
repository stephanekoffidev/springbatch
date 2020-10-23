package com.stephane.springbatch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stephane.springbatch.domain.Geolocation;
import com.stephane.springbatch.dao.GeolocationRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
public class GeolocationController {
	
	@Autowired
	GeolocationRepository geolocationRepository;
	
	@GetMapping("allGeolocations")
	public List<Geolocation> findAll() {
		return geolocationRepository.findAll();
	}
	
	@GetMapping("findGeolocationByCityName")
	public Geolocation findGeolocationByCityName(@RequestParam String cityName) {
		return geolocationRepository.findByCityName(cityName);
	}
	
	@PatchMapping("updateGeolocation")
	public Geolocation update(@RequestBody Geolocation geolocation) {
		return geolocationRepository.save(geolocation);
	}
		
}
