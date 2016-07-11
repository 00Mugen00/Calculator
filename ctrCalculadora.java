package prCalculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ctrCalculadora implements ActionListener{
	private VistaCalculadora vista;
	private Calculadora calc;
	private double op1;
	private double op2;
	private double resultado;
	private boolean sumar;
	private boolean restar;
	private boolean multiplicar;
	private boolean dividir;
	private boolean igual;
	public ctrCalculadora(VistaCalculadora v,Calculadora c){
		vista=v;
		calc=c;
		op1 = 0;
		op2 = 0;
		resultado=0;
		sumar = false;
		restar = false;
		multiplicar = false;
		dividir = false;
		igual=false;
	}
	//Debo separar las operaciones con el igual
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch(comando){
			case "BORRAR":
				vista.getPantalla().setText("0");
			break;
			case "SUMAR":
				if(sumar||restar||multiplicar||dividir){
					sumar = false;
					restar = false;
					multiplicar = false;
					dividir = false;
				}else{
					if(igual){
						op1=resultado;
						igual=false;
					}else{
						op1=vista.obtenerOperando();
					}
				}
				sumar=true;
				vista.getPantalla().setText("0");
			break;
			case "RESTAR":
				if(sumar||restar||multiplicar||dividir){
					sumar = false;
					restar = false;
					multiplicar = false;
					dividir = false;
				}else{
					if(igual){
						op1=resultado;
						igual=false;
					}else{
						op1=vista.obtenerOperando();
					}
				}
				restar=true;
				vista.getPantalla().setText("0");
			break;
			case "MULTIPLICAR":
				if(sumar||restar||multiplicar||dividir){
					sumar = false;
					restar = false;
					multiplicar = false;
					dividir = false;
				}else{
					if(igual){
						op1=resultado;
						igual=false;
					}else{
						op1=vista.obtenerOperando();
					}
				}
				multiplicar=true;
				vista.getPantalla().setText("0");
			break;
			case "DIVIDIR":
				if(sumar||restar||multiplicar||dividir){
					sumar = false;
					restar = false;
					multiplicar = false;
					dividir = false;
				}else{
					if(igual){
						op1=resultado;
						igual=false;
					}else{
						op1=vista.obtenerOperando();
					}
				}
				dividir=true;
				vista.getPantalla().setText("0");
			break;
			case "IGUAL":
				if(igual){
					igual=false;
				}else{
					op2 = vista.obtenerOperando();
				}
				System.out.println("OP1: "+op1+", OP2: "+op2);
				resultado=0;
				if(sumar){
					resultado=calc.suma(op1, op2);
					System.out.println("Resultado: "+resultado);
				}else if(restar){
					resultado=calc.resta(op1, op2);
					System.out.println("Resultado: "+resultado);
				}else if(multiplicar){
					resultado=calc.producto(op1,op2);
					System.out.println("Resultado: "+resultado);
				}else if(dividir){
					resultado=calc.division(op1, op2);
					System.out.println("Resultado: "+resultado);
				}else{
					resultado=Double.parseDouble(vista.getPantalla().getText());
					System.out.println("Resultado: "+resultado);
				}
				vista.getPantalla().setText(Double.toString(resultado));
				op1 = 0;
				op2 = 0;
				sumar = false;
				restar = false;
				multiplicar = false;
				dividir = false;
				igual=true;
			break;
			default:
				if(igual){
					vista.getPantalla().setText("0");
					igual=false;
				}
				int i = Integer.parseInt(comando);
				vista.getPantalla().setText(Integer.toString(i + 10 * Integer.parseInt(vista.getPantalla().getText().equals("") ? "0" : vista.getPantalla().getText())));
			break;
		}
	}
}
