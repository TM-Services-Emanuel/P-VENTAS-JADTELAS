package Controladores;

import Componentes.Login;
import Componentes.Mensajes;
import Datos.GestionarVendedor;
import IU.dlgGestVendedor;
import IU.dlgVendedor;
import Modelo.Vendedor;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class controlVendedor {
    static String UsuarioL="";
    public static void aModificar() {
        int x = dlgVendedor.tablaEmpleados.getSelectedRow();
        DefaultTableModel m = (DefaultTableModel) dlgVendedor.tablaEmpleados.getModel();
        String cod = m.getValueAt(x, 0).toString();

        Vendedor v = GestionarVendedor.busVendedor(cod);
        DecimalFormat df = new DecimalFormat("#,###");
        dlgGestVendedor.lblCodV.setText(String.valueOf(v.getCodVe()));
        dlgGestVendedor.txtNombre.setText(v.getNombreV());
        dlgGestVendedor.txtDireccion.setText(v.getDireccion());
        dlgGestVendedor.txtTelefono.setText(v.getTelefono());
        dlgGestVendedor.txtCelular.setText(v.getCelular());
        dlgGestVendedor.txtSueldo.setText(df.format(Integer.valueOf(v.getSueldo())));
        dlgGestVendedor.txtComision.setText(String.valueOf(v.getComision()));
        dlgGestVendedor.txaS.setText(v.getObs());
        
    }

    public static Vendedor capturarCampos() {
        Vendedor ven = null;
        String direccion;
        String telef;
        int sueldo;
        double comis;
        String obs;
        int codV = Integer.parseInt(dlgGestVendedor.lblCodV.getText());
        String nombreV = dlgGestVendedor.txtNombre.getText();
        if(dlgGestVendedor.txtDireccion.getText().trim()== null){
            direccion="''";   
        }else{
            direccion = dlgGestVendedor.txtDireccion.getText();
        }
        if(dlgGestVendedor.txtTelefono.getText().trim()== null){
            telef="''";   
        }else{
            telef = dlgGestVendedor.txtTelefono.getText();
        }
        String celu = dlgGestVendedor.txtCelular.getText();
        if((dlgGestVendedor.txtSueldo.getText().trim()==null)){
            sueldo=0;
        }else{
            sueldo = Integer.parseInt(dlgGestVendedor.txtSueldo.getText().replace(".", "").replace(",", ""));
        }
        if(dlgGestVendedor.txtComision.getText().trim()==null){
            comis=0;
        }else{
            comis = Double.parseDouble(dlgGestVendedor.txtComision.getText());
        }
        if(dlgGestVendedor.txaS.getText().trim()==null){
            obs="''";
        }else{
            obs = dlgGestVendedor.txaS.getText().toUpperCase();
        }
        ven = new Vendedor(codV, nombreV, direccion, telef, celu, sueldo, comis, obs);
        return ven;
    }

    public static String addVendedor() {
        String msg;
        Vendedor v = capturarCampos();
        String usuario = UsuarioL=Login.getUsuarioLogueado();
        msg = GestionarVendedor.addVendedor(v, usuario);
        if (msg == null) {
            Mensajes.informacion("Empleado Registrado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static void addImagen(String cod) {
        GestionarVendedor.addImagen(cod);
    }

    public static void actImagen(String cod) {
        GestionarVendedor.actImagen(cod);
    }

    public static void busImagen(String cod, JLabel lblImagen) {
        GestionarVendedor.busImagen(cod, lblImagen);
    }

    public static String actVendedor() {
        String msg;
        Vendedor v = capturarCampos();
        String usuario = UsuarioL=Login.getUsuarioLogueado();
        msg = GestionarVendedor.actVendedor(v, usuario);
        if (msg == null) {
            Mensajes.informacion("Empleado Actualizado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String delVendedor() {
        int x = dlgVendedor.tablaEmpleados.getSelectedRow();
        String msg;
        String cod = dlgVendedor.tablaEmpleados.getValueAt(x, 0).toString();
        String usuario = UsuarioL=Login.getUsuarioLogueado();
        msg = GestionarVendedor.delVendedor(cod, usuario);
        if (msg == null) {
            Mensajes.informacion("Empleado Eliminado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static void listVendedor(JTable tabla, String cad) {
        List lista = null;
        lista = GestionarVendedor.listVendedor(cad);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }

    public static void filNombre(JTable tabla, String cad) {
        List lista = null;
        lista = GestionarVendedor.filNombre(cad);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }

    public static void filDireccion(JTable tabla, String cad) {
        List lista = null;
        lista = GestionarVendedor.filDireccion(cad);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }

    public static void filTelefono(JTable tabla, String cad) {
        List lista = null;
        lista = GestionarVendedor.filTelefono(cad);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }

}
