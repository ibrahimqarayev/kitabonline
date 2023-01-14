package com.mycompany.kitabonline.service;

import com.mycompany.kitabonline.dto.BookListItemResponse;
import com.mycompany.kitabonline.dto.SaveBookRequest;
import com.mycompany.kitabonline.entity.Book;
import com.mycompany.kitabonline.entity.Category;
import com.mycompany.kitabonline.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookSaveService {
    private final BookRepository bookRepository;
    private final CategoryService categoryService;

    public BookListItemResponse saveBook(SaveBookRequest saveBookRequest) {
        Category category = categoryService.loadCategory(saveBookRequest.getCategoryId());
        final Book book = Book.builder()
                .category(category)
                .title(saveBookRequest.getTitle())
                .authorName(saveBookRequest.getAuthorName())
                .bookStatus(saveBookRequest.getBookStatus())
                .lastPageNumber(saveBookRequest.getLastPageNumber())
                .totalPage(saveBookRequest.getTotalPage())
                .publisher(saveBookRequest.getPublisher())
                .build();
        final Book bookFromDB = bookRepository.save(book);
        return BookListItemResponse.builder()
                .categoryName(book.getCategory().getName())
                .id(bookFromDB.getId())
                .bookStatus(bookFromDB.getBookStatus())
                .publisher(bookFromDB.getPublisher())
                .authorName(bookFromDB.getAuthorName())
                .totalPage(bookFromDB.getTotalPage())
                .lastPageNumber(bookFromDB.getLastPageNumber())
                .title(bookFromDB.getTitle())
                .build();
    }

}
