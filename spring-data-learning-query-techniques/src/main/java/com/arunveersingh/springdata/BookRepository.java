package com.arunveersingh.springdata;

import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.arunveersingh.springdata.data.entities.Book;

/**
 * BookRepository interface.
 * 
 * This class extends BookRepositoryCustom to take advantage of
 * {@link BookRepositoryCustomImpl}. And theres is one configuration required to
 * use this. See applciation-context.xml for this
 * repository-impl-postfix="CustomImpl"
 * 
 * @author arunveersingh9@gmail.com
 *
 */
public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom {

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

	//this is working
	//List<Book> findByNumberOfPagesGreaterThan(int numberOfPages, Pageable pageable);

	Slice<Book> findByNumberOfPagesLessThan(int numberOfPages, Pageable pageable);
	
	// this is working
	//Collection<Book> findByNumberOfPagesGreaterThan(int numberOfPages);
	
	// this is working
	//Iterable<Book> findByNumberOfPagesGreaterThan(int numberOfPages);
	
	Page<Book> findByNumberOfPagesGreaterThan(int numberOfPages, Pageable pageable);
	
	/**
	 * Modifying Queries
	 */
	@Transactional
	@Modifying
	@Query("update Book b set b.numberOfPages = ?2 where b.title like ?1")
	int setNumberOfPages(String title, int numberOfPages);
	
	
}
