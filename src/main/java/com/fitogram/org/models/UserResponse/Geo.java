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
public class Geo{

	@JsonProperty("lng")
	private String lng;

	@JsonProperty("lat")
	private String lat;
}