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
public class arbol {

    public arbol() {
        this.raiz = null;
    }

    public hoja getRaiz() {
        return raiz;
    }

    public void setRaiz(hoja raiz) {
        this.raiz = raiz;
    }
    hoja raiz;
    void insertar(String conj){
        if(this.raiz ==null){
            this.raiz = new hoja(conj);
        }else{
            insertar(raiz, new hoja(conj));
        }
    }
    void insertar(hoja actual, hoja nuevo){
        if(nuevo.conj.compareTo(actual.conj)<0){
            
        }
    }
}
