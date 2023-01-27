package com.mycompany.kitabonline.api;


import com.mycompany.kitabonline.service.BookListService;
import com.mycompany.kitabonline.service.BookSaveService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@AutoConfigureMockMvc
class BookRestControllerTest {

    @MockBean
    private BookListService bookListService;
    @MockBean
    private BookSaveService bookSaveService;

    @Test
    void itShouldSaveBook_WhenValidBookRequestBody() {
    }
}