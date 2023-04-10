package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class InterfazInic extends JFrame implements ActionListener{

	 public static void main(String[] ar){
		 InterfazInic formulario1=new InterfazInic();
	        formulario1.setVisible(true);
	        formulario1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
	
	private JButton btnCliente;
	private JButton btnOperador;
	
	public InterfazInic(){
		this.btnCliente=new JButton ("Cliente");
		this.btnOperador=new JButton ("Operador");
		add(btnCliente);
		btnCliente.addActionListener(this);
		add(btnOperador);
		btnOperador.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnCliente) {
			
		}
		else if (e.getSource()==btnOperador) {
			
		}
	}

}
