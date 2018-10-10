package com.arunveersingh.springdata;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arunveersingh.springdata.data.entities.Book;

/**
 * BookRepository interface.
 * @author arunveersingh9@gmail.com
 *
 */
public interface BookRepository extends JpaRepository<Book, Long> {
	
	/**
	 * In case findByTitles, Invalid derived query! No property titles found for type Book! Did you mean 'title'? 
	 * @param abc
	 * @return
	 */
	Book findByTitle(String abc);
	
	Book findByTitleLike(String likePart);
	
	Book findByTitleContaining(String containing);
	
	List<Book> findByPriceIsGreaterThanAndPublisDateBefore(Double p, Date date );
	
	
}
