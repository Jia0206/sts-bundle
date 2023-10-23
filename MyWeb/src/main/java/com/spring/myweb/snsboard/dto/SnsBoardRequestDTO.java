package com.spring.myweb.snsboard.dto;

import org.springframework.web.multipart.MultipartFile;

import com.spring.myweb.user.dto.UserJoinRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor


public class SnsBoardRequestDTO {
	
	private String content;
	private String writer;
	private MultipartFile file;
	
}
