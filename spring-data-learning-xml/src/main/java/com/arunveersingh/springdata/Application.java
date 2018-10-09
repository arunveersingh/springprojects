package com.arunveersingh.springdata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.arunveersingh.springdata.data.entities.Book;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		// BookService service = context.getBean(BookService.class);
		// Book book = new Book("First Book", new Date(), 33, new Double(26.00));

		// service.save(book);

		/**
		 * Code to see use of book repository
		 */
		BookRepository repository = context.getBean(BookRepository.class);
		
		// findOne
		Book book = repository.findOne(1L);
		System.out.println(book);

		// findAll
		List<Book> books = repository.findAll();
		books.stream().forEach(b -> System.out.println(b));

		// findAll within input - uses in clause internally
		List<Book> booksSelective = repository.findAll(new ArrayList<Long>() {
			private static final long serialVersionUID = 1L;
			{
				add(1L);
				add(2L);
			}
		});
		booksSelective.stream().forEach(b -> System.out.println(b));
		
		/**
		 * PERSISTENCE OF NEW ENTITIES
		 * 
		 */
		Book book1 = new Book("X Book", new Date(), 35, new Double(35.00));
		repository.save(book1);
		
		List<Book> booksX = BookUtil.create(5);
		repository.save(booksX);
		
		
		// fetch a book from repository and change its update and save it, it will create a new entity in DB and will leave the existing entity intact.
		Book fromRepo = repository.findOne(13L);
		fromRepo.setBookId(1000L);
		repository.save(fromRepo);
		
		List<Book> allBooks = repository.findAll();
		System.out.println("Number of books in repo: " + allBooks.size());
		
		
		/**
		 * REMOVING ENTITIES
		 */
		repository.delete(repository.findOne(14L));
		System.out.println("Number of books in repo: " + repository.findAll().size());
		
		
		repository.deleteInBatch(repository.findAll(new ArrayList<Long>() {
			{
				add(1L);add(1000L); add(3L); add(10001L);
			}
		}));

		System.out.println("Number of books in repo: " + repository.findAll().size());
		
		/**
		 * Playing with Custom Repository - With reduced access
		 */
		BookReadOnlyRepository readRepo = context.getBean(BookReadOnlyRepository.class);
		Book fromReadRepo = readRepo.findOne(5L);
		System.out.println("from read rep : " + fromReadRepo);

		

	}

}
