/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.controller;

import bemyguest.DAO.Classe.ResevationDAO;
import bemyguest.entities.Propriete;
import bemyguest.entities.Resrevation;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.util.Duration;

/**
 *
 * @author HP
 */
public class ReservationController implements Initializable {
    @FXML
    private AnchorPane emchi ;
    @FXML
    private Label label_nom ;
   @FXML
    private Label label_prenom;
    @FXML
    private Label label_des ;
     @FXML
    private Label label_cat ;
     @FXML
    private Label label_ville ;
     
     @FXML
    private Label label_detaille ;
     @FXML
    private ObservableList<Resrevation> data;
    @FXML
    private ObservableList<Propriete> data1;
    @FXML
    private TableView<Resrevation> tab_reservation;
     @FXML
    private TableView<Propriete> tab_hot;
    
    @FXML
    private TableColumn<?, ?> coll_date_debut;
      @FXML
    private TableColumn<?, ?> col_ville;
    @FXML
    
    private TableColumn<?, ?> col_des;
     @FXML
    private TableColumn<?, ?> col_idp;
    @FXML
    private TableColumn<?, ?> col10_id;

    @FXML
    private TableColumn<?, ?> col_date_fin;

    @FXML
    private TableColumn<?, ?> col_hot;

    @FXML
    private TableColumn<?, ?> col_prenom;

    @FXML
    private TableColumn<?, ?> col_nom;

    @FXML
    private Button btn_annuler;

    @FXML
    private Button btn_afficher;
   
   
    @FXML
    private void handleButtonAffficherAction(ActionEvent event) {
//      try {
          //  System.out.println("You clicked me!");
           // label.setText("Hello World!");
            
          //  SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd" );  
          // Date date_debut = format.parse("2017-03-30" );
          ///  java.util.Date date_Fin = format.parse( "2017-03-31" );
       //  User u1 = new User(1, "m", "m", "m", "m", "m");
       //   Propriete p = new Propriete(1, "categoriePropriete", "typePropriete", "pays", "ville", "rue", 0, 0, 0, "description", true, true, true,true, u1);
       //  Resrevation  r = new Resrevation (2,u1,p,date_debut ,date_Fin);
         //   ResevationDAO rd = new ResevationDAO ();
//  rd.ajouter_Reservation (r);
 // rd.delete(r);
 //rd.inserer(r);
   // System.out.println ( rd.getListProprieteSansReservation());
   // System.out.println (rd.getListReservation(r));
      
  // System.out.println ( rd.proprieteLibre(date_debut, date_Fin));
    //  System.out.println ( rd.listReservationParId(1));
   //  ProprieteCrud pp = new ProprieteCrud ();
    // System.out.println (pp.getProprieteById(1).getId()); 
    //  User u = new User(1, "y", "y", "y", "y", "y");
      //  ProprieteCrud pc = new ProprieteCrud();
        //Propriete p = pc.getProprieteById(2);
        //Experience e = new Experience(1,"kk", "kk", u, p);
     //   ExperienceDAO dao = new ExperienceDAO();
    //  Experience e=  dao.getExperienceById(3);
     //     System.out.println(e);
      //  ImageExperienceCrud a = new ImageExperienceCrud();
     //  ImageExperience c = new ImageExperience("mm",e);
       //  a.addImageExperience(c);
// ExperienceDAO dao = new ExperienceDAO();
        //dao.ajouterExperience(e);
          //System.out.println(dao.getExperienceById(1));
          //dao.supprimerExperience(1);
         // System.out.println(dao.findAll());
        // dao.modifierExperience(2,e);
      
 //    } catch (ParseException ex) {
           // Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
      //  }
       
     
     data = FXCollections.observableArrayList();
       data1 = FXCollections.observableArrayList();
     LoadDataPropriete();
        setCellTable();
    
    }
     @FXML
    private void handleButtonVoirReservationAction(ActionEvent event){
    
     Propriete e= tab_hot.getSelectionModel().getSelectedItem();
    if (e==null) {
             
                Alert alert = new Alert(AlertType.WARNING);
                 alert.setTitle("Warning Dialog");
                alert.setHeaderText(null);
                alert.setContentText("selectionner une Propriete svp!");

                alert.showAndWait();
          //      LoadData();
              setCellTable();
              }
    LoadData(1);
    setCellTable();
     LoadDataPropriete();
        setCellTable();
    }
     
    
    @FXML
    private void handleButtonSupprimmerAction(ActionEvent event) {
     Resrevation e= tab_reservation.getSelectionModel().getSelectedItem();
    if (e==null) {
             
                Alert alert = new Alert(AlertType.WARNING);
                 alert.setTitle("Warning Dialog");
                alert.setHeaderText(null);
                alert.setContentText("selectionner une reservation svp!");

                alert.showAndWait();
          //      LoadData();
              setCellTable();
              }
    
    else {
               Alert alert = new Alert(AlertType.CONFIRMATION);
                 alert.setTitle("Confiramtion");
                alert.setHeaderText(null);
                alert.setContentText("vous etes sur de supprimer cette reservation");
Optional<ButtonType> answer =alert.showAndWait();

            if (answer.get() == ButtonType.OK) {
   ResevationDAO dao = new ResevationDAO() ;
              dao.delete(e);
                   //  LoadData();
              setCellTable();
            }
            
            else { 
             //  LoadData();
              setCellTable();
            }
            }
    
    }
    
    
    @FXML
    private void handleButtonAffficherDetailleAction(ActionEvent event){
     Resrevation e= tab_reservation.getSelectionModel().getSelectedItem();
    if (e==null) {
             
                Alert alert = new Alert(AlertType.WARNING);
                 alert.setTitle("Warning Dialog");
                alert.setHeaderText(null);
                alert.setContentText("selectionner une reservation svp!");

                alert.showAndWait();
             //   LoadData();
              setCellTable();
              }

  ResevationDAO dao = new ResevationDAO() ;
  Resrevation r=dao.ReservationById(e.getId_r());
    label_nom.setText("Nom :"+r.getUser().getNom());
     label_prenom.setText("Prenom :"+r.getUser().getPrenom());
     label_des.setText("Description de Hot :"+r.getPropriete().getDescription());
      label_cat.setText("Categorie de Hot :"+r.getPropriete().getCategoriePropriete());
     label_ville.setText("Ville de Hot :"+r.getPropriete().getVille());
    
    }
     @FXML
   private void    handleButtonListAction(ActionEvent event) throws IOException{
   
  

 //emchi.getChildren().setAll( (AnchorPane) FXMLLoader.load(getClass().getResource("ValiderFXML.fxml")));
 //setDataPane(fadeAnimate("ValiderFXML.fxml"));
       //   FileChooser fileChooser = new FileChooser();  
     emchi.getChildren().setAll( (AnchorPane) FXMLLoader.load(getClass().getResource("/bemyguest/gui/ValiderFXML.fxml")));
 setDataPane(fadeAnimate("/bemyguest/gui/ValiderFXML.fxml"));
          FileChooser fileChooser = new FileChooser(); 
   
   
   }
   
   
    
