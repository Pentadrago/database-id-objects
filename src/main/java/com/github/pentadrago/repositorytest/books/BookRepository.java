package com.github.pentadrago.repositorytest.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, BookId> {

    @Query("from Book b where b.id = :bookId")
    Optional<Book> findByBookIdJPQL(@Param("bookId") BookId id);

}
