package com.fitogram.org.models.comments;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentsResponseItem{
	private String name;
	private Integer postId;
	private Integer id;
	private String body;
	private String email;
}
