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
    public Painting savePaintingAndReturn(Painting painting){
        int id = paintingDAO.savePaintingReturnId(painting);
        Painting persistedPainting = paintingDAO.getPaintingById(id);
        return persistedPainting;
    }
    public Painting getAllPaintings(){
        return null;
    }

}
