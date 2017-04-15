/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.entities;

public class UserCfg {
    
    private int id_f;
    private User user;
    private User userFavoris;
    protected int id_u;
    protected String nom;
    protected String prenom;
    protected String email;
    protected String login;
    protected String alias;
    

    public UserCfg(int id_f, User user, User userFavoris, int id_u, String nom, String prenom, String email, String login) {
        this.id_f=id_f;
        this.user = user;
        this.userFavoris = userFavoris;
        this.id_u = id_u;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
    }

    public UserCfg(int id_f, String nom, String prenom, int id_u, String alias) {
        this.id_f=id_f;
        this.nom = nom;
        this.prenom = prenom;
        this.id_u = id_u;
        this.alias = alias;
    }
    
    
    
    

    public int getId_f() {
        return id_f;
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

    public int getId_u() {
        return id_u;
    }

    public void setId_u(int id_u) {
        this.id_u = id_u;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
