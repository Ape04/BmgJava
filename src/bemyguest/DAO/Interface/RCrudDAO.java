/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.DAO.Interface;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author HP
 */
public interface RCrudDAO <T> {
    

public boolean ajouter_Reservation (T t);
public boolean delete (T t );
public boolean update ( T t );
public List getListReservation (T t);
public List getListReservationSelonDate (Date date , int id);
public void inserer ( T t );
public  List getListProprieteSansReservation ();
public List proprieteLibre (Date date_Debut , Date date_Fin );
public  List tousLesReservation ();
public List listReservationParId (int id );
public T ReservationById (int id );
public boolean deleteDemandeReservation (T t );
public List getListDemandReservation (int id);
public T demandrReservationById (int id );
public List getListReservationTraiter (int d);
public boolean deleteDemande ();
public List getListProprieteByUser (int id);
public List getListReservationByPropriete (int id);
public List Test (Date date_Debut,Date date_Fin);

}
