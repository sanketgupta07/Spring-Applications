/**
 * 
 */
package com.sanket.spring.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sanket.spring.model.Account;

/**
 * @author Sanket Gupta
 *
 */
public interface AccountRepository extends MongoRepository<Account, String>{
	/**
	 * Account for user.
	 * @param username
	 * @return {@link Optional}<{@link Account}>
	 */
	Optional<Account> findByUsername(String username);

}
