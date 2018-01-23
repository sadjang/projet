package Classe;
// Generated 14 janv. 2018 09:08:16 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Informations generated by hbm2java
 */
public class Informations  implements java.io.Serializable {


     private int id;
     private Operateur operateur;
     private String nomexpediteur;
     private String imeetelephone;
     private String cniexpediteur;
     private String cnirecepteur;
     private String marquetelephone;
     private String nomrecepteur;
     private String numerorecepteur;
     private Integer montantexpedition;
     private String numeroexpediteur;
     private Date dateexpedition;

    public Informations() {
    }

	
    public Informations(int id, Operateur operateur, Date dateexpedition) {
        this.id = id;
        this.operateur = operateur;
        this.dateexpedition = dateexpedition;
    }
    public Informations(int id, Operateur operateur, String nomexpediteur, String imeetelephone, String cniexpediteur, String marquetelephone, String nomrecepteur, String numerorecepteur, Integer montantexpedition, String numeroexpediteur, Date dateexpedition,String cnirecepteur) {
       this.id = id;
       this.operateur = operateur;
       this.nomexpediteur = nomexpediteur;
       this.imeetelephone = imeetelephone;
       this.cniexpediteur = cniexpediteur;
       this.marquetelephone = marquetelephone;
       this.nomrecepteur = nomrecepteur;
       this.numerorecepteur = numerorecepteur;
       this.montantexpedition = montantexpedition;
       this.numeroexpediteur = numeroexpediteur;
       this.dateexpedition = dateexpedition;
       this.cnirecepteur=cnirecepteur;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Operateur getOperateur() {
        return this.operateur;
    }
    
    public void setOperateur(Operateur operateur) {
        this.operateur = operateur;
    }
    public String getNomexpediteur() {
        return this.nomexpediteur;
    }
    
    public void setNomexpediteur(String nomexpediteur) {
        this.nomexpediteur = nomexpediteur;
    }
    public String getImeetelephone() {
        return this.imeetelephone;
    }
    
    public void setImeetelephone(String imeetelephone) {
        this.imeetelephone = imeetelephone;
    }
    public String getCniexpediteur() {
        return this.cniexpediteur;
    }
    
    public void setCniexpediteur(String cniexpediteur) {
        this.cniexpediteur = cniexpediteur;
    }
    public String getMarquetelephone() {
        return this.marquetelephone;
    }
    
    public void setMarquetelephone(String marquetelephone) {
        this.marquetelephone = marquetelephone;
    }
    public String getNomrecepteur() {
        return this.nomrecepteur;
    }
    
    public void setNomrecepteur(String nomrecepteur) {
        this.nomrecepteur = nomrecepteur;
    }
    public String getNumerorecepteur() {
        return this.numerorecepteur;
    }
    
    public void setNumerorecepteur(String numerorecepteur) {
        this.numerorecepteur = numerorecepteur;
    }
    public Integer getMontantexpedition() {
        return this.montantexpedition;
    }
    
    public void setMontantexpedition(Integer montantexpedition) {
        this.montantexpedition = montantexpedition;
    }
    public String getNumeroexpediteur() {
        return this.numeroexpediteur;
    }
    
    public void setNumeroexpediteur(String numeroexpediteur) {
        this.numeroexpediteur = numeroexpediteur;
    }
    public Date getDateexpedition() {
        return this.dateexpedition;
    }
    
    public void setDateexpedition(Date dateexpedition) {
        this.dateexpedition = dateexpedition;
    }

    public String getCnirecepteur() {
        return cnirecepteur;
    }

    public void setCnirecepteur(String cnirecepteur) {
        this.cnirecepteur = cnirecepteur;
    }




}

