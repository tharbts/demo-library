package com.thapps.library.Configuration;

import java.time.LocalDate;
import java.util.List;

import com.thapps.library.Model.Book;
import com.thapps.library.Repository.BookRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {
    
    @Bean
    CommandLineRunner addBooks(BookRepository bookRepository){
        return args ->{
            List<Book> books = List.of(
                new Book(
                    "Harry Potter",
                    LocalDate.now()
                ),
                new Book(
                    "Peter Pan",
                    LocalDate.now()
                )
            );
            
            bookRepository.saveAll(books);
        };

    }
}
