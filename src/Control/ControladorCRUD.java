/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Conexion;
import Modelo.personaDAO;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Damian
 */
public class ControladorCRUD implements ActionListener {

    Conexion conexion;
    Login vistaLogin = new Login();
    Select vistaCRUD = new Select();
    //ImpuestoDAO modeloCRUD = new ImpuestoDAO();
    personaDAO modeloCRUD = new personaDAO();

    public ControladorCRUD(Select vistaCRUD, personaDAO modeloCRUD, Login LoginCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD = vistaCRUD;
        this.vistaLogin = LoginCRUD;

        this.vistaCRUD.btnListar.addActionListener(this);
        this.vistaCRUD.btnListReten.addActionListener(this);
        this.vistaLogin.btnAceptarLogin.addActionListener(this);
        this.vistaCRUD.btnAceptarAgen.addActionListener(this);
        this.vistaCRUD.btnAceptar.addActionListener(this);
        this.vistaCRUD.btnAceptaClie.addActionListener(this);
        

    }

    public void inicializarCRUD() {

    }

    public void LlenarTabla(JTable TablaD, String años) {
        DefaultTableModel ModeloT = new DefaultTableModel();
        TablaD.setModel(ModeloT);

        ModeloT.addColumn("Fecha de Retencion");
        ModeloT.addColumn("Periodo");
        ModeloT.addColumn("Monto");
        ModeloT.addColumn("Nro de Factura");
        ModeloT.addColumn("Monto Total");

        Object[] Columna = new Object[5];

        int NumeroRegistros = modeloCRUD.listRetenciones(años).size();

        for (int i = 0; i < NumeroRegistros; i++) {

            Columna[0] = modeloCRUD.listRetenciones(años).get(i).getFecha_reten();
            Columna[1] = modeloCRUD.listRetenciones(años).get(i).getPeriodo_reten();
            Columna[2] = modeloCRUD.listRetenciones(años).get(i).getNro_fact();
            Columna[3] = modeloCRUD.listRetenciones(años).get(i).getMonto_reten();
            Columna[4] = modeloCRUD.listRetenciones(años).get(i).getTotal_reten();
           

            ModeloT.addRow(Columna);

        }
}
  
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistaCRUD.btnAceptarAgen) {
            String cuit = vistaCRUD.entryCuil.getText();
            String razon = vistaCRUD.entryrRazon.getText();
            String domic = vistaCRUD.entryAgenDomicilio.getText();
            String tel = vistaCRUD.entryAgenTel.getText();
            String mail = vistaCRUD.entryAgenMail.getText();
            String prov = vistaCRUD.entryAgenProv.getText();
            String cp = vistaCRUD.entryAgenCP.getText();
            String rptaRegistro = modeloCRUD.IntsertPersona(cuit, razon, domic, tel, mail, prov, cp);
            String id = null;
            String cuit1 = vistaCRUD.entryCuil.getText();
            String user1 = vistaCRUD.entryUserAgen.getText();
            String pass = vistaCRUD.entryAgenPass.getText();
            String roll = (String) vistaCRUD.entryRollAgen.getSelectedItem();
            String rptaRegistroAg = modeloCRUD.IntsertAgente(id, cuit1, user1,pass,roll);
            
            if (rptaRegistro != null) {
                JOptionPane.showMessageDialog(null, rptaRegistroAg);
                borrarEntryAgente();
            } else {
                JOptionPane.showMessageDialog(null, "Registro Erroneo");

            }

        }
        
            if (e.getSource() == vistaCRUD.btnAceptaClie) {
            String cuit = vistaCRUD.entryCuitClie.getText();
            String razon = vistaCRUD.entryNomClie.getText();
            String domic = vistaCRUD.entryDomicClie.getText();
            String cat = (String) vistaCRUD.cbxCatClie.getSelectedItem();
            String tel = vistaCRUD.entryTelClie.getText();
            String mail = vistaCRUD.entryClieMail.getText();
            String prov = vistaCRUD.entryClieProv.getText();
            String cp = vistaCRUD.entryClieCP.getText();
            String alicuota = vistaCRUD.entryClieAlic.getText();
            String id = null;
            String rptaRegistro = modeloCRUD.IntsertPersona(cuit, razon, domic, tel, mail, prov, cp);
            String rptaRegistroCli = modeloCRUD.IntsertCliente(id, cuit, cat,alicuota);
            
            if (rptaRegistroCli != null) {
                JOptionPane.showMessageDialog(null, rptaRegistroCli);
                borrarEntryCliente();
            } else {
                JOptionPane.showMessageDialog(null, "Registro Erroneo");

            }

        }
        
        if (e.getSource() == vistaLogin.btnAceptarLogin) {
            String user = vistaLogin.entryUser.getText();
            String pass = vistaLogin.entryPass.getText();
            modeloCRUD.Login(user, pass);
            

        }
        if (e.getSource() == vistaCRUD.btnListReten) {
            vistaCRUD.JComboAño.removeAllItems();
            modeloCRUD.LlenarCombo(vistaCRUD.JComboAño);           
            
        }
        if (e.getSource() == vistaCRUD.btnListar) {
            String años = vistaCRUD.JComboAño.getSelectedItem().toString();
            LlenarTabla(vistaCRUD.tbRetenciones, años);
                    
        }
        
    }

    public void borrarEntryAgente() {
        vistaCRUD.entryAgenMail.setText("");
        vistaCRUD.entryCuil.setText("");
        vistaCRUD.entryrRazon.setText("");
        vistaCRUD.entryUserAgen.setText("");
        vistaCRUD.entryAgenPass.setText("");
        vistaCRUD.entryRollAgen.setSelectedItem(null);
        vistaCRUD.entryAgenDomicilio.setText("");
        vistaCRUD.entryAgenTel.setText("");
        vistaCRUD.entryAgenProv.setText("");
        vistaCRUD.entryAgenCP.setText("");
    }
    
    public void borrarEntryCliente() {
        vistaCRUD.entryCuitClie.setText("");
        vistaCRUD.entryNomClie.setText("");
        vistaCRUD.entryDomicClie.setText("");
        vistaCRUD.cbxCatClie.setSelectedItem(null);
        vistaCRUD.entryTelClie.setText("");
        vistaCRUD.entryAgenMail.setText("");
        vistaCRUD.entryClieProv.setText("");
        vistaCRUD.entryClieCP.setText("");
        vistaCRUD.entryClieAlic.setText("");
    }

}
