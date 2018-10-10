package com.arunveersingh.springdata;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.arunveersingh.springdata.data.entities.Book;

public class Application {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		BookRepository repo = context.getBean(BookRepository.class);

		/**
		 * select book0_.bookId as bookId1_0_, book0_.numberOfPages as numberOf2_0_,
		 * book0_.price as price3_0_, book0_.publisDate as publisDa4_0_, book0_.title as
		 * title5_0_ from BOOK book0_ where book0_.title=?
		 */
		Book byTitle = repo.findByTitle("A");
		System.out.println(byTitle);

		/**
		 * HQL: select
		 * generatedAlias0 from com.arunveersingh.springdata.data.entities.Book as
		 * generatedAlias0 where ( generatedAlias0.price>:param0 ) and (
		 * generatedAlias0.publisDate<:param1 ) 
		 * 
		 * SQL: select book0_.bookId as bookId1_0_,
		 * book0_.numberOfPages as numberOf2_0_, book0_.price as price3_0_,
		 * book0_.publisDate as publisDa4_0_, book0_.title as title5_0_ from BOOK book0_
		 * where book0_.price>? and book0_.publisDate<?
		 */
		repo.findByPriceIsGreaterThanAndPublisDateBefore(1.00, new Date()).stream()
				.forEach(book -> System.out.println(book));

	}

}
