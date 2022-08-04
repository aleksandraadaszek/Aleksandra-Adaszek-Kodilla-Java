package com.kodilla.testing.library;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Book Directory Test Suite")
public class BookDirectoryTestSuite {

    public static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of all tests")
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished");
    }

    @BeforeEach
    public static void beforeEachTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    private List<Book> generateListOfBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title" + n, "Author" + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Nested
    @ExtendWith(MockitoExtension.class)
    @DisplayName("Tests for the first method in the BookLibrary class")
    class TestMethodBooksWithConditions {

        @Mock
        private LibraryDatabase libraryDatabaseMock;

        @Test
        void testBooksWithConditionsReturnList() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOfBooks = new ArrayList<>();
            Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
            Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
            Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
            Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
            resultListOfBooks.add(book1);
            resultListOfBooks.add(book2);
            resultListOfBooks.add(book3);
            resultListOfBooks.add(book4);
            when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

            //When
            List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

            //Then
            assertEquals(4, theListOfBooks.size());
        }

        @Test
        void testBooksWithConditionMoreThan20() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf0Books = new ArrayList<Book>();
            List<Book> resultListOf15Books = generateListOfBooks(15);
            List<Book> resultListOf40Books = generateListOfBooks(40);
            when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
            when(libraryDatabaseMock.listBooksWithCondition("Zero books")).thenReturn(resultListOf15Books);
            when(libraryDatabaseMock.listBooksWithCondition("Forty books")).thenReturn(resultListOf40Books);

            //When
            List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("Zero books");
            List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
            List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("Forty Books");

            //Then
            assertEquals(0, theListOfBooks0.size());
            assertEquals(15, theListOfBooks15.size());
            assertEquals(0, theListOfBooks40.size());
        }

        @Test
        void testBooksWithConditionFragmentShorterThan3() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

            //When
            List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

            //Then
            assertEquals(0, theListOfBooks10.size());
            verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
        }
    }

    @Nested
    @ExtendWith(MockitoExtension.class)
    @DisplayName("Tests for the second method in the BookLibrary class")
    class TestMethodBooksInTheHandsOf {

        @Mock
        private LibraryDatabase libraryDatabaseMock;

        @Test
        void testNoBooksInTheHandsOf () {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> currentListOfBooks = new ArrayList<>();
            LibraryUser John = new LibraryUser("John", "Smith", "9004237623");
            when(libraryDatabaseMock.listBooksInHandsOf(John)).thenReturn(currentListOfBooks);

            //When
            List<Book> actualListOfRentedBooks = bookLibrary.listBooksInHandsOf(John);

            //Then
            assertEquals(0, actualListOfRentedBooks.size());

        }

        @Test
        void test1BookInTheHandsOf () {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> presentListOfBooks = new ArrayList<>();
            LibraryUser Mary = new LibraryUser("Marianne", "Lecksthold", "8706170624");
            Book rentedBook = new Book("Around the world on foot", "Isabelle Simons", 2014);
            presentListOfBooks.add(rentedBook);
            when(libraryDatabaseMock.listBooksInHandsOf(Mary)).thenReturn(presentListOfBooks);

            //When
            List<Book> listOfRentedBooks = bookLibrary.listBooksInHandsOf(Mary);

            //Then
            assertEquals(1, listOfRentedBooks.size());


        }

        @Test
        void test5BooksInTheHandsOf () {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> presentlyRented5Books = generateListOfBooks(5);
            LibraryUser Patrick = new LibraryUser("Patrick", "Swanson", "8309234323");
            when(libraryDatabaseMock.listBooksInHandsOf(Patrick)).thenReturn(presentlyRented5Books);

            //When
            List<Book> currentlyRented5Books = bookLibrary.listBooksInHandsOf(Patrick);

            //Then
            assertEquals(5, currentlyRented5Books.size());
        }

    }
}
