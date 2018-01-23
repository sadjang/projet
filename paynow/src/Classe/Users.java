package Classe;
// Generated 14 janv. 2018 09:08:16 by Hibernate Tools 4.3.1



/**
 * Users generated by hbm2java
 */
public class Users  implements java.io.Serializable {


     private int id;
     private Poste poste;
     private String nom;
     private String prenom;
     private String ncni;
     private String puctureusers;
     private String picturecni;
     private String quartier;
     private String pasword;
     private String numtelph;
     private int actif;

    public Users() {
    }

	
    public Users(int id, Poste poste, String nom, String ncni, String pasword, String numtelph, int actif) {
        this.id = id;
        this.poste = poste;
        this.nom = nom;
        this.ncni = ncni;
        this.pasword = pasword;
        this.numtelph = numtelph;
        this.actif = actif;
    }
    public Users(int id, Poste poste, String nom, String prenom, String ncni, String puctureusers, String picturecni, String quartier, String pasword, String numtelph, int actif) {
       this.id = id;
       this.poste = poste;
       this.nom = nom;
       this.prenom = prenom;
       this.ncni = ncni;
       this.puctureusers = puctureusers;
       this.picturecni = picturecni;
       this.quartier = quartier;
       this.pasword = pasword;
       this.numtelph = numtelph;
       this.actif = actif;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Poste getPoste() {
        return this.poste;
    }
    
    public void setPoste(Poste poste) {
        this.poste = poste;
    }
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getNcni() {
        return this.ncni;
    }
    
    public void setNcni(String ncni) {
        this.ncni = ncni;
    }
    public String getPuctureusers() {
        return this.puctureusers;
    }
    
    public void setPuctureusers(String puctureusers) {
        this.puctureusers = puctureusers;
    }
    public String getPicturecni() {
        return this.picturecni;
    }
    
    public void setPicturecni(String picturecni) {
        this.picturecni = picturecni;
    }
    public String getQuartier() {
        return this.quartier;
    }
    
    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }
    public String getPasword() {
        return this.pasword;
    }
    
    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
    public String getNumtelph() {
        return this.numtelph;
    }
    
    public void setNumtelph(String numtelph) {
        this.numtelph = numtelph;
    }
    public int getActif() {
        return this.actif;
    }
    
    public void setActif(int actif) {
        this.actif = actif;
    }




}

