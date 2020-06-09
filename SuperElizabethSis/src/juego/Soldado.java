package juego;

import java.awt.Color;

import entorno.Entorno;

public class Soldado {
	double x;
	double y;
	double ancho;
	double alto;
	double angulo;
	
	
	Soldado(double x,double y,double ancho,double alto,double angulo){
	    this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		this.angulo=angulo;
	}
	
	public void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(x, y,ancho,alto,angulo,Color.RED);
	}
	
	public void moverAdelante() {
		this.x -= Math.cos(this.angulo)*2;
		this.y += Math.sin(this.angulo)*2;
	}
}

