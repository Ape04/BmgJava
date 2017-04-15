/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bemyguest.entities;

import java.util.Objects;

/**
 *
 * @author Haroun
 */
public class Commentaire {
    protected int id_comm;
    protected String contenu_comm;

    public Commentaire(int id_comm, String contenu_comm) {
        this.id_comm = id_comm;
        this.contenu_comm = contenu_comm;
    }

    public int getId_comm() {
        return id_comm;
    }

    public String getContenu_comm() {
        return contenu_comm;
    }

    public void setId_comm(int id_comm) {
        this.id_comm = id_comm;
    }

    public void setContenu_comm(String contenu_comm) {
        this.contenu_comm = contenu_comm;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id_comm;
        hash = 83 * hash + Objects.hashCode(this.contenu_comm);
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
        final Commentaire other = (Commentaire) obj;
        if (this.id_comm != other.id_comm) {
            return false;
        }
        if (!Objects.equals(this.contenu_comm, other.contenu_comm)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id_comm=" + id_comm + ", contenu_comm=" + contenu_comm + '}';
    }
    
    
    
}


