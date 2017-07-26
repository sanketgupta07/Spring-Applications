/**
 * 
 */
package com.sanket.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Sanket Gupta
 *
 */


@JsonIgnoreProperties(ignoreUnknown=true)
public class Value {
	
	private long id;
	private String quote;

	/**
	 * 
	 */
	public Value() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the quote
	 */
	public String getQuote() {
		return quote;
	}

	/**
	 * @param quote the quote to set
	 */
	public void setQuote(String quote) {
		this.quote = quote;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Value [id=" + id + ", quote=" + quote + "]";
	}

	
}
