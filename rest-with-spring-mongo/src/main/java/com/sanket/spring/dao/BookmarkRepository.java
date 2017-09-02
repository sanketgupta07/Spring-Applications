/**
 * 
 */
package com.sanket.spring.dao;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sanket.spring.model.Bookmark;

/**
 * @author Sanket Gupta
 *
 */
public interface BookmarkRepository extends MongoRepository<Bookmark, String>{

	/**
	 * Bookmarks for an user.
	 * @param username
	 * @return {@link Collection}<{@link Bookmark}>
	 */
	Collection<Bookmark> findByAccountUsername(String username);

}