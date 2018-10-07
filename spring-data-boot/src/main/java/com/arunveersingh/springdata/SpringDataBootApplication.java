package com.arunveersingh.springdata;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.arunveersingh.springdata.data.entities.Book;

@SpringBootApplication
public class SpringDataBootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataBootApplication.class, args);
		
		BookRepository bookRepo = context.getBean(BookRepository.class);
		
		Book book = new Book();
		book.setTitle("My First Book");
		book.setNumberOfPages(100);
		book.setPublisDate(new Date());
		book.setPrice(100.00);
		
		bookRepo.save(book);
		
	}
}
