/**
 * 
 */
package com.sanket.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Sanket Gupta
 *
 */

@Entity
public class Account {
	
	@Id
	@GeneratedValue
	private long id;
	
	@OneToMany(mappedBy="account")
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
	public Account(String password, String username) {
		this.password = password;
		this.username = username;
	}

	/**
	 * @return the id
	 */
	public long getId() {
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
