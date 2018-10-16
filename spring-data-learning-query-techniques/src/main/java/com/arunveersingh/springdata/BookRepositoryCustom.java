package com.arunveersingh.springdata;

import com.arunveersingh.springdata.data.entities.Book;

/**
 * Custom repository Interface
 * @author arunveersingh9@gmail.com
 *
 */
public interface BookRepositoryCustom {
	
	void saveAndLog(Book book);

}
