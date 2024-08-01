package com.bookapplication.core.ports;

import com.bookapplication.adapter.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

        @Query("SELECT p FROM Book p WHERE " +
                "p.nome LIKE CONCAT(:query, '%')")
        List<Book> searchBookTitle(String query);

        @Transactional
        @Query("SELECT p FROM Book p WHERE " +
                "p.nome LIKE CONCAT(:query, '%')")
        List<Book> searchBookTitleStream(String query);

        @Transactional
        @Query("SELECT p FROM Book p WHERE " +
                "p.autor LIKE CONCAT(:query, '%')")
        List<Book> searchBookAuthortStream(String query);

        @Transactional
        @Query("SELECT p FROM Book p WHERE " +
                "p.categoria LIKE CONCAT(:query, '%')")
        List<Book> searchBookCategorytStream(String query);

        @Transactional
        @Query("SELECT p FROM Book p WHERE " +
                "p.tipo LIKE CONCAT(:query, '%')")
        List<Book> searchBookTipotStream(String query);
}
