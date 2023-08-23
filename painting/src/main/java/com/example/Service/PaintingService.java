package com.example.Service;

import com.example.DAO.PaintingDAO;
import com.example.Model.Painting;

public class PaintingService {
    PaintingDAO paintingDAO;
    public PaintingService(){
        paintingDAO = new PaintingDAO();
    }
    /**
     * first, try persisting the painting.
     * then, using the new painting's id,
     * return the full painting with its database id.
     */
    public Painting savePaintingAndReturn(){
        return null;
    }
    public Painting getAllPaintings(){
        return null;
    }

}
