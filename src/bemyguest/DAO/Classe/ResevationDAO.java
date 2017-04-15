/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bemyguest.DAO.Classe;

import bemyguest.DAO.Interface.RCrudDAO;
import bemyguest.config.ConnectionDB;

import bemyguest.entities.Propriete;
import bemyguest.entities.Resrevation;
import bemyguest.entities.User;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class ResevationDAO implements RCrudDAO<Resrevation > {
  
   
    private PreparedStatement pre;
 static  List<Propriete>proprieteLibre= new ArrayList();
         Connection connexion = ConnectionDB.getConnexion();
     private Statement ste;
   
    /****************************************************Debut De Travaille de Ahmed *************************************************************/    
      
      
 /*******************************Ajouter des Reservation**********************************************************************/     
      
      @Override
    public boolean ajouter_Reservation (Resrevation r) {
   List<Resrevation>  l=  this.getListReservation(r);
     long deff= r.getDateFin().getTime()-r.getDateDebut().getTime();
     if (l.isEmpty()) {   
          
           this.update(r);
      //  this.inserer(r);
 return true ;}
  
   
   
   for( int i=0 ; i<l.size();i++ ){
     
      if (r.equals(l.get(i))||( r.getDateDebut().compareTo(l.get(i).getDateFin())==0||( r.getDateDebut().compareTo(l.get(i).getDateDebut())==0))){
      return false;
      
      }
     if (r.getDateDebut().compareTo(l.get((l.size())-1).getDateFin())>0) {   
    // this.inserer(r);
      this.update(r);
    ;return true ;
   }
      
      
     else if (r.getDateDebut().compareTo(l.get(i).getDateFin())>0 && r.getDateFin().compareTo(l.get(i+1).getDateDebut())<0 ){
   
 // this.inserer(r);
     this.update(r);   
      return true ;
     }
 
    else if (r.getDateFin().compareTo(l.get((0)).getDateDebut())<0)  {  
    // this.inserer(r);
       this.update(r);
     return true ;}
 
  
   
   }
   
 
   return false ;
    
     
    }
  /****************************************************************************************************************************/
   
    
    
     /******************************************************Supprimer Reservation ********************************************************************/ 
    
    @Override
    public boolean delete(Resrevation r ) {
       
       
String req="DELETE FROM reservation WHERE id_r='"+r.getId_r()+"'"
;

try {
           
            ste = connexion.createStatement();
            ste.execute(req);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }   
   return true ;
    
    }
  /****************************************************************************************************************************/
    @Override
    public boolean update(Resrevation r) {
    String req="UPDATE  reservation SET etat ='true' WHERE id_r='"+r.getId_r()+"'";
try {
           
            ste = connexion.createStatement();
            ste.execute(req);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }   
   return true ;
        
          
    }
  /****************************************************************************************************************************/
   
    
    
     /*************************************************************List des Reservation *************************************************************/ 
    @Override
    public List getListReservation(Resrevation r1) {
     
       
        List<Resrevation> ListReservation = new ArrayList<>();      
  

   String req ="SELECT *FROM reservation WHERE id_p='"+r1.getPropriete().getId()+"' and etat='true' ORDER BY dateDebut";
      try {
              ste = connexion.createStatement();
            ResultSet res =  ste .executeQuery(req);
          
        
          while (res.next()) {
        Resrevation r = new   Resrevation();
              UserDAO dao = new UserDAO();
          ProprieteCrud daoP = new ProprieteCrud() ;       
                 
            r.setId_r(res.getInt("id_r"));
                            r.setUser(dao.retrieveAdminById(res.getInt("id_u")));
                           r.setPropriete(daoP.getProprieteById(res.getInt("id_p")));
                           r.setUserDemandant(dao.retrieveAdminById(res.getInt("id_u")));
                         r.setEtat(res.getString("etat"));
                        r.setDateDebut(res.getDate("dateDebut")); 
                        r.setDateFin(res.getDate("dateFin"));
                           
                             
        ListReservation.add(r);
        
        }
      } catch (SQLException ex) {
          Logger.getLogger(ResevationDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
   return ListReservation;
    }
  /****************************************************************************************************************************/
    
    
    
    
    /*******************************************************List Des Resrvation par Date *********************************************************************/  
    
    @Override
    public List getListReservationSelonDate(java.util.Date date , int id ) {
     List<Resrevation> ListReservation = new ArrayList<>();      
   
 java.sql.Date sqlDate1 = new java.sql.Date(date.getTime()); 
   
   String req ="SELECT *FROM reservation WHERE dateDebut='"+sqlDate1+"' and id_u='"+id+"'";
      try {
          
          ResultSet res = ste.executeQuery(req);
        while (res.next()) {
       Resrevation r= new Resrevation();
            UserDAO dao = new UserDAO();
          ProprieteCrud daoP = new ProprieteCrud() ;       
                 
                              r.setId_r(res.getInt("id_r"));
                            r.setUser(dao.retrieveAdminById(res.getInt("id_u")));
                           r.setPropriete(daoP.getProprieteById(res.getInt("id_p")));
                             r.setUserDemandant(dao.retrieveAdminById(res.getInt("id_u")));
                        r.setEtat(res.getString("etat")); 

                        r.setDateDebut(res.getDate("dateDebut")); 
                        r.setDateFin(res.getDate("dateFin"));
        ListReservation.add(r);
        
        }
      } catch (SQLException ex) {
          Logger.getLogger(ResevationDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
   return ListReservation;
    }
  /****************************************************************************************************************************/
   
    
    
    
     /**********************************************************Inserer Reservation dans BD****************************************************************/ 
    @Override
    public void inserer(Resrevation r) {
              String req1 = "insert into reservation (dateDebut,dateFin,id_u,id_p) VALUES (?,?,?,?) ";  
       
      try {
        
      java.sql.Date sqlDate1 = new java.sql.Date(r.getDateDebut().getTime()); 
       java.sql.Date sqlDate2 = new java.sql.Date(r.getDateFin().getTime());  
          pre = connexion.prepareStatement(req1);
     pre.setDate(1, sqlDate1);
       pre.setDate(2, sqlDate2);
        
        pre.setInt(3,r.getUser().getId_u());
       pre.setInt(4,r.getPropriete().getId());
      pre.execute();
   
     
      } catch (SQLException ex) {
          Logger.getLogger(ResevationDAO.class.getName()).log(Level.SEVERE, null, ex);
      }  
    }
  /****************************************************************************************************************************/
   
    
    
    
    
     /******************************************************List des Proprietes sans aucune Resrevation **********************************************************************/ 
    
    @Override
    public List getListProprieteSansReservation() {
           
        
        List <Propriete> listPropriete = new ArrayList<>();    
        Propriete p ;
        String req2="Select   *from propriete  where id_p not in ( Select id_p from reservation ) ";
    
  
       try {
           ste = connexion.createStatement();
            ResultSet res =  ste .executeQuery(req2);
         
        while (res.next()) {
       ProprieteCrud daoP = new ProprieteCrud() ; 
          
       p=daoP.getProprieteById(res.getInt("id_p"));
                           
       if ( ! listPropriete.contains(p))
            
            listPropriete.add(p);
        
        }
      } catch (SQLException ex) {
          Logger.getLogger(ResevationDAO.class.getName()).log(Level.SEVERE, null, ex);
      }  
        
        
        
        
        return listPropriete;
    
    }
  /****************************************************************************************************************************/
   
    
    
    
    
    /****************************************Liste De Propriete sans Reservation Selon une Date**********************************************************************/  
    
    @Override
    public List proprieteLibre(Date date_Debut, Date date_Fin) {
    
   List <Propriete> proprieteLibre = new ArrayList ();
      
    return proprieteLibre ;
    
    }
  /****************************************************************************************************************************/
   
    
    
    
   /************************************************Liste Des Toutes les Reservations ****************************************************************************/  
    @Override
    public List tousLesReservation() {
          List<Resrevation> tousLesReservation = new ArrayList<>();      
  
ProprieteCrud daoP = new ProprieteCrud() ; 
          UserDAO dao = new UserDAO(); 
      
   String req ="SELECT *FROM reservation where etat='true' ORDER BY dateDebut ";
      try {
          
            ste = connexion.createStatement();
            ResultSet res =  ste .executeQuery(req);
        while (res.next()) {
        Resrevation r = new Resrevation() ;
            r.setId_r(res.getInt("id_r"));
                             
                
                             r.setUserDemandant(dao.retrieveAdminById(res.getInt("id_u")));
                        r.setEtat(res.getString("etat"));
           
                            r.setUser(dao.retrieveAdminById(res.getInt("id_u")));
                           r.setPropriete(daoP.getProprieteById(res.getInt("id_p")));
                            

                        r.setDateDebut(res.getDate("dateDebut")); 
                        r.setDateFin(res.getDate("dateFin"));
         
        tousLesReservation.add(r);
        
        }

        return tousLesReservation;    
    
     
      
      } catch (SQLException ex) {
          Logger.getLogger(ResevationDAO.class.getName()).log(Level.SEVERE, null, ex);
      return null ;
      
      }
      
       
       
   
    
    }


   
  /***************************************************Liste Des toutes Reservation Pour Une Propriete********************************************************************/
    @Override
    public List listReservationParId(int id) {
      List<Resrevation> ListReservation = new ArrayList<>();      
  
UserDAO dao = new UserDAO();
   ProprieteCrud daoP = new ProprieteCrud();
   String req ="SELECT *FROM reservation WHERE id_p='"+id+"' and  etat='true' ORDER BY dateDebut";
      try {
          
          ste = connexion.createStatement();
            ResultSet res =  ste .executeQuery(req);
        while (res.next()) {
       Resrevation r= new Resrevation() ;
            r.setId_r(res.getInt("id_r"));
                             r.setUser(dao.retrieveAdminById(res.getInt("id_u")));
                           r.setPropriete(daoP.getProprieteById(res.getInt("id_p")));
                            
                            r.setUserDemandant(dao.retrieveAdminById(res.getInt("id_u")));
                        r.setEtat(res.getString("etat"));
                        r.setDateDebut(res.getDate("dateDebut")); 
                        r.setDateFin(res.getDate("dateFin"));
                             
        ListReservation.add(r);
        
        }
      } catch (SQLException ex) {
          Logger.getLogger(ResevationDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
   
       
      return ListReservation; 
    
    
    
    }

    @Override
    public Resrevation ReservationById(int id) {
       //To change body of generated methods, choose Tools | Templates.
 
     
     
  Resrevation r = new  Resrevation();

   String req ="SELECT *FROM reservation WHERE id_r='"+id+"'";
      try {
              ste = connexion.createStatement();
            ResultSet res =  ste .executeQuery(req);
          
        
          while (res.next()) {
        
              UserDAO dao = new UserDAO();
          ProprieteCrud daoP = new ProprieteCrud() ;       
                 
            r.setId_r(res.getInt("id_r"));
                            r.setUser(dao.retrieveAdminById(res.getInt("id_u")));
                           r.setPropriete(daoP.getProprieteById(res.getInt("id_p")));
                            
                             r.setUserDemandant(dao.retrieveAdminById(res.getInt("id_u")));
                         r.setEtat(res.getString("etat"));
                        r.setDateDebut(res.getDate("dateDebut")); 
                        r.setDateFin(res.getDate("dateFin"));
                           
                             
        return r ;
        
        }
      } catch (SQLException ex) {
          Logger.getLogger(ResevationDAO.class.getName()).log(Level.SEVERE, null, ex);
      return null ;
      
      }
   
   
    
      return r ;
    
    
    }

    @Override
    public boolean deleteDemandeReservation(Resrevation r) {
    String req="DELETE FROM demandreservation WHERE id_r='"+r.getId_r()+"'"
;

try {
           
            ste = connexion.createStatement();
            ste.execute(req);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }   
   return true ;
    
    
    
    
    }

    @Override
    public List getListDemandReservation() {
            List<Resrevation> tousLesReservation = new ArrayList<>();      
  
ProprieteCrud daoP = new ProprieteCrud() ; 
          UserDAO dao = new UserDAO(); 
      
   String req ="SELECT *FROM reservation where etat='false' ORDER BY dateDebut ";
      try {
          
            ste = connexion.createStatement();
            ResultSet res =  ste .executeQuery(req);
        while (res.next()) {
        Resrevation r = new Resrevation() ;
            r.setId_r(res.getInt("id_r"));
                             
                
               
           
                            r.setUser(dao.retrieveAdminById(res.getInt("id_u")));
                           r.setPropriete(daoP.getProprieteById(res.getInt("id_p")));
                            

                        r.setDateDebut(res.getDate("dateDebut")); 
                        r.setDateFin(res.getDate("dateFin"));
        
                        
        tousLesReservation.add(r);
        
        }

        return tousLesReservation;    
    
     
      
      } catch (SQLException ex) {
          Logger.getLogger(ResevationDAO.class.getName()).log(Level.SEVERE, null, ex);
      return null ;
      
      }
    
    
    }

    @Override
    public Resrevation demandrReservationById(int id) {
    
    
        
     
  Resrevation r = new  Resrevation();

   String req ="SELECT *FROM reservation WHERE id_r='"+id+"'";
      try {
              ste = connexion.createStatement();
            ResultSet res =  ste .executeQuery(req);
          
        
          while (res.next()) {
        
              UserDAO dao = new UserDAO();
          ProprieteCrud daoP = new ProprieteCrud() ;       
                 
            r.setId_r(res.getInt("id_r"));
                            r.setUser(dao.retrieveAdminById(res.getInt("id_u")));
                           r.setPropriete(daoP.getProprieteById(res.getInt("id_p")));
                             r.setUserDemandant(dao.retrieveAdminById(res.getInt("id_u")));
                        r.setEtat(res.getString("etat"));

                        r.setDateDebut(res.getDate("dateDebut")); 
                        r.setDateFin(res.getDate("dateFin"));
                           
                             
        return r ;
        
        }
      } catch (SQLException ex) {
          Logger.getLogger(ResevationDAO.class.getName()).log(Level.SEVERE, null, ex);
      return null ;
      
      }
   
   
    
      return r ;
    
    
    
    
    }

    @Override
    public List getListReservationTraiter() {
               List<Resrevation> tousLesReservation = new ArrayList<>();      
  
ProprieteCrud daoP = new ProprieteCrud() ; 
          UserDAO dao = new UserDAO(); 
      
   String req ="SELECT *FROM reservation where etat='true' ORDER BY dateDebut ";
      try {
          
            ste = connexion.createStatement();
            ResultSet res =  ste .executeQuery(req);
        while (res.next()) {
        Resrevation r = new Resrevation() ;
            r.setId_r(res.getInt("id_r"));
                             
                
               
           
                            r.setUser(dao.retrieveAdminById(res.getInt("id_u")));
                           r.setPropriete(daoP.getProprieteById(res.getInt("id_p")));
                            

                        r.setDateDebut(res.getDate("dateDebut")); 
                        r.setDateFin(res.getDate("dateFin"));
         
        tousLesReservation.add(r);
        
        }

        return tousLesReservation;    
    
     
      
      } catch (SQLException ex) {
          Logger.getLogger(ResevationDAO.class.getName()).log(Level.SEVERE, null, ex);
      return null ;
      
      }
    }

    @Override
    public boolean deleteDemande( ) {
      List<Resrevation>  l=  this.getListDemandReservation();
      
       
   
   
   for( int i=0 ; i<l.size();i++ ){
     List<Resrevation> l2=this.getListReservation(l.get(i));
    for( int j=0 ; j<l2.size();j++ ){  
      
       if (l.get(i).equals(l2.get(j))||( l.get(i).getDateDebut().compareTo(l2.get(j).getDateFin())==0)||( l.get(i).getDateDebut().compareTo(l2.get(j).getDateDebut())==0)){
      this.delete(l.get(i)); 
      
      }
        
        if (l.get(i).getDateDebut().compareTo(l2.get(j).getDateFin())<0 && l.get(j).getDateFin().compareTo(l2.get(j+1).getDateDebut())>0 ){
   
 // this.inserer(r);
     this.delete(l.get(i));   
      return true ;
     }
        
       else if (l.get(i).getDateDebut().compareTo(l2.get((l2.size())-1).getDateFin())<0) {   
    // this.inserer(r);
      this.delete(l.get(i));
    ;return true ;
   }
      
      
     else if (l.get(i).getDateDebut().compareTo(l2.get(j).getDateFin())<0 && l.get(i).getDateFin().compareTo(l2.get(j+1).getDateDebut())>0 ){
   
 // this.inserer(r);
     this.delete(l.get(i));   
      return true ;
     }
 
    else if (l.get(i).getDateFin().compareTo(l2.get((0)).getDateDebut())>0)  {  
    // this.inserer(r);
      this.delete (l.get(i));
     return true ;}
 
  
   
 
   
 
   return true ;
    }}
  /**}*****************************************la Fin de Travaille de Ahmed **********************************************************************/

return false ;
}

    @Override
    public List getListProprieteByUser(int id) {
         List<Propriete> ListPropriete = new ArrayList<>();      
  

   String req ="SELECT *FROM propriete WHERE id_u='"+id+"'";
      try {
              ste = connexion.createStatement();
            ResultSet res =  ste .executeQuery(req);
          
        
          while (res.next()) {
        Resrevation r = new   Resrevation();
              UserDAO dao = new UserDAO();
          ProprieteCrud daoP = new ProprieteCrud() ;       
                 
           
                           
                             Propriete prop = new Propriete();
                 prop.setId(res.getInt("id_p"));
                prop.setCategoriePropriete(res.getString("CategoriePropriete"));
                prop.setTypePropriete(res.getString("TypePropriete"));
                prop.setPays(res.getString("Pays"));
                prop.setVille(res.getString("Ville"));
                prop.setRue(res.getString("Rue"));
                prop.setPrix(res.getFloat("Prix"));
                prop.setNbrChambre(res.getInt("NbrChambre"));
                prop.setNbrVoyageur(res.getInt("NbrVoyageur"));
                prop.setDescription(res.getString("Description"));
                prop.setAnimaux(res.getBoolean("Animaux"));
                prop.setFumeur(res.getBoolean("Fumeur"));
                prop.setAlcool(res.getBoolean("Alcool"));
                prop.setEnfant(res.getBoolean("Enfant"));
                User user = new User();
              
             user = dao.retrieveAdminById(res.getInt("id_u"));
               prop.setUtilisateur(user); 
                             
        ListPropriete.add(prop);
        
        }
      } catch (SQLException ex) {
          Logger.getLogger(ResevationDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
   return ListPropriete;
    
    
    
    }

    @Override
    public List getListReservationByPropriete(int id) {
         List<Resrevation> ListReservation = new ArrayList<>();      
  

   String req ="SELECT *FROM reservation WHERE id_p='"+id+"' and etat='true' ORDER BY dateDebut";
      try {
              ste = connexion.createStatement();
            ResultSet res =  ste .executeQuery(req);
          
        
          while (res.next()) {
        Resrevation r = new   Resrevation();
              UserDAO dao = new UserDAO();
          ProprieteCrud daoP = new ProprieteCrud() ;       
                 
            r.setId_r(res.getInt("id_r"));
                            r.setUser(dao.retrieveAdminById(res.getInt("id_u")));
                           r.setPropriete(daoP.getProprieteById(res.getInt("id_p")));
                           r.setUserDemandant(dao.retrieveAdminById(res.getInt("id_u")));
                         r.setEtat(res.getString("etat"));
                        r.setDateDebut(res.getDate("dateDebut")); 
                        r.setDateFin(res.getDate("dateFin"));
                           
                             
        ListReservation.add(r);
        
        }
      } catch (SQLException ex) {
          Logger.getLogger(ResevationDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
   return ListReservation;
    
    
    
    
    }


public List <Propriete> comparer (Date date_Debut,Date date_Fin ){

List<Resrevation> l2;


       proprieteLibre=this.getListProprieteSansReservation();
      
        List<Resrevation>  l=  this.tousLesReservation();
    ProprieteCrud daoP = new ProprieteCrud();
        for (int i=0 ;i<l.size();i++){
  
 
 
 
 
 l2=this.listReservationParId(l.get(i).getPropriete().getId());
  
 if (l2.size()==1){
    if (date_Debut.compareTo(l2.get((l2.size())-1).getDateFin())>0) { 
   if (!proprieteLibre.contains(daoP.getProprieteById(l2.get(0).getPropriete().getId()))){
          proprieteLibre.add(daoP.getProprieteById(l2.get(0).getPropriete().getId()));
            System.out.println("hello bouhmid 0");
      }
    
    }
  
  }
 for( int j=0 ; j<l2.size()-1;j++ ){  
  
    if (!( date_Debut.compareTo(l2.get(j).getDateFin())==0||( date_Debut.compareTo(l2.get(j).getDateDebut())==0)||( date_Debut.compareTo(l2.get(j).getDateDebut())==0)||( date_Fin.compareTo(l2.get(j).getDateDebut())==0))){
     
      
      
            if (date_Debut.compareTo(l2.get((l2.size())-1).getDateFin())>0) {   

      if (!proprieteLibre.contains(daoP.getProprieteById(l2.get(j).getPropriete().getId()))){
          proprieteLibre.add(daoP.getProprieteById(l2.get(j).getPropriete().getId()));
            System.out.println("hello bouhmid 1");
      }
            }
        
        
    else  if  (date_Debut.compareTo(l2.get(j).getDateFin())>0 && date_Fin.compareTo(l2.get(j+1).getDateDebut())<0 ){
 if (!proprieteLibre.contains(daoP.getProprieteById(l2.get(j).getPropriete().getId()))){
   proprieteLibre.add(daoP.getProprieteById(l2.get(j).getPropriete().getId()));
   System.out.println("hello bouhmid 2");
 
   }}
  
      
   else  if (date_Fin.compareTo(l2.get((0)).getDateDebut())<0)  {  
   System.out.println (l2.get((0)).getDateDebut());
       
       if (!proprieteLibre.contains(daoP.getProprieteById(l2.get(j).getPropriete().getId()))){
      proprieteLibre.add(daoP.getProprieteById(l2.get(j).getPropriete().getId()));   
  
 
    } }
   
        
        }
    
   
 
 
   



}
        }
        
        
        
        return this.filtrePropriete(proprieteLibre);
                



}

public List <Propriete> filtrePropriete (List <Propriete> l){
List<Propriete> l1 = new ArrayList ();
for (int i=0;i<l.size()-1;i++){

if(!l1.contains(l.get(i)))
   l1.add(l.get(i));
    }


return l1;
}
}









