/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.DAO.Interface;

import bemyguest.entities.HistoriqueImage;
import bemyguest.entities.Image;
import java.util.List;


/**
 *
 * @author Daly
 */
public interface IImagePropriete {

    public boolean addImage(Image i, HistoriqueImage historiqueImage);

    public boolean updateImage(Image i, HistoriqueImage historiqueImage);

    public boolean deleteImageByUrl(String URL);

    public boolean deleteImageById(int id);

    public List<Image> getAllImages();

    public List<HistoriqueImage> getAllHistriqueImages();

    public Image getImageByURL(String URL);

    public HistoriqueImage getHistoriqueImageByURL(String URL);

    public Image getImageById(int id);
        public HistoriqueImage getHistoriqueImageById(int id);

    

}
