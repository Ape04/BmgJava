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
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 *
 * @author Daly
 */
public class ProprieteCrud implements IProprieteCrud {

    Connection connexion = ConnectionDB.getConnexion();

    @Override
    public boolean addPropriete(Propriete propriete, HistoriquePropriete hprop) {
        String query = "INSERT INTO propriete(categoriePropriete,typePropriete,pays,ville,rue,titre,prix,nbrChambre,nbrVoyageur,description,animaux,fumeur,alcool,enfant,id_u) VALUES (?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,?)";
        String query1 = "INSERT INTO historiquepropriete (categoriePropriete,typePropriete,pays,ville,rue,titre,prix,nbrChambre,nbrVoyageur,description,animaux,fumeur,alcool,enfant,id_u) VALUES (?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,?)";

        try {
            PreparedStatement pst = connexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement pst1 = connexion.prepareStatement(query1);

            pst.setString(1, propriete.getCategoriePropriete());
            pst.setString(2, propriete.getTypePropriete());
            pst.setString(3, propriete.getPays());
            pst.setString(4, propriete.getVille());
            pst.setString(5, propriete.getRue());
            pst.setString(6, propriete.getTitre());
            pst.setInt(7, propriete.getPrix());
            pst.setInt(8, propriete.getNbrChambre());
            pst.setInt(9, propriete.getNbrVoyageur());
            pst.setString(10, propriete.getDescription());
            pst.setBoolean(11, propriete.getAnimaux());
            pst.setBoolean(12, propriete.getFumeur());
            pst.setBoolean(13, propriete.getAlcool());
            pst.setBoolean(14, propriete.getEnfant());
            pst.setInt(15, propriete.getUser().getId_u());
            int affectedRows = pst.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    propriete.setId((int) generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

            /*Ajout dans la table Histoque Categorie*/
            pst1.setString(1, hprop.getCategoriePropriete());
            pst1.setString(2, hprop.getTypePropriete());
            pst1.setString(3, hprop.getPays());
            pst1.setString(4, hprop.getVille());
            pst1.setString(5, hprop.getRue());

            pst1.setString(6, hprop.getTitre());
            pst1.setInt(7, hprop.getPrix());
            pst1.setInt(8, hprop.getNbrChambre());
            pst1.setInt(9, hprop.getNbrVoyageur());
            pst1.setString(10, hprop.getDescription());
            pst1.setBoolean(11, hprop.getAnimaux());
            pst1.setBoolean(12, hprop.getFumeur());
            pst1.setBoolean(13, hprop.getAlcool());
            pst1.setBoolean(14, hprop.getEnfant());
            pst1.setInt(15, hprop.getUser().getId_u());
            pst1.executeUpdate();
            tray.notification.TrayNotification tr = new TrayNotification();
            tr.setTitle("Ajout avec succés");
            tr.setMessage("Felicitation votre Propriété a été Ajoutée avec succés !");
            tr.setNotificationType(NotificationType.SUCCESS);
            tr.setAnimationType(AnimationType.SLIDE);
            tr.showAndDismiss(Duration.seconds(6));


            return true;
        } catch (SQLException ex) {
            System.out.println("Echec d'insertion ! " + ex.getMessage());
            Logger.getLogger(ProprieteCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean updatePropriete(Propriete propriete/*, HistoriquePropriete hpop*/) {
        String query = "update propriete set categoriePropriete=?, typePropriete=?, pays=?, ville=?, rue=?,titre=?, prix=?, nbrChambre=?, nbrVoyageur=?, description=?, animaux=?, fumeur=?, alcool=?, enfant=?, id_u=? where id_p=? ";
        // String query1 = "update historiquepropriete set categoriePropriete=?, typePropriete=?, pays=?, ville=?, rue=?, prix=?, nbrChambre=?, nbrVoyageur=?, description=?, animaux=?, fumeur=?, alcool=?, enfant=?, id_u=? where id=? ";

        try {

            PreparedStatement pst = connexion.prepareStatement(query);
            //     PreparedStatement pst1 = connexion.prepareStatement(query1);
            /*Modification dans la table Propriete*/

            pst.setString(1, propriete.getCategoriePropriete());
            pst.setString(2, propriete.getTypePropriete());
            pst.setString(3, propriete.getPays());
            pst.setString(4, propriete.getVille());
            pst.setString(5, propriete.getRue());
            pst.setString(6, propriete.getTitre());
            pst.setInt(7, propriete.getPrix());
            pst.setInt(8, propriete.getNbrChambre());
            pst.setInt(9, propriete.getNbrChambre());
            pst.setString(10, propriete.getDescription());
            pst.setBoolean(11, propriete.getAnimaux());
            pst.setBoolean(12, propriete.getFumeur());
            pst.setBoolean(13, propriete.getAlcool());
            pst.setBoolean(14, propriete.getEnfant());
            pst.setInt(15, propriete.getUser().getId_u());
            pst.setInt(16, propriete.getId());
            pst.executeUpdate();
             tray.notification.TrayNotification tr = new TrayNotification();
            tr.setTitle("Modification avec succés");
            tr.setMessage("Vous avez modifier une propriétée");
            tr.setNotificationType(NotificationType.SUCCESS);
            tr.setAnimationType(AnimationType.SLIDE);
            tr.showAndDismiss(Duration.seconds(6));
            /*Modification dans la table Historique Prop*/
//            pst1.setString(1, hpop.getCategoriePropriete());
//            pst1.setString(2, hpop.getTypePropriete());
//            pst1.setString(3, hpop.getPays());
//            pst1.setString(4, hpop.getVille());
//            pst1.setString(5, hpop.getRue());
//            pst1.setFloat(6, hpop.getPrix());
//            pst1.setInt(7, hpop.getNbrChambre());
//            pst1.setInt(8, hpop.getNbrChambre());
//            pst1.setString(9, hpop.getDescription());
//            pst1.setBoolean(10, hpop.getAnimaux());
//            pst1.setBoolean(11, hpop.getFumeur());
//            pst1.setBoolean(12, hpop.getAlcool());
//            pst1.setBoolean(13, hpop.getEnfant());
//            pst1.setInt(14, hpop.getUser().getId_u());
//            pst1.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println("Echec de mise à jour ! " + ex.getMessage());
            Logger.getLogger(ProprieteCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deletePropriete(int id_p) {
        try {
            String query = "DELETE from propriete WHERE id_p=?";
            PreparedStatement pst = connexion.prepareStatement(query);
            pst.setInt(1, id_p);
            pst.executeUpdate();
            tray.notification.TrayNotification tr = new TrayNotification();
            tr.setTitle("Suppression avec succés");
            tr.setMessage("Vous avez supprimer une propriétée");
            tr.setNotificationType(NotificationType.SUCCESS);
            tr.setAnimationType(AnimationType.SLIDE);
            tr.showAndDismiss(Duration.seconds(6));
            return true;
        } catch (SQLException ex) {
            System.out.println("Echec suppression " + ex.getMessage());
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
                prop.setId(res.getInt("id_p"));
                prop.setCategoriePropriete(res.getString("CategoriePropriete"));
                prop.setTypePropriete(res.getString("TypePropriete"));
                prop.setPays(res.getString("Pays"));
                prop.setVille(res.getString("Ville"));
                prop.setRue(res.getString("Rue"));
                prop.setTitre(res.getString("Titre"));
                prop.setPrix(res.getInt("Prix"));
                prop.setNbrChambre(res.getInt("NbrChambre"));
                prop.setNbrVoyageur(res.getInt("NbrVoyageur"));
                prop.setDescription(res.getString("Description"));
                prop.setAnimaux(res.getBoolean("Animaux"));
                prop.setFumeur(res.getBoolean("Fumeur"));
                prop.setAlcool(res.getBoolean("Alcool"));
                prop.setEnfant(res.getBoolean("Enfant"));
//                User user = new User();
//                UserDAO userDao= new UserDAO();
//                int i = res.getInt("id_u");
//                user = userDao.retrieveAdminById(i);
//                prop.setUser(user);
                proprietes.add(prop);

            }
            return proprietes;
        } catch (SQLException ex) {
            Logger.getLogger(ProprieteCrud.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public Propriete getProprieteById(int id_p) {
        Propriete prop = new Propriete();
        try {
            String query = "select * from propriete where id_p=?";
            PreparedStatement pst = connexion.prepareStatement(query);
            pst.setInt(1, id_p);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                prop.setId(res.getInt("id_p"));
                prop.setCategoriePropriete(res.getString("CategoriePropriete"));
                prop.setTypePropriete(res.getString("TypePropriete"));
                prop.setPays(res.getString("Pays"));
                prop.setVille(res.getString("Ville"));
                prop.setRue(res.getString("Rue"));
                prop.setTitre(res.getString("Titre"));

                prop.setPrix(res.getInt("Prix"));
                prop.setNbrChambre(res.getInt("NbrChambre"));
                prop.setNbrVoyageur(res.getInt("NbrVoyageur"));
                prop.setDescription(res.getString("Description"));
                prop.setAnimaux(res.getBoolean("Animaux"));
                prop.setFumeur(res.getBoolean("Fumeur"));
                prop.setAlcool(res.getBoolean("Alcool"));
                prop.setEnfant(res.getBoolean("Enfant"));
//                User user = new User();
//                UserDAO userDao= new UserDAO();
//
//                int i = res.getInt("id_u");
//                user = userDao.retrieveAdminById(i);
//                prop.setUser(user);

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

        try {
            String query = "select * from historiquepropriete";
            PreparedStatement pst = connexion.prepareStatement(query);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                        HistoriquePropriete historiquePropriete = new HistoriquePropriete();

                historiquePropriete.setCategoriePropriete(res.getString("CategoriePropriete"));
                historiquePropriete.setTypePropriete(res.getString("TypePropriete"));
                historiquePropriete.setPays(res.getString("Pays"));
                historiquePropriete.setVille(res.getString("Ville"));
                historiquePropriete.setRue(res.getString("Rue"));
                historiquePropriete.setTitre(res.getString("Titre"));

                historiquePropriete.setPrix(res.getInt("Prix"));
                historiquePropriete.setNbrChambre(res.getInt("NbrChambre"));
                historiquePropriete.setNbrVoyageur(res.getInt("NbrVoyageur"));
                historiquePropriete.setDescription(res.getString("Description"));
                historiquePropriete.setAnimaux(res.getBoolean("Animaux"));
                historiquePropriete.setFumeur(res.getBoolean("Fumeur"));
                historiquePropriete.setAlcool(res.getBoolean("Alcool"));
                historiquePropriete.setEnfant(res.getBoolean("Enfant"));
//                User user = new User();
//
//                int i = res.getInt("id_u");
//                UserDAO userDao = new UserDAO();
//                user = userDao.retrieveAdminById(i);
//                historiquePropriete.setUser(user);
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
            String query = "select * from propriete where id_p=?";
            PreparedStatement pst = connexion.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                historiquePropriete.setCategoriePropriete(res.getString("CategoriePropriete"));
                historiquePropriete.setTypePropriete(res.getString("TypePropriete"));
                historiquePropriete.setPays(res.getString("Pays"));
                historiquePropriete.setVille(res.getString("Ville"));
                historiquePropriete.setRue(res.getString("Rue"));
                historiquePropriete.setTitre(res.getString("Titre"));

                historiquePropriete.setPrix(res.getInt("Prix"));
                historiquePropriete.setNbrChambre(res.getInt("NbrChambre"));
                historiquePropriete.setNbrVoyageur(res.getInt("NbrVoyageur"));
                historiquePropriete.setDescription(res.getString("Description"));
                historiquePropriete.setAnimaux(res.getBoolean("Animaux"));
                historiquePropriete.setFumeur(res.getBoolean("Fumeur"));
                historiquePropriete.setAlcool(res.getBoolean("Alcool"));
                historiquePropriete.setEnfant(res.getBoolean("Enfant"));

                User user = new User();
                UserDAO userDao = new UserDAO();
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

    @Override
    public List<Propriete> getAllUserProprietes(int id_u) {
        List<Propriete> proprietes = new ArrayList<Propriete>();
        try {
            String query = "select * from propriete where id_u=" + id_u;
            PreparedStatement pst = connexion.prepareStatement(query);
            ResultSet res = pst.executeQuery(query);
            while (res.next()) {
                Propriete prop = new Propriete();
                prop.setId(res.getInt("id_p"));
                prop.setCategoriePropriete(res.getString("CategoriePropriete"));
                prop.setTypePropriete(res.getString("TypePropriete"));
                prop.setPays(res.getString("Pays"));
                prop.setVille(res.getString("Ville"));
                prop.setRue(res.getString("Rue"));
                prop.setTitre(res.getString("Titre"));

                prop.setPrix(res.getInt("Prix"));
                prop.setNbrChambre(res.getInt("NbrChambre"));
                prop.setNbrVoyageur(res.getInt("NbrVoyageur"));
                prop.setDescription(res.getString("Description"));
                prop.setAnimaux(res.getBoolean("Animaux"));
                prop.setFumeur(res.getBoolean("Fumeur"));
                prop.setAlcool(res.getBoolean("Alcool"));
                prop.setEnfant(res.getBoolean("Enfant"));
//                User user = new User();
//                UserDAO userDao= new UserDAO();
//                int i = res.getInt("id_u");
//                user = userDao.retrieveAdminById(i);
//                prop.setUser(user);
                proprietes.add(prop);

            }
            return proprietes;
        } catch (SQLException ex) {
            Logger.getLogger(ProprieteCrud.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
