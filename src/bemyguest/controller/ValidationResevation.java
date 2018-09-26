/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.controller;

import bemyguest.DAO.Classe.ResevationDAO;
import bemyguest.entities.Propriete;
import bemyguest.entities.Resrevation;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import static bemyguest.DAO.Classe.UserDAO.j;
/**
 *
 * @author HP
 */
public class ValidationResevation implements Initializable {
    
   @FXML
    private Pane PaneDetails;
    
      @FXML
    private ComboBox cPropriete;
      @FXML
      private ComboBox cRue;
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
    private ObservableList<Resrevation> data1;
    @FXML
    private TableView<Resrevation> tab_reservation_finis;
     
     @FXML
    private TableView<Resrevation> tab_reservation;
    @FXML
    private TableColumn<?, ?> coll_date_debut;
     @FXML
    private TableColumn<?, ?> coll_date_debut1;
    @FXML
    private TableColumn<?, ?> col10_id;

    @FXML
    private TableColumn<?, ?> col_date_fin;
     @FXML
    private TableColumn<?, ?> col_date_fin1;
      @FXML
   private  AnchorPane afficher;
  
   @FXML
   private  DatePicker date;
   

    @FXML
    private Button btn_valider;

    @FXML
    private Button btn_afficher;
   
    Stage stage1 = new Stage ();
   
    Stage stage2 = new Stage ();
   static int id=j;
    
    
    public void combo(){
     
      ResevationDAO dao = new ResevationDAO() ;
     
       List <Propriete> l = new ArrayList() ;
       l=dao.getListProprieteByUser(id);
       
        for (int i=0 ;i<l.size();i++){
       
           cPropriete.getItems().addAll(l.get(i).getVille());
           cRue.getItems().addAll(l.get(i).getRue());
        } 
    
     
    }
   
   
   
   @FXML
    private void handleButtonRefuserAction(ActionEvent event) {
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
    //  if ( java.sql.Date.valueOf( date.getValue() )!=null ){
      
    //  LoadDataReservationByDate();
    //  data1 = FXCollections.observableArrayList();
    // setCellTable();
    // LoadData();
     // }
     
    
       Resrevation e= tab_reservation.getSelectionModel().getSelectedItem();
    if (e==null) {
             
                Alert alert = new Alert(Alert.AlertType.WARNING);
                 alert.setTitle("Warning Dialog");
                alert.setHeaderText(null);
                alert.setContentText("selectionner une reservation svp!");

                alert.showAndWait();
               LoadData();
              setCellTable();
              }
    
    else {
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                 alert.setTitle("Confiramtion");
                alert.setHeaderText(null);
                alert.setContentText("vous etes sur de supprimer cette reservation");
Optional<ButtonType> answer =alert.showAndWait();

            if (answer.get() == ButtonType.OK) {
   ResevationDAO dao = new ResevationDAO() ;
              dao.delete(e);
                    LoadData();
              setCellTable();
            }
            
            else { 
              LoadData();
              setCellTable();
            }
            }
    
    
    
    
    }
    
