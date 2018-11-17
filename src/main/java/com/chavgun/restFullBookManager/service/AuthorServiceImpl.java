package com.chavgun.restFullBookManager.service;

import com.chavgun.restFullBookManager.dao.AuthorDao;
import com.chavgun.restFullBookManager.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorDao authorDao;
    @Autowired
    public void setAuthorDao(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Transactional
    @Override
    public void addAuthor(Author author) {
        authorDao.addAuthor(author);
    }
    @Transactional
    @Override
    public void updateAuthor(Author author) {
        authorDao.updateAuthor(author);
    }
    @Transactional
    @Override
    public void removeAuthor(int id) {
        authorDao.removeAuthor(id);
    }
    @Transactional
    @Override
    public Author getAuthorById(int id) {
        return authorDao.getAuthorById(id);
    }
    @Transactional
    @Override
    public List<Author> listAuthors() {
        return authorDao.listAuthors();
    }
}
