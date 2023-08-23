package com.jay.service.impl;

import com.jay.controller.Code;
import com.jay.dao.BookDao;
import com.jay.exception.BusinessException;
import com.jay.pojo.Book;
import com.jay.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        return bookDao.save(book) > 0;
    }

    @Override
    public boolean update(Book book) {
        return bookDao.update(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.delete(id) > 0;
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Override
    public Book getById(Integer id) {

        if (id <= 0) {
            throw new BusinessException(Code.BUSINESS_ERR,"sb，叉出去");
        }
//
//        //将可能出现的异常进行包装，转换成自定义异常
//        try {
//            int i = 1 / 0;
//        } catch (Exception e) {
//            throw new SystemException(Code.SYSTEM_TIMEOUT_ERR, "服务器访问超时，请重试", e);
//        }

        return bookDao.getById(id);
    }
}
