/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bemyguest.DAO.Interface;

import java.util.List;






/**
 *
 * @author LENOVO
 */
public interface IRelamationDAO <Reclamation> {
    
        public void ajouterReclamation (Reclamation r) ;
        public boolean DeleteReclamationById(int id_rec);
        public List<Reclamation> afficherReclamation();
        boolean updateReclamation(Reclamation r);
        
}
