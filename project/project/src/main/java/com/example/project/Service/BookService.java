package com.example.project.Service;

import com.example.project.Entity.Book;
import com.example.project.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;

    public Book createBook(Book book) {
        return bookRepo.save(book);
    }

    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    public Book getBook(int id) {
        return bookRepo.findById(id).orElse(null);
    }

    public Book updateBook(Book book) {
        return bookRepo.save(book);
    }

    public String deleteBook(int id) {
        bookRepo.deleteById(id);
        return "Book deleted successfully";
    }
}