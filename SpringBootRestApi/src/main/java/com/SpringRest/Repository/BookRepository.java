package com.SpringRest.Repository;

import org.springframework.data.repository.CrudRepository;

import com.SpringRest.Entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer>
{
	public Book findById(int id);

}
