package com.chavgun.restFullBookManager.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "AUTHORS")
public class Author {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private int id;

    @Column(name = "FIRST_NAME")
    private String first_name;

    @Column(name = "LAST_NAME")
    private String last_name;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /*Для устранения бесконечной рекурсии при выводе*/
    @JsonIgnore
    public Set<Book> getBooks() {
        return books;
    }
    @JsonIgnore
    public void setBooks(HashSet<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                  +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return Objects.equals(getFirst_name(), author.getFirst_name()) &&
                Objects.equals(getLast_name(), author.getLast_name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst_name(), getLast_name());
    }
}
