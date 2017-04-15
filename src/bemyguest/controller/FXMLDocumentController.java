

package bemyguest.controller;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Haroun
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private VBox vbox_id;
    @FXML
    private VBox logo_id;
    @FXML
    private JFXButton btn_admin;
    @FXML
    private JFXButton btn_usr;
    @FXML
    private JFXButton btn_rec;
    @FXML
    private JFXButton btn_stat;
    @FXML
    private JFXButton home_btn;
   
    
    
    
    @FXML
     void GestionAdminEvent(ActionEvent event) throws IOException {
       // VBox vbox =FXMLLoader.load(getClass().getResource("AjouterPage.fxml"));
         AnchorPane ap =FXMLLoader.load(getClass().getResource("/bemyguest/gui/GestionAdmin.fxml"));
        vbox_id.getChildren().setAll(ap);
        vbox_id.autosize();
        vbox_id.fillWidthProperty();
    }
    
    @FXML
     void GestionUserEvent(ActionEvent event) throws IOException 
    {
        AnchorPane ap2 =FXMLLoader.load(getClass().getResource("/bemyguest/gui/GestionUtilisateur.fxml"));
        vbox_id.getChildren().setAll(ap2);
        vbox_id.autosize();
        vbox_id.fillWidthProperty();
    }
     
      @FXML
    private void ShowStat(ActionEvent event) throws IOException {
         AnchorPane ap3 =FXMLLoader.load(getClass().getResource("/bemyguest/gui/statistique.fxml"));
        vbox_id.getChildren().setAll(ap3);
        vbox_id.autosize();
        vbox_id.fillWidthProperty();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            AnchorPane ap2 =FXMLLoader.load(getClass().getResource("/bemyguest/gui/GestionAdmin.fxml"));
        vbox_id.getChildren().setAll(ap2);
        vbox_id.autosize();
        vbox_id.fillWidthProperty();
        } catch (Exception e) {
            System.out.println(""+e);
        }
         
        
        
        
    }    


    @FXML
    private void SupprimerEvent(ActionEvent event) {
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

   

    
    }
