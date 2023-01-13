package com.mycompany.kitabonline.repository;

import com.mycompany.kitabonline.dto.BookResponse;
import com.mycompany.kitabonline.entity.Book;
import com.mycompany.kitabonline.entity.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    List<BookResponse> findByBookStatus(BookStatus bookStatus);
}
