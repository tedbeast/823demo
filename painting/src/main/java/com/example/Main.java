package com.example;

import com.example.Controller.PaintingController;

import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        PaintingController paintingController = new PaintingController();
        Javalin app = paintingController.getAPI();
        app.start(7070);
    }
}