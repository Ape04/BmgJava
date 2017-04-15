package bemyguest.DAO.Classe;

import bemyguest.DAO.Interface.IUser;
import bemyguest.entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import bemyguest.config.ConnectionDB;

/**
 *
 * @author Haroun
 */
public class UserDAO implements IUser {

    Connection connexion = ConnectionDB.getConnexion();

    @Override
    public void inscriptionUser(User user) {
        try {
            String requete = "INSERT INTO `utilisateur` (`nom`, `prenom`, `email`, `login`, `password`,`role`, `imageurl`,`sexe`,`daten`,`numtel` ) VALUES (?, ?, ?, ?, ?,'guest',?,?,?,?)";
            PreparedStatement prt = connexion.prepareStatement(requete);
            
            prt.setString(1, user.getNom());
            prt.setString(2, user.getPrenom());
            prt.setString(3, user.getEmail());
            prt.setString(4, user.getLogin());
            prt.setString(5, user.getPassword());
            prt.setString(6, user.getImageurl());
            prt.setString(7, user.getSexe());
            prt.setString(8, user.getDaten());
            prt.setString(9, user.getNumtel());
            
            prt.executeUpdate();

 Notifications notififcationBuilder=Notifications.create()
                .title("Confiramtion !")
                .text("Inscription effectué avec succée !")
                .graphic(null)
                .hideAfter(Duration.seconds(4))
                .position(Pos.CENTER)
                .onAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    System.out.println("Hello");
                }
            });
     //   notififcationBuilder.darkStyle();
        notififcationBuilder.showConfirm();        } catch (Exception e) {
             Notifications notififcationBuilder=Notifications.create()
                .title("Erreur !")
                .text("Echec d'inscription !")
                .graphic(null)
                .hideAfter(Duration.seconds(4))
                .position(Pos.CENTER)
                .onAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    System.out.println("Hello");
                }
            });
     //   notififcationBuilder.darkStyle();
        notififcationBuilder.showError();
            System.out.println("Echec d'insertion ! " + e.getMessage());
        }
    }
    
    @Override
    public void insertAdmin(User user) {
        try {
            String requete = "INSERT INTO `utilisateur` (`nom`, `prenom`, `email`, `login`, `password`,`role`,`sexe`,`imageurl`,`numtel`) VALUES (?, ?, ?, ?, ?,'Admin',?,?,?)";
            PreparedStatement prt = connexion.prepareStatement(requete);
            
            prt.setString(1, user.getNom());
            prt.setString(2, user.getPrenom());
            prt.setString(3, user.getEmail());
            prt.setString(4, user.getLogin());
            prt.setString(5, user.getPassword());
            prt.setString(6, user.getSexe());  
            prt.setString(7, user.getImageurl());
            prt.setString(8, user.getNumtel());

            prt.executeUpdate();
                        Notifications notififcationBuilder = Notifications.create()
                        .title("Succée !")
                        .text(" Nouveau administrateur ajouté avec succée ")
                        .graphic(null)
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.CENTER);
                      
                notififcationBuilder.showConfirm();
        } catch (SQLException ex) {
            System.out.println("Echec d'ajout ! " + ex);
        }
    }
    @Override    //Admin
    public boolean deleteUser(int id_u) {

        boolean testDelete = false;
        String req = "delete from utilisateur where id_u=?";

        try {
            PreparedStatement prt = connexion.prepareStatement(req);
            prt.setInt(1, id_u);
            int res = prt.executeUpdate();
            
            if (res != 0) {
                testDelete = true;
//                System.out.println("Utilisateur a été supprimé avec succée :) ");
                
            }

        } catch (SQLException ex) {

            System.out.println("Echec de suppression ! " + ex.getMessage());
        }
        return testDelete;
    }

    @Override  //Admin
    public List<User> retriveUser()     {
        List<User> myUsers = new ArrayList<User>();
        User user = null;
        String req = "select * from utilisateur ";

        try {

            PreparedStatement prt = connexion.prepareStatement(req);
            ResultSet res = prt.executeQuery();

            
            
            while (res.next()) {
                user = new User(res.getInt("id_u"),
                        res.getString("nom"),
                        res.getString("prenom"), res.getString("email"), res.getString("login"),
                        res.getString("password"), res.getString("role"), res.getString("imageurl"),res.getString("sexe")
                ,res.getString("daten"),res.getString("numtel"));

                myUsers.add(user);
                
            }

        } catch (SQLException ex) {

            System.out.println("Echec d'afficher la liste des utilisateurs ! " + ex.getMessage());
        }
        return myUsers;

    }

    @Override //User
    public boolean updateUser(User user) {
        
        boolean testUpdate =false;
        String sql="update utilisateur set nom=?,prenom=?,email=?, login=?, password=?, sexe=?, imageurl=?, numtel=? where id_u="+user.getId_u();

        try {
                PreparedStatement prt=connexion.prepareStatement(sql);
            prt.setString(1, user.getNom());
            prt.setString(2, user.getPrenom());
            prt.setString(3, user.getEmail());
            prt.setString(4, user.getLogin());
            prt.setString(5, user.getPassword());
            prt.setString(6, user.getSexe());
            prt.setString(7, user.getImageurl());
            prt.setString(8, user.getNumtel());

                int res=prt.executeUpdate();
        
                    if(res!=0)
                    {
                        testUpdate=true;
                        System.out.println("Mise à jour effectuée avec succès :) ");
                     }

        } catch (SQLException ex) {
            
            System.out.println("Echec de la mise à jour !  " + ex.getMessage());
        }
                        return testUpdate;
        
    }

    @Override
    public User retrieveAdminById(int id_u) {
        String req = "select * from utilisateur where id_u = '" + id_u + "%'";
     User user=null;
        try {
           
            PreparedStatement prt = connexion.prepareStatement(req);

            ResultSet res = prt.executeQuery();
             
                while (res.next()) {
                    user = new User(res.getInt("id_u"), res.getString("nom"), 
                            res.getString("prenom"), res.getString("email"), 
                            res.getString("login"), res.getString("password"), 
                            res.getString("role"),res.getString("imageurl"),
                            res.getString("sexe"),res.getString("daten"),
                            res.getString("numtel")
                    );
                    
                }
            
                        return user;
                     
            } catch (SQLException ex) {
                
                System.out.println("Echec d'afficher cet utilisateur ! " + ex.getMessage());
           
                        return null;
            }
        
    }
@Override
    public User retrieveAdminByLogin(String login) {
        String req = "select * from utilisateur where login = '" + login + "'  ";
     User user=null;
        try {
           
            PreparedStatement prt = connexion.prepareStatement(req);

            ResultSet res = prt.executeQuery();
             
                while (res.next()) {
                    user = new User(res.getInt("id_u"), res.getString("nom"), 
                            res.getString("prenom"), res.getString("email"), 
                            res.getString("login"), res.getString("password"), 
                            res.getString("role"),res.getString("imageurl"),
                            res.getString("sexe"),res.getString("daten"),
                            res.getString("numtel")
                    );
                    
                }
            
                        return user;
                     
            } catch (SQLException ex) {
                
                System.out.println("Echec d'afficher cet utilisateur ! " + ex.getMessage());
           
                        return null;
            }
        
    }

}
