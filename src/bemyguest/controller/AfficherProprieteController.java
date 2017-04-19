/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.controller;
;
import bemyguest.DAO.Classe.ProprieteCrud;
import bemyguest.entities.Propriete;
import bemyguest.entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import static bemyguest.DAO.Classe.UserDAO.j;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Daly
 */
public class AfficherProprieteController implements Initializable {
    @FXML
    private AnchorPane afficher;
    @FXML
    private ImageView imageView;
    @FXML
    private ImageView imageView1;

    @FXML
    private ImageView imageView2;

    @FXML
    private TableView<Propriete> proprieteList;

    @FXML
    private TableColumn<?, ?> categorie;

    @FXML
    private TableColumn<?, ?> type;

    @FXML
    private TableColumn<?, ?> ville;

    @FXML
    private TableColumn<?, ?> rue;

    @FXML
    private TableColumn<?, ?> prix;

    @FXML
    private TableColumn<?, ?> nbrVoyageur;

    @FXML
    private TableColumn<?, ?> nbrChambre;

    @FXML
    private TableColumn<?, ?> description;

    @FXML
    private TableColumn<Boolean, Boolean> animaux;

    @FXML
    private TableColumn<Boolean, Boolean> fumeur;

    @FXML
    private TableColumn<Boolean, Boolean> alcool;

    @FXML
    private TableColumn<Boolean, Boolean> enfant;

    @FXML
    private TableColumn<?, ?> titre;

    private ObservableList<Propriete> data;

    @FXML
    private Label lblRue;

    @FXML
    private Label lblPrix;

    @FXML
    private Label lblTitre;

    @FXML
    private Label lblDescription;
    int prix2;
static int i;
static Propriete prop;
    @FXML
    private AnchorPane anchor1;
    public void loadData() {
        User user = new User(1, "daly", "prenom", "aaaa", "bbbb", "ccccc");
        List<Propriete> list;
        ProprieteCrud pc = new ProprieteCrud();
        list = pc.getAllUserProprietes(j);
        for (int i = 0; i < list.size(); i++) {
            data.add(new Propriete(list.get(i).getId(), list.get(i).getCategoriePropriete(), list.get(i).getTypePropriete(), list.get(i).getVille(), list.get(i).getRue(), list.get(i).getPrix(), list.get(i).getNbrVoyageur(), list.get(i).getNbrChambre(), list.get(i).getDescription(), list.get(i).getAnimaux(), list.get(i).getFumeur(), list.get(i).getEnfant(), list.get(i).getAlcool(), list.get(i).getTitre()));
        }
        proprieteList.setItems(data);

    }

    private void setCellTable() {
        categorie.setCellValueFactory(new PropertyValueFactory<>("categoriePropriete"));
        type.setCellValueFactory(new PropertyValueFactory<>("typePropriete"));
        ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
        rue.setCellValueFactory(new PropertyValueFactory<>("rue"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        nbrVoyageur.setCellValueFactory(new PropertyValueFactory<>("nbrVoyageur"));
        nbrChambre.setCellValueFactory(new PropertyValueFactory<>("nbrChambre"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        animaux.setCellValueFactory(new PropertyValueFactory<>("animaux"));

        fumeur.setCellValueFactory(new PropertyValueFactory<>("fumeur"));

        alcool.setCellValueFactory(new PropertyValueFactory<>("alcool"));

        enfant.setCellValueFactory(new PropertyValueFactory<>("enfant"));

        titre.setCellValueFactory(new PropertyValueFactory<>("titre"));

    }

    /* public void afficher(ActionEvent event) {
        data = FXCollections.observableArrayList();
        loadData();
        setCellTable();
    }
     */
    @FXML
    private void ShowOnClick() {
 
         prop = proprieteList.getSelectionModel().getSelectedItem();
       

        

    }
    
    @FXML
    public void Supprimer(ActionEvent event) {
       Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Suppression");
                alert.setHeaderText("Voulez-vous supprimer cette personne de votre liste ?");
                Optional<javafx.scene.control.ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    ProprieteCrud propC = new ProprieteCrud();
            int i = proprieteList.getSelectionModel().getSelectedItem().getId();
            System.out.println(i);
            propC.deletePropriete(i);
            Propriete prop = (Propriete) proprieteList.getSelectionModel().getSelectedItem();
            String id = String.valueOf(prop.getId());
            System.out.println(id);

            proprieteList.getItems().clear();
            loadData();
            setCellTable();
             Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Suppression réussi");
                alert1.setHeaderText("La propriétée a été supprimée avec succés");
                Optional<javafx.scene.control.ButtonType> result1 = alert1.showAndWait();
                }
            

        }

    

    @FXML
    public void Update(ActionEvent event) throws IOException {
          Parent form2 = FXMLLoader.load(getClass().getResource("/bemyguest/gui/ModifierPropriete.fxml"));
        Scene home_page_scene = new Scene(form2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }
    
       @FXML
    public void Ajouter(ActionEvent event) throws IOException {

        
          Parent form2 = FXMLLoader.load(getClass().getResource("/bemyguest/gui/AjouterPropriete1.fxml"));
        Scene home_page_scene = new Scene(form2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = FXCollections.observableArrayList();
        loadData();
        setCellTable();

        
    }


  
}
