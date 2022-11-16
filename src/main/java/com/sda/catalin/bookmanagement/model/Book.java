package com.sda.catalin.bookmanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "book")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
private Integer Id;
    @Column(name = "title")
private String title;
    @Column(name = "description")
private String description;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(Integer id, String title, String description) {
        Id = id;
        this.title = title;
        this.description = description;
    }

    public Book() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
