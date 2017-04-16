/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.entities;

import java.sql.Date;

public class Message {
    
    private int id_m;
    private String contenu;
    private User userEmetteur;
    private  User userRecepteur;
    private Date date;
    private int reading;
    
    public Message() {
    }
    
    public Message(int id_m, String contenu, User userEmetteur, User userRecepteur, Date date) {
        this.id_m = id_m;
        this.contenu = contenu;
        this.userEmetteur = userEmetteur;
        this.userRecepteur = userRecepteur;
        this.date = date;
    }
    
    public Message(int id_m, String contenu, User userEmetteur, User userRecepteur, int reading) {
        this.id_m = id_m;
        this.contenu = contenu;
        this.userEmetteur = userEmetteur;
        this.userRecepteur = userRecepteur;
        this.reading = reading;
    }
    
    public Message( User userEmetteur, User userRecepteur, String contenu) {
        this.contenu = contenu;
        this.userEmetteur = userEmetteur;
        this.userRecepteur = userRecepteur;
    }
    
    public Message(String contenu, User userEmetteur, User userRecepteur, Date date) {
        this.contenu = contenu;
        this.userEmetteur = userEmetteur;
        this.userRecepteur = userRecepteur;
        this.date = date;
    }

    public Message(String contenu, User userEmetteur, Date date) {
        this.contenu = contenu;
        this.userEmetteur = userEmetteur;
        this.date = date;
    }
    

    public int getId_m() {
        return id_m;
    }

    public void setId_m(int id_m) {
        this.id_m = id_m;
    }

    public int getReading() {
        return reading;
    }

    public void setReading(int reading) {
        this.reading = reading;
    }

    
    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUserEmetteur() {
        return userEmetteur;
    }

    public void setUserEmetteur(User userEmetteur) {
        this.userEmetteur = userEmetteur;
    }

    public User getUserRecepteur() {
        return userRecepteur;
    }

    public void setUserRecepteur(User userRecepteur) {
        this.userRecepteur = userRecepteur;
    }

    @Override
    public String toString() {
        return "Message{" + "id_m=" + id_m + ", contenu=" + contenu + ", userEmetteur=" + userEmetteur + ", userRecepteur=" + userRecepteur + ", date=" + date + '}';
    }

    
    
}
