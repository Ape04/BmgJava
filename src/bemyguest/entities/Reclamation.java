/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entites;

import bemyguest.entities.User;
import java.util.Objects;

/**
 *
 * @author LENOVO
 */
public class Reclamation {
    
    private int id_rec ;
    private String contenu ;
    private User userReclamant;
    private User userReclame;

    public Reclamation() {
    }

    public Reclamation(String contenu, User userReclamant, User userReclame) {
        this.contenu = contenu;
        this.userReclamant = userReclamant;
        this.userReclame = userReclame;
    }
    
    
    public Reclamation(int id_rec, String contenu, User userReclamant, User userReclame) {
        this.id_rec = id_rec;
        this.contenu = contenu;
        this.userReclamant = userReclamant;
        this.userReclame = userReclame;
    }
    
    public User getUserReclamant() {
        return userReclamant;
    }

    public void setUserReclamant(User userReclamant) {
        this.userReclamant = userReclamant;
    }

    public User getUserReclame() {
        return userReclame;
    }

    public void setUserReclame(User userReclame) {
        this.userReclame = userReclame;
    }
    
    public int getId_rec() {
        return id_rec;
    }

    public Reclamation(int id_rec, String contenu) {
        this.id_rec = id_rec;
        this.contenu = contenu;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id_rec=" + id_rec + ", contenu=" + contenu + ", userReclamant=" + userReclamant + ", userReclame=" + userReclame+ '}';
    }



    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id_rec;
        hash = 71 * hash + Objects.hashCode(this.contenu);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reclamation other = (Reclamation) obj;
        if (this.id_rec != other.id_rec) {
            return false;
        }
        if (!Objects.equals(this.contenu, other.contenu)) {
            return false;
        }
        return true;
    }
    
}
