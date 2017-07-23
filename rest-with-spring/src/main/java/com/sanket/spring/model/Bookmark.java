/**
 * 
 */
package com.sanket.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Sanket Gupta
 *
 */
@Entity
public class Bookmark {
	@Id
	@GeneratedValue
	private long id;
	
	@JsonIgnore
	@ManyToOne
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
	public long getId() {
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
