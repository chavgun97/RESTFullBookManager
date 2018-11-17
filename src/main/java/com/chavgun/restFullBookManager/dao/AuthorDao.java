package com.chavgun.restFullBookManager.dao;

import com.chavgun.restFullBookManager.model.Author;
import com.chavgun.restFullBookManager.model.Book;

import java.util.List;

public interface AuthorDao {

    void addAuthor(Author author);
    void updateAuthor(Author author);
    void removeAuthor(int id);
    Author getAuthorById(int id);
    List<Author> listAuthors();
}
