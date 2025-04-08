package com.github.pentadrago.repositorytest.books;

import java.io.Serializable;
import java.util.Objects;

public class BookId implements Serializable {

    Long id;

    public BookId() {
    }

    public BookId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BookId bookId = (BookId) o;
        return Objects.equals(id, bookId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
