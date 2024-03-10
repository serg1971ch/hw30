package ru.otus.hw30feb.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.hw30feb.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
      Book getBooksById(long id);
}
