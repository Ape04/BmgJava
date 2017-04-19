/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.DAO.Interface;

import bemyguest.entities.HistoriquePropriete;
import bemyguest.entities.Propriete;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Daly
 */
public interface IProprieteCrud {
    public boolean addPropriete(Propriete p,HistoriquePropriete hprop);
    public boolean updatePropriete(Propriete p/*,HistoriquePropriete hprop*/);
    public boolean deletePropriete(int id);
   
    public List<Propriete> getAllProprietes();
    public List<Propriete> getAllUserProprietes(int id_u);
    public List<HistoriquePropriete> getAllHistoriqueProprietes();
    public Propriete getProprieteById(int id);
    public HistoriquePropriete getHistoriqueProprieteById(int id);

    
    
}
