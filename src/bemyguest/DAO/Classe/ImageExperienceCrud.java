package bemyguest.DAO.Classe;

import bemyguest.DAO.Interface.IImageExperience;
import bemyguest.config.ConnectionDB;
import bemyguest.entities.Experience;
import bemyguest.entities.ImageExperience;
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
public class ImageExperienceCrud implements IImageExperience {
    Connection connexion = ConnectionDB.getConnexion();
    

    @Override
    public boolean addImageExperience(ImageExperience ix) {
        String query = "INSERT INTO imageexperience (url_xp,id_xp) VALUES (?,?)";

        try {

            PreparedStatement pst = connexion.prepareStatement(query);
            pst.setString(1, ix.getUrl_xp());
            pst.setInt(2, ix.getExp().getId_xp());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ImageExperienceCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean updateImageExperience(ImageExperience ix) {
        String query = "UPDATE imageexperience SET Url_xp=?";

        try {
            PreparedStatement pst = connexion.prepareStatement(query);
            pst.setString(1, ix.getUrl_xp());
            pst.setInt(2, ix.getExp().getId_xp());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ImageExperienceCrud.class.getName()).log(Level.SEVERE, null, ex);
        }return false;   
    }

    @Override
    public boolean deleteImageExperienceById(int id_ixp) {
try {
            String query = "DELETE from imageexperience WHERE id_ixp=?";
            PreparedStatement pst = connexion.prepareStatement(query);
            pst.setInt(1, id_ixp);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ImageExperienceCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<ImageExperience> getAllImagesExperience() {
List<ImageExperience> imagesExp = new ArrayList();

        try {
            
            
            String query = "SELECT * from imageexperience";
            PreparedStatement pst = connexion.prepareStatement(query);
            
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                ImageExperience imageExp = new ImageExperience();
                imageExp.setUrl_xp(res.getString("Url_xp"));
                Experience exp = new Experience();
                ExperienceDAO expC=new ExperienceDAO();
                int i = res.getInt("id_xp");
                exp=expC.getExperienceById(i);
                
                imageExp.setExp(exp);
                
                
            }
            return imagesExp;
        } catch (SQLException ex) {
            Logger.getLogger(ImageExperienceCrud.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ImageExperience getImageExperienceById(int id_ixp) {
        ImageExperience image = null;
        try {

            String query = "select * from imageexperience where id_ixp=?";
            PreparedStatement pst = connexion.prepareStatement(query);
            pst.setInt(1, id_ixp);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                image.setUrl_xp(res.getString("Url_xp"));
                Experience exp = new Experience();
                ExperienceDAO ec = new ExperienceDAO();
                int i = res.getInt("id_xp");
                exp= ec.getExperienceById(i);
                image.setExp(exp);

            }
            return image;
        } catch (SQLException ex) {
            Logger.getLogger(ImageExperienceCrud.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}