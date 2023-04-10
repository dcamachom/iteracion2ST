package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class PanelInmuebles extends JFrame implements ActionListener{

	private JRadioButton btnHabitacion;
	private JRadioButton btnApto;
	private JRadioButton btnCasa;
	private JButton btnOk;
	private InterfazOperador interfaz;
	
	
	public PanelInmuebles(InterfazOperador interfaz) {
		btnHabitacion=new JRadioButton();
		btnApto= new JRadioButton();
		btnCasa= new JRadioButton();
		btnOk= new JButton();
		
		btnOk.addActionListener(this);
		
		add(btnHabitacion);
		add(btnApto);
		add(btnCasa);
		add(btnOk);
		
		this.interfaz=interfaz;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnOk) {
			if (btnHabitacion.isSelected()) {
				interfaz.registroHabitacion();
			}else if (btnApto.isSelected()) {
				interfaz.registrarApto();
			}else if (btnCasa.isSelected()) {
				interfaz.registrarCasa();
			}
		}
	}

}
