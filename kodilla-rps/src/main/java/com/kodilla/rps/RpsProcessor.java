package com.kodilla.rps;


import java.util.Random;

public class RpsProcessor {

    public static int roundNumber = 0;
    private static int userScore = 0;
    private static int computerScore = 0;

    public void initialSteps() {

        UserDialogues userDialogues = new UserDialogues();
        userDialogues.userName();
        userDialogues.selectNumberOfRounds();
        userDialogues.displayingKeyboardSettings();

    }

    public void processGame() {

        GameSettingsRetriever gameSettingsRetriever = new GameSettingsRetriever();
        GameSettings gameSettings = gameSettingsRetriever.retrieveGameSettings();

        RpsProcessor rpsProcessor = new RpsProcessor();
        rpsProcessor.initialSteps();


        boolean end = false;
        while (!end) {

            int stone = 1;
            int paper = 2;
            int scissors = 3;


            String name = gameSettings.getUserName();
            int numberOfRounds = gameSettings.getNumberOfRounds();
            roundNumber++;

            UserDialogues userDialogues = new UserDialogues();

            boolean gameInProgress = true;
            while (gameInProgress && roundNumber <= numberOfRounds) {
                String userSelection = userDialogues.enterUserChoice();
                if (userSelection == "n")
                    return;
                if (userSelection == "x")
                    gameInProgress = false;

                int userMove = userDialogues.enteringUserMove();

                Random randomGenerator = new Random();
                int computerMove = randomGenerator.nextInt(1 - 3);
                for (int n = 0; n < numberOfRounds; n++) {
                    if (userMove == 1 && computerMove == 1) {
                        userScore++;
                        computerScore++;
                    } else if (userMove == 2 && computerMove == 2) {
                        userScore++;
                        computerScore++;
                    } else if (userMove == 3 && computerMove == 3) {
                        userScore++;
                        computerScore++;
                    } else if (userMove == 1 && computerMove == 2) {
                        computerScore++;
                    } else if (userMove == 1 && computerMove == 3) {
                        userScore++;
                    } else if (userMove == 2 && computerMove == 1) {
                        userScore++;
                    } else if (userMove == 2 && computerMove == 3) {
                        computerMove++;
                    } else if (userMove == 3 && computerMove == 1) {
                        computerScore++;
                    } else if (userMove == 3 && computerMove == 2) {
                        userScore++;
                        System.out.println("Po tej rundzie wynik jest następujący: ");
                        System.out.println(name + " : " + userScore + "komputer: " + computerScore + ".");
                    }
                    end = true;
                }
                userDialogues.displayStatistics();
                userDialogues.enterUserChoice();
            }
        }
    }

    public static int getUserScore () {
        return userScore;
    }

    public static int getComputerScore () {
        return computerScore;
    }
}


