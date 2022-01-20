package ui;

import javax.swing.JFrame;

import models.Manzana;
import models.Serpiente;

/**
 * Clase MySnakeFrame
 * 
 * Este es el primer ejemplo de comentarios de documentación que vemos en JAVA
 * Como se puede apreciar son un bloque de comentarios, no sólo una línea
 * 
 * Aquí explicamos qué sentido tiene la clase
 * 
 * Esta clase hereda de JFrame. JFrame es una ventana equivalente a un Form en Gambas3
 * Nuestra ventana principal además del comportamiento y estado natural a una ventana gráfica
 * controlará todo el estado del juego. Como nuestro "game loop" está codificado como 
 * "run forever" tenemos que tener algún objeto que controle si el juego está pausado, empezado, terminado
 * en todo momento, y que a su vez le diga a la serpiente que se resetee, que se mueva, crezca, etc.
 * Para controlar el estado se usan "semáforos". Estos no son nada más que booleanos. Cuando están a false
 * sería el equivalente a "semáforo rojo" y cuando están a true sería el equivalente a "semáforo verde"
 * Estos semáforos se ponen en una serie de "if" que permiten controlar al objeto MySnakeFrame si se 
 * ejecuta alguna acción o no en la serpiente.
 * 
 * @author andres
 *
 */

public class MySnakeFrame extends JFrame {	
	
	//***** estado
	
	//Nuestra serpiente
	private Serpiente snake;
	private Manzana manzana;
	
	//semáforos para indicar que estamos jugando o no
	private boolean jugando;
	private boolean pausado;
	
	//semáforos para mostrar mensaje al final, sólo una vez.
	private boolean mostrarFinal;
	private boolean mostrado;
	private int ancho;
	private int alto;
	
	
	//**** Comportamientos
	
	//Constructor
	public MySnakeFrame(int ancho, int alto) {
		this.snake = new Serpiente();
		this.jugando = false;
		this.mostrarFinal = false;
		this.mostrado = false;
		this.pausado = false;
		this.ancho = ancho;
		this.alto = alto;
		this.manzana = new Manzana();
	}
	
	
	//si alguien necesita nuestra serpiente, se la proporcionamos.
	public Serpiente getSerpiente() {
		return snake;
	}
	
	public Manzana getManzana() {
		return manzana;
	}
	
	
	//tenemos que mostrar la ventanita de final de partida??? Sólo una vez...
	public boolean mostrarFin() {
		boolean resultado;
		
		resultado = false;
		if (mostrarFinal && !mostrado) { //estamos al final de una partida y no hemos mostrado nada
			resultado = true;  //activamos el resultado para que se muestre la ventana
			mostrado = true;   //ya no dejamos que se muestre más la próxima vez...
		}
		
		return resultado;
	}
	
	
	//toca crecer sólo si estamos en una partida activa y no estamos pausados...
	public void tocaCrecer() {
		if (jugando && !pausado)
			snake.crecer();
	}
	
	//toca moverse sólo si estamos en una partida activa y no estamos pausados...
	public void tocaMoverse() {
		if (jugando && !pausado)
			snake.moverse();
	}
	
	
	//han pulsado el botón de start, hay que ponerlo todo en orden.
	public void empezarDeNuevo() {
		snake = new Serpiente();  //nueva y flamante serpiente
		jugando = true;           //estamos jugando a partir de ¡YA!
		mostrarFinal = false;     //ni estamos al final ni mucho menos
		mostrado = false;         //hemos mostrado el msg de final
		pausado = false;          //Y todavía nadie ha pulsado el pause, todavía...
		manzana = new Manzana();
		
	}
	
	
	//Hay que ver si la serpiente sigue viva, pero sólo si estamos jugando y no en modo pausa...
	public void comprobarEstado(int iAlto, int iAncho, JFrame frameSnake) {
		if (jugando && !pausado) {
			if (snake.estaMuerta(iAlto, iAncho)) {
				//acabamos de matarnos. Hay que mostrar msg al final y ya no jugamos...
				jugando = false;
				mostrarFinal = true;
				mostrado = false;
				frameSnake.dispose();
				MenuView menu = new MenuView();
			}
		}
	}
	
	public boolean manzanaComida () {
		boolean respuesta = true;
		if (manzana.getPosX() == snake.getListaCuadrados().get(0).getX() && manzana.getPosY() == snake.getListaCuadrados().get(0).getY()) {
			nextManzana();
			respuesta = true;		
		}else {
			respuesta = false;
		}
		
		return respuesta;
	}	
	
	public void nextManzana() {
		
		int newX = (int)(Math.random()*ancho+1);
		int newY = (int) (Math.random()*alto+1);
		
		if (newX % 20 == 0 && newY % 20 == 0) {
			if(newX < ancho && newY < alto) {
				manzana.setPosX(newX);
				manzana.setPosY(newY);
			}
		}else {
			nextManzana();
		}
		
	}
	
	
	//sólo pausamos / continuamos si estamos jugando.
	public void pausaContinuaJuego() {
		if (jugando) {
			pausado = !pausado;
		}
	}
	
	//nos han pulsado tecla, cambiamos de dirección.
	public void cambiaDireccion(int key) {
		snake.cambiaDireccion(key);
	}



}
