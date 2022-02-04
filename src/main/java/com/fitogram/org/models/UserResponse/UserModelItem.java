package com.fitogram.org.models.UserResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
//@JsonDeserialize(as = UserModel.class)

public class UserModelItem{

	@JsonProperty("website")
	private String website;

	@JsonProperty("address")
	private Address address;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("name")
	private String name;

	@JsonProperty("company")
	private Company company;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("email")
	private String email;

	@JsonProperty("username")
	private String username;
}