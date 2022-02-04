package com.fitogram.org.models.posts;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostsResponseItem{

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("body")
	private String body;

	@JsonProperty("userId")
	private Integer userId;
}