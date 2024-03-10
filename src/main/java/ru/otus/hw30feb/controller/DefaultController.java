package ru.otus.hw30feb.controller;

//import main.model.Book;
//import main.model.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.otus.hw30feb.model.Book;
import ru.otus.hw30feb.repository.BookRepository;

import java.util.ArrayList;

@Controller
@RequestMapping("/books")
public class DefaultController {

    private final BookRepository bookRepository;

    @Value("${someParameter.value}")
    private Integer someParameter;

    @Autowired
    public DefaultController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping
    public String books(Model model) {
        Iterable<Book> bookIterable = bookRepository.findAll();
        ArrayList<Book> books = new ArrayList<>();
        for (Book book : bookIterable) {
            books.add(book);
        }
        model.addAttribute("books", books);
        model.addAttribute("booksCount", books.size());
        model.addAttribute("someParameter", someParameter);
        return "books";
    }
}