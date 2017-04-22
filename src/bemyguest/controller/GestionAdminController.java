package bemyguest.controller;

import ValidatorMail.Validate;
import bemyguest.DAO.Classe.UserDAO;
import bemyguest.entities.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.controlsfx.control.Notifications;
import bemyguest.config.ConnectionDB;

public class GestionAdminController implements Initializable {

    Connection connexion = ConnectionDB.getConnexion();

    private ObservableList<User> data;

    @FXML
    private TableView<User> tableViewAdmin;

    @FXML
    private TableColumn<?, ?> columnNom;

    @FXML
    private TableColumn<?, ?> columnLogin;

    @FXML
    private TableColumn<?, ?> columnPrenom;

    @FXML
    private TableColumn<?, ?> columnPassword;

    @FXML
    private TableColumn<?, ?> columnEmail;

    @FXML
    private TableColumn<?, ?> columnId;

    @FXML
    private TableColumn<?, ?> columnNumtel;

    @FXML
    private JFXButton btn_addAmin;

    @FXML
    private JFXButton btn_editAdmin;

    @FXML
    private JFXButton btn_deleteAdmin;

    @FXML
    private JFXTextField txt_nom;

    @FXML
    private JFXTextField txt_login;
    @FXML
    private JFXTextField txt_email;

    @FXML
    private JFXTextField txt_prenom;

    @FXML
    private JFXPasswordField txt_repass;
    @FXML
    private JFXPasswordField txt_password;
    @FXML
    private Label lbl_id;

    @FXML
    private TextField txt_search2;
    private ImageIcon format = null;
    String filename = null;
    int s = 0;
    byte[] person_image = null;
    private FileChooser fileChooser;
    @FXML
    private ImageView imageView;
    @FXML
    private JFXComboBox<String> comboSexe;
    @FXML
    private TableColumn<?, ?> columnSexe;
    @FXML
    private JFXButton browse_btn;
    @FXML
    private TextArea textArea;
    @FXML
    private JFXTextField txt_num;
    @FXML
    private JFXButton btn_addAmin1;
    @FXML
    private JFXButton btn_editAdmin1;
    
    int c;

