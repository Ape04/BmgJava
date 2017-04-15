package bemyguest.DAO.Classe;

import bemyguest.config.ConnectionDB;
import bemyguest.entities.Message;
import bemyguest.entities.User;
import bemyguest.DAO.Interface.IMessageDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO implements IMessageDAO<Message>{
    Connection connexion = ConnectionDB.getConnexion();


    @Override
    public void insertMsg(Message msg) {
        String req="INSERT INTO message (contenu,id_e,id_r,date) VALUES(?,?,?,?)";

        try {
           PreparedStatement pst=connexion.prepareStatement(req);
           pst.setString(1,msg.getContenu());
           pst.setInt(2,msg.getUserEmetteur().getId_u());
           pst.setInt(3,msg.getUserRecepteur().getId_u());
           pst.setDate(4, Date.valueOf(LocalDate.now()));
           pst.executeUpdate();
           System.out.println("Insertion avec sucçes");
        } catch (SQLException ex) {
            System.out.println("Echec ! " + ex.getMessage());
        }    }

    @Override
    public void updateMsg(Message msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteMsg(int id_m) {
         String req="delete  from  message where id_m="+id_m; 
        try
        {
           PreparedStatement pst =connexion.prepareStatement(req);
           pst.executeUpdate();
           System.out.println("Message supprime avec sucçes");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression"+ex.getMessage());
    }
    }
    
        @Override
    public void deleteMsgByIDu(int id_e, int id_r) {
         String req="delete  from  message where id_e="+id_e+" and id_r="+id_r; 
        try
        {
           PreparedStatement pst =connexion.prepareStatement(req);
           pst.executeUpdate();
           System.out.println("Message supprime avec sucçes");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression"+ex.getMessage());
    }
    }
    
    
    @Override
    public List<Message> retrieveAllMessages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Message> retrieveMessageByEmetteur(int emetteur) {
        List<Message> listeMsg = new ArrayList<>();
        String req="Select * from message WHERE (id_e="+emetteur+")";
        try {
        Statement statement=connexion.createStatement();
         ResultSet resultat=statement.executeQuery(req);
         while (resultat.next())
         {
             User uEmetteur;
             User uRecepteur;
             UserDAO dao = new UserDAO();
             
         String contenu=resultat.getString(2);
         int id_r= resultat.getInt(4);
         Date date=resultat.getDate(5);
                    uEmetteur = dao.retrieveAdminById(emetteur);
                    uRecepteur = dao.retrieveAdminById(id_r);
                    Message msg=new Message();
                    msg.setId_m(resultat.getInt(1));
                    msg.setContenu(contenu);
                    msg.setUserEmetteur(uEmetteur);
                    msg.setUserRecepteur(uRecepteur);
                    msg.setDate(date);
                    listeMsg.add(msg);
                    
                }
         return listeMsg;
         
    } catch (SQLException ex) {
        System.out.println("erreur lors de la chargement de discusion"+ex.getMessage());
    }
        return null;
    }
    
    @Override
    public List<Message> retrieveMessageByRecepteur(int rec) {
        List<Message> listeMsgs = new ArrayList<>();
        String req="Select * from message WHERE (id_r="+rec+")";
        try {
        Statement statement=connexion.createStatement();
         ResultSet resultat=statement.executeQuery(req);
         while (resultat.next())
         {
             User uEmetteur;
             User uRecepteur;
             UserDAO dao = new UserDAO();
             
             int id_e= resultat.getInt(3);
                    Date date=resultat.getDate(5);
                    uEmetteur = dao.retrieveAdminById(id_e);
                    uRecepteur = dao.retrieveAdminById(rec);
                    
                    Message msg=new Message();
                    msg.setId_m(resultat.getInt(1));
                    msg.setContenu(resultat.getString(2));
                    msg.setUserEmetteur(uEmetteur);
                    msg.setUserRecepteur(uRecepteur);
                    msg.setDate(date);
                    listeMsgs.add(msg);
                }
         return listeMsgs;
    } catch (SQLException ex) {
        System.out.println("erreur lors de la chargement de discusion"+ex.getMessage());
    }
        return null;
    }
    
        @Override
    public List<Message> retrieveMessageByEmetRecep(int emet, int recep) {
        List<Message> listeMsgs = new ArrayList<>();
        //String req="Select * from message WHERE (id_e="+emet+" and id_r="+recep+")";
        String req = " Select * from message where id_e in ("+emet+","+recep+")"+"and id_r in ("+emet+","+recep+")";
        try {
        Statement statement=connexion.createStatement();
         ResultSet resultat=statement.executeQuery(req);
         while (resultat.next())
         {
             User uEmetteur;
             User uRecepteur;
             UserDAO dao = new UserDAO();
             
                    Date date=resultat.getDate(5);
                    uEmetteur = dao.retrieveAdminById(emet);
                    uRecepteur = dao.retrieveAdminById(recep);
                    
                    Message msg=new Message();
                    msg.setId_m(resultat.getInt(1));
                    msg.setContenu(resultat.getString(2));
                    msg.setUserEmetteur(uEmetteur);
                    msg.setUserRecepteur(uRecepteur);
                    msg.setDate(date);
                    listeMsgs.add(msg);
                }
         return listeMsgs;
    } catch (SQLException ex) {
        System.out.println("erreur lors de la chargement de discusion"+ex.getMessage());
    }
        return null;
    }
    
        public static void main(String[]args)
        {
        UserDAO ud=new UserDAO();
        MessageDAO msgDao=new MessageDAO();
        
        Message msg = new Message("tt", ud.retrieveAdminById(1), ud.retrieveAdminById(2), null);
        //msgDao.insertMsg(msg);
        //msgDao.deletChat(18);
        System.out.println(msgDao.retrieveMessageByEmetRecep(5, 1));
        
        }
    
}
