package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Nube {
	double x;
	double y;
	double ancho;
	double alto;
	double angulo;
	Image  img1;
		
	
	
	Nube(double x,double y,double ancho,double alto,double angulo){
	    this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		this.angulo=angulo;
		
	}
		
	public void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(x, y,ancho,alto,angulo,Color.	white);
	}
	
	public void moverAdelante() {
		
		this.x -= Math.cos(this.angulo)*1;
		this.y += Math.sin(this.angulo)*2;
		
		if (this.x > 850) {
			this.x=0;
		}
		if (this.x < -50) {
			this.x=850;
		}	
		
	}
}