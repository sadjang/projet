package Classe;
// Generated 14 janv. 2018 09:08:16 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Poste generated by hbm2java
 */
public class Poste  implements java.io.Serializable {


     private int id;
     private String designation;
     private Set userses = new HashSet(0);

    public Poste() {
    }

	
    public Poste(int id, String designation) {
        this.id = id;
        this.designation = designation;
    }
    public Poste(int id, String designation, Set userses) {
       this.id = id;
       this.designation = designation;
       this.userses = userses;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getDesignation() {
        return this.designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public Set getUserses() {
        return this.userses;
    }
    
    public void setUserses(Set userses) {
        this.userses = userses;
    }




}


