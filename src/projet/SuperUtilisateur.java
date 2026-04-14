/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet;

import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author iheb
 */
public class SuperUtilisateur extends User {
    
    SuperUtilisateur(){
        super();
    }
    SuperUtilisateur(String log, String passwd, boolean prev){
        super(log,passwd,prev);
    }
    
    void AjouterClient(Client c){
        try {
            Connect();
            String sql = "insert into clients(cin,prenom,nom,numero,npermis) values ("+c.get_cin()+",'"+c.get_prenom()+"','"+c.get_nom()+"',"+c.get_numero()+","+c.get_npermis()+")";
            int executeUpdate = statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Client ajouté avec succes.");
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    String requeteRechercheClient(String cin, String prenom, String nom, String numero, String npermis, String nbl) throws NumberFormatException {
        String sql = "select * from clients where ";
        if (!cin.isEmpty()){
            int ncin = Integer.parseInt(cin);
            if (cin.length()!=8){
                throw new NumberFormatException();
            }
            sql += "cin = "+ncin+" and ";
        }
        if (!prenom.isEmpty()){
            sql += "prenom = '"+prenom+"' and ";
        }
        if (!nom.isEmpty()){
            sql += "nom = '"+nom+"' and ";
        }
        if (!numero.isEmpty()){
            int numtel = Integer.parseInt(numero);
            sql += "numero = "+numtel+" and ";
        }
        if (!npermis.isEmpty()){
            int permis = Integer.parseInt(npermis);
            if (npermis.length()!=8){
                throw new NumberFormatException();
            }
            sql += "npermis = "+permis+" and ";
        }
        if (!nbl.isEmpty()){
            int loc = Integer.parseInt(nbl);
            sql += "nbloc = "+loc+" and ";
        }
        return sql;
    }
    
    void modifierClient(String cin, String cin2,String prenom, String nom, String numero, String npermis, String nbl){
        String sql = "update clients set ";
        try{
            Connect();
            if (!cin2.isEmpty()){
                int ncin = Integer.parseInt(cin2);
                if (cin.length()!=8){
                    throw new NumberFormatException();
                }
                sql += "cin = "+ncin+" , ";
            }
            if (!prenom.isEmpty()){
                sql += "prenom = '"+prenom+"' , ";
            }
            if (!nom.isEmpty()){
                sql += "nom = '"+nom+"' , ";
            }
            if (!numero.isEmpty()){
                int numtel = Integer.parseInt(numero);
                sql += "numero = "+numtel+" , ";
            }
            if (!npermis.isEmpty()){
                int permis = Integer.parseInt(npermis);
                if (npermis.length()!=8){
                    throw new NumberFormatException();
                }
                sql += "npermis = "+permis+" , ";
            }
            if (!nbl.isEmpty()){
                int loc = Integer.parseInt(nbl);
                sql += "nbloc = "+loc+" , ";
            }
            if (sql.endsWith(", ")){
                sql = sql.substring(0, sql.length()-3);
                //JOptionPane.showMessageDialog(null, sql);
                sql += " where cin =" +cin;
                int executeUpdate = statement.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Client modifié avec succes.");
            }
            else {
                JOptionPane.showMessageDialog(null, "Pas de modification.", "Erreur", HEIGHT);
            }
            connection.close();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Champ invalide!!");
        } catch (SQLException ex) {
            Logger.getLogger(ModifierClient.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Probleme dans la requete update!!!!"+sql);
        }
    }
    
    void supprimerClient(String cin){
        if (cin.isEmpty()){
            JOptionPane.showMessageDialog(null, "Veuillez choisir un client à supprimer dans la fenetre 'Recherche'!");
        }
        else{
            String sql = "delete from clients where cin = "+cin;
            int option = JOptionPane.showConfirmDialog(null, "voulez-vous supprimer l'utilisateur ?","Confirmation de suppression",JOptionPane.YES_NO_CANCEL_OPTION);
            if (option == 0){
                try {
                    Connect();
                    statement.executeUpdate(sql);
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ModifierClient.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "utilisateur supprimé avec succes.");
            }
            
        }
    }
    
    void ajouterVoiture(Voiture v){
        String sql = "insert into voiture values ('"+v.mat+"','"+v.marque+"','"+v.model+"',"+v.nbplace+",'"+v.disp+"',"+v.nbloc+","+v.prix+")";
        try {
            Connect();
            int executeUpdate = statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Voiture ajouté avec succes.");
        } catch (SQLException ex) {
            Logger.getLogger(AjouterClient.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erreur !!", "Erreur", HEIGHT);
                    
        }
    }
    
    void supprimerVoiture(Voiture v){
        String sql = "delete from voiture where mat = '"+v.mat+"'";
        int option = JOptionPane.showConfirmDialog(null, "voulez-vous supprimer la voiture ?","Confirmation de suppression",JOptionPane.YES_NO_CANCEL_OPTION);
        if (option == 0){
            try {
                Connect();
                statement.executeUpdate(sql);
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModifierClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "voiture supprimée avec succes.");     
        }
    }
    
}
