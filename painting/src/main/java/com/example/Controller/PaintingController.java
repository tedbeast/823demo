package com.example.Controller;

import java.util.List;

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
    /**
     * REST
     * Representational State Transfer
     * - we are transfering data that is a representation of some 'entity' in our application - is a resource (cars, movies, paintings, users, etc)
     * - we follow a certain set of guidelines to properly leverage HTTP requests/responses
     *      - self-descriptive URI's
     *      - URI is a pattern that identifies a particular resource
     *      - a restful URI contains only nouns, not verbs
     *      - we define what action we'd like to perform on the resource using the HTTP verb
     *      - we properly inform the sender of the request of the status of the request using the right response
     * - statelessness
     *      - because we don't store any data in-memory past the lifetime of the request/response, a RESTful api is infinitely scaleable
     *          - we can still use a database! it's external to our api. our api's job is just to manage requests/responses.
     *          - let's say that every request added items to our arraylist. (eg we're keeping track of security tokens for every active user.)
     *          - this is fine for a small amount of users.. scale up to several million, your api is now pretty slow, probably, so we don't do this
     * 
     * REST is neither the only common practice for api design (SOAP... good luck), nor is it mandatory - oftentimes, you just need to break
     * convention, do the wrong thing, and, if you'd like to sound like you know what you're doing, call it an "anti-pattern" 
     */
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
        List<Painting> allPaintings = paintingService.getAllPaintings();
        ctx.json(allPaintings);
    }
    public static void getSingleHandler(Context ctx){
        int id = Integer.parseInt(ctx.pathParam("id"));
        Painting p = paintingService.getPaintingById(id);
        if(p == null){
            ctx.status(404);
        }else{
            ctx.json(p);
        }
    }
}
