package com.mycompany.kitabonline.dto;

import com.mycompany.kitabonline.entity.BookStatus;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.File;

@Data
public final class SaveBookRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String authorName;
    @NotNull
    private BookStatus bookStatus;
    @NotBlank
    private String publisher;
    @NotNull
    private Integer lastPageNumber;
    @NotNull
    private Integer totalPage;
    private File image;
    @NotNull
    private Long categoryId;


}
