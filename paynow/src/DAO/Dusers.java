/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classe.Poste;
import Classe.Tabdroit;
import Classe.Users;
import Util.NewHibernateUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sadjang
 */
public class Dusers implements IDusers{
    @Override
    public Users authentification(String nom, String password,int actif) {
        Users use=null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List users = session.createCriteria(Users.class)     
          .add( Restrictions.eq("nom",nom ) )
          .add( Restrictions.eq("pasword",password ) )
          .add( Restrictions.eq("actif", actif ) )
          .list();
        System.out.println(nom);
         System.out.println(password);
         System.out.println(String.valueOf(actif));
         Iterator iter = users.iterator();
         while ( iter.hasNext() ) {
            use =(Users)iter.next();
          }
        session.getTransaction().commit(); 
        return use;  
    }

    @Override
    public List<Users> findByTelephone(String Telephone) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Users> findByNom(String Nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Users> findByQuatier(String Quatier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Users> findByPoste(String Poste) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Users save(Users entity) {
       Session session = NewHibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
           int iduser =(int)session.save(entity);  
         //  create de query
        
        Users user = (Users) session.load(Users.class, iduser);
        System.out.println("id de utilisateur"+user.getId());
       session.getTransaction().commit(); 
     return user;
    }

    @Override
    public Users update(Users entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Users entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteInBatch(List<Users> entities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Users find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Users> findAll() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
       // List users = session.createCriteria(Users.class)  
                Criteria c=session.createCriteria(Users.class);
        /*  .add( Restrictions.eq("nom","sadjang" ) )
          .add( Restrictions.eq("pasword","avompetit" ) )
          .add( Restrictions.eq("actif", 1 ) )*/
        //  .list();
        
        session.getTransaction().commit(); 
        System.out.println(String.valueOf(c.list().size()));
        return c.list();   
    }

    
    
}
