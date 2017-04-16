/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.DAO.Classe;

import static bemyguest.DAO.Classe.UserDAO.j;
import bemyguest.DAO.Interface.IFavorisDAO;
import bemyguest.config.ConnectionDB;
import bemyguest.entities.Favoris;
import bemyguest.entities.User;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oussaa
 */
public class FavorisDAO implements IFavorisDAO {

    Connection connexion = ConnectionDB.getConnexion();

    @Override
    public void insertFavoris(Favoris favoris) {
        try {
            String requete = "INSERT INTO favoris (id_user, id_favoris,alias) VALUES(?,?,null)";
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setInt(1, favoris.getUser().getId_u());
            pst.setInt(2, favoris.getUserFavoris().getId_u());
            pst.executeUpdate();
            System.out.println("Favoris Ajoutee");
        } catch (SQLException ex) {
            System.out.println("Echec ! " + ex.getMessage());
        }
    }
    
    
    
    @Override
    public void insertFavorisUser(User u) {
        try {
            String requete = "INSERT INTO favoris (id_user, id_favoris, alias) VALUES(?,?,null)";
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setInt(1, j);
            pst.setInt(2, u.getId_u());
            pst.executeUpdate();
            System.out.println("Favoris Ajoutee");
        } catch (SQLException ex) {
            System.out.println("Echec ! " + ex.getMessage());
        }
    }

    @Override
    public void deleteFavoris(int id) {
        try {
            String requete = "DELETE FROM favoris where id_f=?";
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Favoris supprime");
        } catch (SQLException ex) {
            System.out.println("Echec de suppression ! " + ex.getMessage());
        }
    }

    @Override
    public void deleteFavoris(Favoris favoris) {
        try {
            String requete = "DELETE FROM favoris where id_user=? AND id_favoris=?";
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setInt(1, favoris.getUser().getId_u());
            pst.setInt(2, favoris.getUserFavoris().getId_u());
            pst.executeUpdate();
            System.out.println("Favoris supprime");
        } catch (SQLException ex) {
            System.out.println("Echec de suppression ! " + ex.getMessage());
        }
    }

    @Override
    public void updateFavoris(Favoris favoris) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Favoris retrieveFavorisById(int id_f) {

        String requete = "SELECT * FROM favoris where id_f=?";
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setInt(1, id_f);
            ResultSet resultat = pst.executeQuery();

            User user = new User();
            User userFavoris = new User();
            UserDAO dao = new UserDAO();

            Favoris favoris = null;

            while (resultat.next()) {
                int idUser = resultat.getInt("id_user");
                int idFavoris = resultat.getInt("id_Favoris");
                user = dao.retrieveAdminById(idUser);
                userFavoris = dao.retrieveAdminById(idFavoris);
                favoris = new Favoris(resultat.getInt("id_f"), user, userFavoris);
            return favoris;

            }
        } catch (SQLException ex) {
            Logger.getLogger(FavorisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Favoris> retrieveFavorisByIdUser(int id_u) {
      
    
        UserDAO dao = new UserDAO();

        List<Favoris> listeFav = new ArrayList<>();
        String requete = "SELECT * FROM favoris where id_user=?";
        try {

            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setInt(1, id_u);
            ResultSet resultat = pst.executeQuery();
          
            while (resultat.next()) {
                User user = new User ();
        User userFavoris = new User() ;
                int idUser = resultat.getInt(2);
                int idFavoris = resultat.getInt(3);
                
                user = dao.retrieveAdminById(idUser);
              
                userFavoris = dao.retrieveAdminById(idFavoris);
              
                
                Favoris f = new Favoris();
                f.setId_f(resultat.getInt("id_f"));
                f.setUser(user);
                f.setUserFavoris(userFavoris);
                f.setAlias(resultat.getString("alias"));
            listeFav.add(f);
            }
            return listeFav;

        } catch (SQLException ex) {
            Logger.getLogger(FavorisDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean isFavoris(int id_user, int id_favoris) {
        try {
            String requete = "SELECT * FROM favoris where id_user = ? AND id_favoris = ?";
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setInt(1, id_user);
            pst.setInt(2, id_favoris);

            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(FavorisDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Favoris> retrieveAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EditAlias(String x, int i) {
        String req="update favoris set alias=? where id_f=? ";
        try {
                PreparedStatement prt=connexion.prepareStatement(req);
        prt.setString(1, x);
        prt.setInt(2, i);
        prt.executeUpdate();
        System.out.println("Mise à jour effectuée avec succès :) ");

        } catch (SQLException ex) {
            System.out.println("Echec de la mise à jour !  " + ex.getMessage());
        }
    }
}
