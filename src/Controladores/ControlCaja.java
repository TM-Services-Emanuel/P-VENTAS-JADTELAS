package Controladores;

import Componentes.Fecha;
import Componentes.Login;
import Componentes.Mensajes;
import Datos.GestionarCaja;
import IU.dlgCaja;
import IU.dlgCajaDia;
import Modelo.Caja;

public class ControlCaja {
static String UsuarioL="";
    public static String addCaja() {
        String msg;
        String caFechaI = dlgCaja.lbFecha.getText();
        String caHoraI= dlgCaja.lbHora.getText();
        String caUsuI= dlgCaja.lbUsuario.getText();
        String caUsuF=" ";
        int caInicial = Integer.parseInt(dlgCaja.txtCaInicialL.getText());

        Caja caja = new Caja(caFechaI,caHoraI,caFechaI,caHoraI,caInicial, 0, 0,caUsuI,caUsuF);
        msg = GestionarCaja.addCaja(caja);
        if (msg == null) {
            Mensajes.informacion("Caja inicial del día establecida");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }
    
    public static String actCaja() {
        String msg;
        int caId=Integer.parseInt(dlgCajaDia.lbNCaja.getText());
        String caFechaF = Fecha.fechaCorrecta();
        String caHoraF = Fecha.darHora();
        int caFinal = Integer.parseInt(dlgCajaDia.txtTotalE.getText());
        int caDif = Integer.parseInt(dlgCajaDia.txtDiferencia.getText());
        String caUsuF=UsuarioL=Login.getUsuarioLogueado();

        Caja caja = new Caja(caId, caFechaF, caHoraF, caDif, caFinal, caUsuF);
        msg = GestionarCaja.actCaja(caja);
        if (msg == null) {
            Mensajes.informacion("CAJA DEL DÍA CERRADA!");
            dlgCajaDia.lbEstado.setText("CERRADO");
        } else {
            //Mensajes.informacion("Caja del día actualizada");
            Mensajes.error(msg);
        }
        return msg;
    }

}
