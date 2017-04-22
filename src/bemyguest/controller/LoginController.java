package bemyguest.controller;


import bemyguest.DAO.Classe.UserDAO;
import static bemyguest.DAO.Classe.UserDAO.j;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import bemyguest.config.ConnectionDB;
import bemyguest.entities.User;
/**
 * *****
 */
//import com.restfb.DefaultFacebookClient;
//import com.restfb.FacebookClient;
//import com.restfb.types.User;
//import java.net.URL;
//import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Haroun
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField txt_nom;

    ResultSet rs = null;
    PreparedStatement pst = null;
    UserDAO dao=new UserDAO();

    @FXML
    void FacebookConnect(ActionEvent event) {

        /*String domain = "https://www.google.fr/";
         String appId = "234379707024214";

         String authUrl = "https://graph.facebook.com/oauth/authorize?type=user_agent&client_id=" + appId + "&redirect_uri=" + domain + "&scope=user_about_me,"
         + "public_profile,user_friends,email,user_actions.books\n"
         + ",user_actions.fitness\n"
         + ",user_actions.music\n"
         + ",user_actions.news\n"
         + ",user_actions.video\n"
         //                + ",user_actions:{app_namespace}\n"
         + ",user_birthday\n"
         + ",user_education_history\n"
         + ",user_events\n"
         + ",user_games_activity\n"
         + ",user_hometown\n"
         + ",user_likes\n"
         + ",user_location\n"
         + ",user_managed_groups\n"
         + ",user_photos\n"
         + ",user_posts\n"
         + ",user_relationships\n"
         + ",user_relationship_details\n"
         + ",user_religion_politics\n"
         + ",user_tagged_places\n"
         + ",user_videos\n"
         + ",user_website\n"
         + ",user_work_history\n"
         + ",read_insights\n"
         + ",read_audience_network_insights\n"
         + ",read_page_mailboxes\n"
         + ",manage_pages\n"
         + ",publish_pages\n"
         + ",publish_actions\n"
         + ",rsvp_event\n"
         + ",pages_show_list\n"
         + ",pages_manage_cta\n"
         + ",pages_manage_instant_articles\n"
         + ",ads_read\n"
         + ",ads_management\n"
         + ",business_management\n"
         + ",pages_messaging\n"
         + ",pages_messaging_subscriptions\n"
         + ",pages_messaging_phone_number";
         ;
         System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
         WebDriver driver = new ChromeDriver();
         driver.get(authUrl);
         String accessToken;
         while (true) {

         if (!driver.getCurrentUrl().contains("https://www.facebook.com/")) {
         String url = driver.getCurrentUrl();
         accessToken = url.replaceAll(".*#access_token=(.+)&.*", "$1");
         driver.quit();
         FacebookClient fbClient = new DefaultFacebookClient(accessToken);
         User user = fbClient.fetchObject("me", User.class);
         //  txt_user.setText(user.getName());

         // System.out.println(""+user.getEmail());
         System.out.println(""+user.getName());*/
//        String accessToken = "EAACEdEose0cBAIaGhjF84ZCcdikyt43iAU3ZARxNlD3PaK5Bl5DdGCyaFZAIJyB2MFMUeismnZAbDZCHNCkMqZBb0hHr31GLJL02WM7xgfQIv55rDZCHfuWUM53KZCPNRLcV7CwmP6hV0R2LqmNfvQKxSZCDyocPJL9zyonnfMDTTC8a9F9kYU2oCJ60phLtD0ZAIZD";
//        FacebookClient fbClient = new DefaultFacebookClient(accessToken);
//        User me = fbClient.fetchObject("me", User.class);
//        String mailFB = me.getEmail();
//        String NomFB = me.getLastName();
//        String PrenomFB = me.getFirstName();
//        String passwordFB = "PiSquad";
//        String adresseFB = me.getHometownName();
//                System.out.println(passwordFB);
//                System.out.println(mailFB);
//                System.out.println(NomFB); 
//                System.out.println(PrenomFB);
//                System.out.println(adresseFB); 
//                System.out.println(""+me.getBirthday());
//                System.out.println(""+me.getGender());
    }

    @FXML
    private void inscriptionEvent(ActionEvent event) throws IOException {

        Parent inscription = FXMLLoader.load(getClass().getResource("/bemyguest/gui/Inscription.fxml"));
        Scene scene = new Scene(inscription);
        scene.getStylesheets().add("/bemyguset/resource/style.css");
        Stage stagex = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stagex.setScene(scene);
        stagex.show();
    }

    @FXML
    private JFXTextField txt_user;
   // @FXML
    public static JFXTextField txt_user2;
    @FXML
    private JFXPasswordField txt_passwd;
    @FXML
    private JFXButton btn_connect;
    @FXML
    private JFXButton btn_inscription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void ForgetPassword(ActionEvent event) {
//        Entities.User us = new Entities.User();
//        UserDAO udao = new UserDAO();
//        us = udao.retrieveAdminByLogin(txt_user.getText());
//        System.out.println("" + us.toString());
//        System.out.println(txt_user.getText());
      //  System.out.println(us.getId_u());

    }

    @FXML
    private void connectEvent(ActionEvent event) throws SQLException, IOException {

        if (txt_user.getText().trim().isEmpty() || txt_passwd.getText().trim().isEmpty()) {
            Notifications notififcationBuilder = Notifications.create()
                    .title("Erreur !")
                    .text("Veuillez remplir tous les champs !")
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
        } else {

            Connection connexion = ConnectionDB.getConnexion();

//
//            txt_nom.setText(txt_user2.toString());
            String req = "SELECT * FROM utilisateur where username=? and password=? and roles='a:1:{i:0;s:16:\"ROLE_SUPER_ADMIN\";}' ";
            
            pst = connexion.prepareStatement(req);
            pst.setString(1, txt_user.getText());
            pst.setString(2, txt_passwd.getText());
            j=dao.retrieveUserByLogin(txt_user.getText());
            System.out.println(j);
            User u = dao.retrieveAdminById(j);
            dao.updateLastLogin(u,j);


            rs = pst.executeQuery();
            if (rs.next()) {
//txt_user2.setText(txt_user.getText());
                // Parent inscription = FXMLLoader.load(getClass().getResource("/gestionAdmin/GestionAdmin.fxml"));
                Parent inscription = FXMLLoader.load(getClass().getResource("/bemyguest/gui/FXMLDocument.fxml"));

                Scene scene = new Scene(inscription);
                scene.getStylesheets().add("/bemyguset/resource/style.css");

                Stage stagex = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stagex.setScene(scene);
                //  stagex.setFullScreen(true);
                stagex.setMinHeight(700);
                stagex.setMinWidth(1300);
                stagex.show();

                Notifications notififcationBuilder = Notifications.create()
                        .title("Bienvenue")
                        .text("Connexion effectué avec succée !")
                        .graphic(null)
                        .hideAfter(Duration.seconds(1))
                        .position(Pos.CENTER);

                //   notififcationBuilder.darkStyle();
                notififcationBuilder.showConfirm();

            } else {

                String req2 = "SELECT * FROM utilisateur where username=? and password=? and roles='a:1:{i:0;s:11:\"ROLE_CLIENT\";}' ";
                
                j=dao.retrieveUserByLogin(txt_user.getText());
                User u2 = dao.retrieveAdminById(j);
                dao.updateLastLogin(u2,j);

                pst = connexion.prepareStatement(req2);
                pst.setString(1, txt_user.getText());
                pst.setString(2, txt_passwd.getText());
//                txt_user2.setText(txt_user.getText());

                rs = pst.executeQuery();

                if (rs.next()) {
                    {           
                        try {
                            Parent nn = FXMLLoader.load(getClass().getResource("/bemyguest/gui/AcceuilFXML.fxml"));
                            Scene scene2 = new Scene(nn);
                            scene2.getStylesheets().add("/bemyguset/resource/mainSheet.css");
                            Stage stagey = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stagey.setScene(scene2);
                            stagey.show();
                            System.out.println(j);

                        } catch (Exception e) {
                            System.out.println("Guest : " + e);
                        }
                        
                    }
                   
                }
 /*Notifications notififcationBuilder = Notifications.create()
                        .title("Erreur !")
                        .text("Nom d'utilisateur ou mot de passe incorrect !")
                        .graphic(null)
                        .hideAfter(Duration.seconds(4))
                        .position(Pos.CENTER);

                //   notififcationBuilder.darkStyle();
                notififcationBuilder.showError();
                // AlertDialog.display("Alert", "Nom d'utilisateur ou mot de passe incorrect !");*/
            }

        }
        
    }
}