   @FXML
    private void   handleButtonListAction(ActionEvent event) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("FXMLHost.fxml"));
        Stage stage = new Stage ();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();}
    
    @FXML
    private void handleButtonValiderAction(ActionEvent event) throws FileNotFoundException, DocumentException {
     Resrevation e= tab_reservation.getSelectionModel().getSelectedItem();
    if (e==null) {
             
                Alert alert = new Alert(Alert.AlertType.WARNING);
                 alert.setTitle("Warning Dialog");
                alert.setHeaderText(null);
                alert.setContentText("selectionner un demande de  reservation a traiter svp!");

                alert.showAndWait();
                LoadData();
              setCellTable();
              }
    
    else {
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                 alert.setTitle("Confiramtion");
                alert.setHeaderText(null);
                alert.setContentText("vous etes sur d'accepter cette demande de reservation");
Optional<ButtonType> answer =alert.showAndWait();

            if (answer.get() == ButtonType.OK) {
   ResevationDAO dao = new ResevationDAO() ;
            if  ( dao.ajouter_Reservation(e)){
            
              LoadData();
              setCellTable();
           
              
                 alert.setTitle("Success Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Demandes accepter avec success");

                alert.showAndWait();
              
              
              
              
              try {
              
              Document d = new Document (PageSize.A4.rotate());
            PdfWriter.getInstance(d,new FileOutputStream(e.getUser().getNom()+"Facture.pdf"));
            d.open();
            
            d.add(new Paragraph("BeMyGuest Facture :",FontFactory.getFont(FontFactory.TIMES_BOLD, 18,Font.BOLD,BaseColor.RED)));
             d.add(new Paragraph(new Date ().toString()));
            d.add(new Paragraph("-------------------------------------------------------------------------------------------------------------"));
             d.add(new Paragraph("             "));
              d.add(new Paragraph("             "));
             PdfPTable pdt = new  PdfPTable (7);                  
              PdfPCell cell = new PdfPCell (new Paragraph("Composant de facture"));
              cell.setColspan(7);
              cell.setHorizontalAlignment(Element.ALIGN_CENTER);
              cell.setBackgroundColor(BaseColor.RED);
              pdt.addCell(cell);
             
              pdt.addCell(new Paragraph("Nom:",FontFactory.getFont(FontFactory.TIMES_BOLD, 8,Font.BOLD,BaseColor.BLACK)));
             pdt.addCell(new Paragraph("Prenom:",FontFactory.getFont(FontFactory.TIMES_BOLD, 8,Font.BOLD,BaseColor.BLACK)));  
            pdt.addCell(new Paragraph("Date Debut:",FontFactory.getFont(FontFactory.TIMES_BOLD, 8,Font.BOLD,BaseColor.BLACK)));
           pdt.addCell(new Paragraph("Date Fin:",FontFactory.getFont(FontFactory.TIMES_BOLD, 8,Font.BOLD,BaseColor.BLACK)));
           pdt.addCell(new Paragraph("nbre chambre:",FontFactory.getFont(FontFactory.TIMES_BOLD, 8,Font.BOLD,BaseColor.BLACK)));
             pdt.addCell(new Paragraph("nbre personne:",FontFactory.getFont(FontFactory.TIMES_BOLD, 8,Font.BOLD,BaseColor.BLACK))); 
          pdt.addCell(new Paragraph("Prix:",FontFactory.getFont(FontFactory.TIMES_BOLD, 8,Font.BOLD,BaseColor.BLACK)));
           pdt.addCell(new Paragraph(e.getUserDemandant().getNom(),FontFactory.getFont(FontFactory.TIMES_BOLD, 8,Font.BOLD,BaseColor.BLACK)));
             pdt.addCell(new Paragraph(e.getUserDemandant().getPrenom(),FontFactory.getFont(FontFactory.TIMES_BOLD, 8,Font.BOLD,BaseColor.BLACK)));
            pdt.addCell(new Paragraph(e.getDateDebut().toString(),FontFactory.getFont(FontFactory.TIMES_BOLD, 8,Font.BOLD,BaseColor.BLACK)));
          pdt.addCell(new Paragraph(e.getDateFin().toString(),FontFactory.getFont(FontFactory.TIMES_BOLD, 8,Font.BOLD,BaseColor.BLACK)));  pdt.addCell(e.getDateDebut().toString());  
           
      
          int nb= e.getPropriete().getNbrChambre();
         
         
           float pr= e.getPropriete().getPrix();
         int nbp = e.getPropriete().getNbrVoyageur();
          pdt.addCell(new Paragraph(Integer.toString(nb),FontFactory.getFont(FontFactory.TIMES_BOLD, 8,Font.BOLD,BaseColor.BLACK)));
          pdt.addCell(new Paragraph(Integer.toString(nbp),FontFactory.getFont(FontFactory.TIMES_BOLD, 8,Font.BOLD,BaseColor.BLACK)));
           pdt.addCell(new Paragraph(Float.toString(pr),FontFactory.getFont(FontFactory.TIMES_BOLD, 8,Font.BOLD,BaseColor.BLACK)));
            
           pdt.addCell(Float.toString(pr)); 
          
            
            d.add(pdt);
          d.close();
            }
            catch (Exception b){
                
                JOptionPane.showMessageDialog(null, b);
            }}
            else {
              alert.setTitle("Error Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Cette Propriete Reserver pendant cette date ");

                alert.showAndWait();
                
                LoadData();
              setCellTable();
            }
            }
           
            
            else { 
               LoadData();
              setCellTable();
            }
            }
    
    }
    
    
    @FXML
    private void handleButtonAffficherDetailleAction(ActionEvent event){
     Resrevation e= tab_reservation.getSelectionModel().getSelectedItem();
    if (e==null) {
             
                Alert alert = new Alert(Alert.AlertType.WARNING);
                 alert.setTitle("Warning Dialog");
                alert.setHeaderText(null);
                alert.setContentText("selectionner une reservation svp!");

                alert.showAndWait();
                LoadData();
              setCellTable();
              }
    else {
  ResevationDAO dao = new ResevationDAO() ;
  Resrevation r=dao.demandrReservationById(e.getId_r());
    
  label_nom.setText("Nom :"+r.getUser().getNom());
     label_prenom.setText("Prenom :"+r.getUser().getPrenom());
     label_des.setText("Description de Hot :"+r.getPropriete().getDescription());
      label_cat.setText("Categorie de Hot :"+r.getPropriete().getCategoriePropriete());
     label_ville.setText("Ville de Hot :"+r.getPropriete().getVille());
    }
    }
   @FXML  
  private void  handleButtonTraiterAction(ActionEvent event)throws Exception{         
    
                   
             //         afficher.getChildren().setAll( (AnchorPane) FXMLLoader.load(getClass().getResource("FXMLHost.fxml")));
 //setDataPane(fadeAnimate("FXMLHost.fxml"));
          // FileChooser fileChooser = new FileChooser();  
    Parent root = FXMLLoader.load(getClass().getResource("/bemyguest/gui/ValidationRFXML.fxml"));
     
        Scene scene = new Scene(root);
        
        stage1.setScene(scene);
        stage1.show();
  
  
  }
  
     @FXML  
  private void  handleButtonConsulterAction(ActionEvent event)throws Exception{         
    
                   
             //         afficher.getChildren().setAll( (AnchorPane) FXMLLoader.load(getClass().getResource("FXMLHost.fxml")));
 //setDataPane(fadeAnimate("FXMLHost.fxml"));
          // FileChooser fileChooser = new FileChooser();  
    Parent root = FXMLLoader.load(getClass().getResource("/bemyguest/gui/FXMLHost.fxml"));
        
        Scene scene = new Scene(root);
        
        stage2.setScene(scene);
        stage2.show();
      
  
  }
  
  
  
  
  
  @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     data = FXCollections.observableArrayList();
       data1 = FXCollections.observableArrayList();
    LoadData();
    setCellTable();
    
    
    }    
    
