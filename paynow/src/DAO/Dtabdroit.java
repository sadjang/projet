/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classe.Poste;
import Classe.Tabdroit;
import Util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author sadjang
 */
public class Dtabdroit implements IDtabdroit{


   

    @Override
    public Tabdroit save(Tabdroit entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tabdroit update(Tabdroit entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Tabdroit entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteInBatch(List<Tabdroit> entities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tabdroit find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tabdroit> findAll() {
       Session session = NewHibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
        //  create de query
       List<Tabdroit>  tabdroit= (List<Tabdroit>)session.createCriteria(Tabdroit.class).list();
        //--create de query
       session.getTransaction().commit(); 
       return tabdroit;
    }
    
     
    
    
    
    
}
