/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.entities;

/**
 *
 * @author Oussaa
 */
public class Favoris {
    private int id_f;
    private User user;
    private User userFavoris;
    private String alias;

    public Favoris(int id_f, User user, User userFavoris) {
        this.id_f = id_f;
        this.user = user;
        this.userFavoris = userFavoris;
    }
    
    public Favoris(User user, User userFavoris) {
        this.user = user;
        this.userFavoris = userFavoris;
    }
    
    public Favoris(User userFavoris) {
        this.user = user;
        this.userFavoris = userFavoris;
    }
    
    
    public Favoris() {
    }

    public int getId_f() {
        return id_f;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setId_f(int id_f) {
        this.id_f = id_f;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUserFavoris() {
        return userFavoris;
    }

    public void setUserFavoris(User userFavoris) {
        this.userFavoris = userFavoris;
    }

    @Override
    public String toString() {
        return "Favoris{" + "id_f=" + id_f + ", user=" + user + ", userFavoris=" + userFavoris + '}';
    }
    
    
    
    
    
}
