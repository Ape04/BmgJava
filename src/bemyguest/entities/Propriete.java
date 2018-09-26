/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.entities;

import bemyguest.entities.User;
import java.util.ArrayList;
import java.util.List;

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
    private String titre;
    private int prix;
    private int nbrChambre;
    private int nbrVoyageur;
    private String description;
    private Boolean animaux;
    private Boolean fumeur;
    private Boolean alcool;
    private Boolean enfant;
    private User user;
    private List<ImageProp> images;

    public Propriete() {
    }

    public Propriete(int id, String categoriePropriete, String typePropriete, String pays, String ville, String rue, int prix, int nbrChambre, int nbrVoyageur, String description, Boolean animaux, Boolean fumeur, Boolean alcool, Boolean enfant, User user, List<ImageProp> images, String titre) {
        this.id = id;
        this.categoriePropriete = categoriePropriete;
        this.typePropriete = typePropriete;
        this.pays = pays;
        this.ville = ville;
        this.rue = rue;
        this.prix = prix;
        this.titre = titre;

        this.nbrChambre = nbrChambre;
        this.nbrVoyageur = nbrVoyageur;
        this.description = description;
        this.animaux = animaux;
        this.fumeur = fumeur;
        this.alcool = alcool;
        this.enfant = enfant;
        this.user = user;
        this.images = images;
    }

    public Propriete(String categoriePropriete, String typePropriete, String pays, String ville, String rue, int prix, int nbrChambre, int nbrVoyageur, String description, Boolean animaux, Boolean fumeur, Boolean alcool, Boolean enfant, String titre) {
        this.categoriePropriete = categoriePropriete;
        this.typePropriete = typePropriete;
        this.pays = pays;
        this.ville = ville;
        this.rue = rue;
        this.prix = prix;
        this.titre = titre;

        this.nbrChambre = nbrChambre;
        this.nbrVoyageur = nbrVoyageur;
        this.description = description;
        this.animaux = animaux;
        this.fumeur = fumeur;
        this.alcool = alcool;
        this.enfant = enfant;
    }

    public Propriete(int id, String categoriePropriete, String typePropriete, String pays, String ville, String rue, int prix, int nbrChambre, int nbrVoyageur, String description, Boolean animaux, Boolean fumeur, Boolean alcool, Boolean enfant, String titre) {
        this.id = id;
        this.categoriePropriete = categoriePropriete;
        this.typePropriete = typePropriete;
        this.pays = pays;
        this.ville = ville;
        this.rue = rue;
        this.prix = prix;
        this.titre = titre;
        this.nbrChambre = nbrChambre;
        this.nbrVoyageur = nbrVoyageur;
        this.description = description;
        this.animaux = animaux;
        this.fumeur = fumeur;
        this.alcool = alcool;
        this.enfant = enfant;
    }

    public Propriete(int id, String categoriePropriete, String typePropriete, String ville, String rue, int prix, int nbrChambre, int nbrVoyageur, String description, Boolean animaux, Boolean fumeur, Boolean alcool, Boolean enfant, String titre) {
        this.id = id;
        this.categoriePropriete = categoriePropriete;
        this.typePropriete = typePropriete;
        this.ville = ville;
        this.rue = rue;
        this.titre = titre;
        this.prix = prix;
        this.nbrChambre = nbrChambre;
        this.nbrVoyageur = nbrVoyageur;
        this.description = description;
        this.animaux = animaux;
        this.fumeur = fumeur;
        this.alcool = alcool;
        this.enfant = enfant;
    }

    public Propriete(String ville, String rue,int id ) {
        this.ville = ville;
        this.rue = rue;
        this.id=id;
    }
    
    public Propriete(int id, String categoriePropriete, String typePropriete, String ville, int prix) {
        this.id = id;
        this.categoriePropriete = categoriePropriete;
        this.typePropriete = typePropriete;
        this.ville = ville;
        this.prix = prix;
    }

      

   

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
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

    public List<ImageProp> getImages() {
        return images;
    }

    public void setImages(List<ImageProp> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Propriete{" + "id=" + id + ", categoriePropriete=" + categoriePropriete + ", typePropriete=" + typePropriete + ", pays=" + pays + ", ville=" + ville + ", rue=" + rue + ", prix=" + prix + ", nbrChambre=" + nbrChambre + ", nbrVoyageur=" + nbrVoyageur + ", description=" + description + ", animaux=" + animaux + ", fumeur=" + fumeur + ", alcool=" + alcool + ", enfant=" + enfant + ", user=" + user + ", images=" + images + '}';
    }

}
