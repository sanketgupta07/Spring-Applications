/**
 * 
 */
package com.sanket.spring;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Sanket Gupta
 *
 */
public class Greeting extends ResourceSupport{
	
	private String message;

	@JsonCreator
	public Greeting(@JsonProperty("message")String message) {
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}	
}
