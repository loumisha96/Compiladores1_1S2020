/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_1S2020;

/**
 *
 * @author lourd
 */
public class hoja {

    public hoja(String conj) {
        this.conj = conj;
    }

    public hoja getLeft() {
        return left;
    }

    public void setLeft(hoja left) {
        this.left = left;
    }

    public hoja getRight() {
        return right;
    }

    public void setRight(hoja right) {
        this.right = right;
    }

    public String getConj() {
        return conj;
    }

    public void setConj(String conj) {
        this.conj = conj;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnulable() {
        return anulable;
    }

    public void setAnulable(String anulable) {
        this.anulable = anulable;
    }

    public String getPrimeros() {
        return primeros;
    }

    public void setPrimeros(String primeros) {
        this.primeros = primeros;
    }

    public String getUltimos() {
        return ultimos;
    }

    public void setUltimos(String ultimos) {
        this.ultimos = ultimos;
    }
    hoja left;
    hoja right;
    String conj, id, anulable, primeros, ultimos;
    
    
}
