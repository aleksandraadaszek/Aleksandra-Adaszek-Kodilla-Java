package com.kodilla.patterns.prototype;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Board {

    private final String name;
    private final Set<TasksList> lists = new HashSet<>();

    public Board(final String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public Set<TasksList> getLists() {
        return lists;
    }

    @Override
    public String toString() {
        String s = "Board [" + name + "]\n";
        for(TasksList tasklist : lists) {
            s+= tasklist.toString();
        }
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return false;
        if(o == null || getClass() != o.getClass()) return false;
        Board board = (Board)o;
        return Objects.equals(name, board.name) && Objects.equals(lists,board.lists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lists);
    }
}
