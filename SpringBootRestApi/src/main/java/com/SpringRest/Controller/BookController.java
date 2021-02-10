package com.SpringRest.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringRest.Entity.Book;
import com.SpringRest.Service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService; //this is use for call all the method of service....
	//@RequestMapping(value="/books",method = RequestMethod.GET)
	//@ResponseBody //this method is use for when we want to return a message nor data
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() //get all books 
	{
		List<Book> list=this.bookService.getAllBooks();
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			
		}
		return ResponseEntity.of(Optional.of(list));
		
	}
	//get a single book here
	@GetMapping("/books/{id}")//this get method is use for fetch the data 
	public ResponseEntity<Book> getSingleBook(@PathVariable("id") int id)
	{
		Book book =bookService.getBookById(id);
		if(book==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book)); 
	} 
	
	//create the books here 
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book)
	{
		System.out.println(book);
		Book b=null;
		try {
		b= this.bookService.addBooks(book);
		System.out.println(book);
		return ResponseEntity.of(Optional.of(b));
		}
		catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
	}
	
	
	//create a method here for delete ...
	 @DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId)
	{
		 System.out.println("your "+bookId+" successfully deleted..");
		this.bookService.deleteBook(bookId);
	}
	 
	 //update data here 
		@PutMapping("/books/{bookId}")
		public Book updateBook( @RequestBody Book book,@PathVariable("bookId") int bookId)
		{
			System.out.println("Your data is successfully updated...");
			this.bookService.updateBook(book,bookId);
			return book;
		}
		
	
	

}
