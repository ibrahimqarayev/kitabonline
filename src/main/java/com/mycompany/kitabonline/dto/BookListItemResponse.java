package com.mycompany.kitabonline.dto;

import com.mycompany.kitabonline.entity.BookStatus;
import lombok.Builder;
import lombok.Data;

import java.io.File;

@Data
@Builder
public class BookListItemResponse {
    private Long id;
    private String title;
    private String authorName;
    private BookStatus bookStatus;
    private String publisher;
    private Integer lastPageNumber;
    private Integer totalPage;
    private File image;
    private String categoryName;

}
