/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classe.Client;
import Classe.Users;
import java.util.List;

/**
 *
 * @author sadjang
 */
public interface IDclients extends Genericservice<Client> {
    List<Client> findAll(String[] tabl);  
}
