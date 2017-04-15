/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bemyguest.DAO.Interface;


import bemyguest.entities.Experience;
import java.util.List;

/**
 *
 * @author User
 */
public interface InterExperience {
    
     public void ajouterExperience(Experience e);
     public void modifierExperience(int i, Experience ee );
     public void supprimerExperience(int id);
     public Experience getExperienceById(int id_xp);
     public List<Experience> findAll();
    
}
