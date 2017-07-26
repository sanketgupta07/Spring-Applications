/**
 * 
 */
package com.sanket.spring.controller;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sanket.spring.dao.AccountRepository;
import com.sanket.spring.dao.BookmarkRepository;
import com.sanket.spring.exception.UserNotFoundException;
import com.sanket.spring.model.Bookmark;

/**
 * @author Sanket Gupta
 *
 */
@RestController
@RequestMapping("/{username}/bookmarks")
public class BookmarkController {

	AccountRepository accountRepository;
	BookmarkRepository bookmarkRepository;
	
	/**
	 * @param accountRepository
	 * @param bookmarkRepository
	 */
	@Autowired
	public BookmarkController(AccountRepository accountRepository, BookmarkRepository bookmarkRepository) {
		this.accountRepository = accountRepository;
		this.bookmarkRepository = bookmarkRepository;
	}
	
	/**
	 * This method will return the bookmarks for user.
	 * @param username
	 * @return {@link Collection} {@link Bookmark}
	 * @throws UserNotFoundException
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Collection<Bookmark> getBookmarksForUser(@PathVariable String username){
		this.validateUserAccount(username);
		return this.bookmarkRepository.findByAccountUsername(username);
	}
	
	/**
	 * This method will add a bookmark in user account.
	 * @param username
	 * @param bookmark
	 * @return {@link ResponseEntity}
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addBookmark(@PathVariable String username, @PathVariable Bookmark bookmark){
		this.validateUserAccount(username);
		this.accountRepository.findByUsername(username).map(account -> {
			Bookmark result = bookmarkRepository.save(new Bookmark(account,
					bookmark.getUri(), bookmark.getDescription()));
//			will create a uri to access this bookmark. 
			URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(result.getId()).toUri();

			return ResponseEntity.created(location).build();
		}).orElse(ResponseEntity.noContent().build());
		return null;
		
	}

	/**
	 * This method will return {@link Bookmark} for Id;
	 * @param username
	 * @param bookmarkId
	 * @return {@link Bookmark}
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/{bookmarkId}")
	public Bookmark getBookmark(@PathVariable String username, @PathVariable Long bookmarkId){
		this.validateUserAccount(username);
		return this.bookmarkRepository.findOne(bookmarkId);
		
	}
	
	/**
	 * This method will validate the user account.
	 * @param username
	 * @throws UserNotFoundException
	 */
	private void validateUserAccount(String username) {
		this.accountRepository.findByUsername(username).orElseThrow(()-> new UserNotFoundException(username));
		
	}
	
}
