package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String beautifiedText, PoemDecorator embellishment) {
        String finalText = embellishment.decorate(beautifiedText);
        System.out.println(finalText);
    }
}
