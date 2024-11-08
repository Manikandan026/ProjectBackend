package com.example.demo.Entity;

import lombok.Data;

@Data
public class ResponsceStructure<T> {
	
	private T data;
	private int status;
	private String msg;

	
}
