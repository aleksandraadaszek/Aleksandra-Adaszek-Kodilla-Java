package com.kodilla.patterns.prototype.library;


import java.time.LocalDate;
import java.util.Objects;

public final class Book {

    final String title;
    final String author;
    final LocalDate publicationYear;

    public Book(final String title, final String author, final LocalDate publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {
        return "Book{ title: " + title + ", author: " + author + ", the year of publication: " + publicationYear +" }.";
    }

    @Override
    public boolean equals (Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Book book  = (Book) o;
        return Objects.equals(title, book.title);
    }

}