    @FXML
    private void ShowOnClick() {

        try {

            User usr = (User) tableViewAdmin.getSelectionModel().getSelectedItem();
            txt_nom.setText(usr.getNom());
            txt_prenom.setText(usr.getPrenom());
            txt_email.setText(usr.getEmail());
            txt_login.setText(usr.getLogin());
            txt_password.setText(usr.getPassword());
            txt_repass.setText(txt_password.getText());
            comboSexe.setValue(usr.getSexe());
            textArea.setText(usr.getImageurl());
            txt_num.setText(usr.getNumtel());

            String url = usr.getImageurl();
            File file = new File(url);
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
            // imageView.
            String a = String.valueOf(usr.getId_u());
            lbl_id.setText(a);

        } catch (Exception e) {
            Notifications notififcationBuilder = Notifications.create()
                    .title("Erreur !")
                    .text("Choix incorrect !")
                    .graphic(null)
                    .hideAfter(Duration.seconds(4))
                    .position(Pos.CENTER)
                    .onAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent t) {
                            System.out.println("Hello");
                        }
                    });
            //   notififcationBuilder.darkStyle();
            notififcationBuilder.showError();
        }

    }

    @FXML
    void SowhFormEdit(ActionEvent event) {

    }

    @FXML
    void ShowFormAdd(ActionEvent event) {

    }

    @FXML
    void addAminEvent(ActionEvent event) {
        boolean status = Validate.ValidateEmail(txt_email.getText());
        
       
        
        if (txt_email.getText().trim().isEmpty()
                || txt_login.getText().trim().isEmpty()
                || txt_nom.getText().trim().isEmpty()
                || txt_prenom.getText().trim().isEmpty()
                || txt_password.getText().trim().isEmpty()
                || txt_repass.getText().trim().isEmpty()
                || comboSexe.getSelectionModel().isEmpty()
                || txt_num.getText().trim().isEmpty()) 
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

                if (txt_password.getText().equals(txt_repass.getText())) {

                    User u = new User();
                    u.setNom(txt_nom.getText());
                    u.setPrenom(txt_prenom.getText());
                    u.setEmail(txt_email.getText());
                    u.setLogin(txt_login.getText());
                    u.setPassword(txt_password.getText());
                    u.setSexe(comboSexe.getValue());
                    u.setImageurl(textArea.getText());
                    u.setNumtel(txt_num.getText());
                    UserDAO uDAO = new UserDAO();
                    uDAO.insertAdmin(u);
                    LoadData();

                } else {
                    Notifications notififcationBuilder = Notifications.create()
                            .title("Erreur !")
                            .text("Les mots de passe doivent être identique !")
                            .graphic(null)
                            .hideAfter(Duration.seconds(4))
                            .position(Pos.CENTER);

                    notififcationBuilder.showError();

                }
            } else {

                Notifications notififcationBuilder = Notifications.create()
                        .title("Erreur !")
                        .text(" Email non valide ! \n Exemple : foulen.benfoulen@domaine.tn")
                        .graphic(null)
                        .hideAfter(Duration.seconds(6))
                        .position(Pos.CENTER);

                notififcationBuilder.showError();
            }
        }
    }

    @FXML
    void editAdminEvent(ActionEvent event) {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Modification");
        alert.setHeaderText("Voulez-vous vraiment modifier cet administrateur ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {

            User us = new User();
            int i = Integer.parseInt(lbl_id.getText());
            us.setId_u(i);
            us.setNom(txt_nom.getText());
            us.setPrenom(txt_prenom.getText());
            us.setEmail(txt_email.getText());
            us.setLogin(txt_login.getText());
            us.setPassword(txt_password.getText());
            us.setSexe(comboSexe.getValue());
            us.setImageurl(textArea.getText());
            us.setNumtel(txt_num.getText());
            UserDAO uDAO = new UserDAO();
            uDAO.updateUser(us);
            LoadData();
     
            Notifications notififcationBuilder = Notifications.create()
                    .title("Confirmation !")
                    .text("L'administrateur " + "<" + txt_nom.getText() + ">" + " modifier avec succées !")
                    .graphic(null)
                    .hideAfter(Duration.seconds(2))
                    .position(Pos.CENTER);
            notififcationBuilder.showConfirm();

        }
    }

    @FXML
    void deleteAdminEvent(ActionEvent event) {
//        JOptionPane jop = new JOptionPane();
//        int option = jop.showConfirmDialog(null, "Voulez-vous vraiment supprimer cet utilisateur ?", "Confiramation de supprission", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//        if (option == JOptionPane.OK_OPTION) 

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Suppression");
        alert.setHeaderText("Voulez-vous vraiment supprimer cet administrateur ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            User us = new User();
            UserDAO usDAO = new UserDAO();
            int i = tableViewAdmin.getSelectionModel().getSelectedItem().getId_u();
            usDAO.deleteUser(i);
            LoadData();
            Notifications notififcationBuilder = Notifications.create()
                    .title("Confirmation !")
                    .text("Utilisateur supprimer avec succées !")
                    .graphic(null)
                    .hideAfter(Duration.seconds(4))
                    .position(Pos.CENTER);
            notififcationBuilder.showConfirm();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboSexe.getItems().add("Femme");
        comboSexe.getItems().add("Homme");
        Connection con = ConnectionDB.getConnexion();
        data = FXCollections.observableArrayList();
        LoadData();
        setCellTable();
        searchAdmin();

    }

    private void setCellTable() {
        columnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        columnPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        columnSexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        columnNumtel.setCellValueFactory(new PropertyValueFactory<>("numtel"));

    }

    private void LoadData() {
//        data.clear();
//        List<User> us;
//        UserDAO udao = new UserDAO();
//        us=udao.retriveUser();
//        for (int i =0;i<us.size();i++){
//data.add(new User(us.get(i).getId_u(), us.get(i).getNom(), us.get(i).getPrenom(), us.get(i).getEmail(), us.get(i).getLogin(), us.get(i).getPassword(), null));        }
//        tableViewAdmin.setItems(data);
        data.clear();

        try {
            Connection connexion = ConnectionDB.getConnexion();

            ResultSet rs = connexion.createStatement().executeQuery("SELECT * FROM utilisateur where roles='a:1:{i:0;s:16:\"ROLE_SUPER_ADMIN\";}' ");
            while (rs.next()) {
                data.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), null, rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));

            }

        } catch (SQLException ex) {
            System.err.println("ERROR" + ex);
        }
        tableViewAdmin.setItems(data);
    }

    private void searchAdmin() {

        txt_search2.setOnKeyReleased(e -> {
            if (txt_search2.getText().equals("")) {
                LoadData();
            } else {
                data.clear();
                                                                                                                                        String sql = "SELECT * FROM utilisateur WHERE roles='a:1:{i:0;s:16:\"ROLE_SUPER_ADMIN\";}' and id LIKE '%" + txt_search2.getText() + "%'"
                                                                                                                                                + "UNION SELECT * FROM utilisateur WHERE roles='a:1:{i:0;s:16:\"ROLE_SUPER_ADMIN\";}' and lastname LIKE '%" + txt_search2.getText() + "%'"
                                                                                                                                                + "UNION SELECT * FROM utilisateur WHERE roles='a:1:{i:0;s:16:\"ROLE_SUPER_ADMIN\";}' and firstname LIKE '%" + txt_search2.getText() + "%'"
                                                                                                                                                + "UNION SELECT * FROM utilisateur WHERE roles='a:1:{i:0;s:16:\"ROLE_SUPER_ADMIN\";}' and email LIKE '%" + txt_search2.getText() + "%'"
                                                                                                                                                + "UNION SELECT * FROM utilisateur WHERE roles='a:1:{i:0;s:16:\"ROLE_SUPER_ADMIN\";}' and username LIKE '%" + txt_search2.getText() + "%'";
                try {

                    PreparedStatement prt = connexion.prepareStatement(sql);
                    ResultSet rs = prt.executeQuery();
                    while (rs.next()) {
                        System.out.println("" + rs.getString(2));
                        data.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
                    }
                    tableViewAdmin.setItems(data);

                } catch (SQLException ex) {
                    System.out.println("" + ex);
                }
            }

        });

    }

    public void attachEvent(ActionEvent event) {

    }

    @FXML
    private void browseEvent(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        FileChooser.ExtensionFilter extFilterTout = new FileChooser.ExtensionFilter("All files (*.*)", "*.*");
        FileChooser.ExtensionFilter extFilterJPEG = new FileChooser.ExtensionFilter("GPEG files (*.jpeg)", "*.JPEG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG, extFilterJPEG, extFilterTout);
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
            Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void clearEvent(ActionEvent event) {

        txt_email.setText("");
        txt_login.setText("");
        txt_nom.setText("");
        txt_num.setText("");
        txt_password.setText("");
        txt_prenom.setText("");
        txt_repass.setText("");
        txt_search2.setText("");
        textArea.setText("");
        imageView.setImage(null);

    }

    @FXML
    private void EventKeyNumber(KeyEvent event) {
    }
}
