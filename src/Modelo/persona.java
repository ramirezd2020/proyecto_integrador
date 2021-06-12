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
public class persona {
    String nombre;
    String apellido;
    String domicilio;
    String telefono;
    String ciudad;
    String mail;
    String fecha_reten;
    String monto_reten;
    String periodo_reten;
    String Nro_fact;
    String total_reten;
    int DNI;

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFecha_reten() {
        return fecha_reten;
    }

    public void setFecha_reten(String fecha_reten) {
        this.fecha_reten = fecha_reten;
    }

    public String getMonto_reten() {
        return monto_reten;
    }

    public void setMonto_reten(String monto_reten) {
        this.monto_reten = monto_reten;
    }

    public String getPeriodo_reten() {
        return periodo_reten;
    }

    public void setPeriodo_reten(String periodo_reten) {
        this.periodo_reten = periodo_reten;
    }

    public String getNro_fact() {
        return Nro_fact;
    }

    public void setNro_fact(String Nro_fact) {
        this.Nro_fact = Nro_fact;
    }

    public String getTotal_reten() {
        return total_reten;
    }

    public void setTotal_reten(String total_reten) {
        this.total_reten = total_reten;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

}