private void setCellTable() {
        col10_id.setCellValueFactory(new PropertyValueFactory<>("id_r"));
        coll_date_debut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
       col_date_fin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
       coll_date_debut1.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
       col_date_fin1.setCellValueFactory(new PropertyValueFactory<>("dateFin"));

 

}




private void LoadData() {
        data.clear();
        data1.clear();
       List <Resrevation>  l ;      
        List <Resrevation>  l2 ;   
       ResevationDAO rdao = new  ResevationDAO() ;
       l=rdao.getListDemandReservation(j);
     l2=rdao.getListReservationTraiter(j);
           
     
           
     
              
   
             
             for (int i=0 ; i<l.size();i++){
      
                data.add(new Resrevation(l.get(i).getUser(),l.get(i).getUserDemandant(),l.get(i).getId_r(), l.get(i).getPropriete(), l.get(i).getDateDebut(), l.get(i).getDateFin(),l.get(i).getEtat()));

           
       }
      
            
          
          
            
             for (int i=0 ; i<l2.size();i++){
                  System.out.println("hello");
                data1.add(new Resrevation(l2.get(i).getUser(),l2.get(i).getUserDemandant(),l2.get(i).getId_r(), l2.get(i).getPropriete(), l2.get(i).getDateDebut(), l2.get(i).getDateFin(),l2.get(i).getEtat()));

           
       }
            
             
       
                    
             
         tab_reservation.setItems(data);
        tab_reservation_finis.setItems(data1);   
               
             

      
       
    }

 private void LoadDataReservation() {
        data.clear();
       
       List <Resrevation>  l ;      
        List <Resrevation>  l2 ;   
       ResevationDAO rdao = new  ResevationDAO() ;
     
     l2=rdao.tousLesReservation();
         for (int i=0 ; i<l2.size();i++){
         
                data1.add(new Resrevation(l2.get(i).getId_r(), l2.get(i).getUser(), l2.get(i).getPropriete(), l2.get(i).getDateDebut(), l2.get(i).getDateFin()));

           
       }
   
      
       
         tab_reservation_finis.setItems(data1);
    }
