package com.arunveersingh.springdata.data.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOOK")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bookId;
	private String title;
	private Date publisDate; // I know it should be publishDate but leaving it as such as this is just a demo project
	private int numberOfPages;
	private Double price;
	public Book(String title, Date publisDate, int numberOfPages, Double price) {

		this.setTitle(title);
		this.setPublisDate(publisDate);
		this.setNumberOfPages(numberOfPages);
		this.setPrice(price);
	
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPublisDate() {
		return publisDate;
	}
	public void setPublisDate(Date publisDate) {
		this.publisDate = publisDate;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	

}
