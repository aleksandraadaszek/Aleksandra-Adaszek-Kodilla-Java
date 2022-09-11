package com.kodilla.testing.statistics;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.kodilla.testing.library.BookDirectoryTestSuite.testCounter;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testing calculating advanced statistics")
public class ForumStatisticsTestSuite {


    @Mock
    private Statistics statisticsMock;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of all tests");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("This is the end of all tests");
    }

    @BeforeEach
    public void beforeEachTest() {

        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);

        List<String> listOfUsers = List.of("User1", "User2", "User3", "User4", "User5", "User6");
        when(statisticsMock.usersNames()).thenReturn(listOfUsers);
        when(statisticsMock.postsCount()).thenReturn(30);
        when(statisticsMock.commentsCount()).thenReturn(17);
    }


    @Test
    void testForumStatisticsWith0Users() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        List<String> listOfUsers = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(listOfUsers);

        //When
        forumStatistics.calculateAdvancedStatistics(statisticsMock);

        //Then
        assertEquals(0, forumStatistics.getNumberOfUsers());
        assertEquals(30, forumStatistics.getNumberOfPosts());
        assertEquals(17, forumStatistics.getNumberOfComments());
        assertEquals(0, forumStatistics.getAverageNumberOfPostsPerUser());
        assertEquals(0, forumStatistics.getAverageNumberOfCommentsPerUser());
        assertEquals(0.56, forumStatistics.getAverageNumberOfCommentsPerPost());
    }

    @Test
    void testForumStatisticsWith0Posts() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        forumStatistics.calculateAdvancedStatistics(statisticsMock);

        //Then
        assertEquals(6, forumStatistics.getNumberOfUsers());
        assertEquals(0, forumStatistics.getNumberOfPosts());
        assertEquals(0, forumStatistics.getNumberOfComments());
        assertEquals(0, forumStatistics.getAverageNumberOfPostsPerUser());
        assertEquals(0, forumStatistics.getAverageNumberOfCommentsPerUser());
        assertEquals(0, forumStatistics.getAverageNumberOfCommentsPerPost());
    }

    @Test
    void testForumStatisticsWith0Comments() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postsCount()).thenReturn(30);

        //When
        forumStatistics.calculateAdvancedStatistics(statisticsMock);

        //Then
        assertEquals(6, forumStatistics.getNumberOfUsers());
        assertEquals(30, forumStatistics.getNumberOfPosts());
        assertEquals(0, forumStatistics.getNumberOfComments());
        assertEquals(5, forumStatistics.getAverageNumberOfPostsPerUser());
        assertEquals(0, forumStatistics.getAverageNumberOfCommentsPerUser());
        assertEquals(0, forumStatistics.getAverageNumberOfCommentsPerPost());
    }

    @Test
    void testForumStatisticsWith1000Posts () {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        when(statisticsMock.postsCount()).thenReturn(1000);

        //When
        forumStatistics.calculateAdvancedStatistics(statisticsMock);

        //Then
        assertEquals(6, forumStatistics.getNumberOfUsers());
        assertEquals(1000, forumStatistics.getNumberOfPosts());
        assertEquals(17, forumStatistics.getNumberOfComments());
        assertEquals(166.66, forumStatistics.getAverageNumberOfPostsPerUser());
        assertEquals(2.83, forumStatistics.getAverageNumberOfCommentsPerUser());
        assertEquals(0.017, forumStatistics.getAverageNumberOfCommentsPerPost());
    }

    @Test
    void testForumStatisticsWithMoreCommentsThanPosts () {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(120);

        //When
        forumStatistics.calculateAdvancedStatistics(statisticsMock);

        //Then
        assertEquals(6, forumStatistics.getNumberOfUsers());
        assertEquals(100, forumStatistics.getNumberOfPosts());
        assertEquals(120, forumStatistics.getNumberOfComments());
        assertEquals(16.66, forumStatistics.getAverageNumberOfPostsPerUser());
        assertEquals(20, forumStatistics.getAverageNumberOfCommentsPerUser());
        assertEquals(1.2, forumStatistics.getAverageNumberOfCommentsPerPost());
    }

    @Test
    void testForumStatisticsWithMorePostsThanComments () {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        when(statisticsMock.postsCount()).thenReturn(300);
        when(statisticsMock.commentsCount()).thenReturn(120);

        //When
        forumStatistics.calculateAdvancedStatistics(statisticsMock);

        //Then
        assertEquals(6, forumStatistics.getNumberOfUsers());
        assertEquals(300, forumStatistics.getNumberOfPosts());
        assertEquals(120, forumStatistics.getNumberOfComments());
        assertEquals(50, forumStatistics.getAverageNumberOfPostsPerUser());
        assertEquals(20, forumStatistics.getAverageNumberOfCommentsPerUser());
        assertEquals(0.4, forumStatistics.getAverageNumberOfCommentsPerPost());


}
    @Test
    void testForumStatisticsWith100Users () {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        List<String> listOfUsers = new ArrayList<>();
            for( int n = 0; n < 100; n++) {
                listOfUsers.add("User");
                when(statisticsMock.usersNames()).thenReturn(listOfUsers);
        }

        //When
        forumStatistics.calculateAdvancedStatistics(statisticsMock);

        //Then
        assertEquals(100, forumStatistics.getNumberOfUsers());
        assertEquals(30, forumStatistics.getNumberOfPosts());
        assertEquals(17, forumStatistics.getNumberOfComments());
        assertEquals(0.3, forumStatistics.getAverageNumberOfPostsPerUser());
        assertEquals(0.17, forumStatistics.getAverageNumberOfCommentsPerUser());
        assertEquals(0.56, forumStatistics.getAverageNumberOfCommentsPerPost());
    }
}
