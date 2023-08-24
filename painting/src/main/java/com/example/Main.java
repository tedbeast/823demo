package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.Controller.PaintingController;

import io.javalin.Javalin;

public class Main {

    public static final Logger myLogger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        PaintingController paintingController = new PaintingController();
        Javalin app = paintingController.getAPI();
        app.start(7070);
    }
    public static Logger getLogger(){
        return myLogger;
    }
}
/**
 * REST
 * Testing/Mocking/TDD
 * Logging
 */