package com.atguigu.test;

import com.atguigu.bean.Book;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;


public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "花花", "momo", new BigDecimal(999), 2000, 12000, null));
    }

    @Test
    public void deleteBookById() {

    }

    @Test
    public void updateBook() {
        bookDao.addBook(new Book(25, "华华", "momo", new BigDecimal(999), 2000, 12000, null));

    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(20));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookDao.queryBooks()) {
            System.out.println(queryBook);
            
        }
        
    }
    @Test
    public void querForPageTotalCount() {
        System.out.println(bookDao.querForPageTotalCount());

    }


    @Test
    public void querForPageItems() {
        for (Book book : bookDao.querForPageItems(8, 4)) {
            System.out.println(book);
        }
    }
    @Test
    public void querForPageTotalCountPrice() {
        System.out.println(bookDao.querForPageTotalCountByPrice(10,100));

    }
    @Test
    public void querForPageItemsByPrice() {
        for (Book book : bookDao.querForPageItemsByPrice(1, 4,10,50)) {
            System.out.println(book);
        }
    }

}