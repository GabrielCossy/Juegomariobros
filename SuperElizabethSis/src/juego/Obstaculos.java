package juego;

import entorno.Entorno;
import java.awt.Color;

public class Obstaculos {
	double x;
	double y;
	double alto;
	double ancho;
	double angulo;
	boolean contacto;
	
	public Obstaculos(double x,double y,double alto,double ancho,double angulo) {
		this.x=x;
		this.y=y;
		this.alto=alto;
		this.ancho=ancho;
		this.angulo=angulo;
		this.contacto=false;
	}
	public void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(x, y, ancho, alto, angulo, Color.RED);
		
		
	}
	public void avanzarObstaculos() {
		if(x>0) {
			x-=1.5;
		}
		else {
			x=780;
			this.contacto=false;
		
		}
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getAlto() {
		return alto;
	}
	public void setAlto(double alto) {
		this.alto = alto;
	}
	public double getAncho() {
		return ancho;
	}
	public void setAncho(double ancho) {
		this.ancho = ancho;
	}
	public double getAngulo() {
		return angulo;
	}
	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}
	public boolean isContacto() {
		return contacto;
	}
	public void setContacto(boolean contacto) {
		this.contacto = contacto;
	}
	

		
	}


