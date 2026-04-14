/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author iheb
 */
public class Voiture {
    
    private String databaseURL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
    private Connection connection;
    private Statement statement;
    private ResultSet res;
    
    
    public String mat;
    public String marque;
    public String model;
    public int nbplace;
    public String disp;
    public int nbloc;
    public double prix;
    
    private void Connect() throws SQLException{
        connection = DriverManager.getConnection(databaseURL,"c##loc","loc");
        statement = connection.createStatement();
    }

    public Voiture(String mat, String marque, String model, int nbplace, String disp, int nbloc, double prix) {
        this.mat = mat;
        this.marque = marque;
        this.model = model;
        this.nbplace = nbplace;
        this.disp = disp;
        this.nbloc = nbloc;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return mat + " - " + marque + " - " + model + " - " + nbplace + " places - " + disp + " - Nbloc: " + nbloc + " - Prix: " + prix;
    }
}
