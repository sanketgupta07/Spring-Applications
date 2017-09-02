/**
 * 
 */
package com.sanket.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Sanket Gupta
 *
 */

public class Bookmark {

	private String id;
	
	@JsonIgnore
	private Account account;
	
	private String uri;
	private String description;
	/**
	 * @param account
	 * @param uri
	 * @param description
	 */
	public Bookmark(Account account, String uri, String description) {
		this.account = account;
		this.uri = uri;
		this.description = description;
	}
	/**
	 * for JPA use
	 */
	public Bookmark() {}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}
	/**
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}	

}
