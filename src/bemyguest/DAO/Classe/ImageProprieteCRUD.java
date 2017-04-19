package bemyguest.DAO.Classe;

import bemyguest.DAO.Interface.IImagePropriete;
import bemyguest.config.ConnectionDB;
import bemyguest.entities.HistoriqueImage;
import bemyguest.entities.ImageProp;
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
public class ImageProprieteCRUD implements IImagePropriete {

    Connection connexion = ConnectionDB.getConnexion();

    @Override
    public boolean addImage(ImageProp i/*,HistoriqueImage historiqueImage*/) {
        String query = "INSERT INTO imagepropriete (URL,id_p) VALUES (?,?)";
//        String query1 = "INSERT INTO historiqueimagepropriete (URL,id_p) VALUES (?,?)";

        try {
            PreparedStatement pst = connexion.prepareStatement(query);
            PreparedStatement pst1 = connexion.prepareStatement(query);

            pst.setString(1, i.getUrl());
            pst.setInt(2, i.getPropriete().getId());
            pst.executeUpdate();
//             pst1.setString(1, historiqueImage.getUrl());
//            pst1.setInt(2,historiqueImage.getPropriete().getId());
//            pst1.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ImageProprieteCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean updateImage(ImageProp i) {

           String query="update imagepropriete set url=?, id_p=? where id_i=? ";        

        try {
            PreparedStatement pst = connexion.prepareStatement(query);
            pst.setInt(3, i.getId());
            pst.setString(1, i.getUrl());
            pst.setInt(2, i.getPropriete().getId());
            pst.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ImageProprieteCRUD.class.getName()).log(Level.SEVERE, null, ex);

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
            Logger.getLogger(ImageProprieteCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteImageById(int id) {
        try {
            String query = "DELETE from imagepropriete WHERE id_i=?";
            PreparedStatement pst = connexion.prepareStatement(query);
            pst.setInt(1, id);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ImageProprieteCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public List<ImageProp> getAllImages() {
        List<ImageProp> images = new ArrayList();

        try {
            String query = "SELECT * from imagepropriete";
            PreparedStatement pst = connexion.prepareStatement(query);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                ImageProp image = new ImageProp();
                image.setId(res.getInt("id"));
                image.setUrl(res.getString("URL"));
                Propriete prop = new Propriete();
                ProprieteCrud pc = new ProprieteCrud();
                int i = res.getInt("id_p");
                prop = pc.getProprieteById(i);
                image.setPropriete(prop);

                images.add(image);
            }
            return images;

        } catch (SQLException ex) {
            Logger.getLogger(ImageProprieteCRUD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ImageProp getImageByURL(String URL) {
        ImageProp image = null;
        List<ImageProp> Images = this.getAllImages();
        int i = 0;
        while (true) {
            if (Images.get(i).getUrl().equals(URL)) {
                return Images.get(i);
            }
        }

    }

    @Override
    public ImageProp getImageById(int id_i) {
        ImageProp image = new ImageProp();
        try {

            String query = "select * from imagepropriete where id_i=?";
            PreparedStatement pst = connexion.prepareStatement(query);
            pst.setInt(1, id_i);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                image.setId(res.getInt("id_i"));
                image.setUrl(res.getString("url"));
                Propriete prop = new Propriete();
                ProprieteCrud pc = new ProprieteCrud();
                int i = res.getInt("id_p");
                prop = pc.getProprieteById(i);
                image.setPropriete(prop);
            }
            return image;
        } catch (SQLException ex) {
            Logger.getLogger(ImageProprieteCRUD.class.getName()).log(Level.SEVERE, null, ex);
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
            while (res.next()) {
                HistoriqueImage historiqueImage = new HistoriqueImage();
                historiqueImage.setUrl(res.getString("URL"));
                Propriete prop = new Propriete();
                ProprieteCrud pc = new ProprieteCrud();
                int i = res.getInt("id_p");
                prop = pc.getProprieteById(i);
                historiqueImage.setPropriete(prop);

                historiqueImages.add(historiqueImage);
            }
            return historiqueImages;

        } catch (SQLException ex) {
            Logger.getLogger(ImageProprieteCRUD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public HistoriqueImage getHistoriqueImageByURL(String URL) {
        HistoriqueImage historiqueImage = null;
        List<HistoriqueImage> historiqueImages = this.getAllHistriqueImages();
        int i = 0;
        while (true) {
            if (historiqueImages.get(i).getUrl().equals(URL)) {
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
                prop = pc.getProprieteById(i);
                historiqueImage.setPropriete(prop);

            }
            return historiqueImage;
        } catch (SQLException ex) {
            Logger.getLogger(ImageProprieteCRUD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<ImageProp> getImagesByProp(int id_p) {
        List<ImageProp> images = new ArrayList();

        try {

            String query = "select * from imagepropriete where id_p=?";
            PreparedStatement pst = connexion.prepareStatement(query);
            pst.setInt(1, id_p);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                ImageProp image = new ImageProp();
                image.setId(res.getInt("id_i"));
                image.setUrl(res.getString("url"));
                Propriete prop = new Propriete();
                ProprieteCrud pc = new ProprieteCrud();
                int i = res.getInt("id_p");
                prop = pc.getProprieteById(i);
                image.setPropriete(prop);
                images.add(image);
            }
            return images;
        } catch (SQLException ex) {
            Logger.getLogger(ImageProprieteCRUD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ImageProp getImageByProp(int id_p) {
        ImageProp image = new ImageProp();
        try {

            String query = "select * from imagepropriete where id_p=?";
            PreparedStatement pst = connexion.prepareStatement(query);
            pst.setInt(1, id_p);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                image.setUrl(res.getString("url"));
                Propriete prop = new Propriete();
                ProprieteCrud pc = new ProprieteCrud();
                int i = res.getInt("id_p");
                prop = pc.getProprieteById(i);
                image.setPropriete(prop);

            }
            return image;
        } catch (SQLException ex) {
            Logger.getLogger(ImageProprieteCRUD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
