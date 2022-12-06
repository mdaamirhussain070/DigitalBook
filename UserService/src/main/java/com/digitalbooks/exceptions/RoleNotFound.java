package com.digitalbooks.exceptions;

public class RoleNotFound extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	
	public RoleNotFound(String resourceName) {
		super(String.format("%s Not Exist ",resourceName));
		this.resourceName = resourceName;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	
	

}
