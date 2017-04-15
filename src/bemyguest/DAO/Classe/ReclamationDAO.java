package bemyguest.DAO.Classe;


import bemyguest.DAO.Interface.IRelamationDAO;
import bemyguest.config.ConnectionDB;
import bemyguest.entities.User;
import entites.Reclamation;
import java.sql.Array;
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
 * @author LENOVO
 */
public class ReclamationDAO implements IRelamationDAO<Reclamation>{
    
    Connection connexion = ConnectionDB.getConnexion();

    @Override
    public void ajouterReclamation(Reclamation r) {
        
        String req1= "INSERT INTO reclamation (userReclamant, userReclame, contenu) VALUES (?,?,?)";
        try {
        PreparedStatement pst=connexion.prepareStatement(req1);
            
            pst.setInt(1, r.getUserReclamant().getId_u() );
            pst.setInt(2, r.getUserReclame().getId_u());
            pst.setString(3, r.getContenu());
            pst.executeUpdate();
            System.out.println("ajout");
        } catch (SQLException ex) {
          Logger.getLogger(ReclamationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  public List<Reclamation> afficherReclamation() {
        String req2= "select * from reclamation";
        List<Reclamation> list = new ArrayList();
        try {
             PreparedStatement pst=connexion.prepareStatement(req2);
            ResultSet res  =pst.executeQuery(req2);
            while (res.next()) { 
                
                 User uReclamant = new User();
                 User uReclame = new User();
                 
                 UserDAO dao = new UserDAO();
                 
                 uReclamant = dao.retrieveAdminById(res.getInt(2));
                 uReclame = dao.retrieveAdminById(res.getInt(3));

                    Reclamation r=new Reclamation();
                    r.setId_rec(res.getInt(1));
                    r.setUserReclamant(uReclamant);
                    r.setUserReclame(uReclame);
                    r.setContenu(res.getString(4));
                    
                    list.add(r);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
  }
  
    @Override
 public boolean DeleteReclamationById(int id_rec) {
        boolean testDelete = false;
        String req = "delete from reclamation where id_rec=?";

        try {
            PreparedStatement pst = connexion.prepareStatement(req);
            pst.setInt(1, id_rec);
            int res = pst.executeUpdate();
            if (res != 0) {
                testDelete = true;
                System.out.println("reclamation a été supprimé avec succée 🙂 ");
            }

        } catch (SQLException ex) {

            System.out.println("Echec de suppression ! " + ex.getMessage());
        }
        return testDelete;
    }
  
  
    @Override
    public boolean updateReclamation(Reclamation r) {
        
        boolean testUpdate =false;
        String sql="update reclamation1 set contenu=? where id_rec="+r.getId_rec();

        try {
                PreparedStatement prt=connexion.prepareStatement(sql);
                prt.setString(1,r.getContenu());
                int res=prt.executeUpdate();
        
                    if(res!=0)
                    {
                        testUpdate=true;
                        System.out.println("Mise à jour effectuée avec succès 🙂 ");
                     }

        } catch (SQLException ex) {
            
            System.out.println("Echec de la mise à jour !  " + ex.getMessage());
        }
                        return testUpdate;
        
    }
  
    
        public static void main(String args[]){
            
            ReclamationDAO dao = new ReclamationDAO();
            UserDAO daou = new UserDAO();
            
            User u1 = new User(1, "m", "m", "m", "m", "m");
            User u2 = new User(1, "o", "o", "o", "o", "o");
            Reclamation r = new Reclamation("rrr", daou.retrieveAdminById(1), daou.retrieveAdminById(5));
            //Reclamation r = new Reclamation("rrr", u1, u2);
            dao.ajouterReclamation(r);
            //System.out.println(dao.afficherReclamation());
            dao.DeleteReclamationById(3);
    }



}
    
