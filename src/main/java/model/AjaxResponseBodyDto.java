package model;

import com.fasterxml.jackson.annotation.JsonView;

import jsonView.Views;

public class AjaxResponseBodyDto {

	@JsonView(Views.Public.class)
	String code;

	@JsonView(Views.Public.class)
	Object result;

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
