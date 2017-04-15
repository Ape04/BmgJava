/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bemyguest.entities;

/**
 *
 * @author User
 */
public class ImageExperience {
    private int id_ixp;
    private String url_xp;
    private Experience exp;

    public ImageExperience(int id_ixp, String url_xp, Experience exp) {
        this.id_ixp = id_ixp;
        this.url_xp = url_xp;
        this.exp = exp;
    }

    public ImageExperience(String url_xp, Experience exp) {
        this.url_xp = url_xp;
        this.exp = exp;
    }

    public ImageExperience() {
    }

    
    public int getId_ixp() {
        return id_ixp;
    }

    public void setId_ixp(int id_ixp) {
        this.id_ixp = id_ixp;
    }

    public String getUrl_xp() {
        return url_xp;
    }

    public void setUrl_xp(String url_xp) {
        this.url_xp = url_xp;
    }

    public Experience getExp() {
        return exp;
    }

    public void setExp(Experience exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "ImageExperience{" + "id_ixp=" + id_ixp + ", url_xp=" + url_xp + ", exp=" + exp + '}';
    }
    
    
    
    
}
