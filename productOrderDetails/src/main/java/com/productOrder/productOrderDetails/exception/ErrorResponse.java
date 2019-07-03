package com.productOrder.productOrderDetails.exception;


import java.util.Date;
import java.util.List;

/**
 * This class holds Error Response from API request
 * @author 787089
 *
 */
public class ErrorResponse {

	private String message;
	
	private List<String> details;
	
	private Date date;
	
	

	public ErrorResponse(String message, Date date,List<String> details) {
        super();
        this.message = message;
        this.details = details;
        this.date=date;
    }
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
