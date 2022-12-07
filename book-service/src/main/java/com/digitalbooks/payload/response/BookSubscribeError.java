package com.digitalbooks.payload.response;

public class BookSubscribeError {
	
	private long id;
    private String meaasge;
	public BookSubscribeError(long id, String meaasge) {
		super();
		this.id = id;
		this.meaasge = meaasge;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMeaasge() {
		return meaasge;
	}
	public void setMeaasge(String meaasge) {
		this.meaasge = meaasge;
	}
    
    
    

}
