package com.arunveersingh.springdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arunveersingh.springdata.data.entities.Book;

@Service
public class BookService {

	@Autowired
	private BookRepository repo;
	
	public void save(Book book) {
		this.repo.save(book);
	}
}
