package com.mycompany.kitabonline.service;

import com.mycompany.kitabonline.dto.BookResponse;
import com.mycompany.kitabonline.dto.BookSearchRequest;
import com.mycompany.kitabonline.dto.CategoryType;
import com.mycompany.kitabonline.entity.Book;
import com.mycompany.kitabonline.entity.BookStatus;
import com.mycompany.kitabonline.entity.Category;
import com.mycompany.kitabonline.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookListService {
    private final BookRepository bookRepository;
    private final CategoryService categoryService;

    public List<BookResponse> listBooks(BookSearchRequest bookSearchRequest) {
        return bookRepository.findAll(PageRequest.of(bookSearchRequest.getSize(), bookSearchRequest.getPage()))
                .getContent()
                .stream()
                .map(BookListService::convertResponse)
                .collect(Collectors.toList());
    }

    public List<BookResponse> searchByCategory(CategoryType categoryType) {
        final Category category = categoryService.findByName(categoryType.getValue());
        List<BookResponse> bookResponseList = category.getBooks().stream().map(BookListService::convertResponse).collect(Collectors.toList());
        return bookResponseList;
    }

    private static BookResponse convertResponse(Book model) {
        return BookResponse.builder()
                .title(model.getTitle())
                .authorName(model.getAuthorName())
                .imageUrl(model.getImage().getImageUrl())
                .build();
    }

    public List<BookResponse> searchBookStatus(BookStatus bookStatus) {
        return bookRepository.findByBookStatus(bookStatus)
                .stream()
                .map(each ->
                        BookResponse.builder()
                                .id(each.getId())
                                .imageUrl(each.getImageUrl())
                                .build()
                ).collect(Collectors.toList());
    }


}
