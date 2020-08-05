package com.atguigu.test;

import com.atguigu.bean.Book;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2020-07-30 21:58
 */
public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"消化叶","22s5",new BigDecimal(1255.255),1255,41522,null));
    }

    @Test
    public void deleteBookById() {

            bookService.deleteBookById(3);




    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(81,"225","22s5",new BigDecimal(1255.255),1255,41522,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(2));
    }

    @Test
    public void queryBooks() {
    }
    @Test
    public void page(){
        System.out.println(bookService.page(1,4));
    }

    @Test
    public void pagebyPrice(){
        System.out.println(bookService.pageByPrice(1,4,10,50));
    }

}