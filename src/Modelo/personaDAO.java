/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Control.ControladorCRUD;
import Vista.Login;
import Vista.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Damian
 */
public class personaDAO {
    
    Conexion conexion;

    public personaDAO() {
        conexion = new Conexion();

        

    }

    public void Login(String user, String pass) {
        String roll2 = "Agente";
        try {
            Connection AccesoDB = conexion.getConexion();
            PreparedStatement ps = AccesoDB.prepareStatement("SELECT user_agente, password_agente, roll_agente FROM agente_retencion where user_agente = ?");
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String usuarioR = rs.getString("user_agente");
                String usuarioP = rs.getString("password_agente");
                String usuarioRoll = rs.getString("roll_agente");
                if (usuarioR.equals(user)) {

                    if (usuarioP.equals(pass)) {
                        if (usuarioRoll.equals(roll2)) {
                            Select VistaC = new Select();
                            Login VistaL = new Login();
                            personaDAO modeloC = new personaDAO();
                            ControladorCRUD controlC = new ControladorCRUD(VistaC, modeloC, VistaL);
                            //Con esto cuando llamemos a dispose de vNueva abrimos la principal
                            VistaC.setVisible(true);

                            VistaC.setLocationRelativeTo(null);
                            //deshabilita el boton de Crear Agente segun Roll
                            VistaC.btnCreaAgente.setEnabled(false);
                            VistaL.setVisible(false);

                        } else {
                            Select VistaC = new Select();
                            Login VistaL = new Login();
                            personaDAO modeloC = new personaDAO();
                            ControladorCRUD controlC = new ControladorCRUD(VistaC, modeloC, VistaL);
                            VistaC.setVisible(true);
                            VistaC.setLocationRelativeTo(null);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Por favor Cheque los datos del usuario ingresado//");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Por favor Cheque los datos del usuario ingresado");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public String IntsertPersona(String cuit, String razon, String domic, String tel, String mail, String prov, String cp) {
        String rptaRegistro = null;
        try {
            Connection AccesoDB = conexion.getConexion();
            CallableStatement cs = AccesoDB.prepareCall("{call sp_insertPersona(?,?,?,?,?,?,?)}");
            cs.setString(1, cuit);
            cs.setString(2, razon);
            cs.setString(3, domic);
            cs.setString(4, tel);
            cs.setString(5, mail);
            cs.setString(6, prov);
            cs.setString(7, cp);
            int NumeroFilasAf = cs.executeUpdate();

            if (NumeroFilasAf > 0) {
                rptaRegistro = "Agente agregado Exitosamente!";

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return rptaRegistro;
    }

    public String IntsertAgente(String id, String cuit1, String user1, String pass, String roll) {
        String rptaRegistroAg = null;
        try {
            Connection AccesoDB = conexion.getConexion();
            PreparedStatement ps = AccesoDB.prepareStatement("SELECT * FROM persona where cuit_cuil = ?");
            ps.setString(1, cuit1);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String id1 = rs.getString("id_persona");
                CallableStatement cs = AccesoDB.prepareCall("{call sp_insertAgente(?,?,?,?)}");
                cs.setString(1, id1);
                cs.setString(2, user1);
                cs.setString(3, pass);
                cs.setString(4, roll);
                int NumeroFilasAf = cs.executeUpdate();

                if (NumeroFilasAf > 0) {
                    rptaRegistroAg = "Agente agregado Exitosamente!";

                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return rptaRegistroAg;
    }

    public String IntsertCliente(String id, String cuit, String cat, String alicuota) {
        String rptaRegistroCli = null;
        try {
            Connection AccesoDB = conexion.getConexion();
            PreparedStatement ps = AccesoDB.prepareStatement("SELECT * FROM persona where cuit_cuil = ?");
            ps.setString(1, cuit);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String id1 = rs.getString("id_persona");
                CallableStatement cs = AccesoDB.prepareCall("{call sp_insertCliente(?,?,?)}");
                cs.setString(1, id1);
                cs.setString(2, cat);
                cs.setString(3, alicuota);
                int NumeroFilasAf = cs.executeUpdate();

                if (NumeroFilasAf > 0) {
                    rptaRegistroCli = "Cliente agregado Exitosamente!";

                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return rptaRegistroCli;
    }

    public String LlenarCombo (JComboBox JComboAño) {
        String RptaCombo = null;
        try {
            Connection AccesoDB = conexion.getConexion();
            PreparedStatement ps = AccesoDB.prepareStatement("SELECT * FROM retencion_cliente ");
            ResultSet rs = ps.executeQuery();
            String fecha_ret = null;
            while (rs.next()) {
                fecha_ret = rs.getString("fecha_retencion");
                JComboAño.addItem(fecha_ret);
                }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return RptaCombo;
    }

    public ArrayList<persona> listRetenciones(String años){
        ArrayList listaRetenciones = new ArrayList();
        persona Persona;
        try {
            System.out.println(años);
            Connection AccesoDB = conexion.getConexion();
            PreparedStatement ps = AccesoDB.prepareStatement("SELECT monto_retencion, num_factura, fecha_retencion, periodo_retencion, monto FROM dgr.retencion_cliente WHERE fecha_retencion = ? ");
            ps.setString(1, años);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Persona = new persona();
                Persona.setFecha_reten(rs.getString(3));
                Persona.setPeriodo_reten(rs.getString(4));
                Persona.setMonto_reten(rs.getString(1));
                Persona.setNro_fact(rs.getString(2));
                Persona.setTotal_reten(rs.getString(5));
                listaRetenciones.add(Persona);
            }

        } catch (Exception e) {
            System.out.println(e);

        }
        return listaRetenciones;

    }

}
