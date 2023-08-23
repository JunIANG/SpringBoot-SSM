package com.jay;

import com.jay.pojo.Book;
import com.jay.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootSsmApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    void contextLoads() {

//        List<Book> bookList = bookService.getAll();
        Book book = bookService.getById(19);
        System.out.println(book);

    }
}
