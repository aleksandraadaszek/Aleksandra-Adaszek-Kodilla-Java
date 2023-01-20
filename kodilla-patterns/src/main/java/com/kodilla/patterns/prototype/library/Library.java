package com.kodilla.patterns.prototype.library;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Library extends PrototypeLibrary<Library> {

    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedListOfBooks = super.clone();
        clonedListOfBooks.books = new HashSet<>();
        for (Book theList : books) {
            Book clonedBooks = new Book(theList.getTitle(), theList.getAuthor(), theList.getPublicationYear());
            clonedListOfBooks.getBooks().add(clonedBooks);
        }
        return clonedListOfBooks;
    }

    @Override
    public String toString() {
        String s = "The collection of books: [ " + name + " ].\n";
        for(Book collection : books) {
            s+= collection.toString();
        }
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(books, library.books);
    }

}


