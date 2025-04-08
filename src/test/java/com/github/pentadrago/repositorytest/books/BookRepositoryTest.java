package com.github.pentadrago.repositorytest.books;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    // Zugriff über findById funktioniert

    @Test
    void findsBook() {
        Book book = new Book();
        book.setTitle("QualityLand");

        Book saved = bookRepository.save(book);

        Optional<Book> bookOptional = bookRepository.findById(saved.getId());

        assertThat(bookOptional).get().extracting(Book::getTitle).isEqualTo(saved.getTitle());
    }

    // Verwendung in finder-Methoden und Queries funktioniert nicht

    @Test
    void findsBookJPQLthrowsException() {
        Book book = new Book();
        book.setTitle("QualityLand");

        Book saved = bookRepository.save(book);

        assertThatException().isThrownBy(() -> bookRepository.findByBookIdJPQL(saved.getId()));
    }
}