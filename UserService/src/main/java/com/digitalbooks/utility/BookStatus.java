package com.digitalbooks.utility;

public class BookStatus {
	
	private String status;
	private String fieldName;
	private boolean fieldValue;
	
	
	
	
	public BookStatus() {
		super();
	}
	
	public BookStatus(String status) {
		super();
		this.status = status;
	}

	public BookStatus(String status, String fieldName, boolean fieldValue) {
	
		this.status = status;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getResource() {
		return status;
	}
	public void setResource(String resource) {
		this.status = resource;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public boolean isFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(boolean fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	
	
}
