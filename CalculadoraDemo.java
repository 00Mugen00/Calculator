package prCalculadora;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalculadoraDemo {
	public static void main(String[] args){
		Calculadora calc = new Calculadora();
		VistaCalculadora vistaCalculadora = new PanelCalculadora();
		ActionListener ctrCalculadora = new ctrCalculadora(vistaCalculadora,calc);
		vistaCalculadora.controlador(ctrCalculadora);
		JFrame ventana = new JFrame("Calculator");  	
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel) vistaCalculadora);		 
		ventana.pack();	
		ventana.setVisible(true);    
		ventana.setResizable(false);
	}
}
