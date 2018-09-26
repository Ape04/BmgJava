/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Daly
 *
 *
 */
public class FXMLForm2Controller implements Initializable {

    @FXML
    private Label lblPays;

    @FXML
    private Label lblVille;

    @FXML
    private Label lblRue;

    @FXML
    private JFXTextField pays;
    static String pays1;
    @FXML
    private JFXTextArea description;
    static String description1;

    @FXML
    private Label lblDescription;

    @FXML
    private JFXTextField rue;
    static String rue1;
    @FXML
    private JFXComboBox<String> comboGouv;
    static String ville;
    @FXML
    private JFXTextField titre;
    static String titre1;
    private WebEngine engine;

    @FXML
    private Label lblTitre;
    @FXML
    private JFXButton btn;
    @FXML
    private WebView mapview;
    @FXML
    private JFXComboBox<String> comboVille;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void suivant(ActionEvent event) throws IOException {
        int verif = 0;

//        if (rue.getText().isEmpty()) {
//            lblRue.setVisible(true);
//            verif++;
//        } else {
//            lblRue.setVisible(false);
//
//        }
        if (description.getText().isEmpty()) {
            lblDescription.setVisible(true);
            verif++;
        } else {
            lblDescription.setVisible(false);

        }
        if (titre.getText().isEmpty()) {
            lblTitre.setVisible(true);
            verif++;
        } else {
            lblTitre.setVisible(false);

        }
        if (verif == 0) {
            Parent form2 = FXMLLoader.load(getClass().getResource("/bemyguest/GUI/FXML/FXMLForm3.fxml"));
            Scene home_page_scene = new Scene(form2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(home_page_scene);
            app_stage.show();

            pays1 = pays.getText();
            System.out.println(pays1);
            ville = comboGouv.getValue();
            rue1 = comboVille.getValue();
            System.out.println(rue1);
            description1 = description.getText();
            titre1 = titre.getText();

        }
    }

//        }
    @FXML
    private void retour(ActionEvent event) throws IOException {
        Parent form = FXMLLoader.load(getClass().getResource("/bemyguest/GUI/FXML/FXMLForm.fxml"));
        Scene home_page_scene = new Scene(form);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        comboGouv.getItems().addAll("Ariana");
        comboGouv.getItems().addAll("Beja");
        comboGouv.getItems().addAll("Ben Arous");
        comboGouv.getItems().addAll("Bizerte");
        comboGouv.getItems().addAll("Gabes");
        comboGouv.getItems().addAll("Gafsa");
        comboGouv.getItems().addAll("Jendouba");
        comboGouv.getItems().addAll("Kairouan");
        comboGouv.getItems().addAll("Kasserine");
        comboGouv.getItems().addAll("Kebili");
        comboGouv.getItems().addAll("Le Kef");
        comboGouv.getItems().addAll("Mahdia");
        comboGouv.getItems().addAll("La Manouba");
        comboGouv.getItems().addAll("Medenine");
        comboGouv.getItems().addAll("Monastir");
        comboGouv.getItems().addAll("Nabeul");
        comboGouv.getItems().addAll("Sfax");
        comboGouv.getItems().addAll("Sidi Bouzid");
        comboGouv.getItems().addAll("Siliana");
        comboGouv.getItems().addAll("Sousse");
        comboGouv.getItems().addAll("Tataouine");
        comboGouv.getItems().addAll("Tozeur");
        comboGouv.getItems().addAll("Tunis");
        comboGouv.setValue("Tunis");

    }

    @FXML
    private void afficheMap(ActionEvent event) {
        String b = comboVille.getValue();
        //String c = rue.getText();
        engine = mapview.getEngine();
        engine.load("https://www.google.fr/maps/search/" + b);
    }

    @FXML
    private void change(ActionEvent event) {
        switch (comboGouv.getValue()) {
            case "Tunis":
                comboVille.getItems().clear();
                comboVille.getItems().addAll("La Goulette", "El Menzah", "Carthage","Le Bardo");
                break;
            case "Tozeur":
                comboVille.getItems().clear();
                comboVille.getItems().addAll("Nefta", "Tameghza", "Degache");
                break;
            case "Tataouine":
                comboVille.getItems().clear();
                comboVille.getItems().addAll("Dehiba", "Remada");
                break;
            case "Sousse":
                comboVille.getItems().clear();
                comboVille.getItems().addAll("Hergla", "Sousse Jawhara");
                  break;
            case "Siliana":
                comboVille.getItems().clear();
                comboVille.getItems().addAll("Gaâfour", "Rouhia", "Makthar");
                  break;
            case "Sidi Bouzid":
                comboVille.getItems().clear();
                comboVille.getItems().addAll("Regueb");
                  break;
            case "Sfax":
                comboVille.getItems().clear();
                comboVille.getItems().addAll("Kerkennah","Mahrès");
                  break;
            case "Nabeul":
                comboVille.getItems().clear();
                comboVille.getItems().addAll("Hammamet","Kélibia","Korba","El Haouaria");
                  break;
            case "Monastir":
                comboVille.getItems().clear();
                comboVille.getItems().addAll("Monastir","Jemmal","Téboulba");
                  break;
             case "Medenine":
                comboVille.getItems().clear();
                comboVille.getItems().addAll("Ben Gardane","Djerba","Zarzis");
                  break;
            case "La Manouba":
                comboVille.getItems().clear();
                comboVille.getItems().addAll("Douar Hicher");
                  break;
             case "Mahdia":
                comboVille.getItems().clear();
                comboVille.getItems().addAll("Mahdia","Chebba");
                  break;
            case "Le Kef":
                comboVille.getItems().clear();
                comboVille.getItems().addAll("Sers","Tajerouine");
                  break;
            case "Kebili":
                comboVille.getItems().clear();
                comboVille.getItems().addAll("Douz","Kébili");
                  break;
            case "Kasserine":
                comboVille.getItems().clear();
                comboVille.getItems().addAll("Ezzouhour","Sbeïtla");
                  break;
            case "Kairouan":
                comboVille.getItems().clear();
                comboVille.getItems().addAll("Bou Hajla","Kairouan");
                  break;
              case "Jendouba":
                comboVille.getItems().clear();
                comboVille.getItems().addAll("Bou Salem","Jendouba","Tabarka");
                  break;
                case "Gafsa":
                comboVille.getItems().clear();
                comboVille.getItems().addAll("Métlaoui","Gafsa","El Ksar");
                  break;
                   case "Gabes":
                comboVille.getItems().clear();
                comboVille.getItems().addAll("Métlaoui","Gafsa","El Ksar");
                  break;
                   case "Bizerte":
                comboVille.getItems().clear();
                comboVille.getItems().addAll("Bizerte","Menzel Bourguiba","Ghar El Melh","Zarzouna");
                  break;
                   case "Ben Arous":
                comboVille.getItems().clear();
                comboVille.getItems().addAll("Hammam Lif","Mégrine","Radès");
                  break;
                    case "Beja":
                comboVille.getItems().clear();
                comboVille.getItems().addAll("Béja","Nefza");
                  break;
                   case "Ariana":
                comboVille.getItems().clear();
                comboVille.getItems().addAll("La Soukra","Raoued","Ettadhamen");
                  break;
                 default:
                comboVille.getItems().addAll("Tunis");
                break;
        }
    }

    @FXML
    private void accueil(ActionEvent event) throws IOException {
         Parent form2 = FXMLLoader.load(getClass().getResource("/bemyguest/GUI/FXML/FXMLAccueil.fxml"));
        Scene home_page_scene = new Scene(form2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

}
