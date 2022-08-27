package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> theForumUsersList = new ArrayList<>();

    public Forum() {

        theForumUsersList.add(new ForumUser(367, "Johnnie", 'M', 1991, 3, 22, 0));
        theForumUsersList.add(new ForumUser(549, "Kassie", 'F', 1992, 2, 3, 23));
        theForumUsersList.add(new ForumUser(878, "Brick", 'M', 1984, 4, 5, 33));
        theForumUsersList.add(new ForumUser(78, "Edith", 'F', 1980,4, 15, 34));
        theForumUsersList.add(new ForumUser(76, "Eron", 'M', 1987, 6, 30, 33));
        theForumUsersList.add(new ForumUser(99, "Tracey", 'M', 2003, 6, 18, 2));
    }

    public List<ForumUser> getForumList() {
        return new ArrayList<>(theForumUsersList);
    }
}
