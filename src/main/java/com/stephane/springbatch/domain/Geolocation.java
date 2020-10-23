package com.stephane.springbatch.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor; 

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Geolocation {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double longitude;
	private Double latitude;
	//@Column(name="city_name")
	private String cityName;	
	
}
