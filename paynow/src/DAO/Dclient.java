/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classe.Client;
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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sadjang
 */
public class Dclient implements IDclients{
    
    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
    @Override
    public List<Client> findAll(String[] tabl) {
       
       Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria c=session.createCriteria(Client.class);
       // c.addOrder(Order.desc("id"));
         System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
       // System.out.println(clients.size());
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      
      /*  if(!tabl[3].equals("")){  
            
            
        }*/
      //  if(!tabl[0].equals("")&&tabl[1].equals("")&&tabl[2].equals("")&&tabl[3].equals(""))
          // c.add(Restrictions.like("nomexpediteur",tabl[0]));
      
       session.getTransaction().commit();    
    return c.list(); 
    }

    @Override
    public Client save(Client entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client update(Client entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Client entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteInBatch(List<Client> entities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Client> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
