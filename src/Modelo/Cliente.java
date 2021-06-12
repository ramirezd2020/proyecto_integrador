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
public class Cliente extends persona{
    
    public String categoria;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public Cliente(String nombre, String apellido, String domicilio, String telefono, String ciudad, String mail, int DNI, String fecha_reten, String monto_reten, String periodo_reten, String Nro_fact, String total_reten) {
        
    }
    
}
