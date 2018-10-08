package com.arunveersingh.springdata;


import org.springframework.data.jpa.repository.JpaRepository;

import com.arunveersingh.springdata.data.entities.Book;

/**
 * BookRepository interface.
 * @author arunveersingh9@gmail.com
 *
 */
public interface BookRepository extends JpaRepository<Book, Long> {
	
	
}
