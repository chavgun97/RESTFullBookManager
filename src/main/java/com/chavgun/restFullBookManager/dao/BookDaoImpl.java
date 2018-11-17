package com.chavgun.restFullBookManager.dao;

import com.chavgun.restFullBookManager.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;



public class BookDaoImpl implements BookDao {
    private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(book);
        logger.debug("Книга успешно сохранена. Детали: " + book);
    }

    public void updateBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
        logger.debug("Книга успешно обновлена. Детали:" + book);
    }

    public void removeBook(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("DELETE FROM books_authors " +
                "WHERE BOOKS_ID="+id);
        query.executeUpdate();
        Book book = (Book) session.get(Book.class, id);
        if(book!=null){
            session.delete(book);
        }
        logger.debug("Книга успешно удалена. Детали: " + book);
    }

    /*2,5 часа твоего времени, и невероятное количество нервов.
    * Разберись чем отличаеться session.get от session.load,
    * и почему при session.load не работает серриализация json обьектов
    * load использует прокси, а get реальный обьект*/
    public Book getBookById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = (Book) session.get(Book.class, id);
        logger.debug("Книга успешно загружена. Детели:" + book);
        return book;
    }

    @SuppressWarnings("unchecked")
    public List<Book> listBooks() {
        Session session = sessionFactory.getCurrentSession();
        List<Book> listBooks = session.createQuery("from Book").list();
        listBooks.forEach(part->logger.debug("Лист книг:" + part));

        return listBooks;
    }

}
