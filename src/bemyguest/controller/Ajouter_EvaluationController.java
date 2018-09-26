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
 */

package bemyguest.controller;


import bemyguest.DAO.Classe.Evaluation_Crud;
import bemyguest.DAO.Classe.UserDAO;
import bemyguest.config.ConnectionDB;
import bemyguest.entities.Evaluation;
import bemyguest.entities.Reclamation;
import bemyguest.entities.User;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Ajouter_EvaluationController implements Initializable {
    @FXML
    private ComboBox<String> Combo_Type;
    ObservableList<String>list =  FXCollections.observableArrayList("très bon","Bon","Moyen","Mauvais") ;
    @FXML
    private ComboBox<String> Combo_etat;
      ObservableList<String>list2 =  FXCollections.observableArrayList("très bon","Bon","Moyen","Mauvais") ;
    @FXML
    private ComboBox<String> Combo_caractere ;
       ObservableList<String>list3 =  FXCollections.observableArrayList("très bon","Bon","Moyen","Mauvais") ;
    @FXML
    private ComboBox<String> Combo_Proprete;
      ObservableList<String>list4 =  FXCollections.observableArrayList("propre","Mauvais") ;
    @FXML
    private AnchorPane afficher;
    private Label label1;
   Connection connexion = ConnectionDB.getConnexion();
      
      
       @FXML
    private ToggleGroup experience;

    @FXML
    private Button menuClub;

    @FXML
    private Label titelLabel;

    @FXML
    private RadioButton rb_3;

    @FXML
    private ToggleGroup reglement;

    @FXML
    private RadioButton rb_2;

    @FXML
    private RadioButton rb_1;

    @FXML
    private Button menuMatch;

    @FXML
    private RadioButton rbR_1;

    @FXML
    private RadioButton rbQ_2;

    @FXML
    private RadioButton rbR_2;

    @FXML
    private RadioButton rbQ_3;

    @FXML
    private Button menuMessage;

    @FXML
    private RadioButton rbQ_1;

  

    

    @FXML
    private Button menuCompetition;

    @FXML
    private Button menuClub1;

   

    @FXML
    private Button menuFormation;

    @FXML
    private Button boutton_ajouter;

    @FXML
    private RadioButton rbE_1;

    @FXML
    private ToggleGroup qualite_p;

    @FXML
    private Button menuCup;

    @FXML
    private ToggleGroup qualite;

    @FXML
    private RadioButton rbE_2;

  
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           
          
        Combo_Proprete.setItems(list4);
        Combo_Type.setItems(list);
        Combo_caractere.setItems(list3);
        Combo_etat.setItems(list2);
    }    
  @FXML
    void Button_Ajouter_EV(ActionEvent event) {
 UserDAO ud = new  UserDAO();
        User u = new User();
        User u2 = new User();
        
        u = ud.retrieveAdminById(1);
        u2 = ud.retrieveAdminById(2);
        System.out.println ( u2 );
        Evaluation_Crud evCrud= new Evaluation_Crud();
        Evaluation eva = new Evaluation();
    
        
        eva.setType_acceuil(Combo_Type.getValue());
        eva.setPropreté(Combo_Proprete.getValue());
        eva.setCaractere_du_host(Combo_caractere.getValue());
        eva.setEtat_du_chambre(Combo_etat.getValue());
        
        eva.setId_evaluant(u);
        eva.setId_evalue(u2);
         if (rb_1.isSelected()) {
            eva.setQualite_cuisine("Bonne");
        } else if (rb_2.isSelected()) {
            eva.setQualite_cuisine("Moyenne");

        } else 
            eva.setQualite_cuisine("Mauvaise");
          if (rbE_1.isSelected()) {
            eva.setExperience_globale("interessante");
       
        } else 
            eva.setExperience_globale("Mauvaise");
           if (rbR_1.isSelected()) {
            eva.setReglement("tres stricte");
       
        } else 
            eva.setReglement("normale");
           
           if (rbQ_1.isSelected()) {
            eva.setQualité_prix("tres cher");
        } else if (rbQ_2.isSelected()) {
            eva.setQualité_prix("prix raisonable");

        } else 
            eva.setQualite_cuisine("bonne affaire");
        evCrud.ajouterEvaluation(eva);
            
        System.out.println("ajout avec sucéé");
       
         
       Combo_Proprete.setItems(list4);
        Combo_Type.setItems(list);
        Combo_caractere.setItems(list3);
        Combo_etat.setItems(list2);
        if (rb_1.isSelected()) {
            eva.setQualite_cuisine("Bonne");
        } else if (rb_2.isSelected()) {
            eva.setQualite_cuisine("Moyenne");

        } else 
            eva.setQualite_cuisine("Mauvaise");
    }

   
   
}
