package com.atguigu.service.impl;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.service.BookService;

import java.util.List;

/**
 * 添加图书,删除图书,修改图书,查询图书
 *
 * @author shkstart
 * @create 2020-07-30 21:54
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);

    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);

    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);

    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pagerNo, int pageSize) {
        Page<Book> page = new Page<Book>();
        // 设置当前页码
        page.setPageNo(pagerNo);
        // 设置每页显示的数量
        page.setPageSize(pageSize);
        //设置总记录数
        Integer pageTotalCount = bookDao.querForPageTotalCount();
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        // 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1)*pageSize;
        // 求当前页数据
        List<Book> items = bookDao.querForPageItems(begin, pageSize);
        // 设置当前页数据
        page.setItem(items);



        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pagerNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<Book>();
        // 设置当前页码
        page.setPageNo(pagerNo);
        // 设置每页显示的数量
        page.setPageSize(pageSize);
        //设置总金额数
        Integer pageTotalCount = bookDao.querForPageTotalCountByPrice(min,max);
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        // 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1)*pageSize;
        // 求当前页数据
        List<Book> items = bookDao.querForPageItemsByPrice(begin, pageSize,min,max);
        // 设置当前页数据
        page.setItem(items);



        return page;
    }

}



    