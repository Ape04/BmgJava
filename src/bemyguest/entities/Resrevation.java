/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.entities;









import java.util.Date;
import java.util.Objects;


/**
 *
 * @author HP
 */
public class Resrevation {
private User user ;
private User userDemandant;
private int id_r;
private Propriete propriete;
private  Date	dateDebut;
private  Date  dateFin;
 private String etat ;
public Resrevation() {
    }

    public Resrevation(User user, User userDemandant, Propriete propriete, Date dateDebut, Date dateFin, String etat) {
        this.user = user;
        this.userDemandant = userDemandant;
        this.propriete = propriete;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.etat = etat;
    }

    



public Resrevation(User user, User userDemandant, int id_r, Propriete propriete, Date dateDebut, Date dateFin, String etat) {
        this.user = user;
        this.userDemandant = userDemandant;
        this.id_r = id_r;
        this.propriete = propriete;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.etat = etat;
    }
   
   


 public Resrevation(User user, Propriete propriete, Date dateDebut, Date dateFin) {
        this.user = user;
        this. propriete =  propriete;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }


public Resrevation(int id_r, User user,  Propriete propriete, Date dateDebut, Date dateFin) {
        this.id_r = id_r;
         this.user= user;
        this.propriete = propriete;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public int getId_r() {
        return id_r;
    }

   

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setId_r(int id_r) {
        this.id_r = id_r;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

   

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

  

    public User getUser() {
        return user;
    }

    public Propriete getPropriete() {
        return propriete;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPropriete(Propriete propriete) {
        this.propriete = propriete;
    }

    public User getUserDemandant() {
        return userDemandant;
    }

  

    public void setUserDemandant(User userDemandant) {
        this.userDemandant = userDemandant;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Resrevation other = (Resrevation) obj;
        if (!Objects.equals(this.dateDebut, other.dateDebut)) {
            return false;
        }
        if (!Objects.equals(this.dateFin, other.dateFin)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "Resrevation{" + "user=" + user + ", userDemandant=" + userDemandant + ", id_r=" + id_r + ", propriete=" + propriete + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", etat=" + etat + '}';
    }

   

   

   

  


   

   


}
