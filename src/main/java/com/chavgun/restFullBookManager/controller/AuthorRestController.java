package com.chavgun.restFullBookManager.controller;


import com.chavgun.restFullBookManager.model.Author;

import com.chavgun.restFullBookManager.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/authors")
@RestController
public class AuthorRestController {

    private AuthorService authorService;

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> getBookById(@PathVariable("id") Integer authorId) {
        if (authorId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Author author = authorService.getAuthorById(authorId);

        if (author == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> saveAuthor(@RequestBody @Valid Author author) {
        HttpHeaders headers = new HttpHeaders();

        if (author == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        authorService.addAuthor(author);
        return new ResponseEntity<>(author, headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> updateAuthor(@RequestBody @Valid Author author, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (author == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        authorService.updateAuthor(author);


        return new ResponseEntity<>(author, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> deleteAuthor(@PathVariable("id") Integer id) {
       Author author = authorService.getAuthorById(id);

        if (author == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        authorService.removeAuthor(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Author>> getAllBooks() {
        List<Author> authors = authorService.listAuthors();

        if (authors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }



}
