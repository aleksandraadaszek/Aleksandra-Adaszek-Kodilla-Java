package com.kodilla.rps;


import java.util.Scanner;

public class UserDialogues {


    public String userName() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Jak Ci na imię?");git
        String userName = scan.nextLine();

        System.out.println("Zmierzmy się " + userName + "!");
        return userName;
    }

    public int selectNumberOfRounds() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ile rund ma mieć nasz pojedynek?");
        int numberOfRounds = scan.nextInt();

        System.out.println("Nasz pojedynek będzie się zatem składał z " + numberOfRounds + " rund.");
        return numberOfRounds;
    }

    public void displayingKeyboardSettings() {
        System.out.println("Aby wybrać: ");
        System.out.println("\"kamień\",  naciśnij 1,");
        System.out.println("\"papier\", naciśnij 2,");
        System.out.println("\"nożyczki\", naciśnij 3,");
        System.out.println("zakończenie gry, naciśnij x,");
        System.out.println("uruchomienie gry od nowa, naciśnij \"n\".");
        System.out.println("potwierdzenie wyboru, naciśnij ponownie \"n\" lub \"x\".");
        System.out.println("anulowanie wyboru, naciśnij klawisz \"z\".");
        System.out.println("Powodzenia :)!");

    }

    public String enterUserChoice() {

        RpsProcessor rps = new RpsProcessor();

        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();
        if (userChoice == "n")
            System.out.println("Czy na pewno zakończyć aktualną grę i rozpocząć nową rozgrywkę?");
        String userFinalChoice = scanner.nextLine();
        if (userFinalChoice == "n")
            return userChoice = userFinalChoice;
        if (userChoice == "z")
            rps.processGame();
        if (userChoice == "x")
            System.out.println("Czy na pewno zamknąć grę?");
        String userFinalChoice2 = scanner.nextLine();
        if (userChoice == "x")
            return userChoice = userFinalChoice2;
        if (userChoice == "z")
            rps.processGame();

        return userChoice;
    }

    public int enteringUserMove() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Wybierz swój ruch!");
        int userMove = scan.nextInt();

        System.out.println("Teraz moja kolej!");
        return userMove;
    }

    public void displayStatistics() {

        GameSettingsRetriever gameSettingsRetriever = new GameSettingsRetriever();
        GameSettings gameSettings = gameSettingsRetriever.retrieveGameSettings();
        int numberOfRounds = gameSettings.getNumberOfRounds();
        String userName = gameSettings.getUserName();

        System.out.println("Ten pojedynek składał się z " + numberOfRounds + "rund.");

        int userScore = RpsProcessor.getUserScore();
        int computerScore = RpsProcessor.getComputerScore();

        System.out.println("Wynik rozgrywki jest następujący:" + userName + ": " + userScore + "; komputer: " + computerScore + ".");

        if (userScore > computerScore) {
            System.out.println("Zwycięzcą tej rozgrywki jest " + userName + ".");
        } else {
            System.out.println("Zwycięzcą tej rozgrywki jest komputer.");
        }
    }
}

