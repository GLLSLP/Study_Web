package com.example.demo.mvc.domain;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Board {
	//@JsonProperty
	private int boardSeq;
	//@JsonProperty
	private String title;
	//@JsonProperty
	private String contents;
	//@JsonProperty
	private Date regDate;

}
