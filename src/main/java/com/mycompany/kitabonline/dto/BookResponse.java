package com.mycompany.kitabonline.dto;

import com.mycompany.kitabonline.entity.BookStatus;
import lombok.Data;

import java.io.File;

@Data
public class BookResponse {
    private String title;
    private String authorName;
    private BookStatus bookStatus;
    private String publisher;
    private Integer lastPageNumber;
    private Integer totalPage;
    private File image;
    private Long categoryId;
}
