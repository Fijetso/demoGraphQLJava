package com.example.demo.Service.DataFetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Model.Book;
import com.example.demo.Model.BookRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class BookDataFetcher implements DataFetcher<Book>{

	@Autowired
	BookRepository bookRepository;
	@Override
	public Book get(DataFetchingEnvironment environment) {
		String isn_string = environment.getArgument("id");
		Long isn = (long) Integer.parseInt(isn_string);
		return bookRepository.findById(isn).get();
	}

}
