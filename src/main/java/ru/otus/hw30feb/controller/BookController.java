package ru.otus.hw30feb.controller;

//import main.model.Book;
//import main.model.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.otus.hw30feb.model.Book;
import ru.otus.hw30feb.service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final BookService service;
    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

//    @GetMapping(name = "/books")
//    public List<Book> list() {
//        return service.getAllBooks();
//    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public RedirectView addBook(@RequestParam(value = "book") String name) {
        service.addBook(name);
        return new RedirectView("/books");
    }
}