private void LoadDataReservationDemande() {
        data.clear();
       
     
        List <Resrevation>  l2 ;   
       ResevationDAO rdao = new  ResevationDAO() ;
     
     l2=rdao.tousLesReservation();
         for (int i=0 ; i<l2.size();i++){
         
                data.add(new Resrevation(l2.get(i).getUser(),l2.get(i).getUserDemandant(), l2.get(i).getId_r(),l2.get(i).getPropriete(), l2.get(i).getDateDebut(), l2.get(i).getDateFin(),l2.get(i).getEtat()));

           
       }
   
      
       
         tab_reservation.setItems(data);
    }
 public void setDataPane(Node node) {
        
       afficher.getChildren().setAll(node);
    }
      public Pane fadeAnimate(String url) throws IOException {
       Pane v = (Pane) FXMLLoader.load(getClass().getResource(url));
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(v);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
        return v;
    }

 private void LoadDataReservationByDate( ) {
       // data1.clear();
      
       List <Resrevation>  l ;      
        List <Resrevation>  l2 ;   
       ResevationDAO rdao = new  ResevationDAO() ;
     
     l2=rdao.getListReservationSelonDate( java.sql.Date.valueOf( date.getValue() ), 1);
         for (int i=0 ; i<l2.size();i++){
         
                data1.add(new Resrevation(l2.get(i).getId_r(), l2.get(i).getUser(), l2.get(i).getPropriete(), l2.get(i).getDateDebut(), l2.get(i).getDateFin()));

           
       }
   
      
       
         tab_reservation_finis.setItems(data1);
    }


 @FXML
    private void handleButtonAffficherrDetailleAction() {    
       
        
        tab_reservation.setOnMouseClicked((MouseEvent e) -> {
         Resrevation e1= tab_reservation.getSelectionModel().getSelectedItem();
    if (e==null) {
             
                Alert alert = new Alert(Alert.AlertType.WARNING);
                 alert.setTitle("Warning Dialog");
                alert.setHeaderText(null);
                alert.setContentText("selectionner une reservation svp!");

                alert.showAndWait();
             //   LoadData();
              setCellTable();
              }

  ResevationDAO dao = new ResevationDAO() ;
  Resrevation r=dao.ReservationById(e1.getId_r());
     PaneDetails.setVisible(true);
   FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(PaneDetails);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    
     
     label_nom.setText("Nom :"+r.getUserDemandant().getNom());
     label_prenom.setText("Prenom :"+r.getUserDemandant().getPrenom());
     label_des.setText("Description de Hot :"+r.getPropriete().getDescription());
      label_cat.setText("Categorie de Hot :"+r.getPropriete().getCategoriePropriete());
     label_ville.setText("Ville de Hot :"+r.getPropriete().getVille());
        
        });
 }
   @FXML
   private void handleButtonChercherAction(ActionEvent event) {
     data = FXCollections.observableArrayList();
       data1 = FXCollections.observableArrayList();
     LoadData();
    setCellTable();
       
     
    }


private void LoadDatad() {
        data.clear();
        data1.clear();
       List <Resrevation>  l ;      
        List <Resrevation>  l2 ;   
       ResevationDAO rdao = new  ResevationDAO() ;
       l=rdao.getListDemandReservation(j);
     l2=rdao.getListReservationTraiter(j);
         for (int i=0 ; i<l.size();i++){
      
                data.add(new Resrevation(l.get(i).getUser(),l.get(i).getUserDemandant(),l.get(i).getId_r(), l.get(i).getPropriete(), l.get(i).getDateDebut(), l.get(i).getDateFin(),l.get(i).getEtat()));

           
       }
     for (int i=0 ; i<l2.size();i++){
         
                data1.add(new Resrevation(l2.get(i).getUser(),l2.get(i).getUserDemandant(),l2.get(i).getId_r(), l2.get(i).getPropriete(), l2.get(i).getDateDebut(), l2.get(i).getDateFin(),l2.get(i).getEtat()));

           
       }

      
        tab_reservation.setItems(data);
         tab_reservation_finis.setItems(data1);
    }






}
