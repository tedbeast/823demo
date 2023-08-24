package com.example.Service;

import java.util.List;

import org.slf4j.Logger;

import com.example.Main;
import com.example.DAO.PaintingDAO;
import com.example.Model.Painting;

public class PaintingService {
    PaintingDAO paintingDAO;
    Logger log;
    public PaintingService(){
        paintingDAO = new PaintingDAO();
        log = Main.myLogger;
    }
    /**
     * first, try persisting the painting.
     * then, using the new painting's id,
     * return the full painting with its database id.
     */
    public Painting savePaintingAndReturn(Painting painting){
        int id = paintingDAO.savePaintingReturnId(painting);
        Painting persistedPainting = paintingDAO.getPaintingById(id);
        log.info("saving a painting : "+painting);
        return persistedPainting;
    }

    
    public List<Painting> getAllPaintings(){
        log.info("getting all paintings");
        return paintingDAO.getAllPaintings();
    }

}
