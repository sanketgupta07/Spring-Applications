/**
 * 
 */
package com.sanket.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Sanket Gupta
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;

	/**
	 * @param username
	 */
	public UserNotFoundException(String username) {
		super("could not find user '" + username + "'.");
		this.username = username;
	}

	@Override
	public void printStackTrace() {		
		System.err.println(this.username+" account not found.");
		super.printStackTrace();
	}

	@Override
	public String getMessage() {
		System.err.println(this.username+" account not found.");
		return super.getMessage();
	}

}
