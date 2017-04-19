/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.DAO.Interface;

import bemyguest.entities.HistoriqueImage;
import bemyguest.entities.ImageProp;
import java.util.List;


/**
 *
 * @author Daly
 */
public interface IImagePropriete {

    public boolean addImage(ImageProp i);

    public boolean updateImage(ImageProp i/*, HistoriqueImage historiqueImage*/);

    public boolean deleteImageByUrl(String URL);

    public boolean deleteImageById(int id);

    public List<ImageProp> getAllImages();

    public List<HistoriqueImage> getAllHistriqueImages();

    public ImageProp getImageByURL(String URL);

    public HistoriqueImage getHistoriqueImageByURL(String URL);

    public ImageProp getImageById(int id);
        public HistoriqueImage getHistoriqueImageById(int id);
        public List<ImageProp> getImagesByProp(int id_p);
        public ImageProp getImageByProp(int id_p);

    

}
