package com.example.Controller;

import com.example.Model.Painting;
import com.example.Service.PaintingService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

    static PaintingService paintingService = new PaintingService();
    
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
    /**
     * retrieve the request body json as a painting object,
     * ask the service to persist and return the painting object,
     * and respond with that as json
     * @param ctx
     */
    public static void postHandler(Context ctx){
        String requestJson = ctx.body();
        ObjectMapper om = new ObjectMapper();
        try{
            Painting painting = om.readValue(requestJson, Painting.class);
            Painting persistedPainting = paintingService.savePaintingAndReturn(painting);
            ctx.json(persistedPainting);
        }catch(JsonProcessingException e){
            ctx.status(400);
        }
    }
    public static void getAllHandler(Context ctx){

    }
    public static void getSingleHandler(Context ctx){

    }

}
