/**
 * 
 */
package com.sanket.spring.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanket.spring.model.Bookmark;

/**
 * @author Sanket Gupta
 *
 */
public interface BookmarkRepository extends JpaRepository<Bookmark, Long>{

	/**
	 * Bookmarks for an user.
	 * @param username
	 * @return {@link Collection}<{@link Bookmark}>
	 */
	Collection<Bookmark> findByAccountUsername(String username);

}