package com.example.demo.mvc.domain;

/**
 * 기본 CodeLabelEnum.
 * @author 곰돌이
 */
public interface BaseCodeLabelEnum {

	/**
	 * 코드를 리턴.
	 * @return
	 */
	String code();
	
	/**
	 * 라벨(코드명)을 리턴.
	 * @return
	 */
	String label();
	
}
