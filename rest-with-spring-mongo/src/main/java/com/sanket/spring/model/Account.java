/**
 * 
 */
package com.sanket.spring.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Sanket Gupta
 *
 */


public class Account {
	
	
	private String id;
	
	private Set<Bookmark> bookmarks = new HashSet<>();
	
	@JsonIgnore
	private String password;
	private String username;
	
	/**
	 * For JPA use
	 */
	public Account() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param password
	 * @param username
	 */
	public Account(String username, String password) {
		
		this.password = password;
		this.username = username;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the bookmarks
	 */
	public Set<Bookmark> getBookmarks() {
		return bookmarks;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
}
