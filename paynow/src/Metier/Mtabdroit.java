/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Classe.Tabdroit;
import Classe.Users;
import DAO.IDtabdroit;
import DAO.IDusers;
import java.util.List;

/**
 *
 * @author sadjang
 */
public class Mtabdroit implements IMtabdroit {
      private  IDtabdroit tabdroit;

    public Mtabdroit(IDtabdroit tabdroit) {
        this.tabdroit = tabdroit;
    }

    public IDtabdroit getTabdroit() {
        return tabdroit;
    }

    public void setTabdroit(IDtabdroit tabdroit) {
        this.tabdroit = tabdroit;
    }
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
         List<Tabdroit> tabdroit= this.tabdroit.findAll();
    return tabdroit;
    }
    
    
    
}
