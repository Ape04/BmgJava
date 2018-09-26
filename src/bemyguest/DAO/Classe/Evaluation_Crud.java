/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bemyguest.DAO.Classe;
import bemyguest.DAO.Interface.IEvaluation;

import bemyguest.config.ConnectionDB;
import bemyguest.entities.Evaluation;
import bemyguest.entities.Reclamation;
import bemyguest.entities.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;

/**
 *
 * @author LENOVO
 */
public class Evaluation_Crud implements IEvaluation<Evaluation> {
 Connection connexion = ConnectionDB.getConnexion();
      
        public void ajouterEvaluation(Evaluation e) {
         String req1= "INSERT INTO evaluation (type_d_acceuil,etat_chambre,caractere_host,reglement,qualite_prix,experience_globale) VALUES (?,?,?,?,?,?)";
        try {
        PreparedStatement pst=connexion.prepareStatement(req1);
            
          
            pst.setString(1, e.getType_acceuil());
             pst.setString(2, e.getEtat_du_chambre());
            pst.setString(3, e.getCaractere_du_host());
          
         
          pst.setString(4, e.getReglement());
            pst.setString(5, e.getQualité_prix());
           pst.setString(6, e.getExperience_globale());
           
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

   
        
        
        
}
