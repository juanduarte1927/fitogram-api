package com.fitogram.org.models.comments;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CommentsResponse{
	private List<CommentsResponseItem> commentsResponse;
}