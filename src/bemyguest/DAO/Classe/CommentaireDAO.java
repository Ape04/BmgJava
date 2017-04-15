/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bemyguest.DAO.Classe;

import bemyguest.DAO.Interface.ICommentaire;
import bemyguest.entities.Commentaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bemyguest.config.ConnectionDB;

/**
 *
 * @author Haroun
 */
public class CommentaireDAO implements ICommentaire {
    Connection connexion = ConnectionDB.getConnexion();

    @Override
    public void addComment(Commentaire commentaire) {
        
        try {
            String requete = "INSERT INTO `commentaire` (`contenu_comm`) VALUES (?)";
            PreparedStatement prt = connexion.prepareStatement(requete);
            
            prt.setString(1, commentaire.getContenu_comm());
        
            prt.executeUpdate();
        } catch (SQLException ex) {

            System.out.println(""+ex);
        }
    }

    @Override
    public boolean deleteComment(int id_comm) {
         boolean testDelete = false;
        String req = "delete from commentaire where id_comment=?";

        try {
            PreparedStatement prt = connexion.prepareStatement(req);
            prt.setInt(1, id_comm);
            int res = prt.executeUpdate();
            
            if (res != 0) {
                testDelete = true;
                System.out.println("Commentaire a été supprimé avec succée :) ");
                
            }

        } catch (SQLException ex) {

            System.out.println("Echec de suppression ! " + ex.getMessage());
        }
        return testDelete;
    }

    @Override
    public List<Commentaire> retriveComment() {
        List<Commentaire> myComments = new ArrayList<Commentaire>();
        Commentaire commentaire = null;
        String req = "select * from commentaire ";

        try {

            PreparedStatement prt = connexion.prepareStatement(req);
            ResultSet res = prt.executeQuery();
            while (res.next()) {
                commentaire = new Commentaire(res.getInt("id_comment"),
                        res.getString("contenu_comm")
                        );

                myComments.add(commentaire);
                
            }

        } catch (SQLException ex) {

            System.out.println("Echec d'afficher la liste des commentaires ! " + ex.getMessage());
        }
        return myComments;
    }
    
}
