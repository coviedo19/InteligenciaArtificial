/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo.aprendamosasumar;

/**
 *
 * @author Andrea
 */
public class Imagen {

    private String ruta;
    private int resultado;

    public Imagen(String ruta, int resultado) {
        this.ruta = ruta;
        this.resultado = resultado;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }    
}
