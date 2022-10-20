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


        boolean running = true;
        while (running) {

            UserDialogues userDialogues = new UserDialogues();

            String name = gameSettings.getUserName();
            int numberOfRounds = gameSettings.getNumberOfRounds();


            boolean gameInProgress = true;
            while (gameInProgress && computerScore < numberOfRounds && userScore < numberOfRounds) {
                String userMove = userDialogues.getUserChoice();
                Random randomGenerator = new Random();
                int computerMove = randomGenerator.nextInt(5) + 1;
                int computerChance = randomGenerator.nextInt(4);

                if (userMove.equals("n")) {
                    System.out.println("Potwierdź swój wybór.");
                    userMove = userDialogues.getUserChoice();
                    if (userMove.equals("a")) {
                        gameInProgress = false;
                    }
                } else if (userMove.equals("x")) {
                    System.out.println("Potwierdź swój wybór.");
                    userMove = userDialogues.getUserChoice();
                    if (userMove.equals("a")) {
                        gameInProgress = false;
                        running = false;
                    }
                }
                String showingUserMove = userDialogues.showingChoices(Integer.parseInt(userMove));
                String showingComputerMove = userDialogues.showingChoices(computerMove);
                if (computerChance == 0) {

                    if (((userMove.equals("1")) && (computerMove == 3)) ||
                            ((userMove.equals("1")) && (computerMove == 4)) ||
                            ((userMove.equals("2")) && (computerMove == 1)) ||
                            ((userMove.equals("2")) && (computerMove == 5)) ||
                            ((userMove.equals("3")) && (computerMove == 2)) ||
                            ((userMove.equals("3")) && (computerMove == 4))) {
                        userScore++;
                        System.out.println("You won!");
                        System.out.println("Your choice: " + showingUserMove + " : Computer' choice: " + showingComputerMove);

                    } else if (((userMove.equals("2")) && (computerMove == 3)) ||
                            ((userMove.equals("2")) && (computerMove == 4)) ||
                            ((userMove.equals("3")) && (computerMove == 1)) ||
                            ((userMove.equals("3")) && (computerMove == 5)) ||
                            ((userMove.equals("1")) && (computerMove == 5)) ||
                            ((userMove.equals("1")) && (computerMove == 2))) {
                        computerScore++;
                        System.out.println("Computer won!");
                        System.out.println("Your choice: " + showingUserMove + " : Computer' choice: " + showingComputerMove);

                    } else {
                        System.out.println("Remis!");
                        System.out.println("Your choice: " + showingUserMove + " : Computer' choice: " + showingComputerMove);
                    }
                } else if (computerChance == 1) {

                    if (((userMove.equals("1")) && (computerMove == 3)) ||
                            ((userMove.equals("2")) && (computerMove == 1)) ||
                            ((userMove.equals("2")) && (computerMove == 5)) ||
                            ((userMove.equals("3")) && (computerMove == 2)) ||
                            ((userMove.equals("3")) && (computerMove == 4))) {
                        userScore++;
                        System.out.println("You won!");
                        System.out.println("Your choice: " + showingUserMove + " : Computer' choice: " + showingComputerMove);

                    } else if (((userMove.equals("2")) && (computerMove == 3)) ||
                            ((userMove.equals("2")) && (computerMove == 4)) ||
                            ((userMove.equals("3")) && (computerMove == 1)) ||
                            ((userMove.equals("3")) && (computerMove == 5)) ||
                            ((userMove.equals("1")) && (computerMove == 5)) ||
                            ((userMove.equals("1")) && (computerMove == 2))) {
                        computerScore++;
                        System.out.println("Computer won!");
                        System.out.println("Your choice: " + showingUserMove + " : Computer' choice: " + showingComputerMove);
                    } else if (((userMove.equals("1")) && (computerMove == 4))) {
                        computerScore++;
                        System.out.println("Computer won as a result of cheating :D !");
                        System.out.println("Your choice: " + showingUserMove + " : Computer' choice: " + showingComputerMove + " replaced with paper :D .");
                    } else {
                        System.out.println("Remis!");
                        System.out.println("Your choice: " + showingUserMove + " : Computer' choice: " + showingComputerMove);
                    }

                } else if (computerChance == 2) {

                    if (((userMove.equals("1")) && (computerMove == 3)) ||
                            ((userMove.equals("3")) && (computerMove == 2)) ||
                            ((userMove.equals("3")) && (computerMove == 4))) {
                        userScore++;
                        System.out.println("You won!");
                        System.out.println("Your choice: " + showingUserMove + " : Computer' choice: " + showingComputerMove);

                    } else if (((userMove.equals("2")) && (computerMove == 3)) ||
                            ((userMove.equals("2")) && (computerMove == 4)) ||
                            ((userMove.equals("3")) && (computerMove == 1)) ||
                            ((userMove.equals("3")) && (computerMove == 5)) ||
                            ((userMove.equals("1")) && (computerMove == 5)) ||
                            ((userMove.equals("1")) && (computerMove == 2))) {
                        computerScore++;
                        System.out.println("Computer won!");
                        System.out.println("Your choice: " + showingUserMove + " : Computer' choice: " + showingComputerMove);
                    } else if (((userMove.equals("1")) && (computerMove == 4)) ||
                            (((userMove.equals("2")) && (computerMove == 1)) ||
                                    ((userMove.equals("2")) && (computerMove == 5)))) {
                        if (userMove.equals("1")) {
                            System.out.println("Computer won as a result of cheating :D !");
                            System.out.println("Your choice: " + showingUserMove + " : Computer' choice: " + showingComputerMove + " replaced with paper :D !");
                        } else {
                            System.out.println("Computer won as a result of cheating :D !");
                            System.out.println("Your choice: " + showingUserMove + " : Computer' choice: " + showingComputerMove + " replaced with scissors :D!");
                        }
                        computerScore++;

                    } else {
                        System.out.println("Remis!");
                        System.out.println("Your choice: " + showingUserMove + " : Computer' choice: " + showingComputerMove);
                    }
                } else {
                    System.out.println("Computer won as a result of cheating :D !");
                    computerScore++;
                    if (userMove.equals("1")) {
                        System.out.println("Your choice: " + showingUserMove + " : Computer' choice: " + showingComputerMove + " replaced with paper :D !");
                    } else if (userMove.equals("2")) {
                        System.out.println("Your choice: " + showingUserMove + " : Computer' choice: " + showingComputerMove + " replaced with scissors:D !");
                    } else if (userMove.equals("3")) {
                        System.out.println("Your choice: " + showingUserMove + " : Computer' choice: " + showingComputerMove + " replaced with a stone:D !");
                    } else if (userMove.equals("4")) {
                        System.out.println("Your choice: " + showingUserMove + " : Computer' choice: " + showingComputerMove + " replaced with a lizard:D !");
                    } else if (userMove.equals("5")) {
                        System.out.println("Your choice: " + showingUserMove + " : Computer' choice: " + showingComputerMove + " replaced with a stone:D !");
                    }
                }


                System.out.println("Po tej rundzie wynik jest następujący: ");
                System.out.println(name + " : " + userScore + "komputer: " + computerScore + ".");
            }

            if (computerScore < numberOfRounds || userScore < numberOfRounds) {
                System.out.println("Koniec rozgrywki!");
                running = false;
            }
        }
    }

    public static int getUserScore() {
        return userScore;
    }

    public static int getComputerScore() {
        return computerScore;
    }
}
