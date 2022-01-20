package models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Serpiente {
    //Constantes. No hay

    //******   Atributos. Estado

    //Cuerpo de la serpiente, es una lista de cuadrados
    private static ArrayList<Cuadrado> listaCuadrados;

    //Dirección inicial del movimiento
    private int iDireccion;
        
    

    //******   Métodos -- Comportamientos

    //Creación
    public Serpiente(){
    	//creamos la lista de cuadrados.
        setListaCuadrados(new ArrayList());

        //añadimos el primero de los cuadrados...
        getListaCuadrados().add(new Cuadrado(60,60,20,(int)(Math.random()*16000000)));
        
        //siempre hacia abajo al principio
        iDireccion = Cuadrado.ABAJO;    

    }

    //Moverse. Una serpiente sabe moverse
    public void moverse(){
	
        Cuadrado nuevaCabeza;
        Cuadrado antiguaCabeza;
        
        
        //Primero cogemos la cabeza y la duplicamos
        antiguaCabeza = getListaCuadrados().get(0);
        nuevaCabeza = new Cuadrado(antiguaCabeza.getX(),antiguaCabeza.getY(),antiguaCabeza.getLado(),antiguaCabeza.getColor());

        //movemos la cabeza a su nueva posición
        nuevaCabeza.moverse(iDireccion);

        //la añadimos a la lista
        getListaCuadrados().add(0,nuevaCabeza);

        //borramos el último cuadrado por la cola (pop del basic)
        getListaCuadrados().remove(getListaCuadrados().size()-1);
	}

    

    public void crecer(){ 
    	
    	Cuadrado cabeza = getListaCuadrados().get(0);
    	
	        Cuadrado nuevaCabeza;
	        Cuadrado antiguaCabeza;
	        
	        //Primero cogemos la cabeza y la duplicamos
	        antiguaCabeza = getListaCuadrados().get(0);
	        nuevaCabeza = new Cuadrado(antiguaCabeza.getX(),antiguaCabeza.getY(),antiguaCabeza.getLado(),antiguaCabeza.getColor());
	        //movemos la cabeza a su nueva posición
	        nuevaCabeza.moverse(iDireccion);
	
	        //la añadimos a la lista
	        getListaCuadrados().add(0,nuevaCabeza);
	
	        //ahora no borramos la �ltima y hemos crecido...
          	
	}
    


    //la serpiente se muere porque se toca a si misma o porque se ha salido del tablero
    public boolean estaMuerta(int iAlto, int iAncho) {
    	boolean resultado;
    	
    	resultado = (seEstaTocandoEllaMisma() || seHaSalido(iAlto, iAncho));
    	
        return resultado;
    }

    //la cabeza, está tocando alguna parte de su cuerpo??
    private boolean seEstaTocandoEllaMisma() {
        int iCont;
        Cuadrado cabeza;
        
        cabeza = getListaCuadrados().get(0);

        //la cabeza podrá tocar como mucho, el quinto cuadrado en adelante de su cuerpo...
        //por eso el cuadrado 1, 2 y 3 no lo comprobamos
        for (iCont=4;iCont < getListaCuadrados().size();iCont++) {
            if (getListaCuadrados().get(iCont).estaEncimaDe(cabeza)) //oh oh, hemos chocado...
            	return true;
        }

        return false;
    }

    //nos hemos salido de los límites del tablero???
    private boolean seHaSalido(int iAlto, int iAncho) {
        //Hacemos las comprobaciones sobre la cabeza
        Cuadrado cabeza = getListaCuadrados().get(0);

        return (cabeza.getX() < 0 || cabeza.getX() > iAncho || cabeza.getY() < 0 || cabeza.getY() > iAlto);
    }

    //la serpiente también sabe pintarse
    public void pintarse(Graphics2D g) {
        int iCont;

        //pintamos desde el cuadrado 0 hasta el último. Cuidado, aquí con el "<" evitamos
        //tener que poner el "-1" que poniamos en el for del BASIC
        for (iCont=0;iCont < getListaCuadrados().size();iCont++) {
            getListaCuadrados().get(iCont).pintarse(g);
        }
    }

    //controlamos el cambio de dirección
    public void cambiaDireccion(int key) {
    	if (key == KeyEvent.VK_LEFT) {
    		iDireccion = Cuadrado.IZQ;
    	} else if (key == KeyEvent.VK_DOWN) {
    		iDireccion = Cuadrado.ABAJO;
    	} else if (key == KeyEvent.VK_UP) {
    		iDireccion = Cuadrado.ARRIBA;
    	} else if (key == KeyEvent.VK_RIGHT) {
    		iDireccion = Cuadrado.DER;
    	}
    }
    
    //los puntos se corresponden con el tamaño de nuestra serpiente
    public int getPuntos() {
    	return getListaCuadrados().size();
    }

	public ArrayList<Cuadrado> getListaCuadrados() {
		return listaCuadrados;
	}

	public static void setListaCuadrados(ArrayList<Cuadrado> listaCuadrados) {
		Serpiente.listaCuadrados = listaCuadrados;
	}
    
}