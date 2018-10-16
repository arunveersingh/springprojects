package com.arunveersingh.springdata;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class ExtendedRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, Serializable>
		implements BaseRepository<T, Serializable> {

	private JpaEntityInformation<T, ?> entityInformation;
	private EntityManager entityManager;

	public ExtendedRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityInformation = entityInformation;
		this.entityManager = entityManager;
	}

	@Override
	public List<T> findByIds(Serializable...ids) {
		
		// Note: it is  javax.persistence.Query
		Query query = this.entityManager.createQuery("select e from " + this.entityInformation.getEntityName()
				+ " e where e." + this.entityInformation.getIdAttribute().getName() + " in :ids");
		query.setParameter("ids", Arrays.asList(ids));
		
		
		System.out.println("Execurting queries for ids " + Arrays.toString(ids));

		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done with executing queries for ids " + Arrays.toString(ids));
		return query.getResultList();
	}

}
