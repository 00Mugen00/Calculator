package prCalculadora;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelCalculadora extends JPanel implements VistaCalculadora{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField pantalla;
	private JLabel resultado;
	private JTextArea mensaje;
	private JButton sumar,restar,multiplicar,dividir,borrar,igual;
	private JButton[] botonera = new JButton[10];
	public PanelCalculadora() {
		// componentes del panel
		pantalla = new JTextField(10);
		pantalla.setHorizontalAlignment(JTextField.RIGHT);
		pantalla.setEditable(false);
		resultado = new JLabel(" ");
		resultado.setHorizontalAlignment(JTextField.RIGHT);
		mensaje = new JTextArea();
		mensaje.setEditable(false);
		//JScrollPane scMensaje = new JScrollPane(mensaje);
		sumar = new JButton("+");
		restar = new JButton("-");
		multiplicar= new JButton("*");
		dividir= new JButton("/");
		igual = new JButton("=");
		borrar = new JButton("AC");
		
		for (int cont = 0; cont <= 9; cont++) {
			botonera[cont] = new JButton(Integer.toString(cont));
			botonera[cont].setActionCommand(Integer.toString(cont));
		}
		
		
		
		// distribuición de los componentes en el panel principal
		setLayout(new GridLayout(1,1));
		
		
		// componente panel arriba 
		JPanel panelArriba = new JPanel();
		panelArriba.setLayout(new BorderLayout());
	
		panelArriba.add(pantalla,BorderLayout.NORTH);
		panelArriba.add(resultado, BorderLayout.SOUTH);
		
		JPanel botones = new JPanel();
		botones.setLayout(new GridLayout(4,3,1,1));
		for (int cont = 1; cont <= 9; cont++) {
			botones.add(botonera[cont]);
		}
		botones.add(borrar);
		botones.add(botonera[0]);
		botones.add(igual);
		
		
		
		JPanel acciones = new JPanel();
		acciones.setLayout(new GridLayout(2,1,5,5));
		acciones.add(sumar);
		acciones.add(restar);
		acciones.add(multiplicar);
		acciones.add(dividir);
		//acciones.add(igual);
	
		JPanel central = new JPanel();
		central.setLayout(new BorderLayout());
		central.add(botones,BorderLayout.WEST);
		central.add(new JLabel("  "),BorderLayout.CENTER);
		central.add(acciones,BorderLayout.EAST);
		
		panelArriba.add(central, BorderLayout.CENTER);
		
		
		
		// añadimos los componentes del panel principal		
		add(panelArriba);
	}
	
	public void controlador(ActionListener ctr) {
		sumar.addActionListener(ctr);
		sumar.setActionCommand(SUMAR);
		restar.addActionListener(ctr);
		restar.setActionCommand(RESTAR);
		multiplicar.addActionListener(ctr);
		multiplicar.setActionCommand(MULTIPLICAR);
		dividir.addActionListener(ctr);
		dividir.setActionCommand(DIVIDIR);
		borrar.addActionListener(ctr);
		borrar.setActionCommand(BORRAR);
		igual.addActionListener(ctr);
		igual.setActionCommand(IGUAL);
		
		for (int cont = 0; cont <= 9; cont++) {
			botonera[cont].addActionListener(ctr);
			botonera[cont].setActionCommand(Integer.toString(cont));
		}
		/*
		igual.addActionListener(ctr);
		igual.setActionCommand(IGUAL);
		*/
	}
	
	
	public void resultado(double res) {
		//resultado.setText("Resultado:  "+res);
		pantalla.setText(Double.toString(res));
	}
	
	public void mensaje(String msg) {
		mensaje.append(msg+"\n");
	}
	public int obtenerOperando() {
		return Integer.parseInt(pantalla.getText());
	}
	public JTextField getPantalla(){
		return pantalla;
	}
	
}
