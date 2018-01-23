/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Classe.Client;
import Classe.Informations;
import DAO.IDclients;
import DAO.IDinformations;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author sadjang
 */
public class Mclient implements IMclient{
    private IDclients client;

    public Mclient(IDclients client) {
        this.client = client;
    }

    public IDclients getClient() {
        return client;
    }

    public void setClient(IDclients client) {
        this.client = client;
    }
    
   
    
    

    @Override
    public List<Client> findAllbyTable(String[] tabRequette) {
        List<Client> infos= this.client.findAll(tabRequette);   
        return infos;    }

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
    public void delete(Long id) {
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
