package com.kodilla.testing.statistics;


import java.util.List;

public class ForumStatistics {

 private int numberOfUsers;
 private int numberOfPosts;
 private int numberOfComments;
 private double averageNumberOfPostsPerUser;
 private double averageNumberOfCommentsPerUser;
 private double averageNumberOfCommentsPerPost;


   public void calculateAdvancedStatistics (Statistics statistics) {
     numberOfUsers = statistics.usersNames().size();
     numberOfPosts = statistics.postsCount();
     numberOfComments = statistics.commentsCount();
     if(numberOfUsers != 0) {
         averageNumberOfPostsPerUser = numberOfPosts/ (double) numberOfUsers;
     }else{
         averageNumberOfPostsPerUser = 0;
     }
     if(numberOfUsers != 0) {
         averageNumberOfCommentsPerUser = numberOfComments /(double) numberOfUsers;
     }else{
         averageNumberOfCommentsPerUser = 0;
     }
     if (numberOfPosts != 0) {
           averageNumberOfCommentsPerPost = numberOfComments / (double) numberOfPosts;
     }else{
           averageNumberOfCommentsPerPost = 0;
       }
   }

   public void showStatistics () {
     System.out.println(numberOfUsers);
     System.out.println(numberOfPosts);
     System.out.println(numberOfComments);
     System.out.println(averageNumberOfPostsPerUser);
     System.out.println(averageNumberOfCommentsPerUser);
     System.out.println(averageNumberOfCommentsPerPost);
   }


    public int getNumberOfUsers () {
        return numberOfUsers;
    }

    public int getNumberOfPosts () {
        return numberOfPosts;
    }

    public int getNumberOfComments () {
        return numberOfComments;
    }

    public double getAverageNumberOfPostsPerUser () {
        return averageNumberOfPostsPerUser;
    }

    public double getAverageNumberOfCommentsPerUser () {
        return averageNumberOfCommentsPerUser;
    }

    public double getAverageNumberOfCommentsPerPost () {
        return averageNumberOfCommentsPerPost;
    }


}
