package com.kodilla.rps;



public class GameSettingsRetriever {

    public GameSettings retrieveGameSettings () {

        UserDialogues userDialogues = new UserDialogues();
        String userName = userDialogues.userName();
        int numberOfRounds = userDialogues.selectNumberOfRounds();

        return new GameSettings(userName, numberOfRounds);
    }
}
