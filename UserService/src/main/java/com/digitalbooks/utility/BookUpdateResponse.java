package com.digitalbooks.utility;

public class BookUpdateResponse {

	private String resource;
	private String fieldName;
	private int fieldValue;
	
	
	
	
	public BookUpdateResponse(String resource, String fieldName, int fieldValue) {
		
		this.resource = resource;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
	public BookUpdateResponse(String resource) {
		this.resource = resource;
	}


	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public int getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(int fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	

}
