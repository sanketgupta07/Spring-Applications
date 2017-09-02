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

@SpringBootApplication
public class RestWithSpringMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWithSpringMongoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(AccountRepository accountRepository, BookmarkRepository bookmarkRepository){
		
		return (evt) -> Arrays.asList(
				"sanket,ankit,abhay,hemant,prashant,aakash".split(","))
				.forEach(
						a -> {
							Account account = accountRepository.save(new Account(a,
									"password"));
							System.out.println(account);
							bookmarkRepository.save(new Bookmark(account,
									"http://bookmark.com/1/" + a, "A description"));
							bookmarkRepository.save(new Bookmark(account,
									"http://bookmark.com/2/" + a, "A description"));
						});
	}
}
