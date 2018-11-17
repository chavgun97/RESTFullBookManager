package com.chavgun.restFullBookManager.dao;

import com.chavgun.restFullBookManager.model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthorDaoImpl implements AuthorDao {

    private static final Logger logger = LoggerFactory.getLogger(AuthorDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addAuthor(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(author);
        logger.debug("Автор успешно добавлен. Детали: " + author);
    }

    @Override
    public void updateAuthor(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.update(author);
        logger.debug("Автор успешно обновлён. Детали: " + author);
    }

    @Override
    public void removeAuthor(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("DELETE FROM books_authors " +
                "WHERE AUTHORS_ID="+id);
        query.executeUpdate();

        Author author = session.get(Author.class, id);
        if(author!=null){
            session.delete(author);
        }
        logger.debug("Автор успешно Удалён. Детали: " + author);

    }

    @Override
    public Author getAuthorById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Author author = session.get(Author.class, id);
        logger.debug("Автор успешно загружен. Детали: " + author);
        return author;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Author> listAuthors() {
        Session session = sessionFactory.getCurrentSession();
        List<Author> authors = session.createQuery("from Author").list();
        authors.forEach(author -> logger.debug("Лист авторов: " + author));
        return authors;
    }
}
