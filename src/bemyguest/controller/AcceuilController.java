/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.controller;

import bemyguest.DAO.Classe.ProprieteCrud;
import bemyguest.entities.Propriete;
import bemyguest.DAO.Classe.ResevationDAO;
import static bemyguest.DAO.Classe.UserDAO.j;
import com.jfoenix.controls.JFXTextField;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */

public class AcceuilController implements Initializable {
    
    @FXML
    private Button deconnexion;
    
    @FXML
    private AnchorPane afficher;

    @FXML
    private JFXTextField place;

    @FXML
    private DatePicker depart;

    @FXML
    private DatePicker arrivee;

    @FXML
    private Button btn_rechercher;
    
    @FXML
    private Button btn_reserver;
    
    @FXML
    private Button menuMessage;

    @FXML
    private ComboBox nbVoyageur;

    @FXML
    private TableView<Propriete> tableRech;

    @FXML
    private TableColumn<?, ?> clm_id;

    @FXML
    private TableColumn<?, ?> clm_categorie;

    @FXML
    private TableColumn<?, ?> clm_type;

    @FXML
    private TableColumn<?, ?> clm_ville;

    @FXML
    private TableColumn<?, ?> clm_prix;

    private ObservableList<Propriete> data;
    
        @FXML
    private AnchorPane acc;
        @FXML
    private Button gestionProp;
    

    boolean req = false;
    java.sql.Date d1 = null;
    java.sql.Date d2 = null;
    static int i=0 ;

    public void combo() {
        //nbVoyageur.getItems().add(1);
        //nbVoyageur.getItems().add(2);
        nbVoyageur.getItems().addAll(1, 2, 3, 4, 5);
    }
    
    @FXML
    private void ShowMsg() throws IOException  {
       
                afficher.getChildren().setAll( (AnchorPane) FXMLLoader.load(getClass().getResource("/bemyguest/gui/MessagerieFXML.fxml")));
    }
    
       @FXML
    private void ShowAcc() throws IOException  {
       
                acc.getChildren().setAll( (AnchorPane) FXMLLoader.load(getClass().getResource("/bemyguest/gui/AcceuilFXML.fxml")));
    }
       @FXML
    private void GestionProp() throws IOException  {
       
                afficher.getChildren().setAll( (AnchorPane) FXMLLoader.load(getClass().getResource("/bemyguest/gui/AfficherPropriete.fxml")));
    }
    
     @FXML
    private void traiterReservation() throws IOException  {
       
                afficher.getChildren().setAll( (AnchorPane) FXMLLoader.load(getClass().getResource("/bemyguest/gui/ValiderFXML.fxml")));
    }
    @FXML
    private void listReservation() throws IOException  {
       
                afficher.getChildren().setAll( (AnchorPane) FXMLLoader.load(getClass().getResource("/bemyguest/gui/ConsulterReFXML.fxml")));
    }
   
    
    
    @FXML
    private void GoHome(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("/bemyguest/gui/Login.fxml"));
        Scene scene = new Scene(login);
         scene.getStylesheets().add("/bemyguset/resource/style.css");

        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg.setScene(scene);
        stg.setResizable(false);
        stg.show();
        
    }

    public boolean checkDate() {

        ResevationDAO rdao = new ResevationDAO();
        ProprieteCrud pdao = new ProprieteCrud();
        List<Propriete> l = new ArrayList();
        List<Propriete> l2 = new ArrayList();

        if (depart.getValue() != null) {
            d1 = java.sql.Date.valueOf(depart.getValue());
        }
        if (arrivee.getValue() != null) {
            d2 = java.sql.Date.valueOf(arrivee.getValue());
        }

        if (d1 == null || d2 == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Vous n'avez pas saisie de date");
            alert.showAndWait();
            return false;
        }

        if (d1.after(d2)) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Vous avez entrer une date de départ supérieur à la date d'arrivée");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    public List<Propriete> checkVoy() {
        List<Propriete> l = new ArrayList();
        List<Propriete> l2 = new ArrayList();
        ResevationDAO rdao = new ResevationDAO();
        ProprieteCrud pdao = new ProprieteCrud();

        if (nbVoyageur.getValue() != null) {
            l = rdao.comparer(d1, d2);
          
            int nb = parseInt(nbVoyageur.getValue().toString());
            for (int i = 0; i < l.size(); i++) {
                if (l.get(i).getNbrVoyageur() >= nb) {
                    l2.add(l.get(i));
                }
            }
            return l2;
        } else {
            l = rdao.comparer(d1, d2);
            return l;
        }

    }

    public List<Propriete> checkPlace() {
        checkVoy();
        ResevationDAO rdao = new ResevationDAO();
        ProprieteCrud pdao = new ProprieteCrud();
        List<Propriete> l3 = checkVoy();
        List<Propriete> l4 = new ArrayList();

        if (place.getText().equals("")) {
            return l3;
        } else {
            for (int i = 0; i < l3.size(); i++) {
                if (l3.get(i).getVille().contains(place.getText())) {
                    l4.add(l3.get(i));
                }
            }
            return l4;
        }
    }

    public List<Propriete> rechercher() {
      
           data = FXCollections.observableArrayList();
   
         List<Propriete> l = new ArrayList() ;
         List<Propriete> l2 = new ArrayList() ;
        
        if (checkDate()) {
            l2 = checkPlace();
            tableRech.setVisible(true);
        
        }
        
      for(int i=0;i<l2.size();i++){
        for(int j=i+1;j<l2.size();j++){
            if((l2.get(i)).getId()==((l2.get(j)).getId())){
                l2.remove(j);
                j--;
            }
        }
    }  
        
        for (int i = 0; i < l2.size(); i++) {
            data.add(new Propriete(l2.get(i).getId(), l2.get(i).getCategoriePropriete(), l2.get(i).getTypePropriete(), l2.get(i).getVille(), l2.get(i).getPrix()));
        }
         tableRech.setItems(data);
        
        return l2;
        
    }

    private void setCellTable() {
        clm_id.setCellValueFactory(new PropertyValueFactory<>("id_p"));
        clm_categorie.setCellValueFactory(new PropertyValueFactory<>("categoriePropriete"));
        clm_type.setCellValueFactory(new PropertyValueFactory<>("typePropriete"));
        clm_ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
        clm_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
    }
    
    public int getId(){
        tableRech.setOnMouseClicked((MouseEvent e) -> {
         i = tableRech.getSelectionModel().getSelectedItem().getId();
         btn_reserver.setVisible(true);
        });
        
        return i;
    }

    @FXML
    public  void callURL() {
        btn_reserver.setOnMouseClicked((MouseEvent me) -> {
        
        String myURL="https://rest.nexmo.com/sms/json?api_key=a52c723f&api_secret=97adf42b867159cb&to=216"+
                "52326060"+"&from=BeMyGuest&text=Vous+avez+recu+une+demande+de+reservation+Code+du+message+:+"+1523;
        System.out.println(myURL);
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;
        try {
            URL url = new URL(myURL);
            urlConn = url.openConnection();
            if (urlConn != null)
                urlConn.setReadTimeout(60 * 1000);
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(),
                        Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(in);
                if (bufferedReader != null) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                }
            }
            in.close();
        } catch (Exception e) {
            throw new RuntimeException("Exception while calling URL:"+ myURL, e);
        }
        });
        
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        combo();
        setCellTable();
         getId();
    }

}
