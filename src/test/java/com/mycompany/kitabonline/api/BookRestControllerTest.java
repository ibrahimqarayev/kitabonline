package com.mycompany.kitabonline.api;


import com.mycompany.kitabonline.service.BookListService;
import com.mycompany.kitabonline.service.BookSaveService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class BookRestControllerTest {

    @MockBean
    private BookListService bookListService;
    @MockBean
    private BookSaveService bookSaveService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void itShouldSaveBook_WhenValidBookRequestBody() {
    }
}