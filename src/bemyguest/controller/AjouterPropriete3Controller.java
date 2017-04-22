/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.controller;

import bemyguest.DAO.Classe.ImageProprieteCRUD;
import bemyguest.DAO.Classe.ProprieteCrud;
import bemyguest.DAO.Classe.UserDAO;
import bemyguest.entities.HistoriquePropriete;
import bemyguest.entities.ImageProp;
import bemyguest.entities.Propriete;
import bemyguest.entities.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import org.controlsfx.control.Notifications;
import static bemyguest.DAO.Classe.UserDAO.j;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author Daly
 */
public class AjouterPropriete3Controller implements Initializable {

    @FXML
    private ImageView imageview;
    @FXML
    private JFXRadioButton radio3;

    @FXML
    private JFXRadioButton radio4;

    @FXML
    private JFXRadioButton radio1;

    @FXML
    private JFXRadioButton radio2;
    @FXML
    private JFXRadioButton radio5;

    @FXML
    private JFXRadioButton radio6;

    @FXML
    private JFXRadioButton radio7;

    @FXML
    private JFXRadioButton radio8;

    @FXML
    private Label lblan;

    @FXML
    private Label lbldes;

    @FXML
    private Label lblfu;

    @FXML
    private Label lblenf;

    @FXML
    private Label lblalc;

    @FXML
    private ImageView imageview1;

    @FXML
    private JFXButton btn2;

    private Label lbl2;


    @FXML
    private ImageView imageview2;

    @FXML
    private JFXButton btn3;

    private Label lbl3;
    @FXML
    private JFXButton btn1;

    private Label lbl1;
   

    @FXML
    private JFXTextField urlText;
      @FXML
    private JFXTextField url1Text;

    @FXML
    private JFXTextField url2Text;
    
    @FXML
    private AnchorPane an3;
    @FXML
    private JFXButton retour;
    @FXML
    private JFXButton accueil;

    /**
     * Initializes the controller class.
     */
    Propriete prop = new Propriete();
    HistoriquePropriete hpop = new HistoriquePropriete();

