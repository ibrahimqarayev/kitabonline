package com.mycompany.kitabonline.api;


import com.mycompany.kitabonline.service.BookListService;
import com.mycompany.kitabonline.service.BookSaveService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
class BookRestControllerTest {

    @Mock
    private BookListService bookListService;
    @Mock
    private BookSaveService bookSaveService;

    @Test
    void itShouldSaveBook_WhenValidBookRequestBody() {
    }
}