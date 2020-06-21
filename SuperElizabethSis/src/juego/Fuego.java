package juego;
import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;


public class Fuego {
	
	double x;
	double y;
	double ancho;
	double alto;
	boolean movimiento;
	double escala;
	Image img;
	
	Fuego(double x,double y){
		this.x=x;
		this.y=y;
		this.escala=50;
		this.ancho=50;
		this.alto=10;
		this.movimiento=false;
		this.img =  Herramientas.cargarImagen("fuego.png");
	}
	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(img, x, y, 0);
	}
	public void lanzar() {
			this.x=this.x+5;
	
	}
	public boolean salenDeRango(Entorno entorno) {
		if(this.x+(this.ancho/2)>=entorno.ancho())
			return true;
		else
			return false;
	}
	/*public boolean Quema(Soldado soldado) {
		if(( x > soldado.x-soldado.ancho/2) &&( x < soldado.x+soldado.ancho/2) && (y > soldado.y-soldado.alto/2)&& (y < soldado.y+soldado.alto/2)) {
			return true;
		}
		else {
			return false;
		}*/
		      
	}

	
