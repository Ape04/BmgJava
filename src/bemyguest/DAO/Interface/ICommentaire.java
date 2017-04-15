/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bemyguest.DAO.Interface;

import bemyguest.entities.Commentaire;
import java.util.List;


public interface ICommentaire {
    public void addComment(Commentaire commentaire);
    public boolean deleteComment(int id_comm);
    public List<Commentaire> retriveComment();
     
}
