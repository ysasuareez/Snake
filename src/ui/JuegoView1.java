package ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import models.Manzana;
import models.TableroJuego;

public class JuegoView1 extends Thread{
		
		private int ancho = 0;
		private int alto = 0;
		private int velocidad = 0;
		private int contador;
		private MySnakeFrame frameSnake;
		private JPanel mainPanel;
		private TableroJuego tablero;
		private JPanel botonera;
		private JLabel puntos;
		private JLabel puntosNum;
		private JButton start;
		private JButton pause;
		private ControlTeclado miControlador;
		private Manzana manzana;

		/**
		 * Create the application.
		 */
		public JuegoView1(int ancho, int alto, int velocidad) {
			this.ancho = ancho;
			this.alto = alto;
			this.velocidad = velocidad;

		}
		
		
		public int getAncho() {
			return ancho;
		}

		public void setAncho(int ancho) {
			this.ancho = ancho;
		}

		public int getAlto() {
			return alto;
		}

		public void setAlto(int alto) {
			this.alto = alto;
		}

		public int getVelocidad() {
			return velocidad;
		}

		public void setVelocidad(int velocidad) {
			this.velocidad = velocidad;
		}
		
		
		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			configureUIComponents();
			configureListeners();
			empezar();
		}
		
		/**
		 * @wbp.parser.entryPoint
		 */
		@Override
		public void run() {
			frameSnake = new MySnakeFrame(ancho, alto);
			try {
				configureUIComponents();
				configureListeners();
				empezar();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		


		private void configureUIComponents() {
							
				// 1. Crear el frame.
				frameSnake = new MySnakeFrame(ancho, alto);		
	
				// asignamos el tamaño a nuestra ventana, y hacemos que se cierre cuando nos
				// pulsan
				// la X de cerrar la ventana
				frameSnake.setSize(ancho, alto);
				frameSnake.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
				// 3. Ahora creamos los componentes y los ponemos en la frame (ventana).
		
				// El panel de fondo. Rellena el frame, y sirve de contenedor del tablero y de
				// la botonera.
				mainPanel = new JPanel(new BorderLayout());
		
				// Ahora creamos el tablero. Recordamos: no deja de ser un panel un poquito
				// "especial"
				tablero = new TableroJuego();
		
				// Les damos las propiedades a nuestro tablero. Su color, tamaño y borde
				tablero.setBorder(BorderFactory.createLineBorder(Color.black));
				tablero.setBackground(new java.awt.Color(246, 209, 209));
				tablero.setSize(ancho, alto);
		
				// Le damos un enlace al tablero para que sepa quién es su frame (ventana) y así
				// sepa
				// quién contiene la serpiente y quién controla el juego...
				tablero.setSnakeFrame(frameSnake);
		
				// Ahora el turno de la botonera. Tendrá los dos botones y las etiquetas de
				// texto
				botonera = new JPanel();
				botonera.setBorder(BorderFactory.createLineBorder(Color.black));
				botonera.setBackground(new java.awt.Color(150, 150, 150));
		
				// Ahora definimos las dos etiquetas para los puntos.
				puntos = new JLabel();
				puntos.setText("Puntos: ");
				puntos.setBackground(new java.awt.Color(190, 190, 190));
		
				puntosNum = new JLabel();
				puntosNum.setText("0");
				puntosNum.setBackground(new java.awt.Color(190, 190, 190));
		
				// turno de los botones de empezar y pausar/continuar
				start = new JButton();
				start.setSize(50, 20);
				start.setText("Start");
				
		
				pause = new JButton();
				pause.setSize(50, 20);
				pause.setText("Pause");
				
		
				// Preparamos el control del teclado
				miControlador = new ControlTeclado();
				miControlador.setSnakeFrame(frameSnake); // le damos al controlador de teclado un enlace el frame principal
				tablero.addKeyListener(miControlador); // le decimos al tablero que el teclado es cosa de nuestro controlador
				tablero.setFocusable(true); // permitimos que el tablero pueda coger el foco.
		
				// Añadimos los componentes uno a uno, cada uno en su contenedor, y al final el
				// panel principal
				// se añade al frame principal.
				botonera.add(start);
				botonera.add(pause);
				botonera.add(puntos);
				botonera.add(puntosNum);
		
				mainPanel.add(botonera, BorderLayout.PAGE_END);
				mainPanel.add(tablero, BorderLayout.CENTER);
				frameSnake.add(mainPanel);

				frameSnake.setVisible(true); // activamos la ventana principal para que sea "pintable"
				
				contador = 0; // nuestro control de los pasos del tiempo. Cada vez que contador cuenta un
								// paso, pasan 10ms
		}
		
		private void configureListeners() {
			start.addActionListener(new MyButtonListener(frameSnake, tablero));

			pause.addActionListener(new MyButtonListener(frameSnake, tablero));
			
		}
				
				
		public void empezar() {
				
				while (true) { // por siempre jamás (hasta que nos cierren la ventana) estamos controlando el
								// juego.
		
					// actualizamos el estado del juego
				//	if (contador % velocidad == 0) { // cada xms nos movemos o crecemos...	
						if (frameSnake.manzanaComida()) { // Cada 600ms crecemos y reseteamos el contador
							contador = 0;
							frameSnake.tocaCrecer();
							//frameSnake.nextManzana();
							// hemos crecido... actualizamos puntos.
							puntosNum.setText(Integer.toString(frameSnake.getSerpiente().getPuntos()));
							
						} else { // a los 200 y 400 ms nos movemos...
							contador++;
							frameSnake.tocaMoverse();
							frameSnake.comprobarEstado(tablero.getHeight(), tablero.getWidth(), frameSnake);
						}
						frameSnake.comprobarEstado(tablero.getHeight(), tablero.getWidth(), frameSnake); // comprobamos si hemos muerto o no.
		
//					} else { // Cada vez que no hay que moverse o crecer, simplemente contamos...
//						contador++;
//					}
		
					// hemos terminado?? mostramos msg
					if (frameSnake.mostrarFin()) {
						JOptionPane.showMessageDialog(frameSnake,
								"Se acabo vaquero, has conseguido " + puntosNum.getText() + " puntos");
					}
		
					// Repintamos
					tablero.repaint();
		
					// Esperamos para dar tiempo al thread de repintado a pintar.
					try {
						Thread.sleep(velocidad);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		


		
}



