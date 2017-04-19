/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.controller;

import bemyguest.DAO.Classe.ImageProprieteCRUD;
import bemyguest.DAO.Classe.ProprieteCrud;
import bemyguest.DAO.Classe.UserDAO;
import static bemyguest.DAO.Classe.UserDAO.j;
import static bemyguest.controller.AfficherProprieteController.prop;
import bemyguest.entities.ImageProp;
import bemyguest.entities.Propriete;
import bemyguest.entities.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JTextField;

/**
 * FXML Controller class
 *
 * @author Daly
 */
public class ModifierProprieteController implements Initializable {
  @FXML
    private JFXComboBox<String> comboVille;
    @FXML
    private ImageView imageview;

    @FXML
    private ImageView imageview1;

    @FXML
    private JFXButton btn2;

    @FXML
    private ImageView imageview2;

    @FXML
    private JFXButton btn3;

    @FXML
    private JFXTextField urlText;

    @FXML
    private JFXTextField urlText1;

    @FXML
    private JFXTextField urlText2;

    @FXML
    private JFXButton btn1;

    @FXML
    private JFXComboBox<String> categorie1;

    @FXML
    private JFXComboBox<String> type1;

    @FXML
    private JFXTextField rue1;

    @FXML
    private JFXComboBox<String> gouve;

    @FXML
    private JFXTextField prix1;

    @FXML
    private Spinner<String> nbrVoyageur1;

    @FXML
    private JFXComboBox<String> nbrChambre1;

    @FXML
    private JFXTextField titre1;

    @FXML
    private JFXRadioButton animauxYes;

    @FXML
    private JFXRadioButton animauxNo;

    @FXML
    private JFXRadioButton alcoolYes;

    @FXML
    private JFXRadioButton alcoolNo;

    @FXML
    private JFXRadioButton enfantYes;

    @FXML
    private JFXRadioButton enfantNo;

    @FXML
    private JFXRadioButton fumeurYes;

    @FXML
    private JFXRadioButton fumeurNo;

    @FXML
    private JFXTextArea description1;
    @FXML
    private Label lblRue;

    @FXML
    private Label lblPrix;

    @FXML
    private Label lblTitre;

