package com.digitalbooks.exceptions;


public class ResourceNotFound extends RuntimeException {
	
	private String resourceName;
	private String fieldName;
	private int fieldValue;
	
	public ResourceNotFound(String resourceName, String fieldName, int fieldValue) {
		super(String.format("%s Not Found with %s:%s",resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
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
