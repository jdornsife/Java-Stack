package com.jennifer.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jennifer.mvc.models.Book;
import com.jennifer.mvc.services.BookService;

//... imports removed for brevity
@Controller
public class BooksController {
	   private final BookService bookService;
    
    public BooksController(BookService bookService) {
        this.bookService = bookService;
}
    
 @RequestMapping("/books")
 public String index(Model model) {
 	List<Book> books = bookService.allBooks();
     model.addAttribute("books", books);
     return "/books/index.jsp";
 }
}
