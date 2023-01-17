package com.kodilla.petterns.social;


import com.kodilla.strategy.social.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {


    @Test
    void testDefaultSharingStrategies() {
        //Given
        User snapchatUser = new Millenials("Robert McKinsay");
        User twitterUser = new YGeneration("Anitta Sobloth");
        User facebookUser = new ZGeneration("Emily Evans");

        //When
        String snapchatUserWrites = snapchatUser.sharePost();
        System.out.println("A Snapchat user shares: " + snapchatUserWrites);
        String twitterUserWrites = twitterUser.sharePost();
        System.out.println("A Twitter user shares: " + twitterUserWrites);
        String facebookUserWrites = facebookUser.sharePost();
        System.out.println("A facebook user shares: " + facebookUserWrites);

        //Then
        assertEquals("Using Snapchat", snapchatUserWrites);
        assertEquals("Using Twitter", twitterUserWrites);
        assertEquals("Using Facebook", facebookUserWrites);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User twitterUser = new YGeneration("Anitta Sobloth");

        //When
        String twitterUserWrites = twitterUser.sharePost();
        System.out.println("A Twitter user shares: " + twitterUserWrites);
        twitterUser.setNewSocialMedium(new FacebookPublisher());
        twitterUserWrites = twitterUser.sharePost();
        System.out.println("A former Twitter use now shares: " + twitterUserWrites);

        //Then
        assertEquals("Using Facebook", twitterUserWrites);
    }
}
