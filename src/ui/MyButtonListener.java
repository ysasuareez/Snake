package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import models.TableroJuego;

public class MyButtonListener implements ActionListener {

	private MySnakeFrame snakeFrame;
	private TableroJuego tablero;
	private JLabel puntos;
	
	
	public MyButtonListener(MySnakeFrame sf, TableroJuego t) {
		snakeFrame = sf;
		tablero = t;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if (((JButton)ae.getSource()).getText() == "Start") {
			snakeFrame.empezarDeNuevo();
			tablero.requestFocus();			
		} else { //Bot�n de pausar
			snakeFrame.pausaContinuaJuego();
			tablero.requestFocus();
		}
	}

}
