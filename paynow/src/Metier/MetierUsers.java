/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Classe.Users;
import DAO.IDusers;
import java.util.List;

/**
 *
 * @author sadjang
 */
public class MetierUsers implements IMetierUsers {
      private  IDusers dusers;

    public MetierUsers(IDusers dusers) {
        this.dusers = dusers;
        
    }

    public IDusers getDusers() {
        return dusers;
    }

    public void setDusers(IDusers dusers) {
        this.dusers = dusers;
    }
    
    
    @Override
    public Users authentification(String nom, String password, int actif) {
         Users user= this.dusers.authentification(nom, password, actif);
         return user;
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
      Users user= this.dusers.save(entity);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
