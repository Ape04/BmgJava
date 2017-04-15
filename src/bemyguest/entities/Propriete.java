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
public class Propriete {
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

    public Propriete() {
    }

    public Propriete(String ville, String rue,int id ) {
        this.ville = ville;
        this.rue = rue;
        this.id=id;
    }
    
        public Propriete(int id, String cat, String type, String ville, float prix  ) {
        this.id = id;
        this.categoriePropriete=cat;
        this.typePropriete=type;
        this.ville = ville;
        this.prix = prix;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.id;
        return hash;
    }


    public Propriete(int id, String categoriePropriete, String typePropriete, String pays, String ville, String rue, float prix, int nbrChambre, int nbrVoyageur, String description, Boolean animaux, Boolean fumeur, Boolean alcool, Boolean enfant, User user) {
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
        this.animaux = animaux;
        this.fumeur = fumeur;
        this.alcool = alcool;
        this.enfant = enfant;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getCategoriePropriete() {
        return categoriePropriete;
    }

    public String getTypePropriete() {
        return typePropriete;
    }

    public String getPays() {
        return pays;
    }

    public String getVille() {
        return ville;
    }

    public String getRue() {
        return rue;
    }

    public float getPrix() {
        return prix;
    }

    public int getNbrChambre() {
        return nbrChambre;
    }

    public int getNbrVoyageur() {
        return nbrVoyageur;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getAnimaux() {
        return animaux;
    }

    public Boolean getFumeur() {
        return fumeur;
    }

    public Boolean getAlcool() {
        return alcool;
    }

    public Boolean getEnfant() {
        return enfant;
    }

    public User getUtilisateur() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoriePropriete(String categoriePropriete) {
        this.categoriePropriete = categoriePropriete;
    }

    public void setTypePropriete(String typePropriete) {
        this.typePropriete = typePropriete;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setNbrChambre(int nbrChambre) {
        this.nbrChambre = nbrChambre;
    }

    public void setNbrVoyageur(int nbrVoyageur) {
        this.nbrVoyageur = nbrVoyageur;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAnimaux(Boolean animaux) {
        this.animaux = animaux;
    }

    public void setFumeur(Boolean fumeur) {
        this.fumeur = fumeur;
    }

    public void setAlcool(Boolean alcool) {
        this.alcool = alcool;
    }

    public void setEnfant(Boolean enfant) {
        this.enfant = enfant;
    }

    public void setUtilisateur(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Propriete{" + "id=" + id + ", categoriePropriete=" + categoriePropriete + ", typePropriete=" + typePropriete + ", pays=" + pays + ", ville=" + ville + ", rue=" + rue + ", prix=" + prix + ", nbrChambre=" + nbrChambre + ", nbrVoyageur=" + nbrVoyageur + ", description=" + description + ", animaux=" + animaux + ", fumeur=" + fumeur + ", alcool=" + alcool + ", enfant=" + enfant + ", utilisateur=" + user+ '}';
    }

   
    


    

    
    
}
