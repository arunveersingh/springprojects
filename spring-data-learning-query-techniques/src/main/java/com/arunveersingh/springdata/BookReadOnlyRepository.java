package com.arunveersingh.springdata;

import org.springframework.stereotype.Repository;

import com.arunveersingh.springdata.data.entities.Book;

@Repository
public interface BookReadOnlyRepository extends ReadOnlyRepository<Book, Long> {


}
