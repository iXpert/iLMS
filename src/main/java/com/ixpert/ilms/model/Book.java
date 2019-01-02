package com.ixpert.ilms.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "Books")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @NotNull(message = "Book must have a name")
    @Column(name = "BookName")
    private String name;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "IssueDate")
    private String issueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AuthorId", nullable = false)
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryId", nullable = false)
    private Category category;

    public Book(){}

    public Book(String name, String isbn, String issueDate){
        this.isbn = isbn;
        this.name = name;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        this.issueDate = dateFormat.format(issueDate);
    }

}




