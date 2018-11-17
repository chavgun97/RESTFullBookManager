package com.chavgun.restFullBookManager.service;


import com.chavgun.restFullBookManager.dao.BookDao;
import com.chavgun.restFullBookManager.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Transactional
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }
    @Transactional
    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }
    @Transactional
    @Override
    public void removeBook(int id) {
        bookDao.removeBook(id);
    }
    @Transactional
    @Override
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }
    @Transactional
    @Override
    public List<Book> listBooks() {
        return bookDao.listBooks();
    }
}
