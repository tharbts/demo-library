package com.thapps.library.Controller;

import java.util.List;

import com.thapps.library.Model.Book;
import com.thapps.library.Service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

	private final BookService bookService;

	@Autowired
	public LibraryController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping
    public ResponseEntity<List<Book>> getAll() {
		return ResponseEntity.ok(bookService.getAll());
	}

	@PostMapping
	public ResponseEntity<Book> save(@RequestBody Book book) {
		return ResponseEntity.ok(bookService.save(book));
	}
}
