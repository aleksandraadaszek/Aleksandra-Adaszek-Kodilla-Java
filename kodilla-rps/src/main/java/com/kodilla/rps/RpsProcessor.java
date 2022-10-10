package com.kodilla.rps;


import java.util.Random;

public class RpsProcessor {

    public static int roundNumber = 0;
    private static int userScore = 0;
    private static int computerScore = 0;

    public void initialSteps() {

        UserDialogues userDialogues = new UserDialogues();
        userDialogues.displayingKeyboardSettings();

    }


    public void processGame() {

        GameSettingsRetriever gameSettingsRetriever = new GameSettingsRetriever();
        GameSettings gameSettings = gameSettingsRetriever.retrieveGameSettings();

        RpsProcessor rps = new RpsProcessor();
        rps.initialSteps();


        boolean end = true;
        while (end) {

            UserDialogues userDialogues = new UserDialogues();

            String name = gameSettings.getUserName();
            int numberOfRounds = gameSettings.getNumberOfRounds();


            boolean gameInProgress = true;
            while (gameInProgress && computerScore < numberOfRounds && userScore < numberOfRounds) {
                String userMove = userDialogues.getUserChoice();
                Random randomGenerator = new Random();
                int computerMove = randomGenerator.nextInt(3) + 1;
                if (userMove.equals("n")) {
                    System.out.println("Potwierdź swój wybór.");
                    userMove = userDialogues.getUserChoice();
                    if (userMove.equals("a")) {
                        gameInProgress = false;
                    }
                }
                else if (userMove.equals("x")) {
                    System.out.println("Potwierdź swój wybór.");
                    userMove = userDialogues.getUserChoice();
                    if (userMove.equals("a")) {
                        gameInProgress = false;
                        end = false;
                    }
                } else if (((userMove.equals("1")) && (computerMove == 3)) ||
                ((userMove.equals("2")) && (computerMove == 1)) ||
                ((userMove.equals("3")) && (computerMove == 2))) {
                        userScore++;

                } else if (((userMove.equals("2")) && (computerMove == 3)) ||
                        ((userMove.equals("3")) && (computerMove == 1)) ||
                        ((userMove.equals("1")) && (computerMove == 2))) {
                    computerScore++;

                }else{
                    System.out.println("Remis!"); }

                        System.out.println("Po tej rundzie wynik jest następujący: ");
                        System.out.println(name + " : " + userScore + "komputer: " + computerScore + ".");
                    }

            if (computerScore < numberOfRounds || userScore < numberOfRounds) {
                System.out.println("Koniec rozgrywki!");
                end = false;
            }
                }
            }


//    public void run() {
//
//        GameSettingsRetriever gameSettingsRetriever = new GameSettingsRetriever();
//        GameSettings gameSettings = gameSettingsRetriever.retrieveGameSettings();
//
//        RpsProcessor rps = new RpsProcessor();
//        rps.initialSteps();
//
//
//
//        boolean end = false;
//        while (!end) {
//
//            UserDialogues userDialogues = new UserDialogues();
//
//            String name = gameSettings.getUserName();
//            int numberOfRounds = userDialogues.selectNumberOfRounds();
//            roundNumber++;
//
//
//            boolean gameInProgress = true;
//            while (gameInProgress && roundNumber <= numberOfRounds) {
//                String userSelection = userDialogues.getUserChoice();
//                if (userSelection.equals("n"))
//                    return;
//                if (userSelection.equals("x"))
//                    gameInProgress = false;
//
//                int userMove = userDialogues.enteringUserMove();
//
//                Random randomGenerator = new Random();
//                int computerMove = randomGenerator.nextInt(3)+1;
//                for (int n = 0; n < numberOfRounds; n++) {
//                    if (userMove == 1 && computerMove == 1) {
//                        userScore++;
//                        computerScore++;
//                    } else if (userMove.equals("2") && computerMove == 2) {
//                        userScore++;
//                        computerScore++;
//                    } else if (userMove == 3 && computerMove == 3) {
//                        userScore++;
//                        computerScore++;
//                    } else if (userMove == 1 && computerMove == 2) {
//                        computerScore++;
//                    } else if (userMove == 1 && computerMove == 3) {
//                        userScore++;
//                    } else if (userMove == 2 && computerMove == 1) {
//                        userScore++;
//                    } else if (userMove == 2 && computerMove == 3) {
//                        computerMove++;
//                    } else if (userMove == 3 && computerMove == 1) {
//                        computerScore++;
//                    } else if (userMove == 3 && computerMove == 2) {
//                        userScore++;
//                        System.out.println("Po tej rundzie wynik jest następujący: ");
//                        System.out.println(name + " : " + userScore + "komputer: " + computerScore + ".");
//                    }
//
//                }
//                userDialogues.displayStatistics();
//                userDialogues.getUserChoice();
//            }
//        }
//    }

    public static int getUserScore () {
        return userScore;
    }

    public static int getComputerScore () {
        return computerScore;
    }
            }




//


