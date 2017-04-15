/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.DAO.Classe;

import bemyguest.DAO.Interface.InterExperience;
import bemyguest.config.ConnectionDB;
import bemyguest.entities.Experience;
import bemyguest.entities.Propriete;
import bemyguest.entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class ExperienceDAO implements InterExperience{
    
    Connection connexion = ConnectionDB.getConnexion();

    @Override
    public void ajouterExperience(Experience e) {
        try {
            System.out.println("111");
            String req="INSERT INTO `experience`(`description`, `type`, `id_u`,`id_p`) VALUES (?,?,?,?)";
            PreparedStatement st = connexion.prepareStatement(req);
           
             st.setString(1, e.getDescription());
             st.setString(2, e.getType());
             st.setInt(3, e.getUser().getId_u());
             st.setInt(4, e.getPropriete().getId());
             st.executeUpdate();
             
             
            System.out.println("sql request" + st);
            
        } catch (SQLException ex) {
            System.out.println("Echec d'insertion ! " + ex.getMessage());
        }
    }

    @Override
    public void modifierExperience(int id, Experience e) {
        try {
            PreparedStatement st = connexion.prepareStatement("UPDATE `experience` SET `description`=?,`type`=?,`id_u`=?,`id_p`=? WHERE `id_xp`=?");

            st.setString(1, e.getDescription());
            
            st.setString(2, e.getType());
          
            st.setInt(3, e.getUser().getId_u());
            
            st.setInt(4, e.getPropriete().getId());
            
            st.setInt(5, id);
        
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("no" + ex);
        }
    }

    @Override
    public void supprimerExperience(int i) {
        try {
            PreparedStatement st = connexion.prepareStatement("Delete from `experience` where `id_xp`=?");
            st.setInt(1, i);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("no" + ex);
        }
    }

    @Override
    public Experience getExperienceById(int id_xp) {
        Experience experience = new Experience();
        String query = "SELECT * from experience where id_xp=?";
        try {

            PreparedStatement pst = connexion.prepareStatement(query);
            pst.setInt(1, id_xp);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                experience.setId_xp(id_xp);
                experience.setDescription(res.getString("description"));
                experience.setType(res.getString("type"));
                
                User user = new User();
                
                Propriete propriete = new Propriete();
                
                ProprieteCrud propC=new ProprieteCrud();
                UserDAO uDAO=new UserDAO();
                int iu=res.getInt("id_u");
                int ip=res.getInt("id_p");

                user=uDAO.retrieveAdminById(iu);
                propriete=propC.getProprieteById(ip);
                experience.setPropriete(propriete);
                experience.setUser(user);
              

            }
            return experience;
        } catch (SQLException ex) {
            System.out.println("no" + ex);
            return null;
        }
    }

    @Override
    public List<Experience> findAll() {
        
        List<Experience> listeExperience = new ArrayList<>();
        String requete = "select * from experience";
        try {
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
           while (resultat.next()) {
                Experience e = new Experience();
                User user = new User();
                Propriete prop = new Propriete();
                int iu=resultat.getInt("id_u");
                int ip=resultat.getInt("id_p");
                UserDAO uDao = new UserDAO();
                user=uDao.retrieveAdminById(iu);
                ProprieteCrud proDAO = new ProprieteCrud();
                prop=proDAO.getProprieteById(ip);

                
                e.setId_xp(resultat.getInt("id_xp"));
                e.setDescription(resultat.getString("description"));
                e.setType(resultat.getString("type"));
                e.setUser(user);
                e.setPropriete(prop);
               listeExperience.add(e);
            }
            return listeExperience;
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex);
            return null;
        }
    }
    
    public static void main(String[] args){
        User u = new User(1, "y", "y", "y", "y", "y");
        ProprieteCrud pc = new ProprieteCrud();
        Propriete p = pc.getProprieteById(1);
        Experience e = new Experience("ss", "ss", u, p);
        
        ExperienceDAO dao = new ExperienceDAO();
        dao.ajouterExperience(e);
    }
}
