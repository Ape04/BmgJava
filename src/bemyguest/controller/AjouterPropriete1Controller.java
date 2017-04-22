/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.controller;

import static bemyguest.controller.AjouterPropriete1Controller.prix1;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Daly
 */
public class AjouterPropriete1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXComboBox<String> combo;
    static String genre;
    @FXML
    private JFXComboBox<String> combo1;
    static String type;

    @FXML
    private JFXButton btn;

    @FXML
    private JFXComboBox<String> comboNbrChambre;
    static int nbrChambre;
    String chaine;
    @FXML
    private JFXTextField prix;
    static int prix1;

    @FXML
    private Label lblPrix;
    @FXML
    private Spinner<String> spinner = new Spinner<String>();
    @FXML
    private JFXButton accueil;

    static int nbrVoyageur;
    String str;
    @FXML
    private Label lblPrix2;
    @FXML
    private AnchorPane an1;

    @FXML
    void suivant(ActionEvent event) throws IOException {
        int verif = 0;
         if (prix.getText().isEmpty()) {
            lblPrix.setVisible(true);
            verif++;
        } else {
            lblPrix.setVisible(false);
        }try {
            prix1 = Integer.parseInt(prix.getText());
        } catch (Exception e) {
            verif++;
            lblPrix2.setVisible(true);
        }
         if (verif == 0) {
        Parent form2 = FXMLLoader.load(getClass().getResource("/bemyguest/gui/AjouterPropriete2.fxml"));
        Scene home_page_scene = new Scene(form2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        /*Recuperation du genre de la pro*/
        genre = combo.getValue();
        /*Recuperation du type de la propriete*/
        type = combo1.getValue();
        /*Affichae*/
        System.out.println(genre);
        System.out.println(type);
        /*Recuperation du nombre de chambre*/
        chaine = comboNbrChambre.getValue().substring(0, 1);
        nbrChambre = Integer.parseInt(chaine);
        System.out.println(nbrChambre);
        /*Recuperation du nombre de voyageur*/
        str = spinner.getValue().substring(0, 1);
        nbrVoyageur = Integer.parseInt(str);
        System.out.println(nbrVoyageur);
        /**/
        
        
        

    }}
    
//    @FXML
//    void getSelected(ActionEvent event) throws IOException{
//               String output = combo.getSelectionModel().getSelectedItem();
//                      String output1 = combo1.getSelectionModel().getSelectedItem();
//                      System.out.println(output);
//        System.out.println(output1);
//
//
//    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<String> voyageur = FXCollections.observableArrayList(//
                "1 Voyageur", "2 Voyageurs", "3 Voyageurs", "4 Voyageurs", //
                "5 Voyageurs");
        SpinnerValueFactory<String> valueFactory
                = //
                new SpinnerValueFactory.ListSpinnerValueFactory<String>(voyageur);
        valueFactory.setValue("1 Voyageur");
        spinner.setValueFactory(valueFactory);

        // TODOc
        combo.getItems().add("Maison");
        combo.setValue("Maison");
        combo.getItems().add("Appartement");
        combo.getItems().add("Bungalow");
        combo.getItems().add("Cabane");
        combo.getItems().add("Chateux");
        combo.getItems().add("Chalet");
        combo.getItems().add("Caravane");

        combo1.getItems().add("Chambre(s) Privée(s)");
        combo1.setValue("Chambre(s) entier(s)");
        combo1.getItems().add("Chambre(s) entier(s)");
        combo1.getItems().add("Chambre(s) partagée(s)");

        comboNbrChambre.getItems().add("1 Chambre");
        comboNbrChambre.setValue("1 Chambre");
        comboNbrChambre.getItems().add("2 Chambres");
        comboNbrChambre.getItems().add("3 Chambres");
        comboNbrChambre.getItems().add("4 Chambres");
        comboNbrChambre.getItems().add("5 Chambres");

    }

    @FXML
    private void accueil(ActionEvent event) throws IOException {
         an1.getChildren().setAll( (AnchorPane) FXMLLoader.load(getClass().getResource("/bemyguest/gui/AcceuilFXML.fxml")));
    }
    

}
