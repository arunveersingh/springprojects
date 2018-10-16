package com.arunveersingh.springdata;

import java.util.stream.LongStream;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.util.SystemPropertyUtils;

import com.arunveersingh.springdata.data.entities.Book;

public class Application {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		BookRepository repo = context.getBean(BookRepository.class);

		System.out.println("Book.queryOne " + repo.queryOne());

		/**
		 * Paging Results
		 */
		repo.findAll(new PageRequest(0, 2)).forEach(b -> System.out.println(b));

		repo.findAll(new PageRequest(1, 2)).forEach(b -> System.out.println(b));

		System.out.println("************");
		repo.findByNumberOfPagesGreaterThan(210, new PageRequest(1, 2)).forEach(b -> System.out.println(b));

		System.out.println("****** SLICE ******");
		Slice<Book> slice = repo.findByNumberOfPagesLessThan(210, new PageRequest(1, 2));
		slice.getContent().stream().forEach(b -> System.out.println(b));
		;

		repo.saveAndLog(BookUtil.create());

		/**
		 * Sort
		 */
		System.out.println("SORTING QUERIES");
		// HQL: select generatedAlias0 from
		// com.arunveersingh.springdata.data.entities.Book as generatedAlias0 left join
		// generatedAlias0.authorId as generatedAlias1 order by generatedAlias1.lastname
		// asc, generatedAlias0.numberOfPages asc
		repo.findAll(new Sort(Sort.Direction.ASC, "authorId.lastname", "numberOfPages"));

		// HQL: select generatedAlias0 from
		// com.arunveersingh.springdata.data.entities.Book as generatedAlias0 left join
		// generatedAlias0.authorId as generatedAlias1 order by generatedAlias1.lastname
		// asc, generatedAlias0.numberOfPages desc
		repo.findAll(
				new Sort(Sort.Direction.ASC, "authorId.lastname").and(new Sort(Sort.Direction.DESC, "numberOfPages")));
		
		/**
		 * Query Method Return Type
		 */
		Page<Book> books = repo.findByNumberOfPagesGreaterThan(3, new PageRequest(1, 3));
		books.forEach(b->System.out.println("Book from Page: " + b));
		
		BookRepositoryUsingBaseRepository repoUsingBase = context.getBean(BookRepositoryUsingBaseRepository.class);
		//repoUsingBase.findByIds(1L, 8L).forEach(a->System.out.println("repoUsingBase: "+ a));
		
		/**
		 * Below code is working
		 */

		/*LongStream.range(0, 4).forEach(val -> {
			repoUsingBase.findByIds(val);
		});*/
		
		//System.out.println(repoUsingBase.findByIds(1L));
		//System.out.println(repoUsingBase.findByIds(2L));
		//System.out.println(repoUsingBase.findByIds(3L));

		
		/**
		 * See CustomAuditAware and see customAuditAware in application-context.xml
		 */
		Book newBookWithAudit = BookUtil.create();
		repo.save(newBookWithAudit);
		System.out.println(newBookWithAudit);
		

	}

}