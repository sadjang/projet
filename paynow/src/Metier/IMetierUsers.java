/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Classe.Users;
import java.util.List;

/**
 *
 * @author sadjang
 */
public interface IMetierUsers extends Generiqueservice<Users> {
    Users authentification(String nom, String password,int actif);
    List<Users> findByTelephone(String Telephone);
    List<Users> findByNom(String Nom);
    List<Users> findByQuatier(String Quatier);
    List<Users> findByPoste(String Poste);
    
    
    
}

   
