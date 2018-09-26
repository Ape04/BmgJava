/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bemyguest.entities;



/**
 *
 * @author LENOVO
 */
public class Evaluation {

private int id_e;
private String type_acceuil ;
private String etat_du_chambre ;
private String caractere_du_host;
private String propreté; 
private String qualite_cuisine;
private String reglement;
private String qualité_prix;
private String experience_globale;
private User id_evalue;
private User id_evaluant;

    public Evaluation(int id_e, String type_acceuil, String etat_du_chambre, String caractere_du_host, String propreté, String qualite_cuisine, String reglement, String qualité_prix, String experience_globale, User id_evalue, User id_evaluant) {
        this.id_e = id_e;
        this.type_acceuil = type_acceuil;
        this.etat_du_chambre = etat_du_chambre;
        this.caractere_du_host = caractere_du_host;
        this.propreté = propreté;
        this.qualite_cuisine = qualite_cuisine;
        this.reglement = reglement;
        this.qualité_prix = qualité_prix;
        this.experience_globale = experience_globale;
        this.id_evalue = id_evalue;
        this.id_evaluant = id_evaluant;
    }

    public Evaluation() {
        
    }


   
    

    public int getId_e() {
        return id_e;
    }

    public void setId_e(int id_e) {
        this.id_e = id_e;
    }

    public String getType_acceuil() {
        return type_acceuil;
    }

    public void setType_acceuil(String type_acceuil) {
        this.type_acceuil = type_acceuil;
    }

    public String getEtat_du_chambre() {
        return etat_du_chambre;
    }

    public void setEtat_du_chambre(String etat_du_chambre) {
        this.etat_du_chambre = etat_du_chambre;
    }

    public String getCaractere_du_host() {
        return caractere_du_host;
    }

    public void setCaractere_du_host(String caractere_du_host) {
        this.caractere_du_host = caractere_du_host;
    }

    public String getPropreté() {
        return propreté;
    }

    public void setPropreté(String propreté) {
        this.propreté = propreté;
    }

    public String getQualite_cuisine() {
        return qualite_cuisine;
    }

    public void setQualite_cuisine(String qualite_cuisine) {
        this.qualite_cuisine = qualite_cuisine;
    }

    public String getReglement() {
        return reglement;
    }

    public void setReglement(String reglement) {
        this.reglement = reglement;
    }

    public String getQualité_prix() {
        return qualité_prix;
    }

    public void setQualité_prix(String qualité_prix) {
        this.qualité_prix = qualité_prix;
    }

    public String getExperience_globale() {
        return experience_globale;
    }

    public void setExperience_globale(String experience_globale) {
        this.experience_globale = experience_globale;
    }

    public User getId_evalue() {
        return id_evalue;
    }

    public void setId_evalue(User id_evalue) {
        this.id_evalue = id_evalue;
    }

    public User getId_evaluant() {
        return id_evaluant;
    }

    public void setId_evaluant(User id_evaluant) {
        this.id_evaluant = id_evaluant;
    }



   
    }




