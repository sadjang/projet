/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasseUi;

import javafx.scene.control.CheckBox;

/**
 *
 * @author sadjang
 */
public class Droit {
    private String id;
    private String designation;
    private CheckBox check;
     public Droit(String id, String designation) {
           this.id = id;
           this.designation = designation;
           this.check=new CheckBox();
     }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public CheckBox getCheck() {
        return check;
    }

    public void setCheck(CheckBox check) {
        this.check = check;
    }
    
}
