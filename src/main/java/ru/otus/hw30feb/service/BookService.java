package ru.otus.hw30feb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw30feb.model.Book;
import ru.otus.hw30feb.repository.BookRepository;

import java.util.*;

@Service
public class BookService {
    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAllBooks() {
        Iterable<Book> bookIterable = repository.findAll();
        ArrayList<Book> books = new ArrayList<>();
        for (Book book : bookIterable) {
            books.add(book);
        }
        return books;
    }

    public Long saveBook(Book book) {
        Book newBook = repository.save(book);
        return newBook.getId();
    }

    @Transactional
    public void addBook(String name) {
        Book book = new Book();
        book.setTitle(name);
        repository.save(book);
    }

    public void returnBook(Long id) {
        repository.getBooksById(id);
    }
}
