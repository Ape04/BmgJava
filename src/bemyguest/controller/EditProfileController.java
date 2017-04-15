/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bemyguest.controller;

import bemyguest.DAO.Classe.UserDAO;
import bemyguest.entities.User;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class EditProfileController implements Initializable {
    @FXML
    private JFXTextField txt_nom;
//    @FXML
//    public static JFXTextField txt_user2;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadData();
//                System.out.println("aaaaaaaaaaaaaa");
//
//          User us = new User();
//        UserDAO udao= new UserDAO();
//        
//        txt_nom.setText(LoginController.txt_user2.getText());
//        System.out.println(LoginController.txt_user2.getText());
//        System.out.println(us.toString());
//        
//      // udao.retrieveAdminByLogin();
//      loadData();
        
    }    
    
    public void loadData(){
        
        
               // txt_nom.setText(LoginController.txt_user2.getText());

   
       // us=udao.retrieveAdminByLogin(LoginController.txt_user2.getText());
            User us = new User();
        UserDAO udao= new UserDAO();
        txt_nom.setText(udao.retrieveAdminByLogin(LoginController.txt_user2.getText()).getLogin());
    }
    
}
