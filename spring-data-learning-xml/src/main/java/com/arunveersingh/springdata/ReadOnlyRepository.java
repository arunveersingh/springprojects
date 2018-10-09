package com.arunveersingh.springdata;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 * This class has {@link NoRepositoryBean} annotation because as soon as Spring
 * sees that any interface which extends the {@link Repository} it creates a
 * implementation class for this.
 * 
 * @author arunveersingh9@gmail.com
 *
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface ReadOnlyRepository<T, ID extends Serializable> extends Repository<T, ID> {

	/**
	 * Signature need to match as in {@link CrudRepository}
	 * @param id
	 * @return
	 */
	T findOne(ID id);

	Iterable<T> findAll();
}
