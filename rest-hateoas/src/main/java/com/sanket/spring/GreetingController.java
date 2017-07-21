/**
 * 
 */
package com.sanket.spring;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Sanket Gupta
 *
 */
@RestController
public class GreetingController {

	private static final String TEMPLATE = "Hello, %s!";
	
	@RequestMapping("/greeting")
	public HttpEntity<Greeting> greet(@RequestParam(value = "name", required = false, defaultValue = "World") String name){
		Greeting greeting = new Greeting(String.format(TEMPLATE, name));
		greeting.add(linkTo(methodOn(GreetingController.class).greet(name)).withSelfRel());;
		
		return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
	}

}
