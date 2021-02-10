package com.SpringRest.Service;

import java.util.List;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;

import com.SpringRest.Entity.Book;
import com.SpringRest.Repository.BookRepository;
@Component //or we can use her @Services
public class BookService 
{
	@Autowired
	private BookRepository bookRepository;
	
	
	
//	private static List<Book> list=new ArrayList<>();
//	static {
//		list.add(new Book(1002,"java complete reference","james"));
//		list.add(new Book(1003,"Spring framework in java using ","mk rawats"));
//		list.add(new Book(1004,"Hibernate using java for backend ","p.k kumar "));
//		list.add(new Book(1005,"core java books here  ","pkj rastogi ... "));
//
//	}
	//get all books here 
	public List<Book>getAllBooks()
	{
		
//		List<Book> list=(List<Book>) this.bookRepository.findAll();
		List<Book> list=(List<Book>) this.bookRepository.findAll();
		
		return list;
	}
	
	//get single book by id
	
	public Book getBookById(int id)
	{
	
		Book book=null;
		try {
		//book =list.stream().filter(e->e.getId()==id).findFirst().get();
		book =this.bookRepository.findById(id);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("your file is not here please search a correct file ");
		}
		
		return book;
	}
	
	//adding the books here or creating the books 
	public Book addBooks(Book book)
	{
		Book result =bookRepository.save(book);
		return result;
	}
	
	//declare here a method for delete 
//	public void deleteBook(int bookId)
//	{
//		list.stream().filter(book->{
//			if(book.getId()!=bookId)
//			{
//				return  true;
//			}
//			else {
//				return false;
//			}
//		}).collect(Collectors.toList());
//		
//	}
	//this is also declare here for delete the books ...
	public void deleteBook(int bId) 
	{
		//list.stream().filter(book->book.getId()!=bId).
		bookRepository.deleteById(bId);	
		
		//collect(Collectors.toList());
		
	}
	//update book handler here 

	public void updateBook(Book book, int bookId)
	{
//		list.stream().map(b->{
//			if(b.getId()==bookId)
//			{
//				b.setTitle(book.getTitle());
//				b.setAuther(book.getAuther());
//				
//			}
//			return b;
//			
//		}).collect(Collectors.toList());
		
		book.setId(bookId);
		bookRepository.save(book);
		
		// TODO Auto-generated method stub
		
	}

	

}
