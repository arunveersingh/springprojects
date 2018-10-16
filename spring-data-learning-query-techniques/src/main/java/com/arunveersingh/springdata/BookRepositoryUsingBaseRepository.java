package com.arunveersingh.springdata;

import org.springframework.stereotype.Repository;

import com.arunveersingh.springdata.data.entities.Book;

/**
 * To use this class application-context.xml is also updated to add base-class.
 * <jpa:repositories
		base-package="com.arunveersingh.springdata"
		repository-impl-postfix="CustomImpl"
		base-class="com.arunveersingh.springdata.ExtendedRepositoryImpl"></jpa:repositories>
 * @author SinghAru
 *
 */
@Repository
public interface BookRepositoryUsingBaseRepository extends BaseRepository<Book, Long> {
	
	

}
