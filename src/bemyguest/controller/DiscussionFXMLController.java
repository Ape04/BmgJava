/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.controller;

import bemyguest.DAO.Classe.FavorisDAO;
import bemyguest.DAO.Classe.MessageDAO;
import bemyguest.DAO.Classe.UserDAO;
import static bemyguest.DAO.Classe.UserDAO.j;
import bemyguest.entities.Favoris;
import bemyguest.entities.Message;
import bemyguest.entities.UserCfg;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Oussaa
 */
public class DiscussionFXMLController implements Initializable {

    private ObservableList<UserCfg> data;

    @FXML
    private TableView<UserCfg> tableView;
    @FXML
    private TableColumn<?, ?> columnId_f;
    @FXML
    private TableColumn<?, ?> columnNom;
    @FXML
    private TableColumn<?, ?> columnPrenom;
    @FXML
    private TableColumn<?, ?> columnId_u;
    @FXML
    private TableColumn<?, ?> columnNick;
    @FXML
    private JFXTextArea contenu;
    @FXML
    private JFXTextField message;
    @FXML
    private JFXButton btnEnvoie;

    int i = 0;
    String msg = "";
    List<Message> lst = null;
    List<Message> lst2 = null;
    @FXML
    private AnchorPane afficherMesagerie;
    @FXML
    private VBox VboxDisc;

    UserDAO uDao = new UserDAO();
    /**
     * Initializes the controller class.
     */
    private void setCellTable() {
        columnId_f.setCellValueFactory(new PropertyValueFactory<>("id_f"));
        columnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        columnPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        columnId_u.setCellValueFactory(new PropertyValueFactory<>("Id_u"));
        columnNick.setCellValueFactory(new PropertyValueFactory<>("alias"));
    }

    private void loadFavoris() {
        List<Favoris> lst = new ArrayList();
        FavorisDAO dao = new FavorisDAO();

        lst = dao.retrieveFavorisByIdUser(j);
        for (int i = 0; i < lst.size(); i++) {
            data.add(new UserCfg(lst.get(i).getId_f(), lst.get(i).getUserFavoris().getNom(), lst.get(i).getUserFavoris().getPrenom(), lst.get(i).getUserFavoris().getId_u(), lst.get(i).getAlias()));
        }
        tableView.setItems(data);
    }

    private void getMsgU() {
        MessageDAO dao = new MessageDAO();

        tableView.setOnMouseClicked((MouseEvent e) -> {

            try {
                i = tableView.getSelectionModel().getSelectedItem().getId_u();
                btnEnvoie.setVisible(true);
                message.setEditable(true);
            } catch (Exception ex) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("Vous devez selectionner une personne");
                alert.showAndWait();
            }
            contenu.clear();
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(() -> {
                        lst = dao.retrieveMessageByEmetRecep(j, i);
                        loadMsg();
                    });
                }
            }, 0, 3000);

        });

    }

    private void loadMsg() {
        Font prTxt = new Font("Arial", 15);
        contenu.setFont(prTxt);
        contenu.clear();
        for (int i = 0; i < lst.size(); i++) {
            contenu.appendText(lst.get(i).getContenu() + "\n");
        }
    }

    private void sendMsg() {
        UserDAO uDAO = new UserDAO();
        MessageDAO mDAO = new MessageDAO();

        btnEnvoie.setOnMouseClicked((MouseEvent e) -> {
            msg = message.getText();
            if (!"".equals(msg)) {
                Message m = new Message();
                m.setContenu(uDAO.retrieveAdminById(j).getNom()+" "+uDAO.retrieveAdminById(j).getPrenom()+" : "+msg);
                m.setUserEmetteur(uDAO.retrieveAdminById(j));
                m.setUserRecepteur(uDAO.retrieveAdminById(i));
                m.setDate(Date.valueOf(LocalDate.now()));
                mDAO.insertMsg(m);
                message.clear();
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = FXCollections.observableArrayList();
        loadFavoris();
        setCellTable();
        getMsgU();
        sendMsg();
        loadMenu();
    }

    public void loadMenu() {

        FavorisDAO dao = new FavorisDAO();
        MessageDAO mDao = new MessageDAO();
        final ContextMenu contextMenu = new ContextMenu();
        MenuItem edit = new MenuItem("Edit");
        MenuItem supprimer = new MenuItem("Supprimer Contact");
        MenuItem supprimerMsg = new MenuItem("Supprimer les messages");
        contextMenu.getItems().addAll(edit, supprimer, supprimerMsg);

        tableView.setOnMousePressed((MouseEvent event) -> {
            if (event.isSecondaryButtonDown()) {
                contextMenu.show(tableView, event.getScreenX(), event.getScreenY());
            }
        });

        supprimer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                i = tableView.getSelectionModel().getSelectedItem().getId_f();

                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Suppression");
                alert.setHeaderText("Voulez-vous supprimer cette personne de votre liste ?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    dao.deleteFavoris(i);
                    tableView.getItems().clear();
                    loadFavoris();
                }
            }
        }
        );

        edit.setOnAction(
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event
            ) {
                i = tableView.getSelectionModel().getSelectedItem().getId_f();
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Alias");
                dialog.setHeaderText("Ajouter un alias à votre contact");
                dialog.setContentText("Entrez le nickname :");
                Optional<String> result = dialog.showAndWait();
                result.ifPresent(name -> {
                    dao.EditAlias(name, i);
                    tableView.getItems().clear();
                    loadFavoris();
                });
            }
        }
        );
        
        supprimerMsg.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                i = tableView.getSelectionModel().getSelectedItem().getId_u();

                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Suppression");
                alert.setHeaderText("Voulez-vous supprimer votre conversation ?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    mDao.deleteMsgByIDu(j,i);
                    mDao.deleteMsgByIDu(i,j);
                    tableView.getItems().clear();
                    loadFavoris();
                }
            }
        }
        );
        tableView.setContextMenu(contextMenu);
    }
}