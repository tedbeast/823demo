package com.example.Controller;

import com.example.Service.PaintingService;

import io.javalin.Javalin;
import io.javalin.http.Context;

/**
 * As a user, I should be able to persist a painting by using a POST request to localhost:7070/painting, with the painting JSON in the body
 * As a user, I should be able to get all paintings by using a GET request to localhost:7070/painting, which will return a JSON of all paintings
 * As a user, I should able to get a single painting by its id using a GET request to localhost:7070/painting/{id}, which will return a 
 * JSON of a single painting
 * 
 * painting: int id, string title, string author, int year
 * create table painting(id int, title varchar(255), author varchar(255), year int);
 */
public class PaintingController {

    PaintingService paintingService = new PaintingService();
    public PaintingController(){
        this.paintingService = new PaintingService();
    }
    
    public Javalin getAPI(){
        Javalin app = Javalin.create();

        app.post("/painting", PaintingController::postHandler);
        app.get("/painting", PaintingController::getAllHandler);
        app.get("/painting/{id}", PaintingController::getSingleHandler);

        return app;
    }

    public static void postHandler(Context ctx){
        
    }
    public static void getAllHandler(Context ctx){

    }
    public static void getSingleHandler(Context ctx){

    }

}
