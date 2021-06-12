/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Damian
 */
public class Agente extends persona{
    public String usuario;
    public String contraseña;
    public String roll;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }
    
    public Agente(String nombre, String apellido, String domicilio, String telefono, String ciudad, String mail, int DNI, String fecha_reten, String monto_reten, String periodo_reten, String Nro_fact, String total_reten) {
     
    }
    
    
}
