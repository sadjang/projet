/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Classe.Informations;
import DAO.IDinformations;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author sadjang
 */
public class Minformation implements IMinformation{
    private IDinformations information;

    public Minformation(IDinformations information) {
        this.information = information;
    }

    public IDinformations getInformation() {
        return information;
    }

    public void setInformation(IDinformations information) {
        this.information = information;
    }
    
    @Override
    public List<Informations> findByTelephone(String Telephone) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Informations> findByNom(String Nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Informations> findByQuatier(String Quatier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Informations> findByPoste(String Poste) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Informations save(Informations entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Informations update(Informations entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Informations entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteInBatch(List<Informations> entities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Informations find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Informations> findAll() {
        List<Informations> infos= this.information.findAll();   
        return infos;
    }

    @Override
    public List<Informations> findAllbyTable(String[] tabRequette) {
         List<Informations> infos= this.information.findAllbyTable(tabRequette);   
        return infos;
    }
    
    
}
