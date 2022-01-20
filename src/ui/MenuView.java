package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ui.JuegoView1;
import models.TableroJuego;
import java.awt.Font;
import javax.swing.SwingConstants;

import main.Main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuView {

	private JPanel mainPanel;
	private TableroJuego tablero;
	private JPanel decoración1;
	private JLabel lblSelecDifi;
	private JLabel lblSelecTam;
	private JButton btnFacil;
	private JLabel lblFacil;
	private JButton btnInter;
	private JLabel lblInter; 
	private JButton btnDificil;
	private JLabel lblDificil;
	private JButton btnImposible;
	private JLabel lblImposible;
	private JPanel panelMenu;
	private JButton btnGrande;
	private	JLabel lblGrande;
	private	JLabel lblMediano;
	private	JButton btnMediano;
	private JLabel lblpequeño;
	private JButton btnPequeño;	
	private JFrame frameMenuView;
	private JPanel decoracion2;
	private JuegoView1 juego;
	private int velocidad;
	private int ancho;
	private int alto;
	private JButton btnEmpezar;
	/**
	 * Create the application.
	 */
	public MenuView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		configureUIComponents();
		configureListeners();
	}
	
	private void configureUIComponents() {
		frameMenuView = new JFrame();
		frameMenuView.setVisible(true);
		frameMenuView.setBounds(100, 100, 450, 300);
		frameMenuView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMenuView.setSize(600, 600);
		
		mainPanel = new JPanel(new BorderLayout());
		tablero = new TableroJuego();
		
		tablero.setBorder(BorderFactory.createLineBorder(Color.black));
		tablero.setBackground(new java.awt.Color(246, 209, 209));
		tablero.setSize(600, 400);
		mainPanel.add(tablero, BorderLayout.CENTER);
		tablero.setLayout(null);
		
		decoración1 = new JPanel();
		decoración1.setBorder(BorderFactory.createLineBorder(Color.black));
		decoración1.setBackground(new Color(150, 150, 150));
		decoración1.setBounds(0, 0, 586, 33);
		tablero.add(decoración1);				
		
		decoracion2 = new JPanel();
		decoracion2.setBorder(BorderFactory.createLineBorder(Color.black));
		decoracion2.setBackground(new Color(150, 150, 150));
		decoracion2.setBounds(0, 530, 586, 33);
		tablero.add(decoracion2);
		
		/*
		 * MENU DIFICULTAD Y TAMAÑO
		 */
		panelMenu = new JPanel();
		panelMenu.setBounds(114, 64, 356, 432);
		tablero.add(panelMenu);
		panelMenu.setLayout(null);
		
				lblSelecDifi = new JLabel("SELECCIONE LA DIFICULTAD");
				lblSelecDifi.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblSelecDifi.setBounds(10, 10, 210, 48);
				panelMenu.add(lblSelecDifi);
				
				btnFacil = new JButton();
				btnFacil.setText("F\u00C1CIL");
				btnFacil.setFont(new Font("Tahoma", Font.PLAIN, 11));
				btnFacil.setBounds(44, 53, 130, 25);
				panelMenu.add(btnFacil);
				
				lblFacil = new JLabel("Velocidad: 20 ms");
				lblFacil.setVerticalAlignment(SwingConstants.TOP);
				lblFacil.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblFacil.setBounds(209, 57, 130, 25);
				panelMenu.add(lblFacil);
				
				btnInter = new JButton();
				btnInter.setText("INTERMEDIO");
				btnInter.setFont(new Font("Tahoma", Font.PLAIN, 11));
				btnInter.setBounds(44, 88, 130, 25);
				panelMenu.add(btnInter);
				
				lblInter = new JLabel("Velocidad: 10 ms");
				lblInter.setVerticalAlignment(SwingConstants.TOP);
				lblInter.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblInter.setBounds(209, 92, 130, 25);
				panelMenu.add(lblInter);
				
				lblDificil = new JLabel("Velocidad: 5 ms");
				lblDificil.setVerticalAlignment(SwingConstants.TOP);
				lblDificil.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblDificil.setBounds(209, 127, 130, 25);
				panelMenu.add(lblDificil);
				
				btnDificil = new JButton();
				btnDificil.setText("DIFICIL");
				btnDificil.setFont(new Font("Tahoma", Font.PLAIN, 11));
				btnDificil.setBounds(44, 123, 130, 25);
				panelMenu.add(btnDificil);
				
				btnImposible = new JButton();
				btnImposible.setText("IMPOSIBLE");
				btnImposible.setFont(new Font("Tahoma", Font.PLAIN, 11));
				btnImposible.setBounds(44, 158, 130, 25);
				panelMenu.add(btnImposible);
				
				lblImposible = new JLabel("Velocidad: 1 ms");
				lblImposible.setVerticalAlignment(SwingConstants.TOP);
				lblImposible.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblImposible.setBounds(209, 162, 130, 25);
				panelMenu.add(lblImposible);
				
				lblSelecTam = new JLabel("SELECCIONE EL TAMA\u00D1O ");
				lblSelecTam.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblSelecTam.setBounds(10, 205, 210, 48);
				panelMenu.add(lblSelecTam);
				
				btnPequeño = new JButton();
				btnPequeño.setText("PEQUE\u00D1O");
				btnPequeño.setFont(new Font("Tahoma", Font.PLAIN, 11));
				btnPequeño.setBounds(44, 248, 130, 25);
				panelMenu.add(btnPequeño);
				
				lblpequeño = new JLabel("Velocidad: 20 ms");
				lblpequeño.setVerticalAlignment(SwingConstants.TOP);
				lblpequeño.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblpequeño.setBounds(209, 252, 130, 25);
				panelMenu.add(lblpequeño);
				
				btnMediano = new JButton();
				btnMediano.setText("MEDIANO");
				btnMediano.setFont(new Font("Tahoma", Font.PLAIN, 11));
				btnMediano.setBounds(44, 283, 130, 25);
				panelMenu.add(btnMediano);
				
				lblMediano = new JLabel("Velocidad: 10 ms");
				lblMediano.setVerticalAlignment(SwingConstants.TOP);
				lblMediano.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblMediano.setBounds(209, 287, 130, 25);
				panelMenu.add(lblMediano);
	
				lblGrande = new JLabel("Velocidad: 5 ms");
				lblGrande.setVerticalAlignment(SwingConstants.TOP);
				lblGrande.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblGrande.setBounds(209, 322, 130, 25);
				panelMenu.add(lblGrande);
				
				btnGrande = new JButton();
				btnGrande.setText("GRANDE");
				btnGrande.setFont(new Font("Tahoma", Font.PLAIN, 11));
				btnGrande.setBounds(44, 318, 130, 25);
				panelMenu.add(btnGrande);
				
				btnEmpezar = new JButton("START");
				btnEmpezar.setBounds(122, 385, 85, 21);
				panelMenu.add(btnEmpezar);
		/*
		 * FIN MENU
		 */
				
		frameMenuView.getContentPane().add(mainPanel);
	}
	
	private void configureListeners() {
		
		btnFacil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				velocidad = 200;
				
			}
		});
		
		btnInter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				velocidad = 150;
			}
		});
		
		btnDificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				velocidad = 70;
			}
		});
		
		btnImposible.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				velocidad = 1;
			}
		});
		
		btnPequeño.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ancho = 300;
				alto = 300;
			}
		});
		
		btnMediano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ancho = 600;
				alto = 600;
			}
		});
		
		btnGrande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ancho = 900;
				alto = 900;
				
			}
		});
		
		btnEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameMenuView.dispose();
				try {
					var juego = new JuegoView1(ancho, alto, velocidad);
					juego.start();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		
		
		
		
	}
}
