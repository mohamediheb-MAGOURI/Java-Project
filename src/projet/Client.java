/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet;

import javax.swing.JOptionPane;

/**
 *
 * @author iheb
 */
public class Client {
    private int cin;
    private String prenom;
    private String nom;
    private int numero;
    private int npermis;
    private int nbloc;
    
    Client(int cin, String prenom, String nom, int numero, int npermis, int nbloc){
        this.cin = cin;
        this.prenom = prenom;
        this.nom = nom;
        this.numero= numero;
        this.npermis= npermis;
        this.nbloc = nbloc;
    }
    
    Client(String cin, String prenom, String nom, String numero, String npermis, String nbloc){
        try{
            this.cin = Integer.parseInt(cin);
            this.prenom = prenom;
            this.nom = nom;
            this.numero = Integer.parseInt(numero);
            this.npermis = Integer.parseInt(npermis);
            this.nbloc = Integer.parseInt(nbloc);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Probleme de conversion de 'String' a 'int' dans Client");
        }
    }
    
    int get_cin(){
        return this.cin;
    }
    String get_prenom(){
        return this.prenom;
    }
    String get_nom(){
        return this.nom;
    }
    int get_numero(){
        return this.numero;
    }
    int get_npermis(){
        return this.npermis;
    }
    int get_nbloc(){
        return this.nbloc;
    }
    
    /*void set_cin ...
    ......
    */
    
    
    
}
