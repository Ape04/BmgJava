/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bemyguest.entities;
import bemyguest.entities.User;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author LENOVO
 */
public class ReclamationAN {
    
    private int id_rec ;
    private String contenu ;
    private User userReclamant;
    private User userReclame;
    private String type ;
   
    private Date Date ; 
     protected int id_u;
    protected String nom;
    protected String nom2;
    protected String prenom;
     protected String prenom2;
    protected String email;
    protected String login;
    protected String password;
    protected String role;

    

    public ReclamationAN(String contenu, String type, Date date, String nom,String nom2) {
        this.contenu = contenu;
        this.type = type;
        this.Date = Date;
        this.nom = nom;
        this.nom2 = nom2;
       
    }

    public ReclamationAN(String contenu, String type, Date Date, String nom, String nom2, String prenom, String prenom2) {
        this.contenu = contenu;
        this.type = type;
        this.Date = Date;
        this.nom = nom;
        this.nom2 = nom2;
        this.prenom = prenom;
        this.prenom2 = prenom2;
    }

    public ReclamationAN(String contenu, String type, Date Date,  String nom) {
        this.contenu = contenu;
        this.type = type;
        this.Date = Date;
        this.nom = nom;
       
    }

    public String getPrenom2() {
        return prenom2;
    }

    public void setPrenom2(String prenom2) {
        this.prenom2 = prenom2;
    }

    public ReclamationAN() {
     
    }

   
    public int getId_rec() {
        return id_rec;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNom2() {
        return nom2;
    }

    public void setNom2(String nom2) {
        this.nom2 = nom2;
    }

    public ReclamationAN(int id_rec, String contenu, String type, Date Date, String nom, String nom2) {
        this.id_rec = id_rec;
        this.contenu = contenu;
        this.type = type;
        this.Date = Date;
        this.nom = nom;
        this.nom2 = nom2;
    }

    public ReclamationAN(int id_rec, String contenu, String type, Date Date, String nom, String nom2, String prenom, String prenom2, String email) {
        this.id_rec = id_rec;
        this.contenu = contenu;
        this.type = type;
        this.Date = Date;
        this.nom = nom;
        this.nom2 = nom2;
        this.prenom = prenom;
        this.prenom2 = prenom2;
        this.email = email;
    }

    
}
