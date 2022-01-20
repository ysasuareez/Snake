package models;

import java.awt.Color;
import java.awt.Graphics2D;

public class Manzana {
	
	/*
	 * ATRIBUTOS
	 */
    private int posX;
    private int posY;
    private int lado;    
    private int colorManzana;

    /*
     * CONSTRUCTOR
     */
	public Manzana() {
		super();
		this.posX = 20;
		this.posY = 20;
		this.lado = 20;
		this.colorManzana = 0;
		
	}
	/*
	 *  G & S
	 */
	public int getPosX() {
		return posX;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public int getLado() {
		return lado;
	}
	
	public void setLado(int lado) {
		this.lado = lado;
	}
	
	public int getColor() {
		return colorManzana;
	}
	
	public void setColor(int color) {
		this.colorManzana = color;
	}
	
		
	//Una manzana tiene que saber pintarse
    public void pintarse(Graphics2D g) {
    	g.setColor(new Color(168, 0, 0));
    	//g.drawRect(posX, posY, lado, lado);
    	g.fillRect(posX, posY, lado, lado);
		//g.fillOval(posX, posY, lado, lado);
    }
		
    
    	/*
    	 * CREO QUE NO ES NECESARIO
    	 */
    //una manzana tiene que ser comida por la cabeza de la serpiente
    public boolean estaEncimaDe(Cuadrado cabeza) {
    	
        return (cabeza.getX() == posX && cabeza.getY() == posY);
    }
		
			
			
			
	
}
