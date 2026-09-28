package com.example.project.Controller;

import com.example.project.Entity.Book;
import com.example.project.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/createBook")
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        return new ResponseEntity<>(
                bookService.createBook(book),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/getBooks")
    public ResponseEntity<?> getBooks() {
        return new ResponseEntity<>(
                bookService.getBooks(),
                HttpStatus.OK
        );
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> getBook(@PathVariable int id) {
        return new ResponseEntity<>(
                bookService.getBook(id),
                HttpStatus.OK
        );
    }

    @PutMapping("/updateBook")
    public ResponseEntity<?> updateBook(@RequestBody Book book) {
        return new ResponseEntity<>(
                bookService.updateBook(book),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/deletebook/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id) {
        return new ResponseEntity<>(
                bookService.deleteBook(id),
                HttpStatus.OK
        );
    }
}