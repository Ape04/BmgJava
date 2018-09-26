package bemyguest.DAO.Classe;



import bemyguest.DAO.Interface.IRelamation;
import bemyguest.config.ConnectionDB;
import bemyguest.entities.Reclamation;
import bemyguest.entities.ReclamationAN;
import bemyguest.entities.User;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Duration;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
/**
 *
 * @author LENOVO
 */
public class ReclamationCrud implements IRelamation<Reclamation>{
    
    Connection connexion = ConnectionDB.getConnexion();

    @Override
    public void ajouterReclamation(Reclamation r) {
        
        String req1= "INSERT INTO reclamation (email,type,etat,contenu,date,nom,prenom,id_user) VALUES (?,?,?,?,?,?,?,?)";
        try {
        PreparedStatement pst=connexion.prepareStatement(req1);
            pst.setString(1,r.getUserReclamant().getEmail() );
           
           pst.setString(2, r.getType());
             pst.setInt(3, 0);
           pst.setString(4, r.getContenu());
          pst.setDate(5, Date.valueOf(LocalDate.now()));
           pst.setString(6,r.getUserReclamant().getNom() );
           pst.setString(7,r.getUserReclamant().getPrenom() );
            pst.setInt(8,r.getUserReclamant().getId_u() );
            pst.executeUpdate();
            System.out.println("ajout");
           
            
            tray.notification.TrayNotification tr = new tray.notification.TrayNotification();
                tr.setTitle("Terminé");
                tr.setMessage("Ajouté avec succées" );
                tr.setNotificationType(NotificationType.SUCCESS);
                tr.setAnimationType(AnimationType.POPUP);
                tr.showAndDismiss(Duration.seconds(200));
        } catch (SQLException ex) {
          Logger.getLogger(ReclamationCrud.class.getName()).log(Level.SEVERE, null, ex);
          System.out.println("passss ajouuut");
           tray.notification.TrayNotification tr = new tray.notification.TrayNotification();
                tr.setTitle("Erreuuur");
                tr.setMessage("Erreuuur" );
                tr.setNotificationType(NotificationType.ERROR);
                tr.setAnimationType(AnimationType.POPUP);
                tr.showAndDismiss(Duration.seconds(200));
        }
    }
    
  public List<Reclamation> afficherReclamation() {
        String req2= "select * from reclamation";
        List<Reclamation> list = new ArrayList();
        try {
             PreparedStatement pst=connexion.prepareStatement(req2);
            ResultSet res  =pst.executeQuery(req2);
            while (res.next()) { 
                
                 User uReclamant = new User();
                 User uReclame = new User();
                 
                 UserDAO  dao = new  UserDAO ();
                 
                 uReclamant = dao.retrieveAdminById(res.getInt(9));
                

                    Reclamation r=new Reclamation();
                    r.setId_rec(res.getInt(1));
                    r.setUserReclamant(uReclamant);
                    r.setUserReclame(uReclame);
                    r.setContenu(res.getString(5));
             
                  r.setDate(res.getDate("date"));
                   r.setType(res.getString("type"));
                    list.add(r);
            }
         return list;   
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
  }
  public List<ReclamationAN> afficherReclamationAN() {
        String req2= "select * from reclamation";
        List<ReclamationAN> list = new ArrayList();
        try {
             PreparedStatement pst=connexion.prepareStatement(req2);
            ResultSet res  =pst.executeQuery(req2);
            while (res.next()) { 
                
                 User uReclamant = new User();
                 User uReclame = new User();
                 
                 UserDAO dao = new  UserDAO ();
                 
                 uReclamant = dao.retrieveAdminById(res.getInt(9));
                 

                    ReclamationAN r=new ReclamationAN();
                    r.setId_rec(res.getInt(1));
                    r.setUserReclamant(uReclamant);
                    r.setUserReclame(uReclame);
                    r.setContenu(res.getString(5));
             
                  r.setDate(res.getDate("date"));
                   r.setType(res.getString("type"));
                    list.add(r);
            }
         return list;   
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
  }
    @Override
 public boolean DeleteReclamationById(int id_rec) {
        boolean testDelete = false;
        String req = "delete from reclamation where id=?";

        try {
            PreparedStatement pst = connexion.prepareStatement(req);
            pst.setInt(1, id_rec);
            int res = pst.executeUpdate();
            if (res != 0) {
                testDelete = true;
                System.out.println("reclamation a été supprimé avec succée 🙂 ");
            }

        } catch (SQLException ex) {

            System.out.println("Echec de suppression ! " + ex.getMessage());
        }
        return testDelete;
    }
  
  
        public boolean updateReclamation(Reclamation r) {
        
        boolean testUpdate =false;
        String sql="update reclamation1 set contenu=? where id_rec="+r.getId_rec();

        try {
                PreparedStatement prt=connexion.prepareStatement(sql);
                prt.setString(1,r.getContenu());
                int res=prt.executeUpdate();
        
                    if(res!=0)
                    {
                        testUpdate=true;
                        System.out.println("Mise à jour effectuée avec succès 🙂 ");
                     }

        } catch (SQLException ex) {
            
            System.out.println("Echec de la mise à jour !  " + ex.getMessage());
        }
                        return testUpdate;
        
    }
  
    
        public static void main(String args[]){
            
            ReclamationCrud dao = new ReclamationCrud();
             UserDAO  daou = new  UserDAO ();
            
            User u1 = new User(1, "m", "m", "m", "m", "m");
            User u2 = new User(1, "o", "o", "o", "o", "o");
           // Reclamation r = new Reclamation(1,"rrr", daou.retrieveAdminById(1), daou.retrieveAdminById(5),"ggggg","ffffff",Date.valueOf(LocalDate.now()));
            System.out.println("ajouoter");
            //Reclamation r = new Reclamation("rrr", u1, u2);
          //  dao.ajouterReclamation(r);
            //System.out.println(dao.afficherReclamation());
            dao.DeleteReclamationById(3);
    }



}
    
