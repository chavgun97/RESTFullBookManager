package com.chavgun.restFullBookManager.model;

import com.chavgun.restFullBookManager.controller.AuthorRestController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/*
* Класы обертки для моделей, позволяют предоставлять их как ресурсы в REST сервисе,
* и удобно ими управлятью
* В данном приложении, потестировал и решил их не использывать, за ненадобностю.
* Но для рассширения функционала в будушем решил их оставить в коде.
*/

public class AuthorResurce extends ResourceSupport {
    private final Author author;

    public AuthorResurce(Author author) {
        this.author = author;
        this.add(linkTo(AuthorRestController.class, author.getId()).withRel("author"));
    }

    public Author getAuthor() {
        return author;
    }
}
