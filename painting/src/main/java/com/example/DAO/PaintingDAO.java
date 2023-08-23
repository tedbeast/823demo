package com.example.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.example.Model.Painting;

public class PaintingDAO {

    Connection conn;
    public PaintingDAO(){
        try{
            conn = DriverManager.getConnection("");     
        }catch(Exception e){
            System.out.println("failed to set up db connection");
            System.exit(0);
        }
    }

    public int savePaintingReturnId(){
        return 0;
    }
    public List<Painting> getAllPaintings(){
        return null;
    }
    
}
