/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet;

import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author iheb
 */
public class User {
    protected String login;
    protected String passwword;
    protected boolean prev;
    
    protected Connection connection;
    protected Statement statement;

    
    User(){
        
    }
    
    User(String login, String password, boolean prev){
        this.login = login;
        this.passwword = password;
        this.prev = prev;
    }
    
    protected void Connect(){
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","c##loc","loc");
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erreur de connection !!", "Erreur", HEIGHT);
        }
    }
    
    String requeteRechercheVoiture(String mat, String marq, String mod, String nbp, String disp, String nbloc, String prixJ) throws NumberFormatException {
        String sql = "select * from voiture where ";
        if (!mat.isEmpty()){
            sql += "mat = '"+mat+"' and ";
        }
        if (!marq.isEmpty()){
            sql += "marque = '"+marq+"' and ";
        }
        if (!mod.isEmpty()){
            sql += "model = '"+mod+"' and ";
        }
        if (!nbp.isEmpty()){
            sql += "nbplace = "+Integer.parseInt(nbp)+" and ";
        }
        if (!disp.equals(" ")){
            sql += "disp = '"+disp+"' and ";
        }
        if (!nbloc.isEmpty()){
            sql += "nbloc = "+Integer.parseInt(nbloc)+" and ";
        }
        if (!prixJ.isEmpty()){
            sql += "prix = "+Float.parseFloat(prixJ)+" and ";
        }
        return sql;
    }
    
    
    
}
