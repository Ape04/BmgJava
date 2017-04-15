/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.DAO.Interface;

import bemyguest.entities.Favoris;
import bemyguest.entities.Message;
import bemyguest.entities.User;
import java.util.List;


/**
 *
 * @author Oussaa
 */
public interface IFavorisDAO {
    
    public void insertFavoris(Favoris favoris);

    public void deleteFavoris(int id);
    
    public void deleteFavoris(Favoris favoris);

    public void updateFavoris(Favoris favoris);

    public Favoris retrieveFavorisById(int id);
    
    public List<Favoris> retrieveFavorisByIdUser(int id_u);

    public List<Favoris> retrieveAll();
    
    public boolean isFavoris(int cin1, int cin2);
    
    public void insertFavorisUser(User u);
    
    
    public void EditAlias(String x, int i);
    
    
    
}
