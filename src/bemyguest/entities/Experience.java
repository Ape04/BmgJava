/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bemyguest.entities;
import bemyguest.entities.Propriete;
import bemyguest.entities.User;
import java.util.Objects;

/**
 *
 * @author User
 */
public class Experience {
    
     private int id_xp;
     private String description;
     private String type;
     private User user;
     private Propriete propriete;

    public Experience() {
    }

    public Experience(int id_xp, String description, String type, User user, Propriete propriete) {
        this.id_xp = id_xp;
        this.description = description;
        this.type = type;
        this.user = user;
        this.propriete = propriete;
    }
    
    public Experience(String description, String type, User user, Propriete propriete) {
        this.description = description;
        this.type = type;
        this.user = user;
        this.propriete = propriete;
    }

    public int getId_xp() {
        return id_xp;
    }

    public void setId_xp(int id_xp) {
        this.id_xp = id_xp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Propriete getPropriete() {
        return propriete;
    }

    public void setPropriete(Propriete propriete) {
        this.propriete = propriete;
    }

    @Override
    public String toString() {
        return "Experience{" + "id_xp=" + id_xp + ", description=" + description + ", type=" + type + ", user=" + user + ", propriete=" + propriete + '}';
    }
     

    
    
    
    
}
