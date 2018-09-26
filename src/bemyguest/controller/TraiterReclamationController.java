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
import bemyguest.DAO.Classe.ReclamationCrud;
import bemyguest.config.ConnectionDB;
import bemyguest.entities.Mail;
import bemyguest.entities.Mail;
import bemyguest.entities.Propriete;
import bemyguest.entities.Reclamation;
import bemyguest.entities.ReclamationAN;
import bemyguest.entities.Resrevation;
import bemyguest.entities.User;
import java.net.URL;

import java.util.List;
import java.util.Optional;

import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.input.MouseEvent;



/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class TraiterReclamationController implements Initializable {

        private ObservableList<ReclamationAN> data;
    @FXML
    private TableView<ReclamationAN> tab_reclamation;
    @FXML
    private TableColumn<?, ?> col_id;
    @FXML
    private TableColumn<?, ?> col_date;
    @FXML
    private TableColumn<?, ?> Colone_Reclamant;
    @FXML
    private TableColumn<?, ?> Colone_Reclame;
    @FXML
    private TableColumn<?, ?> col_type;
    @FXML
    private TableColumn<?, ?> col_contenu;
    @FXML
    private TableColumn<?, ?> Column_PrenomReclamant;
    @FXML
    private Button button_supprimer;
    @FXML
    private Button Button_Traiter;
    @FXML
    private TextField RechercherAdmin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = FXCollections.observableArrayList();
        LoadData();
        setCellTable();
        // TODO
        RechercherAdmin.textProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                filterEvenementList((String) oldValue, (String) newValue);

            }
        });
        
    }

   
 

    private void setCellTable() {

        col_contenu.setCellValueFactory(new PropertyValueFactory<>("contenu"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        Colone_Reclamant.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Column_PrenomReclamant.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         Colone_Reclame.setCellValueFactory(new PropertyValueFactory<>("prenom2"));
     //  Column_PrenomReclamme.setCellValueFactory(new PropertyValueFactory<>("nom2"));
    }

    private void LoadData() {

        int idUserConnecte = 1;
        List<ReclamationAN> l;
        ReclamationCrud rdao = new ReclamationCrud();

        l = rdao.afficherReclamationAN();

        for (int i = 0; i < l.size(); i++) {

          // data.add(new ReclamationAN(l.get(i).getContenu(), l.get(i).getType(), l.get(i).getDate(), l.get(i).getUserReclame().getNom(), l.get(i).getUserReclamant().getNom()));
             data.add(new ReclamationAN(l.get(i).getId_rec(),l.get(i).getContenu(), l.get(i).getType(), l.get(i).getDate(), l.get(i).getUserReclame().getNom(), l.get(i).getUserReclame().getNom(), l.get(i).getUserReclame().getPrenom(),l.get(i).getUserReclamant().getPrenom(),l.get(i).getUserReclame().getEmail()));
            
    //  System.out.println(" reclame ==== " + l.get(i).getUserReclamant().getNom());
        }

        tab_reclamation.setItems(data);

    }

    @FXML
    private void SupprimerAction(ActionEvent event) {
       
Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Supprimer Reclamation");
                alert.setHeaderText("Voulez-vous vraiment supprimer cette reclamation ?");
                Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
        ReclamationAN rec = new  ReclamationAN();
        rec=tab_reclamation.getSelectionModel().getSelectedItem();
        int id =rec.getId_rec();
        System.out.println(id);
        ReclamationCrud recd=new ReclamationCrud();
        recd.DeleteReclamationById(id);
    data = FXCollections.observableArrayList();
        LoadData();
        setCellTable();
}
    }

    @FXML
    private void show(MouseEvent event) {
        ReclamationAN rec = new  ReclamationAN();
        rec=tab_reclamation.getSelectionModel().getSelectedItem();
        int id =rec.getId_rec();
        System.out.println(id);
    }

    @FXML
    private void TraiterAction(ActionEvent event) {
              
Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Traiter Reclamation");
                alert.setHeaderText("vous aller envoyer un mail  ?");
                Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
         ReclamationAN rec = new  ReclamationAN();
         rec=tab_reclamation.getSelectionModel().getSelectedItem();
         String email=tab_reclamation.getSelectionModel().getSelectedItem().getEmail();
        int id =rec.getId_rec();
       
            System.out.println(email);
            Mail mail = new Mail();
      mail.send("dorra.dalhoumi@esprit.tn");
}
    }

     
    public void filterEvenementList(String oldValue, String newValue) {
        ObservableList<ReclamationAN> filteredList = FXCollections.observableArrayList();
        if (RechercherAdmin == null || (newValue.length() < oldValue.length()) || newValue == null) {

            tab_reclamation.setItems(data);
            LoadData();
        } else {
            newValue = newValue.toUpperCase();
            for (ReclamationAN t : tab_reclamation.getItems()) {
                String filterType = t.getType();
                String filterContenu = t.getContenu();
                
                
                if (filterType.toUpperCase().contains(newValue) || filterContenu.toUpperCase().contains(newValue) ) {
                 
                    filteredList.add(t);
                }
            }
            tab_reclamation.setItems(filteredList);
        }
    }
}
