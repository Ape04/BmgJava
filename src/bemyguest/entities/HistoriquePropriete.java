/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.entities;

import bemyguest.entities.User;

/**
 *
 * @author Daly
 */
public class HistoriquePropriete {
    private int id;
    private String categoriePropriete;
    private String typePropriete;
    private String pays;
    private String ville;
    private String rue;
    private float prix;
    private int nbrChambre;
    private int nbrVoyageur;    
    private String description;
    private Boolean animaux;
    private Boolean fumeur;
    private Boolean alcool;
    private Boolean enfant;
    private User user;

    public HistoriquePropriete(int id, String categoriePropriete, String typePropriete, String pays, String ville, String rue, float prix, int nbrChambre, int nbrVoyageur, String description, Boolean fumeur, Boolean alcool, Boolean enfant, User user) {
        this.id = id;
        this.categoriePropriete = categoriePropriete;
        this.typePropriete = typePropriete;
        this.pays = pays;
        this.ville = ville;
        this.rue = rue;
        this.prix = prix;
        this.nbrChambre = nbrChambre;
        this.nbrVoyageur = nbrVoyageur;
        this.description = description;
        this.fumeur = fumeur;
        this.alcool = alcool;
        this.enfant = enfant;
        this.user = user;
    }

    public HistoriquePropriete() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoriePropriete() {
        return categoriePropriete;
    }

    public void setCategoriePropriete(String categoriePropriete) {
        this.categoriePropriete = categoriePropriete;
    }

    public String getTypePropriete() {
        return typePropriete;
    }

    public void setTypePropriete(String typePropriete) {
        this.typePropriete = typePropriete;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getNbrChambre() {
        return nbrChambre;
    }

    public void setNbrChambre(int nbrChambre) {
        this.nbrChambre = nbrChambre;
    }

    public int getNbrVoyageur() {
        return nbrVoyageur;
    }

    public void setNbrVoyageur(int nbrVoyageur) {
        this.nbrVoyageur = nbrVoyageur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAnimaux() {
        return animaux;
    }

    public void setAnimaux(Boolean animaux) {
        this.animaux = animaux;
    }

    public Boolean getFumeur() {
        return fumeur;
    }

    public void setFumeur(Boolean fumeur) {
        this.fumeur = fumeur;
    }

    public Boolean getAlcool() {
        return alcool;
    }

    public void setAlcool(Boolean alcool) {
        this.alcool = alcool;
    }

    public Boolean getEnfant() {
        return enfant;
    }

    public void setEnfant(Boolean enfant) {
        this.enfant = enfant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
}