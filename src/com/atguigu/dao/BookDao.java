package com.atguigu.dao;

import com.atguigu.bean.Book;

import java.util.List;

/**
 * 图书操作的接口
 * @author shkstart
 * @create 2020-07-30 21:07
 */
public interface BookDao {
    //增删改查方法
    public int addBook(Book book);
    //删除,根据id删除
    public int deleteBookById(Integer id);
    //修改
    public int updateBook(Book book);
    //查找两种
    public Book queryBookById(Integer id);
    //查找集合多个
    public List<Book> queryBooks();


    Integer querForPageTotalCount();

    List<Book> querForPageItems(int begin, int pageSize);

    Integer querForPageTotalCountByPrice(int min, int max);

    List<Book> querForPageItemsByPrice(int begin, int pageSize, int min, int max);
}

