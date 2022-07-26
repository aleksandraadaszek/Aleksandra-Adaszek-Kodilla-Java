package com.kodilla.testing;
import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test ok");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator(200, 321);
        int addResult = calculator.add();
        int subResult = calculator.subtract();
        if(addResult == 521 && subResult == 121)  {
            System.out.println("Calculator test OK");
        }else{
            System.out.println("Something is wrong!");
        }
    }
}
    