      @FXML  
  private void  handleButtonTraiterAction(ActionEvent event)throws Exception{         
    
                   
             //         afficher.getChildren().setAll( (AnchorPane) FXMLLoader.load(getClass().getResource("FXMLHost.fxml")));
 //setDataPane(fadeAnimate("FXMLHost.fxml"));
          // FileChooser fileChooser = new FileChooser();  
  //  Parent root = FXMLLoader.load(getClass().getResource("ValiderRservationFXML.fxml"));
    //    Stage stage = new Stage ();
      //  Scene scene = new Scene(root);
        
      //  stage.setScene(scene);   bemyguest.gui 
      //  stage.show();
  
     emchi.getChildren().setAll( (AnchorPane) FXMLLoader.load(getClass().getResource("/bemyguest/gui/ConsulterReFXML.fxml")));
 setDataPane(fadeAnimate("/bemyguest/gui/ConsulterReFXML.fxml"));
          FileChooser fileChooser = new FileChooser();   
  }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
    }    
    
private void setCellTable() {
        col10_id.setCellValueFactory(new PropertyValueFactory<>("id_r"));
        coll_date_debut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
       col_date_fin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
      col_ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
    col_des.setCellValueFactory(new PropertyValueFactory<>("rue"));
}

 private void LoadData(int id ) {
        data.clear();
        data1.clear();
       
        int idUserConnecte=1;
       List <Resrevation>  l ;      
         ResevationDAO rdao = new  ResevationDAO() ;
         
         l=rdao.getListReservationByPropriete(id);
      
         for (int i=0 ; i<l.size();i++){
         
                data.add(new Resrevation(l.get(i).getId_r(), l.get(i).getUser(), l.get(i).getPropriete(), l.get(i).getDateDebut(), l.get(i).getDateFin()));

           
       }
    
 
      
        tab_reservation.setItems(data);
         
    }

private void LoadDataPropriete() {
int idUserConnecte=1;
      
         ResevationDAO rdao = new  ResevationDAO() ;
          List <Propriete>  l2;
          l2=rdao.getListProprieteByUser(idUserConnecte);

 for (int i=0 ; i<l2.size();i++){
         
           data1.add(new Propriete(l2.get(i).getVille(),l2.get(i).getRue(),l2.get(i).getUser())); //kenet getUtilisateur radithha getUser 5ater ena fel entité propriete msamih User not utilisateur
         
       }

 tab_hot.setItems(data1);

}


                   


 public void setDataPane(Node node) {
        
      emchi.getChildren().setAll(node);
    }
      public AnchorPane fadeAnimate(String url) throws IOException {
       AnchorPane v = (AnchorPane) FXMLLoader.load(getClass().getResource(url));
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(v);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
        return v;
    }





}
