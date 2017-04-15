/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bemyguest.DAO.Interface;


import bemyguest.entities.User;
import java.util.List;

/**
 *
 * @author Haroun
 */
public interface IUser {
    public boolean deleteUser(int id_u);
    public List<User> retriveUser();
    public User retrieveAdminById(int id_u);
    public boolean updateUser(User user);
    public void inscriptionUser(User user);
    public void insertAdmin(User user);
    public User retrieveAdminByLogin(String login) ;
    public int retrieveUserByLogin(String login);
}
