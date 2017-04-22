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
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import org.openide.util.Exceptions;

/**
 *
 * @author Haroun
 */
public class UserDAO implements IUser {

    Connection connexion = ConnectionDB.getConnexion();
    public static int j;
    public static String Time() {

    java.util.Date dt = new java.util.Date();

    java.text.SimpleDateFormat sdf = 
     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String currentTime = sdf.format(dt); 
    return currentTime;
}

    public void updateLastLogin(User user, int i) {
        try {
            String requete = "Update `utilisateur` set `last_login`=? where `id`="+i ;
            PreparedStatement prt = connexion.prepareStatement(requete);
            prt.setString(1, Time());
            prt.executeUpdate();
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
            }
        
    
    @Override
    public void inscriptionUser(User user) {
       
        try {
            String requete = "INSERT INTO `utilisateur` (`lastname`, `firstname`, `email`, `email_canonical`,`username`,`username_canonical`,`enabled`, `password`,`roles`, `imageurl`,`sexe`,`daten`,`numtel`,`last_login` ) VALUES (?, ?, ?, ?, ?,?, '1', ?,'a:1:{i:0;s:11:\"ROLE_CLIENT\";}',?,?,?,?,?)";
            PreparedStatement prt = connexion.prepareStatement(requete);
            
            prt.setString(1, user.getNom());
            prt.setString(2, user.getPrenom());
            prt.setString(3, user.getEmail());
            prt.setString(4, user.getEmail().toLowerCase());
            prt.setString(5, user.getLogin());
            prt.setString(6, user.getLogin().toLowerCase());
            prt.setString(7, user.getPassword());
            prt.setString(8, user.getImageurl());
            prt.setString(9, user.getSexe());
            prt.setString(10, user.getDaten());
            prt.setString(11, user.getNumtel());
            prt.setString(12, Time());
            
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
            String requete = "INSERT INTO `utilisateur` (`lastname`, `firstname`, `email`, `username`, `password`,`roles`,`sexe`,`imageurl`,`numtel`) VALUES (?, ?, ?, ?, ?,'a:1:{i:0;s:16:\"ROLE_SUPER_ADMIN\";}',?,?,?)";
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
        String req = "delete from utilisateur where id=?";

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
                user = new User(res.getInt("id"),
                        res.getString("lastname"),
                        res.getString("firstname"), res.getString("email"), res.getString("username"),
                        res.getString("password"), res.getString("roles"), res.getString("imageurl"),res.getString("sexe")
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
        String sql="update utilisateur set lastname=?,firstname=?,email=?, username=?, password=?, sexe=?, imageurl=?, numtel=? where id="+user.getId_u();

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
        String req = "select * from utilisateur where id = '" + id_u + "%'";
     User user=null;
        try {
           
            PreparedStatement prt = connexion.prepareStatement(req);

            ResultSet res = prt.executeQuery();
             
                while (res.next()) {
                    user = new User(res.getInt("id"), res.getString("lastname"), 
                            res.getString("firstname"), res.getString("email"), 
                            res.getString("username"), res.getString("password"), 
                            res.getString("roles"),res.getString("imageurl"),
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
        String req = "select * from utilisateur where username = '" + login + "'  ";
     User user=null;
        try {
           
            PreparedStatement prt = connexion.prepareStatement(req);

            ResultSet res = prt.executeQuery();
             
                while (res.next()) {
                    user = new User(res.getInt("id"), res.getString("lastname"), 
                            res.getString("firstname"), res.getString("email"), 
                            res.getString("username"), res.getString("password"), 
                            res.getString("roles"),res.getString("imageurl"),
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
    public int retrieveUserByLogin(String login) {
        
        String req = "select id from utilisateur where username = '" + login + "' and (roles='a:1:{i:0;s:11:\"ROLE_CLIENT\";}' or roles='a:1:{i:0;s:16:\"ROLE_SUPER_ADMIN\";}')  ";
        try {
           
            PreparedStatement prt = connexion.prepareStatement(req);
            ResultSet res = prt.executeQuery();
             while(res.next()){
            j=res.getInt("id");}
                        return j;
                     
            } catch (SQLException ex) {
                
                System.out.println("Echec d'afficher cet utilisateur ! " + ex.getMessage());
           
                        return 0;
            }
    }
    
    public static void main(String[] args) {
        System.out.println(Time());
    }

}
