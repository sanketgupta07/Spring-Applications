package com.sanket.spring;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sanket.spring.dao.AccountRepository;
import com.sanket.spring.dao.BookmarkRepository;
import com.sanket.spring.model.Account;
import com.sanket.spring.model.Bookmark;

/**
 * 
 * @author Sanket Gupta
 *
 */
@SpringBootApplication
public class Application{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner init(AccountRepository accountRepository, BookmarkRepository bookmarkRepository){
		System.out.println("Initailizing");
		return (evt) -> Arrays.asList(
				"sanket,ankit,abhay,hemant,prashant,aakash".split(","))
				.forEach(
						a -> {
							Account account = accountRepository.save(new Account(a,
									"password"));
							bookmarkRepository.save(new Bookmark(account,
									"http://bookmark.com/1/" + a, "A description"));
							bookmarkRepository.save(new Bookmark(account,
									"http://bookmark.com/2/" + a, "A description"));
						});
	}
	
}
