/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bemyguest.controller;

import bemyguest.DAO.Classe.UserDAO;
import bemyguest.entities.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import bemyguest.config.ConnectionDB;

/**
 * FXML Controller class
 *
 * @author Haroun
 */
public class GestionUtilisateurController implements Initializable {
    Connection connexion = ConnectionDB.getConnexion();
     private ObservableList<User> data;
    @FXML
    private JFXButton btn_deleteAdmin;
    @FXML
    private Label lbl_id;
    @FXML
    private TableView<User> tableViewAdmin;
    @FXML
    private TableColumn<?, ?> columnNom;
    @FXML
    private TableColumn<?, ?> columnPrenom;
    @FXML
    private TableColumn<?, ?> columnEmail;
    @FXML
    private TableColumn<?, ?> columnLogin;
    @FXML
    private TableColumn<?, ?> columnPassword;
    @FXML
    private TableColumn<?, ?> columnId;
    @FXML
    private TableColumn<?, ?> columnNumtel;
        @FXML
    private TableColumn<?, ?> columnTel;
    @FXML
    private JFXTextField txt_search2;
    @FXML
    private ImageView imageView;
    
    @FXML
    private TableColumn<?, ?> columDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Connection con = ConnectionDB.getConnexion();
        data = FXCollections.observableArrayList();                                             
        LoadData();
        setCellTable();
        searchAdmin();
    }    

    @FXML
    private void deleteAdminEvent(ActionEvent event) {
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Modification");
        alert.setHeaderText("Voulez-vous vraiment modifier cette utilisateur ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
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
                     notififcationBuilder.showConfirm();}
    }
    
    private void searchAdmin() {

        txt_search2.setOnKeyReleased(e -> {
            if (txt_search2.getText().equals("")) {
                LoadData();
            } else {
                data.clear();
                String sql = "SELECT * FROM utilisateur WHERE roles='a:1:{i:0;s:11:\"ROLE_CLIENT\";}' and id LIKE '%" + txt_search2.getText() + "%'"
                        + "UNION SELECT * FROM utilisateur WHERE roles='a:1:{i:0;s:11:\"ROLE_CLIENT\";}' and lastname LIKE '%" + txt_search2.getText() + "%'"
                        + "UNION SELECT * FROM utilisateur WHERE roles='a:1:{i:0;s:11:\"ROLE_CLIENT\";}' and firstname LIKE '%" + txt_search2.getText() + "%'"
                        + "UNION SELECT * FROM utilisateur WHERE roles='a:1:{i:0;s:11:\"ROLE_CLIENT\";}' and email LIKE '%" + txt_search2.getText() + "%'"
                        + "UNION SELECT * FROM utilisateur WHERE roles='a:1:{i:0;s:11:\"ROLE_CLIENT\";}' and username LIKE '%" + txt_search2.getText() + "%'";

                try {

                    PreparedStatement prt = connexion.prepareStatement(sql);
                    ResultSet rs = prt.executeQuery();
                    while (rs.next()) {
                       System.out.println(""+rs.getString(2));
                        data.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
                    }
                    tableViewAdmin.setItems(data);

                } catch (SQLException ex) {
                    System.out.println(""+ex);
                }
            }
        });

    }

    
    private void setCellTable() {
        
        columnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        columnPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        columDate.setCellValueFactory(new PropertyValueFactory<>("daten"));
        columnTel.setCellValueFactory(new PropertyValueFactory<>("numtel"));


    }
      private void LoadData() {

        data.clear();
        
        try {
            Connection connexion = ConnectionDB.getConnexion();
            ResultSet rs = connexion.createStatement().executeQuery("SELECT * FROM utilisateur where roles='a:1:{i:0;s:11:\"ROLE_CLIENT\";}' ");
            while (rs.next())
            {
                data.add(new User(rs.getInt("id"), rs.getString("lastname"), rs.getString("firstname"), rs.getString("email"), rs.getString("username"), rs.getString("password"), null, rs.getString("imageurl"), rs.getString("sexe"), rs.getString("daten"), rs.getString("numtel")));                
            }
        } catch (SQLException ex) {
            System.err.println("ERROR" + ex);

        }
        tableViewAdmin.setItems(data);
    }
    @FXML
    private void ShowOnClick(MouseEvent event) {
        
            User usr = (User) tableViewAdmin.getSelectionModel().getSelectedItem();
            String url=usr.getImageurl();
            File file=new File(url);
            Image image=new Image(file.toURI().toString());
            imageView.setImage(image);
    }
    
}
