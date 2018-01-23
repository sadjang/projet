/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author sadjang
 * @param <T>
 */
public interface Genericservice <T extends Object>{
    T save(T entity);
    T update(T entity);
    void delete(T entity);
    void delete(Long id);
    void deleteInBatch(List<T> entities);
    T find(Long id);
    List<T> findAll();
    
}
