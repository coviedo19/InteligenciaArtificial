/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo.aprendamosasumar;

/**
 *
 * @author JorgeArmando
 */
class Usuario {
    
    private int CODUSUARIO,CODNIVEL;
    private String NOMBREUSUARIO,PASWORD;

    public Usuario(int CODUSUARIO, int CODNIVEL, String NOMBREUSUARIO, String PASWORD) {
        this.CODUSUARIO = CODUSUARIO;
        this.CODNIVEL = CODNIVEL;
        this.NOMBREUSUARIO = NOMBREUSUARIO;
        this.PASWORD = PASWORD;
    }

    public int getCODUSUARIO() {
        return CODUSUARIO;
    }

    public void setCODUSUARIO(int CODUSUARIO) {
        this.CODUSUARIO = CODUSUARIO;
    }

    public int getCODNIVEL() {
        return CODNIVEL;
    }

    public void setCODNIVEL(int CODNIVEL) {
        this.CODNIVEL = CODNIVEL;
    }

    public String getNOMBREUSUARIO() {
        return NOMBREUSUARIO;
    }

    public void setNOMBREUSUARIO(String NOMBREUSUARIO) {
        this.NOMBREUSUARIO = NOMBREUSUARIO;
    }

    public String getPASWORD() {
        return PASWORD;
    }

    public void setPASWORD(String PASWORD) {
        this.PASWORD = PASWORD;
    }
    
    
    
}
