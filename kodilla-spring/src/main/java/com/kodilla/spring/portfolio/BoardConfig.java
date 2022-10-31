package com.kodilla.spring.portfolio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class BoardConfig {

    @Autowired
    @Qualifier("toDoList")
    TaskList toDoList;

    @Bean (name = "toDoList")
    @Scope( value = "prototype")
    public TaskList getToDoList () {
        return new TaskList();
    }
    @Autowired
    @Qualifier("inProgressList")
    TaskList inProgressList;


    @Bean(name = "inProgressList")
    @Scope(value = "prototype")
    public TaskList getInProgressList() {
        return new TaskList();
    }
    @Autowired
    @Qualifier("doneList")
    TaskList doneList;


    @Bean(name = "doneList")
    @Scope(value = "prototype")
    public TaskList getDoneList() {
        return new TaskList();
    }

     @Bean
     public Board  getAllTasks () {
         return new Board(toDoList,inProgressList, doneList);
        }
    }

