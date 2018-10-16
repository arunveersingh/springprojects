package com.arunveersingh.springdata;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.scheduling.annotation.Async;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

	// Uncomment @Async Annotation in case you want to run Async Queries. See
	// application-context.xml for usage of usage of task.
	// @Async
	List<T> findByIds(ID... ids);

}