    @FXML
    public void btnLoadEventListener(ActionEvent t) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);
        String url1 = file.toPath().toAbsolutePath().toString();
        System.out.println(url1);
        urlText.setText(url1);
       
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imageview.setImage(image);
           
            
            

        } catch (IOException ex) {
            Logger.getLogger(AjouterPropriete3Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void btnLoadEventListener1(ActionEvent t) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);
        String url2 = file.toPath().toAbsolutePath().toString();
        System.out.println(url2);
        url1Text.setText(url2);
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imageview1.setImage(image);
            
        } catch (IOException ex) {
            Logger.getLogger(AjouterPropriete3Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void btnLoadEventListener2(ActionEvent t) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);
        String url3 = file.toPath().toAbsolutePath().toString();
        System.out.println(url3);
        url2Text.setText(url3);
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imageview2.setImage(image);
            
         
        } catch (IOException ex) {
            Logger.getLogger(AjouterPropriete3Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void valider(ActionEvent event) throws IOException {

        int verif = 0;
        User user = new User();
        UserDAO ud = new UserDAO();
        user=ud.retrieveAdminById(j);

        prop.setTypePropriete(AjouterPropriete1Controller.type);
        hpop.setTypePropriete(AjouterPropriete1Controller.type);
        prop.setCategoriePropriete(AjouterPropriete1Controller.genre);
        hpop.setCategoriePropriete(AjouterPropriete1Controller.genre);

        prop.setDescription(AjouterPropriete2Controller.description1);
        hpop.setDescription(AjouterPropriete2Controller.description1);

        prop.setPays(AjouterPropriete2Controller.pays1);
        hpop.setPays(AjouterPropriete2Controller.pays1);

        prop.setRue(AjouterPropriete2Controller.rue1);
        hpop.setRue(AjouterPropriete2Controller.rue1);

        prop.setVille(AjouterPropriete2Controller.ville);
        hpop.setVille(AjouterPropriete2Controller.ville);

        prop.setPrix(AjouterPropriete1Controller.prix1);
        hpop.setPrix(AjouterPropriete1Controller.prix1);

        prop.setNbrVoyageur(AjouterPropriete1Controller.nbrVoyageur);
        hpop.setNbrVoyageur(AjouterPropriete1Controller.nbrVoyageur);

        prop.setNbrChambre(AjouterPropriete1Controller.nbrChambre);
        hpop.setNbrChambre(AjouterPropriete1Controller.nbrChambre);
        prop.setTitre(AjouterPropriete2Controller.titre1);
        hpop.setTitre(AjouterPropriete2Controller.titre1);
        if (radio1.isSelected()) {
            hpop.setAnimaux(Boolean.TRUE);

            prop.setAnimaux(Boolean.TRUE);
        } else {
            prop.setAnimaux(Boolean.FALSE);
            hpop.setAnimaux(Boolean.FALSE);

        }
        if (radio3.isSelected()) {
            prop.setFumeur(Boolean.TRUE);
            hpop.setFumeur(Boolean.TRUE);

        } else {
            prop.setFumeur(Boolean.FALSE);
            hpop.setFumeur(Boolean.FALSE);

        }
        if (radio5.isSelected()) {
            hpop.setEnfant(Boolean.TRUE);

            prop.setEnfant(Boolean.TRUE);
        } else {
            prop.setEnfant(Boolean.FALSE);
            hpop.setEnfant(Boolean.FALSE);

        }
        if (radio7.isSelected()) {
            prop.setAlcool(Boolean.TRUE);
            hpop.setAlcool(Boolean.TRUE);
        } else {
            prop.setAlcool(Boolean.FALSE);
            hpop.setAlcool(Boolean.FALSE);
        }
        prop.setUser(user);
        hpop.setUser(user);
        ProprieteCrud pc = new ProprieteCrud();
        
        ImageProp imageProp = new ImageProp();
        ImageProp imageProp1 = new ImageProp();
        ImageProp imageProp2 = new ImageProp();
        imageProp.setUrl(urlText.getText());
        imageProp.setPropriete(prop);
        imageProp1.setUrl(url1Text.getText());
        imageProp1.setPropriete(prop);
        imageProp2.setUrl(url2Text.getText());
        imageProp2.setPropriete(prop);
        System.out.println(prop.getId());
        ImageProprieteCRUD imgC=new ImageProprieteCRUD();
       
            pc.addPropriete(prop, hpop);
                    imgC.addImage(imageProp);
                    imgC.addImage(imageProp1);
                    imgC.addImage(imageProp2);

            Parent form2 = FXMLLoader.load(getClass().getResource("/bemyguest/GUI/FXML/FXMLAfficher.fxml"));
            Scene home_page_scene = new Scene(form2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(home_page_scene);
            app_stage.show();
            
        
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ajout avec succés");
                alert.setHeaderText("La propriétée a été ajoutée avec succés");
                Optional<javafx.scene.control.ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    
                   

                }
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Parent form = FXMLLoader.load(getClass().getResource("/bemyguest/gui/AjouterPropriete2.fxml"));
        Scene home_page_scene = new Scene(form);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup groupAn = new ToggleGroup();
        ToggleGroup groupAl = new ToggleGroup();
        ToggleGroup groupFu = new ToggleGroup();
        ToggleGroup groupEn = new ToggleGroup();
        radio1.setToggleGroup(groupAn);
        radio1.setSelected(true);
        radio2.setToggleGroup(groupAn);
        radio3.setToggleGroup(groupFu);
        radio3.setSelected(true);

        radio4.setToggleGroup(groupFu);
        radio5.setToggleGroup(groupEn);
        radio5.setSelected(true);

        radio6.setToggleGroup(groupEn);
        radio7.setToggleGroup(groupAl);
        radio7.setSelected(true);

        radio8.setToggleGroup(groupAl);
        // TODO
    }

    
    @FXML
    private void handleDragOver(DragEvent event) {
        if (event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.ANY);

        }
    }

    @FXML
    private void handleDropOver(DragEvent event) throws FileNotFoundException {
        List<File> files = event.getDragboard().getFiles();
        Image img = new Image(new FileInputStream(files.get(0)));
        imageview.setImage(img);

        btn1.setVisible(false);
        lbl1.setVisible(false);

    }

    @FXML
    private void handleDragOver1(DragEvent event) {
        if (event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.ANY);

        }
    }

    @FXML
    private void handleDropOver1(DragEvent event) throws FileNotFoundException {
        List<File> files = event.getDragboard().getFiles();
        Image img = new Image(new FileInputStream(files.get(0)));
        imageview1.setImage(img);
        btn2.setVisible(false);
        lbl2.setVisible(false);

    }

    @FXML
    private void handleDragOver2(DragEvent event) {
        if (event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.ANY);

        }
    }

    private void handleDropOver2(DragEvent event) throws FileNotFoundException {
        List<File> files = event.getDragboard().getFiles();
        Image img = new Image(new FileInputStream(files.get(0)));
        imageview2.setImage(img);
        btn3.setVisible(false);
        lbl3.setVisible(false);

    }

    @FXML
    private void accueil(ActionEvent event) throws IOException {
         an3.getChildren().setAll( (AnchorPane) FXMLLoader.load(getClass().getResource("/bemyguest/gui/AcceuilFXML.fxml")));
    }
}
