package ru.otus.hw30feb.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor
@Table("BOOKS")
public class Book {
    @Id
    private Long id;
    private String title;

    @PersistenceCreator
    public Book (Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
