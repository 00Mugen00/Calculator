package prCalculadora;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
public interface VistaCalculadora {
	 String SUMAR = "SUMAR"; 
	 String RESTAR = "RESTAR"; 
	 String MULTIPLICAR = "MULTIPLICAR"; 
	 String DIVIDIR = "DIVIDIR";
	 String BORRAR="BORRAR";
	 String IGUAL = "IGUAL";
	 String cero="0";
	 String uno="1";
	 String dos="2";
	 String tres="3";
	 String cuatro="4";
	 String cinco="5";
	 String seis="6";
	 String siete="7";
	 String ocho="8";
	 String nueve="9";
	 //String IGUAL="IGUAL";
	 void resultado(double res);
	 void controlador(ActionListener ctr);
	 JTextField getPantalla();
	 int obtenerOperando();
}
