package com.kodilla.patterns.prototype.library;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        Library library = new Library("Collection 1");
        for (int i = 0; i < 10; i++) {
            Book theBook = new Book("title" + i, "author" + i, LocalDate.of(2000 + i, 2 + i, 07));
                library.getBooks().add(theBook);
            }

            Library clonedList = null;
            try {
                clonedList = library.shallowCopy();
                clonedList.setName("Collection 2");
            } catch (CloneNotSupportedException e) {
               System.out.println(e);
            }

            Library deepClonedList = null;
            try {
                deepClonedList = library.deepCopy();
                deepClonedList.setName("Collection 3");
            } catch (CloneNotSupportedException e) {
                System.out.println(e);
            }

            //When
            library.getBooks().removeIf(book->book.title.contains("title1"));

            //When
            System.out.println(library);
            System.out.println(clonedList);
            System.out.println(deepClonedList);
            assertEquals(9, library.getBooks().size());
            assertEquals(9, clonedList.getBooks().size());
            assertEquals(10, deepClonedList.getBooks().size());
            assertEquals(library.getBooks(),clonedList.getBooks());
            assertNotEquals(library.getBooks(), deepClonedList.getBooks());
        }
        }





