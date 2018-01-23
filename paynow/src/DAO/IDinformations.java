/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classe.Informations;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author sadjang
 */
public interface IDinformations extends Genericservice<Informations>  {

    List<Informations> findAllbyTable(String[] tabRequette);
    
}
