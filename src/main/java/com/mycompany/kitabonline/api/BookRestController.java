package com.mycompany.kitabonline.api;

import com.mycompany.kitabonline.dto.BookListItemResponse;
import com.mycompany.kitabonline.dto.BookResponse;
import com.mycompany.kitabonline.dto.CategoryType;
import com.mycompany.kitabonline.dto.SaveBookRequest;
import com.mycompany.kitabonline.entity.BookStatus;
import com.mycompany.kitabonline.entity.Category;
import com.mycompany.kitabonline.service.BookListService;
import com.mycompany.kitabonline.service.BookSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/book")
@RestController
@RequiredArgsConstructor
public class BookRestController {
    private final BookListService bookListService;
    private final BookSaveService bookSaveService;

    @PostMapping("/save")
    public ResponseEntity<BookListItemResponse> saveBook(@RequestBody @Valid SaveBookRequest saveBookRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bookSaveService.saveBook(saveBookRequest));
    }

    @GetMapping("/seacrh")
    public ResponseEntity<List<BookResponse>> listBook(
            @RequestParam(name = "size") int size,
            @RequestParam(name = "page") int page) {
        return ResponseEntity.ok(bookListService.listBooks(size, page));
    }

    @GetMapping("/list/{categoryType}")
    public ResponseEntity<List<BookResponse>> listByCategory(@PathVariable CategoryType categoryType) {
        return ResponseEntity.ok(bookListService.searchByCategory(categoryType));
    }

    @GetMapping("/list/{status}")
    public ResponseEntity<List<BookResponse>> listByCategory(@PathVariable BookStatus bookStatus) {
        return ResponseEntity.ok(bookListService.searchBookStatus(bookStatus));
    }

    @GetMapping("/list/{title}")
    public ResponseEntity<List<BookResponse>> listByCategory(@PathVariable String title) {
        return ResponseEntity.ok(bookListService.searchByTitle(title));
    }


}
