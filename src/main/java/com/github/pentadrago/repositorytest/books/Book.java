package com.github.pentadrago.repositorytest.books;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(BookId.class)
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    /**
     * liefert das ID-Objekt
     */
    public BookId getId() {
        return new BookId(id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
