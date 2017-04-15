/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.gui;

import bemyguest.DAO.Classe.FavorisDAO;
import bemyguest.DAO.Classe.UserDAO;
import bemyguest.entities.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Oussaa
 */
public class ValidationFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ImageView imgAdd;

    @FXML
    private Button reserver;
    private String sb;

    private void AddFavoris() {
        imgAdd.setOnMouseClicked((MouseEvent e) -> {
            User u = new User();
            UserDAO dao = new UserDAO();
            FavorisDAO fd = new FavorisDAO();
            u = dao.retrieveAdminById(6);
            fd.insertFavorisUser(u);
            System.out.println("Added");
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AddFavoris();
    }

}
