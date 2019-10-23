package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.GraphQLProvider;

import graphql.ExecutionResult;

@RestController
public class BookController {
	@Autowired
	GraphQLProvider graphQLProvider;
	@PostMapping
	public ResponseEntity<Object> getAllBooks(@RequestBody String query) {
		ExecutionResult execute = graphQLProvider.graphQL().execute(query);
		return new ResponseEntity<Object>(execute, HttpStatus.OK);
	}
	@GetMapping
	public String helloWorld() {
		return "Hello World";
	}
}
