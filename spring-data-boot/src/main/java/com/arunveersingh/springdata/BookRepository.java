package com.arunveersingh.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arunveersingh.springdata.data.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
