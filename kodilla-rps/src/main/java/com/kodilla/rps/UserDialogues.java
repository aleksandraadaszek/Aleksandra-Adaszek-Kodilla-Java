package com.kodilla.rps;


import javax.sound.midi.Soundbank;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
import java.util.Scanner;

public class UserDialogues {


    public String userName() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Jak Ci na imię?");
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
        System.out.println("\"jaszczurka\", naciśnij 4,");
        System.out.println("\"spock\", naciśnij 5,");
        System.out.println("zakończenie gry, naciśnij x,");
        System.out.println("uruchomienie gry od nowa, naciśnij \"n\".");
        System.out.println("potwierdzenie wyboru, naciśnij ponownie \"a\" .");
        System.out.println("anulowanie wyboru, naciśnij klawisz \"b\".");
        System.out.println("Powodzenia :)!");

    }
        public String getUserChoice() {
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("Enter your choice:");
                String s = sc.nextLine();
                if ("12345nxab".contains(s)) {
                    return s;
                }
                System.out.println("Wrong choice, try again");
            }
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

    public String showingChoices (int choice) {
        if(choice == 1) {
            return "kamień";
        } else if (choice == 2) {
            return "papier";
        } else if (choice == 3) {
            return "nożyczki";
        } else if (choice == 4) {
            return "Spock";
        }
        return "jaszczurka";
    }
}

