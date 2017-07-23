/**
 * 
 */
package com.sanket.spring.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanket.spring.model.Account;

/**
 * @author Sanket Gupta
 *
 */
public interface AccountRepository extends JpaRepository<Account, Long>{
	/**
	 * Account for user.
	 * @param username
	 * @return {@link Optional}<{@link Account}>
	 */
	Optional<Account> findByUsername(String username);

}
