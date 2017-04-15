package bemyguest.DAO.Classe;

import bemyguest.DAO.Interface.IImagePropriete;
import bemyguest.config.ConnectionDB;
import bemyguest.entities.HistoriqueImage;
import bemyguest.entities.Image;
import bemyguest.entities.Propriete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Daly
 */
public class ImageProrieteCRUD implements IImagePropriete {

    Connection connexion = ConnectionDB.getConnexion();
    @Override
    public boolean addImage(Image i,HistoriqueImage historiqueImage) {
        String query = "INSERT INTO imagepropriete (URL,id_p) VALUES (?,?)";
        String query1 = "INSERT INTO historiqueimagepropriete (URL,id_p) VALUES (?,?)";

        try {
            PreparedStatement pst = connexion.prepareStatement(query);
            PreparedStatement pst1 = connexion.prepareStatement(query);

            pst.setString(1, i.getUrl());
            pst.setInt(2,i.getPropriete().getId());
            pst.executeUpdate();
             pst1.setString(1, historiqueImage.getUrl());
            pst1.setInt(2,historiqueImage.getPropriete().getId());
            pst1.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ImageProrieteCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean updateImage(Image i,HistoriqueImage historiqueImage) {
        try {
            String query = "UPDATE imagepropriete SET URL=?";
                        String query1 = "UPDATE historiqueimagepropriete SET URL=?";

            PreparedStatement pst = connexion.prepareStatement(query);
            pst.setString(1, i.getUrl());
            pst.setInt(2, i.getPropriete().getId());
            pst.executeUpdate();
            
            PreparedStatement pst1 = connexion.prepareStatement(query1);
            pst1.setString(1, historiqueImage.getUrl());
            pst1.setInt(2, historiqueImage.getPropriete().getId());
            pst1.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ImageProrieteCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean deleteImageByUrl(String URL) {
        try {
            String query = "DELETE from imagepropriete WHERE URL=?";
            PreparedStatement pst = connexion.prepareStatement(query);
            pst.setString(1, URL);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ImageProrieteCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteImageById(int id) {
        try {
            String query = "DELETE from imagepropriete WHERE id=?";
            PreparedStatement pst = connexion.prepareStatement(query);
            pst.setInt(1, id);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ImageProrieteCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public List<Image> getAllImages() {
        List<Image> images = new ArrayList();

        try {
            String query = "SELECT * from imagepropriete";
            PreparedStatement pst = connexion.prepareStatement(query);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                Image image = new Image();
                image.setUrl(res.getString("URL"));
               Propriete prop = new Propriete();
               ProprieteCrud pc = new ProprieteCrud();
               int i = res.getInt("id_p");
               prop=pc.getProprieteById(i);
               image.setPropriete(prop);
               
               
                images.add(image);
            }
            return images;

        } catch (SQLException ex) {
            Logger.getLogger(ImageProrieteCRUD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        

    }

    @Override
    public Image getImageByURL(String URL) {
        Image image=null;
        List<Image> Images= this.getAllImages();
        int i=0;
        while(true){
            if(Images.get(i).getUrl().equals(URL)){
                return Images.get(i);
            }
        }
        
        
    }

    @Override
    public Image getImageById(int id) {
        Image image = null;
        try {
            
            String query = "select * from imagepropriete where id=?";
            PreparedStatement pst = connexion.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                image.setUrl(res.getString("URL"));
              Propriete prop = new Propriete();
               ProprieteCrud pc = new ProprieteCrud();
               int i = res.getInt("id_p");
               prop=pc.getProprieteById(i);
               image.setPropriete(prop);
                
            }
            return image;
        } catch (SQLException ex) {
            Logger.getLogger(ImageProrieteCRUD.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
        }
        
    }

    
    @Override
    public List<HistoriqueImage> getAllHistriqueImages() {
    List<HistoriqueImage> historiqueImages = new ArrayList();

        try {
            String query = "SELECT * from historiqueimagepropriete";
            
            PreparedStatement pst = connexion.prepareStatement(query);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                HistoriqueImage historiqueImage = new HistoriqueImage();
                historiqueImage.setUrl(res.getString("URL"));
                Propriete prop = new Propriete();
               ProprieteCrud pc = new ProprieteCrud();
               int i = res.getInt("id_p");
               prop=pc.getProprieteById(i);
               historiqueImage.setPropriete(prop);

                historiqueImages.add(historiqueImage);
            }
            return historiqueImages;

        } catch (SQLException ex) {
            Logger.getLogger(ImageProrieteCRUD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }    }

    @Override
    public HistoriqueImage getHistoriqueImageByURL(String URL) {
          HistoriqueImage historiqueImage=null;
        List<HistoriqueImage> historiqueImages= this.getAllHistriqueImages();
        int i=0;
        while(true){
            if(historiqueImages.get(i).getUrl().equals(URL)){
                return historiqueImages.get(i);
            }
        }
        
    }

    @Override
    public HistoriqueImage getHistoriqueImageById(int id) {
         HistoriqueImage historiqueImage = null;
        try {
            
            String query = "select * from historiqueimagepropriete where id=?";
            PreparedStatement pst = connexion.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                historiqueImage.setUrl(res.getString("URL"));
              Propriete prop = new Propriete();
               ProprieteCrud pc = new ProprieteCrud();
               int i = res.getInt("id_p");
               prop=pc.getProprieteById(i);
               historiqueImage.setPropriete(prop);
                
            }
            return historiqueImage;
        } catch (SQLException ex) {
            Logger.getLogger(ImageProrieteCRUD.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
        }
    }
    

}
