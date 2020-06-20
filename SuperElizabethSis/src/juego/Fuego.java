package juego;
import java.awt.Color;

import entorno.Entorno;


public class Fuego {
	
	double x;
	double y;
	double ancho;
	double alto;
	boolean movimiento;
	double escala;
	
	Fuego(double x,double y){
		this.x=x;
		this.y=y;
		this.escala=0.1;
		this.ancho=ancho;
		this.alto=alto;
		this.movimiento=false;
	}
	public void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(x, y, ancho, alto, escala, Color.yellow);
	}
	public void lanzar() {
		if(this.movimiento) {
			this.x=this.x+5;
		}
	}
	public boolean salenDeRango(Entorno entorno) {
		if(this.x+(this.ancho/2)>=entorno.ancho())
			return true;
		else
			return false;
	}
	public boolean Quema(Soldado soldado) {
		if(( x > soldado.x-soldado.ancho/2) &&( x < soldado.x+soldado.ancho/2) && (y > soldado.y-soldado.alto/2)&& (y < soldado.y+soldado.alto/2)) {
			return true;
		}
		else {
			return false;
		}
		      
	}
}
		
		
		

		
		
		
	

		
	


