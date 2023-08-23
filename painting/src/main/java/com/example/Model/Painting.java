package com.example.Model;

public class Painting {
    public int id;
    public String author;
    public String title;
    public int year;
    /**
     * we need this constructor or else jackson databind will give us a weird error... "unable to deserialize"
     * jackson databind, when it's converting json to java object, actually tries to always use the no-args constructor
     */
    public Painting(){

    }

    public Painting(int id, String author, String title, int year) {
        this.id = id;
        this.author = author; 
        this.title = title; 
        this.year = year;
    }



}