    @FXML
    private Label lblDescription;
    int prix2;

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
            Logger.getLogger(ModifierProprieteController.class.getName()).log(Level.SEVERE, null, ex);
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
        urlText1.setText(url2);
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imageview1.setImage(image);

        } catch (IOException ex) {
            Logger.getLogger(ModifierProprieteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void Update(ActionEvent event) throws IOException {

        ProprieteCrud pc = new ProprieteCrud();
        int id = AfficherProprieteController.prop.getId();
        System.out.println(id);
        Propriete p = new Propriete();
        p = pc.getProprieteById(id);

        int verif = 0;
        if (rue1.getText().isEmpty()) {
            lblRue.setVisible(true);
            verif++;
        } else {
            lblRue.setVisible(false);
        }
        if (description1.getText().isEmpty()) {
            lblDescription.setVisible(true);
            verif++;
        } else {
            lblDescription.setVisible(false);

        }
        if (titre1.getText().isEmpty()) {
            lblTitre.setVisible(true);
            verif++;
        } else {
            lblTitre.setVisible(false);

        }
        if (prix1.getText().isEmpty()) {
            lblPrix.setVisible(true);
            verif++;
        } else {
            lblPrix.setVisible(false);

        }
        try {
            prix2 = Integer.parseInt(prix1.getText());
        } catch (Exception e) {
            verif++;
            lblPrix.setVisible(true);
        }
        if (verif == 0) {
            p.setCategoriePropriete(type1.getValue());
            p.setTypePropriete(categorie1.getValue());
            p.setDescription(description1.getText());

            p.setVille(gouve.getValue());
            p.setRue(rue1.getText());
            p.setPrix(prix2);
            String nbVoya;
            nbVoya = nbrVoyageur1.getValue().substring(0, 1);
            p.setNbrVoyageur(Integer.parseInt(nbVoya));
            String nbCham = nbrChambre1.getValue().substring(0, 1);
            p.setNbrChambre(Integer.parseInt(nbCham));
            p.setTitre(titre1.getText());
            if (animauxYes.isSelected()) {
                p.setAnimaux(Boolean.TRUE);
            } else {
                p.setAnimaux(Boolean.FALSE);
            }
            if (fumeurYes.isSelected()) {
                p.setFumeur(Boolean.TRUE);
            } else {
                p.setFumeur(Boolean.FALSE);
            }
            if (enfantYes.isSelected()) {
                p.setEnfant(Boolean.TRUE);
            } else {
                p.setEnfant(Boolean.FALSE);
            }
            if (alcoolYes.isSelected()) {
                p.setAlcool(Boolean.TRUE);
            } else {
                p.setAlcool(Boolean.FALSE);
            }
 User user = new User();
        UserDAO ud = new UserDAO();
        user=ud.retrieveAdminById(j);
            p.setUser(user);
            ImageProp ip;
            ImageProp ip1;
            ImageProp ip2;
            List<ImageProp> iprop;
            ImageProprieteCRUD ipc = new ImageProprieteCRUD();
            iprop = ipc.getImagesByProp(p.getId());
            
            String a=urlText.getText();
            String b=urlText1.getText();
            String c=urlText2.getText();
            

            int id1 = iprop.get(0).getId();
            int id2 = iprop.get(1).getId();

            int id3 = iprop.get(2).getId();

            ip = ipc.getImageById(id1);
            ip1 = ipc.getImageById(id2);
            ip2 = ipc.getImageById(id3);
            ip.setUrl(a);
            System.out.println(a);
            ip1.setUrl(b);
            System.out.println(b);
            ip2.setUrl(c);
            System.out.println(c);

            ip.setPropriete(prop);
            ip1.setPropriete(prop);
            ip2.setPropriete(prop);

            ipc.updateImage(ip);
            ipc.updateImage(ip1);
            ipc.updateImage(ip2);

            pc.updatePropriete(p);
            Parent form2 = FXMLLoader.load(getClass().getResource("/bemyguest/GUI/FXML/FXMLAfficher.fxml"));
            Scene home_page_scene = new Scene(form2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(home_page_scene);
            app_stage.show();

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
        urlText2.setText(url3);
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imageview2.setImage(image);

        } catch (IOException ex) {
            Logger.getLogger(ModifierProprieteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        System.out.println("aaaaaaaaa");

        ImageProprieteCRUD ipc = new ImageProprieteCRUD();
        ImageProp ip = new ImageProp();
        ProprieteCrud pc = new ProprieteCrud();

        // ip = ipc.getImageByProp(prop.getId());
        // ip=ipc.getImageById(10);
        
        List<ImageProp> iProps = new ArrayList<>();     
        iProps = ipc.getImagesByProp(AfficherProprieteController.prop.getId());
        String url1 = iProps.get(0).getUrl();
        String url2 = iProps.get(1).getUrl();
        String url3 = iProps.get(2).getUrl();
          
        urlText.setText(url1);
        urlText1.setText(url2);
        urlText2.setText(url3);
        System.out.println(url1);
        System.out.println(url2);
        System.out.println(url3);
        File file = new File(url1);
        Image image = new Image(file.toURI().toString());
        imageview.setImage(image);

        File file1 = new File(url2);
        Image image1 = new Image(file1.toURI().toString());
        imageview1.setImage(image1);

        File file2 = new File(url3);
        Image image2 = new Image(file2.toURI().toString());
        imageview2.setImage(image2);
        categorie1.getItems().add("Maison");
        categorie1.getItems().add("Appartement");
        categorie1.getItems().add("Bungalow");
        categorie1.getItems().add("Cabane");
        categorie1.getItems().add("Chateux");
        categorie1.getItems().add("Chalet");
        categorie1.getItems().add("Caravane");

        
        type1.getItems().add("Chambre(s) Privée(s)");
        type1.setValue("Chambre(s) entier(s)");
        type1.getItems().add("Chambre(s) entier(s)");
        type1.getItems().add("Chambre(s) partagée(s)");
        

        ObservableList<String> voyageur = FXCollections.observableArrayList(//
                "1 Voyageur", "2 Voyageurs", "3 Voyageurs", "4 Voyageurs", //
                "5 Voyageurs");
        SpinnerValueFactory<String> valueFactory
                = //
                new SpinnerValueFactory.ListSpinnerValueFactory<String>(voyageur);
        valueFactory.setValue("1 Voyageur");
        nbrVoyageur1.setValueFactory(valueFactory);
        nbrChambre1.getItems().add("1 Chambre");
        nbrChambre1.getItems().add("2 Chambres");
        nbrChambre1.getItems().add("3 Chambres");
        nbrChambre1.getItems().add("4 Chambres");
        nbrChambre1.getItems().add("5 Chambres");

        ToggleGroup group = new ToggleGroup();
        ToggleGroup group1 = new ToggleGroup();
        ToggleGroup group2 = new ToggleGroup();
        ToggleGroup group3 = new ToggleGroup();
        animauxYes.setToggleGroup(group);
        animauxNo.setToggleGroup(group);

        fumeurYes.setToggleGroup(group1);
        fumeurNo.setToggleGroup(group1);

        alcoolYes.setToggleGroup(group2);
        alcoolNo.setToggleGroup(group2);

        enfantYes.setToggleGroup(group3);
        enfantNo.setToggleGroup(group3);
        gouve.getItems().addAll("Ariana");
        gouve.getItems().addAll("Beja");
        gouve.getItems().addAll("Ben Arous");
        gouve.getItems().addAll("Bizerte");
        gouve.getItems().addAll("Gabes");
        gouve.getItems().addAll("Gafsa");
        gouve.getItems().addAll("Jendouba");
        gouve.getItems().addAll("Kairouan");
        gouve.getItems().addAll("Kasserine");
        gouve.getItems().addAll("Kebili");
        gouve.getItems().addAll("Le Kef");
        gouve.getItems().addAll("Mahdia");
        gouve.getItems().addAll("La Manouba");
        gouve.getItems().addAll("Médenine");
        gouve.getItems().addAll("Monastir");
        gouve.getItems().addAll("Nabeul");
        gouve.getItems().addAll("Sfax");
        gouve.getItems().addAll("Sidi Bouzid");
        gouve.getItems().addAll("Siliana");
        gouve.getItems().addAll("Sousse");
        gouve.getItems().addAll("Tataouine");
        gouve.getItems().addAll("Tozeur");
        gouve.getItems().addAll("Tunis");
        gouve.setValue("Tunis");
       
        categorie1.setValue(AfficherProprieteController.prop.getCategoriePropriete());
        type1.setValue(AfficherProprieteController.prop.getTypePropriete());
        gouve.setValue(AfficherProprieteController.prop.getVille());
        rue1.setText(AfficherProprieteController.prop.getRue());
        titre1.setText(AfficherProprieteController.prop.getTitre());
        String str = String.valueOf(AfficherProprieteController.prop.getPrix());
        prix1.setText(str);
        if (AfficherProprieteController.prop.getNbrChambre() == 1) {
            nbrChambre1.setValue("1 Chambre");
        }
        if (AfficherProprieteController.prop.getNbrChambre() == 2) {
            nbrChambre1.setValue("2 Chambres");
        }
        if (AfficherProprieteController.prop.getNbrChambre() == 3) {
            nbrChambre1.setValue("3 Chambres");

        }
        if (AfficherProprieteController.prop.getNbrChambre() == 4) {
            nbrChambre1.setValue("4 Chambres");
        }
        if (AfficherProprieteController.prop.getNbrChambre() == 5) {
            nbrChambre1.setValue("5 Chambres");
        }
        if (AfficherProprieteController.prop.getNbrVoyageur() == 1) {
            valueFactory.setValue("1 Voyageur");
            nbrVoyageur1.setValueFactory(valueFactory);
        }
        if (AfficherProprieteController.prop.getNbrVoyageur() == 2) {
            valueFactory.setValue("2 Voyageurs");
            nbrVoyageur1.setValueFactory(valueFactory);
        }
        if (AfficherProprieteController.prop.getNbrVoyageur() == 3) {
            valueFactory.setValue("3 Voyageurs");
            nbrVoyageur1.setValueFactory(valueFactory);
        }
        if (AfficherProprieteController.prop.getNbrVoyageur() == 4) {
            valueFactory.setValue("4 Voyageurs");
            nbrVoyageur1.setValueFactory(valueFactory);
        }
        if (AfficherProprieteController.prop.getNbrVoyageur() == 5) {
            valueFactory.setValue("5 Voyageurs");
            nbrVoyageur1.setValueFactory(valueFactory);
        }
        gouve.setValue(AfficherProprieteController.prop.getVille());

        description1.setText(AfficherProprieteController.prop.getDescription());
        if (AfficherProprieteController.prop.getAnimaux()) {
            animauxYes.setSelected(true);
        } else {
            animauxNo.setSelected(true);
        }
        if (AfficherProprieteController.prop.getFumeur()) {
            fumeurYes.setSelected(true);
        } else {
            fumeurNo.setSelected(true);
        }
        if (AfficherProprieteController.prop.getAlcool()) {
            alcoolYes.setSelected(true);
        } else {
            alcoolNo.setSelected(true);
        }
        if (AfficherProprieteController.prop.getEnfant()) {
            enfantYes.setSelected(true);
        } else {
            enfantNo.setSelected(true);
        }
    }

    private void supprimer(ActionEvent event) {
        Propriete p = AfficherProprieteController.prop;
        ImageProp ip;
            ImageProp ip1;
            ImageProp ip2;
            List<ImageProp> iprop;
            ImageProprieteCRUD ipc = new ImageProprieteCRUD();
            iprop = ipc.getImagesByProp(p.getId());
            
            String a=urlText.getText();
            
            

            int id1 = iprop.get(0).getId();
       

            ip = ipc.getImageById(id1);
            ipc.deleteImageById(id1);
        
            
        
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
