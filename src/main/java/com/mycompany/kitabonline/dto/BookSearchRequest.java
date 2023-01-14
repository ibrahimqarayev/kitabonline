package com.mycompany.kitabonline.dto;

import lombok.Getter;

@Getter
public class BookSearchRequest {
    private int size;
    private int page;
}
