package com.example.demo.configuration.http;

import lombok.Data;

/**
 * 공통으로 사용할 응답 클래스.
 * @author 송자바
 * @param <T>
 */
@Data
public class BaseResponse<T> {

	private BaseResponseCode code;
	private String message;
	private T data;
	
	public BaseResponse(T data) {
		this.code = BaseResponseCode.SUCCESS;
		this.data = data;
	}

	public BaseResponse(BaseResponseCode code, String message) {
		// TODO Auto-generated constructor stub
		this.code=code;
		this.message=message;
		System.out.println(code+"///"+message);
	}
	
}
