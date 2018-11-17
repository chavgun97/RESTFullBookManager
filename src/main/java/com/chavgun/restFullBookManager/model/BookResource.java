package com.chavgun.restFullBookManager.model;

import com.chavgun.restFullBookManager.controller.BookRestController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import java.util.Set;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


/*
 * Классы обертки для моделей, позволяют представлять их как ресурсы в REST сервисе,
 * и удобно ими управлять.
 * В данном приложении, потестировал и решил их не использывать, за ненадобностю.
 * Но для рассширения функционала в будушем решил их оставить в коде.
 */
public class BookResource extends ResourceSupport {
    private final Book book;
    private Set<Link> authors;

    public BookResource(Book book) {
        this.book = book;
        this.add(linkTo(BookRestController.class, book.getId()).withRel("Book"));
        this.getId();
    }

    public Book getBook() {
        return book;
    }






}
