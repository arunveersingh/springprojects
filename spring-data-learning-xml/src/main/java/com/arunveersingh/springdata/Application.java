package com.arunveersingh.springdata;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.arunveersingh.springdata.data.entities.Book;

public class Application {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		BookService service = context.getBean(BookService.class);
		Book book = new Book("First Book", new Date(), 33, new Double(26.00));
		
		service.save(book);
	}

}
