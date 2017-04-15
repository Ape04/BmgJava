/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.DAO.Classe;

import bemyguest.DAO.Interface.IProprieteCrud;
import bemyguest.config.ConnectionDB;
import bemyguest.entities.HistoriquePropriete;
import bemyguest.entities.Propriete;
import bemyguest.entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Daly
 */
public class ProprieteCrud implements IProprieteCrud {

    Connection connexion = ConnectionDB.getConnexion();

    @Override
    public boolean addPropriete(Propriete propriete, HistoriquePropriete historiquePropriete) {
        String query = "INSERT INTO propriete (categoriePropriete,typePropriete,pays,ville,rue,prix,nbrChambre,nbrVoyageur,description,animaux,fumeur,alcool,enfant,id_u) VALUES (?,?,?,?, ?,?,?,?,?, ?,?,?,?,?)";
        String query2 = "INSERT INTO historiquepropriete (categoriePropriete,typePropriete,pays,ville,rue,prix,nbrChambre,nbrVoyageur,description,animaux,fumeur,alcool,enfant,id_u) VALUES (?,?,?,?, ?,?,?,?,?, ?,?,?,?,?)";

        try {
            PreparedStatement pst = connexion.prepareStatement(query);
            PreparedStatement pst1 = connexion.prepareStatement(query2);
            pst.setString(1, propriete.getCategoriePropriete());
            pst.setString(2, propriete.getTypePropriete());
            pst.setString(3, propriete.getPays());
            pst.setString(4, propriete.getVille());
            pst.setString(5, propriete.getRue());
            pst.setFloat(6, propriete.getPrix());
            pst.setInt(7, propriete.getNbrChambre());
            pst.setInt(8, propriete.getNbrVoyageur());
            pst.setString(9, propriete.getDescription());
            pst.setBoolean(10, propriete.getAnimaux());
            pst.setBoolean(11, propriete.getFumeur());
            pst.setBoolean(12, propriete.getAlcool());
            pst.setBoolean(13, propriete.getEnfant());
            pst.setInt(14, propriete.getUtilisateur().getId_u());
            pst.executeUpdate();
            /*Ajout dans la table Histoque Categorie*/

            pst1.setString(1, historiquePropriete.getCategoriePropriete());
            pst1.setString(2, historiquePropriete.getTypePropriete());
            pst1.setString(3, historiquePropriete.getPays());
            pst1.setString(4, historiquePropriete.getVille());
            pst1.setString(5, historiquePropriete.getRue());
            pst1.setFloat(6, historiquePropriete.getPrix());
            pst1.setInt(7, historiquePropriete.getNbrChambre());
            pst1.setInt(8, historiquePropriete.getNbrVoyageur());
            pst1.setString(9, historiquePropriete.getDescription());
            pst1.setBoolean(10, historiquePropriete.getAnimaux());
            pst1.setBoolean(11, historiquePropriete.getFumeur());
            pst1.setBoolean(12, historiquePropriete.getAlcool());
            pst1.setBoolean(13, historiquePropriete.getEnfant());
            pst1.setInt(14, historiquePropriete.getUser().getId_u());
            pst1.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Echec d'insertion ! " + ex.getMessage());
            Logger.getLogger(ProprieteCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean updatePropriete(Propriete propriete, HistoriquePropriete historiquePropriete) {
        try {
            String query = "update propriete set categoriePropriete=?, typePropriete=?, pays=?, ville=?, rue=?, prix=?, nbrChambre=?, nbrVoyageur=?, description=?, animaux=?, fumeur=?, alcool=?, enfant=?, id_u=?";
            String query2 = "update historiquepropriete set categoriePropriete=?, typePropriete=?, pays=?, ville=?, rue=?, prix=?, nbrChambre=?, nbrVoyageur=?, description=?, animaux=?, fumeur=?, alcool=?, enfant=?, id_u=?";

            PreparedStatement pst = connexion.prepareStatement(query);
            PreparedStatement pst1 = connexion.prepareStatement(query);
            /*Modification dans la table Propriete*/
            pst.setString(1, propriete.getCategoriePropriete());
            pst.setString(2, propriete.getTypePropriete());
            pst.setString(3, propriete.getPays());
            pst.setString(4, propriete.getVille());
            pst.setString(5, propriete.getRue());
            pst.setFloat(6, propriete.getPrix());
            pst.setInt(7, propriete.getNbrChambre());
            pst.setInt(8, propriete.getNbrChambre());
            pst.setString(9, propriete.getDescription());
            pst.setBoolean(10, propriete.getAnimaux());
            pst.setBoolean(11, propriete.getFumeur());
            pst.setBoolean(12, propriete.getAlcool());
            pst.setBoolean(13, propriete.getEnfant());
            pst.setInt(14, propriete.getUtilisateur().getId_u());
            pst.executeUpdate();
            /*Modification dans la table Historique Prop*/
            pst1.setString(1, historiquePropriete.getCategoriePropriete());
            pst1.setString(2, historiquePropriete.getTypePropriete());
            pst1.setString(3, historiquePropriete.getPays());
            pst1.setString(4, historiquePropriete.getVille());
            pst1.setString(5, historiquePropriete.getRue());
            pst1.setFloat(6, historiquePropriete.getPrix());
            pst1.setInt(7, historiquePropriete.getNbrChambre());
            pst1.setInt(8, historiquePropriete.getNbrChambre());
            pst1.setString(9, historiquePropriete.getDescription());
            pst1.setBoolean(10, historiquePropriete.getAnimaux());
            pst1.setBoolean(11, historiquePropriete.getFumeur());
            pst1.setBoolean(12, historiquePropriete.getAlcool());
            pst1.setBoolean(13, historiquePropriete.getEnfant());
            pst1.setInt(14, historiquePropriete.getUser().getId_u());
            pst1.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println("Echec de mise à jour ! " + ex.getMessage());
            Logger.getLogger(ProprieteCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deletePropriete(int id) {
        try {
            String query = "DELETE from propriete WHERE id=?";
            PreparedStatement pst = connexion.prepareStatement(query);
            pst.setInt(1, id);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Echec de mise à jour ! " + ex.getMessage());
            Logger.getLogger(ProprieteCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Propriete> getAllProprietes() {
        List<Propriete> proprietes = new ArrayList<Propriete>();
        try {
            String query = "select * from propriete";
            PreparedStatement pst = connexion.prepareStatement(query);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Propriete prop = new Propriete();
                prop.setCategoriePropriete(res.getString("CategoriePropriete"));
                prop.setTypePropriete(res.getString("TypePropriete"));
                prop.setPays(res.getString("Pays"));
                prop.setVille(res.getString("Ville"));
                prop.setRue(res.getString("Rue"));
                prop.setPrix(res.getFloat("Prix"));
                prop.setNbrChambre(res.getInt("NbrChambre"));
                prop.setNbrVoyageur(res.getInt("NbrVoyageur"));
                prop.setDescription(res.getString("Description"));
                prop.setAnimaux(res.getBoolean("Animaux"));
                prop.setFumeur(res.getBoolean("Fumeur"));
                prop.setAlcool(res.getBoolean("Alcool"));
                prop.setEnfant(res.getBoolean("Enfant"));
                User user = new User();
//                UserDao userDap= new UserDao();
//                int i = res.getInt("id_u");
//                user = userDao.getUserById(i);
//                prop.setUtilisateur(user);
                proprietes.add(prop);

            }
            return proprietes;
        } catch (SQLException ex) {
            Logger.getLogger(ProprieteCrud.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public Propriete getProprieteById(int id) {
        Propriete prop = new Propriete();

        try {
            String query = "select * from propriete where id_p=?";
            PreparedStatement pst = connexion.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                prop.setId(res.getInt("id_p"));
                prop.setCategoriePropriete(res.getString("CategoriePropriete"));
                prop.setTypePropriete(res.getString("TypePropriete"));
                prop.setPays(res.getString("Pays"));
                prop.setVille(res.getString("Ville"));
                prop.setRue(res.getString("Rue"));
                prop.setPrix(res.getFloat("Prix"));
                prop.setNbrChambre(res.getInt("NbrChambre"));
                prop.setNbrVoyageur(res.getInt("NbrVoyageur"));
                prop.setDescription(res.getString("Description"));
                prop.setAnimaux(res.getBoolean("Animaux"));
                prop.setFumeur(res.getBoolean("Fumeur"));
                prop.setAlcool(res.getBoolean("Alcool"));
                prop.setEnfant(res.getBoolean("Enfant"));
                User user = new User();
                UserDAO userDao= new UserDAO();

                int i = res.getInt("id_u");
                user = userDao.retrieveAdminById(i);
                prop.setUtilisateur(user);


            }
            return prop;
        } catch (SQLException ex) {
            Logger.getLogger(ProprieteCrud.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public List<HistoriquePropriete> getAllHistoriqueProprietes() {
        List<HistoriquePropriete> historiqueProprietes = new ArrayList<HistoriquePropriete>();
        HistoriquePropriete historiquePropriete = new HistoriquePropriete();

        try {
            String query = "select * from historiquepropriete";
            PreparedStatement pst = connexion.prepareStatement(query);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                historiquePropriete.setCategoriePropriete(res.getString("CategoriePropriete"));
                historiquePropriete.setTypePropriete(res.getString("TypePropriete"));
                historiquePropriete.setPays(res.getString("Pays"));
                historiquePropriete.setVille(res.getString("Ville"));
                historiquePropriete.setRue(res.getString("Rue"));
                historiquePropriete.setPrix(res.getFloat("Prix"));
                historiquePropriete.setNbrChambre(res.getInt("NbrChambre"));
                historiquePropriete.setNbrVoyageur(res.getInt("NbrVoyageur"));
                historiquePropriete.setDescription(res.getString("Description"));
                historiquePropriete.setAnimaux(res.getBoolean("Animaux"));
                historiquePropriete.setFumeur(res.getBoolean("Fumeur"));
                historiquePropriete.setAlcool(res.getBoolean("Alcool"));
                historiquePropriete.setEnfant(res.getBoolean("Enfant"));
                User user = new User();
                
                int i = res.getInt("id_u");
                UserDAO userDao= new UserDAO();
                user = userDao.retrieveAdminById(i);
                historiquePropriete.setUser(user);
                historiqueProprietes.add(historiquePropriete);

            }
            return historiqueProprietes;
        } catch (SQLException ex) {
            Logger.getLogger(ProprieteCrud.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public HistoriquePropriete getHistoriqueProprieteById(int id) {
        HistoriquePropriete historiquePropriete = new HistoriquePropriete();

        try {
            String query = "select * from propriete where id=?";
            PreparedStatement pst = connexion.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                historiquePropriete.setCategoriePropriete(res.getString("CategoriePropriete"));
                historiquePropriete.setTypePropriete(res.getString("TypePropriete"));
                historiquePropriete.setPays(res.getString("Pays"));
                historiquePropriete.setVille(res.getString("Ville"));
                historiquePropriete.setRue(res.getString("Rue"));
                historiquePropriete.setPrix(res.getFloat("Prix"));
                historiquePropriete.setNbrChambre(res.getInt("NbrChambre"));
                historiquePropriete.setNbrVoyageur(res.getInt("NbrVoyageur"));
                historiquePropriete.setDescription(res.getString("Description"));
                historiquePropriete.setAnimaux(res.getBoolean("Animaux"));
                historiquePropriete.setFumeur(res.getBoolean("Fumeur"));
                historiquePropriete.setAlcool(res.getBoolean("Alcool"));
                historiquePropriete.setEnfant(res.getBoolean("Enfant"));
                  
                User user = new User();
                 UserDAO userDao= new UserDAO();
                int i = res.getInt("id_u");
                user = userDao.retrieveAdminById(i);
                historiquePropriete.setUser(user);

            }
            return historiquePropriete;
        } catch (SQLException ex) {
            Logger.getLogger(ProprieteCrud.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
