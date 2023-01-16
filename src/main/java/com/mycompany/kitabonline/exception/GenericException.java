package com.mycompany.kitabonline.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GenericException extends RuntimeException {
    private HttpStatus httpStatus;
    private ErrorCode errorCode;
    private String errorMessage;

}
