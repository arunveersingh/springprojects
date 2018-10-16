package com.arunveersingh.springdata;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.arunveersingh.springdata.data.entities.Book;

/**
 * 
 * @author arunveersingh9@gmail.com
 *
 */
@Repository
public class BookRepositoryCustomImpl implements BookRepositoryCustom {
	
	private static Logger logger = LoggerFactory.getLogger(BookRepositoryCustomImpl.class);
	
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public void saveAndLog(Book book) {
		logger.debug("Saving a new book  :: " + book.toString());
		entityManager.persist(book);
	}

}
