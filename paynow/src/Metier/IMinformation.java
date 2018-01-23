/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Classe.Informations;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author sadjang
 */
public interface IMinformation extends Generiqueservice<Informations> {
    List<Informations> findByTelephone(String Telephone);
    List<Informations> findByNom(String Nom);
    List<Informations> findByQuatier(String Quatier);
    List<Informations> findByPoste(String Poste);
    List<Informations> findAllbyTable(String[] tabRequette);
    
}

   
