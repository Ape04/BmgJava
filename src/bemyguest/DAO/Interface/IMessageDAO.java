package bemyguest.DAO.Interface;


import bemyguest.entities.Message;
import java.util.List;

/**
 *
 * @author Oussaa
 * @param <T>
 */


public interface IMessageDAO <T>{
    public void insertMsg(Message msg);
    public void updateMsg(Message msg);
    public void deleteMsg(int id);
    public List<Message> retrieveAllMessages();
    public List<Message> retrieveMessageByEmetteur(int emetteur);
    public List<Message> retrieveMessageByRecepteur(int rec);
    public List<Message> retrieveMessageByEmetRecep(int emet, int recep);
    public void deleteMsgByIDu(int x, int y);
    
}