package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {

    public static void main (String[] args) {
        System.out.println("Calculating expressions with lambdas");
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a/ b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        System.out.println("Beautifying texts with lambdas.");
        PoemBeautifier beautifier = new PoemBeautifier();
        beautifier.beautify("This is the very first text.", (beautifiedText) -> beautifiedText.toUpperCase());
        beautifier.beautify("And that would be the second one.", (beautifiedText) ->beautifiedText.toLowerCase());
        beautifier.beautify("The third text to be beautified!", (beautifiedText) -> beautifiedText + "ABC");
        beautifier.beautify("The last piece waiting for its spa!", (beautifiedText) -> "ABC" + beautifiedText);
        beautifier.beautify("Actually, the previous text wasn't the last one and this on isn't either.", (beautifiedText) -> beautifiedText.replace('o', 'O'));
        beautifier.beautify("And, finally, the last text awaiting its spa!", (beautifiedText) -> beautifiedText.substring(0, 14));
    }
}
