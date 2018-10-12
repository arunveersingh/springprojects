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
	
	// Logical keyword And
	List<Book> findByPriceIsGreaterThanAndPublisDateBefore(Double p, Date date );
	
	Book findByTitleIgnoreCase(String title);
	
	
	// Relational Operators - arguments must have implemented Comparable - in this case auto-boxing
	List<Book> findByNumberOfPagesEquals(int pageCount);
	
	List<Book> findByNumberOfPagesGreaterThan(int pageCount);

	List<Book> findByNumberOfPagesBetween(int min, int max);
	
	// Ordering Results
	Book findByTitleContainingOrderByTitleDesc(String abc);

	// Limiting Query Results
	Book findTopByOrderByNumberOfPagesDesc();
	
	List<Book> findTop5ByOrderByNumberOfPagesDesc();
	
	List<Book> findByAuthorIdFirstName(String firstName);

}
