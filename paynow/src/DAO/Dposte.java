/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classe.Poste;
import Util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author sadjang
 */
public class Dposte implements IDposte{

    @Override
    public Poste save(Poste entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Poste update(Poste entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Poste entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteInBatch(List<Poste> entities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Poste find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Poste> findAll() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //  create de query
         List<Poste>  postes= (List<Poste>)session.createCriteria(Poste.class).list();
        //--create de query
        session.getTransaction().commit();    
    return postes;
    }
    
}
