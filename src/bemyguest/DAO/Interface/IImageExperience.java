/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.DAO.Interface;

import bemyguest.entities.ImageExperience;
import java.util.List;



/**
 *
 * @author Daly
 */
public interface IImageExperience {
    public boolean addImageExperience(ImageExperience ix);
    public boolean updateImageExperience(ImageExperience ix);
    public boolean deleteImageExperienceById(int id_ixp);
    public List<ImageExperience> getAllImagesExperience();
    public ImageExperience getImageExperienceById(int id_ixp);
    
    
}
