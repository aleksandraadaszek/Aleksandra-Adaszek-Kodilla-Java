package com.kodilla.stream.forum;

import com.kodilla.stream.forumuser.Forum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ForumUserTestSuite {


    @Test
    void getLocationOfFriends() {
        //Given
        //Create users
        ForumUser user1 = new ForumUser("alan01", "Alan Kosovsky", "Washington");
        ForumUser user2 = new ForumUser("ethanreard", "Etan Reard", "Miami");
        ForumUser user3 = new ForumUser("eRIK", "Erik Hull", "Key West");
        ForumUser user4 = new ForumUser("booth", "Mya Booth", "Washington");
        ForumUser user5 = new ForumUser("nicole1987", "Nicole Lee", "Orlando");
        ForumUser user6 = new ForumUser("nobody", "Briana Williams", "Miami");
        ForumUser user7 = new ForumUser("bigmac", "Robert Macdonald", "Washington");
        ForumUser user8 = new ForumUser("thebigone", "Clay Small", "Orlando");
        ForumUser user9 = new ForumUser("user121212", "Marisa Frank", "Washington");
        ForumUser user10 = new ForumUser("lawyer", "Lexie John", "Miami");

        //When
        //Creating relations for user1
        user1.addFriend(user3);
        user1.addFriend(user7);
        user1.addFriend(user10);
        //Creating relations for user3
        user3.addFriend(user1);
        user3.addFriend(user2);
        user3.addFriend(user7);
        user3.addFriend(user9);
        //Creating relations for user7
        user7.addFriend(user1);
        user7.addFriend(user3);
        //Creating relations for user10
        user10.addFriend(user1);
        //Creating relations for user2
        user2.addFriend(user3);
        //Creating relations for user9
        user9.addFriend(user3);

        //Then
        Assertions.assertEquals(3, user1.getLocationsOfFriends().size());
        Assertions.assertTrue(user1.getLocationsOfFriends().contains("Key West"));
        Assertions.assertTrue(user1.getLocationsOfFriends().contains("Washington"));
        Assertions.assertTrue(user1.getLocationsOfFriends().contains("Miami"));
        Assertions.assertFalse(user1.getLocationsOfFriends().contains("Orlando"));
    }

    @Test
    void getLocationOfFriendsOfFriends() {
        //Given
        //Create users
        ForumUser user1 = new ForumUser("alan01", "Alan Kosovsky", "Washington");
        ForumUser user2 = new ForumUser("ethanreard", "Etan Reard", "Miami");
        ForumUser user3 = new ForumUser("eRIK", "Erik Hull", "Key West");
        ForumUser user4 = new ForumUser("booth", "Mya Booth", "Washington");
        ForumUser user5 = new ForumUser("nicole1987", "Nicole Lee", "Orlando");
        ForumUser user6 = new ForumUser("nobody", "Briana Williams", "Miami");
        ForumUser user7 = new ForumUser("bigmac", "Robert Macdonald", "Washington");
        ForumUser user8 = new ForumUser("thebigone", "Clay Small", "Orlando");
        ForumUser user9 = new ForumUser("user121212", "Marisa Frank", "Washington");
        ForumUser user10 = new ForumUser("lawyer", "Lexie John", "Miami");

        //When
        //Creating relations for user1
        user1.addFriend(user3);
        user1.addFriend(user7);
        user1.addFriend(user10);
        //Creating relations for user3
        user3.addFriend(user1);
        user3.addFriend(user2);
        user3.addFriend(user7);
        user3.addFriend(user9);
        //Creating relations for user7
        user7.addFriend(user1);
        user7.addFriend(user3);
        //Creating relations for user10
        user10.addFriend(user1);
        //Creating relations for user2
        user2.addFriend(user3);
        //Creating relations for user9
        user9.addFriend(user3);

        //Then
        Assertions.assertEquals(3, user1.getLocationsOfFriendsOfFriends().size());
        Assertions.assertTrue(user1.getLocationsOfFriendsOfFriends().contains("Key West"));
        Assertions.assertTrue(user1.getLocationsOfFriendsOfFriends().contains("Washington"));
        Assertions.assertTrue(user1.getLocationsOfFriendsOfFriends().contains("Miami"));
        Assertions.assertFalse(user1.getLocationsOfFriendsOfFriends().contains("Orlando"));
    }

}
