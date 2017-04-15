package bemyguest.controller;


import bemyguest.DAO.Classe.UserDAO;
import bemyguest.entities.User;
import ValidatorMail.Validate;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import org.controlsfx.control.Notifications;

public class InscriptionController implements Initializable {

    @FXML
    private JFXTextField txt_nom;
    @FXML
    private JFXTextField txt_prenom;
    @FXML
    private JFXTextField txt_email;
    @FXML
    private JFXTextField txt_login;
    @FXML
    private JFXPasswordField txt_pwd;
    @FXML
    private JFXPasswordField txt_pwd1;
    @FXML
    private JFXButton btnSignIn;
    @FXML
    private JFXButton backBtn;
    @FXML
    private Pane paneInscription;
    @FXML
    private JFXDatePicker datens;
    @FXML
    private ImageView imageView;
    private File iconImage;
    @FXML
    private AnchorPane AnchorP;
    @FXML
    private Button browse_btn;
    @FXML
    private TextArea textArea;

    private FileInputStream fis;
    @FXML
    private JFXComboBox<String> comboSexe;
     @FXML
    private JFXTextField txt_numtel;
         @FXML
    private Label lbl_numtel;
         int c;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        comboSexe.getItems().add("Femme");
        comboSexe.getItems().add("Homme");

    }
    
    
    
    
        @FXML
    void FbLogin(ActionEvent event) {

        
        String accessToken = "EAACEdEose0cBAIt4tIWsBXv9DuZCAOTGZBwIRZCNMTPkF4R2mfhIUZCEmZA4UZBBazrhUQT7ksyHYeom8wYjRZB4OBZAcJBgOSvov3rHjMZBCzmT3kgY3hPCT9l17q1Cspu76Qdi7zU8GqblxP7KSRUZBHTZAqVTWSr6dusWY1VQUKgKmwJ69PaQ9mZAlCjpT24LhvgZD";
       // FacebookClient fbClient = new DefaultFacebookClient(accessToken);
        //com.restfb.types.User me = fbClient.fetchObject("me", com.restfb.types.User.class);
       // String mailFb = me.getEmail();
        //String NomFb = me.getLastName();
        //String PrenomFb = me.getFirstName();
        //String passwordFb = "PiSquad";
        //String adresseFb = me.getHometownName();
        //String DOB=me.getBirthday();
                
                
        //String a=me.getName();
          //  System.out.println(""+a);
            
            Random rand = new Random();
            int  n = rand.nextInt(1000) + 10;
            
            //txt_login.setText(NomFb+n);
        //txt_nom.setText(NomFb);
        //txt_prenom.setText(PrenomFb);
        //txt_email.setText(mailFb);
        //txt_pwd.setText(passwordFb);
        //txt_pwd1.setText(passwordFb);
        //System.out.println(""+me.getBirthday());

               /* System.out.println(passwordFB);
                System.out.println(mailFB);
                System.out.println(NomFB); 
                System.out.println(PrenomFB);
                System.out.println(adresseFB); 
                System.out.println(""+me.getBirthday());
                System.out.println(""+me.getGender());*/
    }

    
  
        
    
    @FXML
    private void InscriptionEvent(ActionEvent event) {
 
        
        try
        {
             c=Integer.parseInt(txt_numtel.getText());
              boolean status = Validate.ValidateEmail(txt_email.getText());
        if (txt_email.getText().trim().isEmpty()
                || txt_login.getText().trim().isEmpty()
                || txt_nom.getText().trim().isEmpty()
                || txt_prenom.getText().trim().isEmpty()
                || txt_pwd.getText().trim().isEmpty()
                || txt_pwd1.getText().trim().isEmpty()
                || comboSexe.getSelectionModel().isEmpty()
                || txt_numtel.getText().isEmpty()

                )
            
            
            
        {
            Notifications notififcationBuilder = Notifications.create()
                    .title("Erreur !")
                    .text("Veuillez remplir tout les champs !")
                    .graphic(null)
                    .hideAfter(Duration.seconds(4))
                    .position(Pos.CENTER);
                    
            notififcationBuilder.showError();
        } else {

            if (status) {

                if (txt_pwd1.getText().equals(txt_pwd.getText())) {

                    User u = new User();

                    u.setNom(txt_nom.getText());
                    u.setPrenom(txt_prenom.getText());
                    u.setEmail(txt_email.getText());
                    u.setLogin(txt_login.getText());
                    u.setPassword(txt_pwd.getText());
                    u.setImageurl(textArea.getText());
                    u.setSexe(comboSexe.getValue());
                    u.setNumtel(txt_numtel.getText());
                    
                    String dt =((TextField)datens.getEditor()).getText();
                    u.setDaten(datens.getValue().format(DateTimeFormatter.ISO_DATE));
                    
                    UserDAO uDAO = new UserDAO();
                    uDAO.inscriptionUser(u);
                    
                    txt_nom.setText("");
                    txt_prenom.setText("");
                    txt_email.setText("");
                    txt_login.setText("");
                    txt_pwd.clear();
                    txt_pwd1.clear();
                    txt_numtel.clear();
                    datens.setValue(null);
                    
                } else {
                    Notifications notififcationBuilder = Notifications.create()
                            .title("Erreur !")
                            .text("Les mots de passe doivent être identique !")
                            .graphic(null)
                            .hideAfter(Duration.seconds(4))
                            .position(Pos.CENTER)
                            .onAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent t) {
                                    System.out.println("Hello");
                                }
                            });
                    notififcationBuilder.showError();

                }
            } else {
                Notifications notififcationBuilder = Notifications.create()
                        .title("Erreur !")
                        .text(" Email non valide ! \n Exemple : foulen.benfoulen@domaine.tn")
                        .graphic(null)
                        .hideAfter(Duration.seconds(6))
                        .position(Pos.CENTER)
                        .onAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent t) {
                                System.out.println("Hello");
                            }
                        });
                notififcationBuilder.showError();
            }

        }
             
             
        }
        catch (NumberFormatException e) {
                        Notifications notififcationBuilder = Notifications.create()
                        .title("Erreur !")
                        .text(" Le numero doit etre de type numérique  ")
                        .graphic(null)
                        .hideAfter(Duration.seconds(6))
                        .position(Pos.CENTER)
                        .onAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent t) {
                                System.out.println("Hello");
                            }
                        });
                notififcationBuilder.showError();            
        }
       
             
             
             
             
        }
    

    @FXML
    private void BackEvent(ActionEvent event) throws IOException {
        Parent inscription = FXMLLoader.load(getClass().getResource("/bemyguest/gui/Login.fxml"));
        Scene scene = new Scene(inscription);
        scene.getStylesheets().add("/bemyguset/resource/style.css");

        Stage stagex = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stagex.setScene(scene);
        stagex.show();
    }

    @FXML
    private void browseEvent(ActionEvent event) {
        try {
            
            FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);
        String x = file.toPath().toAbsolutePath().toString();
        System.out.println(x);
           textArea.setText(x.toString());
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imageView.setImage(image);
         

        } catch (IOException ex) {
            System.out.println(""+ex.getMessage());
        }

            
            
        } catch (Exception e) {
            System.out.println(""+e.getMessage());
        }
        
    }
}
