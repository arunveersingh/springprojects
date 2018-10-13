package com.arunveersingh.springdata;

import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.arunveersingh.springdata.data.entities.Book;

/**
 * BookRepository interface.
 * 
 * @author arunveersingh9@gmail.com
 *
 */
public interface BookRepository extends JpaRepository<Book, Long> {
	
	/**
	 * @Query
	 * @return
	 */

	@Query("select b from Book b")
	List<Book> queryOne();

	@Query("select b from Book b where b.numberOfPages > ?1")
	List<Book> queryTwo(int numberOfPages);

	@Query("select b from Book b where b.title = :title")
	List<Book> queryThree(@Param("title") String title);

	
	/**
	 * @NamedQuery
	 */
	/**
	 * Eclipse IDE will show error (Invalid derived query! No property queryOneNamed
	 * found for type Book!) on {@link NamedQuery} methods, but its fine.
	 * 
	 * @return
	 */
	List<Book> queryOneNamed();

	List<Book> queryTwoNamed(int numberOfPages);

	List<Book> queryThreeNamed(@Param("title") String title);
	
	List<Book> findByNumberOfPagesGreaterThan(int numberOfPages, Pageable pageable);
}
