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
public class Conjunto {

    public int getRangoMenor() {
        return rangoMenor;
    }

    public void setRangoMenor(int rangoMenor) {
        this.rangoMenor = rangoMenor;
    }

    public int getRangoMayor() {
        return rangoMayor;
    }

    public void setRangoMayor(int rangoMayor) {
        this.rangoMayor = rangoMayor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    int rangoMenor, rangoMayor;
    String nombre;
}
