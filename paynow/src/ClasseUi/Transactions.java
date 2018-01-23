/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasseUi;

import java.util.Date;

/**
 *
 * @author sadjang
 */
public class Transactions {
    private int id;
     private String NomOperateur;
     private String nomexpediteur;
     private String imeetelephone;
     private String cniexpediteur;
     private String marquetelephone;
     private String nomrecepteur;
     private String numerorecepteur;
     private Integer montantexpetion;
     private String numeroexpediteur;
     private Date dateexpedition;
     private String cnirecepteur;   
    public Transactions(int id, String NomOperateur, String nomexpediteur, String imeetelephone, String cniexpediteur, String marquetelephone, String nomrecepteur, String numerorecepteur, Integer montantexpetion, String numeroexpediteur, Date dateexpedition,String cnirecepteur) {
        this.id = id;
        this.NomOperateur = NomOperateur;
        this.nomexpediteur = nomexpediteur;
        this.imeetelephone = imeetelephone;
        this.cniexpediteur = cniexpediteur;
        this.marquetelephone = marquetelephone;
        this.nomrecepteur = nomrecepteur;
        this.numerorecepteur = numerorecepteur;
        this.montantexpetion = montantexpetion;
        this.numeroexpediteur = numeroexpediteur;
        this.dateexpedition = dateexpedition;
        this.cnirecepteur=cnirecepteur;
    }

    public String getCnirecepteur() {
        return cnirecepteur;
    }

    public void setCnirecepteur(String cnirecepteur) {
        this.cnirecepteur = cnirecepteur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomOperateur() {
        return NomOperateur;
    }

    public void setNomOperateur(String NomOperateur) {
        this.NomOperateur = NomOperateur;
    }

    public String getNomexpediteur() {
        return nomexpediteur;
    }

    public void setNomexpediteur(String nomexpediteur) {
        this.nomexpediteur = nomexpediteur;
    }

    public String getImeetelephone() {
        return imeetelephone;
    }

    public void setImeetelephone(String imeetelephone) {
        this.imeetelephone = imeetelephone;
    }

    public String getCniexpediteur() {
        return cniexpediteur;
    }

    public void setCniexpediteur(String cniexpediteur) {
        this.cniexpediteur = cniexpediteur;
    }

    public String getMarquetelephone() {
        return marquetelephone;
    }

    public void setMarquetelephone(String marquetelephone) {
        this.marquetelephone = marquetelephone;
    }

    public String getNomrecepteur() {
        return nomrecepteur;
    }

    public void setNomrecepteur(String nomrecepteur) {
        this.nomrecepteur = nomrecepteur;
    }

    public String getNumerorecepteur() {
        return numerorecepteur;
    }

    public void setNumerorecepteur(String numerorecepteur) {
        this.numerorecepteur = numerorecepteur;
    }

    public Integer getMontantexpetion() {
        return montantexpetion;
    }

    public void setMontantexpetion(Integer montantexpetion) {
        this.montantexpetion = montantexpetion;
    }

    public String getNumeroexpediteur() {
        return numeroexpediteur;
    }

    public void setNumeroexpediteur(String numeroexpediteur) {
        this.numeroexpediteur = numeroexpediteur;
    }

    public Date getDateexpedition() {
        return dateexpedition;
    }

    public void setDateexpedition(Date dateexpedition) {
        this.dateexpedition = dateexpedition;
    }
     

    
}
