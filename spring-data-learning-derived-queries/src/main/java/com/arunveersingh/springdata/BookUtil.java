package com.arunveersingh.springdata;


import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.arunveersingh.springdata.data.entities.Book;

public class BookUtil {

	private static String[] titles = { "Don Quixote", "1984", "Adventures of Huckleberry Finn", "Ulysses",
			"The Great Gatsby", "On The Road", "Catch 22", "To Kill A Mockingbird", "Brave New World",
			"The Scarlet Letter" };

	public static List<Book> create(int size) {
		List<Book> books = new LinkedList<Book>();
		for (int x = 0; x < size; x++) {
			books.add(BookUtil.create());
		}
		return books;
	}

	public static Book create() {
		Book book = new Book();
		book.setTitle(titles[ThreadLocalRandom.current().nextInt(1, titles.length)]);
		book.setNumberOfPages(ThreadLocalRandom.current().nextInt(100, 151));
		book.setPublisDate(new Date());
		book.setPrice(new Double("15.00"));
		return book;
	}
	
}
