package com.example.Model;

public class Painting {
    String author;
    String title;
    int year;
    /**
     * we need this constructor or else jackson databind will give us a weird error... "unable to deserialize"
     * jackson databind, when it's converting json to java object, actually tries to always use the no-args constructor
     */
    public Painting(){

    }

    public Painting(String author, String title, int year) {
        this.author = author; 
        this.title = title; 
        this.year = year;
    }

}