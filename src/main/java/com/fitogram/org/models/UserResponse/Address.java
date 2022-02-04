package com.fitogram.org.models.UserResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address{

	@JsonProperty("zipcode")
	private String zipcode;

	@JsonProperty("geo")
	private Geo geo;

	@JsonProperty("suite")
	private String suite;

	@JsonProperty("city")
	private String city;

	@JsonProperty("street")
	private String street;
}