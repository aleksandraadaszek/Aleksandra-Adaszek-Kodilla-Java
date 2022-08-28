package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalCalculator;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        System.out.println("Calculating expressions with lambdas");
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        System.out.println("Beautifying texts with lambdas.");
        PoemBeautifier beautifier = new PoemBeautifier();
        beautifier.beautify("This is the very first text.", (beautifiedText) -> beautifiedText.toUpperCase());
        beautifier.beautify("And that would be the second one.", (beautifiedText) -> beautifiedText.toLowerCase());
        beautifier.beautify("The third text to be beautified!", (beautifiedText) -> beautifiedText + "ABC");
        beautifier.beautify("The last piece waiting for its spa!", (beautifiedText) -> "ABC" + beautifiedText);
        beautifier.beautify("Actually, the previous text wasn't the last one and this on isn't either.", (beautifiedText) -> beautifiedText.replace('o', 'O'));
        beautifier.beautify("And, finally, the last text awaiting its spa!", (beautifiedText) -> beautifiedText.substring(0, 14));

        System.out.println("Using stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

        System.out.println("Using stream to filter and modify names.");
        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(s -> System.out.println(s));

        System.out.println("Using stream for concatenation.");
        BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book:: toString)
                .collect(Collectors.joining(",\n", "<<", ">>"));

                System.out.println(theResultStringOfBooks);


         System.out.println("Using stream to filter and map forum's users.");
         Forum forum = new Forum();

         Map<Integer, ForumUser> theResultMapOfForumUsers =forum.getForumList().stream()
                 .filter(forumUser -> forumUser.getSex() == 'M')
                 .filter(forumUser -> ChronoUnit.YEARS.between(forumUser.getDateOfBirth(), LocalDate.now()) >=20)
                 .filter(forumUser -> forumUser.getNumberOfPosts() > 0)
                 .collect(Collectors.toMap(ForumUser::getIdNumber, forumUser -> forumUser));

         theResultMapOfForumUsers.entrySet().stream()
                 .map(entry -> entry.getKey() + ":" + entry.getKey())
                 .forEach(System.out::println);


    }
}
