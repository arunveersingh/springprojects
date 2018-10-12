package com.arunveersingh.springdata;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;

import com.arunveersingh.springdata.data.entities.Book;

public class Application {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		BookRepository repo = context.getBean(BookRepository.class);
		
		System.out.println("Book.queryOne " + repo.queryOne());
		
		/**
		 * Paging Results
		 */
		repo.findAll(new PageRequest(0, 2)).forEach(b->System.out.println(b));
		
		repo.findAll(new PageRequest(1, 2)).forEach(b->System.out.println(b));
		
		System.out.println("************");
		repo.findByNumberOfPagesGreaterThan(210, new PageRequest(1, 2)).forEach(b->System.out.println(b));

		

	}

}
