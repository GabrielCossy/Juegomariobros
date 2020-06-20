package juego;

import java.awt.Color;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;



public class Soldado {
	double x;
	double y;
	double ancho;
	double alto;
	double angulo;
	Image img;
	
	Soldado(double x,double y,double ancho,double alto,double angulo){
	    this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		this.angulo=angulo;
		this.img =  Herramientas.cargarImagen("soldado.png");
	}
	
	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(img, x, y, 0);
	}
	
	public void mover(double angulo) {
		//con angulo indico el sentido del movimiento con 0 a la izq y 180 a la der
		
		this.x += Math.cos(angulo);
		//this.y += Math.sin(this.angulo)*2;
		
		if (this.x > 850) {
			this.x=0;
		}
		if (this.x < -50) {
			this.x=850;
		}	
		
	}
	
		
	}
	
	


