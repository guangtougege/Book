package com.atguigu.service;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;

import java.util.List;

/**
 * Service业务层
 * 添加图书,删除图书,修改图书,查询图书
 * @author shkstart
 * @create 2020-07-30 21:51
 */
public interface BookService {

    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Page<Book> page(int pagerNo, int pageSize);

    Page<Book> pageByPrice(int pagerNo, int pageSize, int min, int max);
}

