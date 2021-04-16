package com.thapps.library.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.thapps.library.Model.Book;
import com.thapps.library.Repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll() {
		return bookRepository.findAll();
	}

    public Book save(Book book){
        book.setCreatedAt(Optional.of(book.getCreatedAt()).orElse(LocalDate.now()));
        
        return bookRepository.save(book);
    }
}
