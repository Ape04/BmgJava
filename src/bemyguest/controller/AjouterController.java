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
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choConnectionBD in Project Properties.
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
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bemyguest.controller;

import bemyguest.DAO.Classe.ReclamationCrud;
import bemyguest.DAO.Classe.UserDAO;
import bemyguest.config.ConnectionDB;
import bemyguest.entities.Mail;
//import bemyguest.entities.Mail;
import bemyguest.entities.Reclamation;
import bemyguest.entities.ReclamationAN;
import bemyguest.entities.Resrevation;
import bemyguest.entities.User;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.mail.Message;
import javax.mail.Message ;
import javax.mail.MessagingException ;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport ;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AjouterController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private ComboBox <String> combobox;
    ObservableList<String>list = FXCollections.observableArrayList("etat du chambre","acceuil","fausse annonce","other") ;
    

    @FXML
    private Label label_prenom1221;


    @FXML
    private TableColumn<?, ?> col_contenu;
 @FXML
    private TableColumn<?, ?> col_type;
    
   @FXML
    private TableColumn<?, ?> col_date;
   @FXML
    private TableColumn<?, ?> col_id;
  @FXML
    private Button menuMessage;

    @FXML
    private AnchorPane afficher;


    @FXML
    private Button menuCompetition;

        private Label label_type;

        private Label label_contenu;

    @FXML
    private Button traiter_reservation;

    @FXML
    private Label label_prenom11;

    @FXML
    private Label label1;

    @FXML
    private Button menuClub1;

    @FXML
    private Button menuClub;

    @FXML
    private AnchorPane gestion;

    @FXML
    private Button menuFormation;

    @FXML
    private Label titelLabel;

    @FXML
    private Button menuCup;

        private Label label_duree;

       Connection connexion = ConnectionDB.getConnexion();


    @FXML
    private TableView<Reclamation>tab_reclamation;
    private ObservableList<Reclamation> data;
    @FXML
    private Button menuMatch;
    @FXML
    private Button boutton_ajouter;
    @FXML
    private Label label_prenom121;
    @FXML
    private TextArea txt_contenu;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TextField text_rechercher;
            
    @FXML
    void boutton_ajouter() {
        UserDAO ud = new  UserDAO ();
        User u = new User();
        User u2 = new User();
        
        u = ud.retrieveAdminById(1);
        u2 = ud.retrieveAdminById(2);
        System.out.println ( u2 );
        ReclamationCrud recCrud= new ReclamationCrud();
        Reclamation rec = new Reclamation();
     //  Date date2 = java.sql.Date.valueOf(date.getValue());
        
        rec.setType(combobox.getValue());
      
    //    rec.setDate(date2);
        rec.setContenu(txt_contenu.getText());
        rec.setUserReclamant(u);
        rec.setUserReclame(u2);
        recCrud.ajouterReclamation(rec);
            
        System.out.println("ajout avec sucéé");
        data = FXCollections.observableArrayList();
         
        LoadData();
          setCellTable();
        combobox.setItems(list);
       
    Mail mail = new Mail();
      mail.send("dorra.dalhoumi@esprit.tn");
     
      
    }

   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       data = FXCollections.observableArrayList();
          LoadData();
          setCellTable();
        combobox.setItems(list);
        
        text_rechercher.textProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                filterEvenementList((String) oldValue, (String) newValue);
              
            }
        });
    }    
           private void handleButtonAfficheAction(ActionEvent event) {
        data = FXCollections.observableArrayList();
          LoadData();
          setCellTable();
        
        
        
    }
           
     

    
    private void setCellTable() {
        
        col_contenu.setCellValueFactory(new PropertyValueFactory<>("contenu"));
       col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
       col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
      
      col_id.setCellValueFactory(new PropertyValueFactory<>("id_rec"));
    
}

 private void LoadData( ) {
       
       data.clear();
       
        int idUserConnecte=1;
       List <Reclamation>  l ;      
         ReclamationCrud rdao = new  ReclamationCrud () ;
         
         l=rdao.afficherReclamation();
      
         for (int i=0 ; i<l.size();i++){
         
                data.add(new Reclamation(l.get(i).getId_rec(),l.get(i).getType(),l.get(i).getDate(),l.get(i).getContenu()));
  System.out.println(l.get(i).getType());
           
       }
    
 
      
        tab_reclamation.setItems(data);
         
 }
     
   
    
    public void filterEvenementList(String oldValue, String newValue) {
        ObservableList<Reclamation> filteredList = FXCollections.observableArrayList();
        if (text_rechercher == null || (newValue.length() < oldValue.length()) || newValue == null) {

            tab_reclamation.setItems(data);
            LoadData();
        } else {
            newValue = newValue.toUpperCase();
            for (Reclamation t : tab_reclamation.getItems()) {
                String filterType = t.getType();
                String filterContenu = t.getContenu();
                if (filterType.toUpperCase().contains(newValue) || filterContenu.toUpperCase().contains(newValue)) {
                   
                    filteredList.add(t);
                }
            }
            
            tab_reclamation.setItems(filteredList);
        }
    }

   
}
