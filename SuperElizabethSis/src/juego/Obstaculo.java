package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Obstaculo {
	double x;
	double y;
	double ancho;
	double alto;
	double angulo;
	boolean contacto;
	Image img;
	
	Obstaculo(double x,double y,double ancho,double alto,double angulo){
	    this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		this.angulo=angulo;
		this.contacto=false;
		this.img =  Herramientas.cargarImagen("bloque.png");
		
	}
	
	

	public void pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	
	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(img, x, y, 0);
	}
	public void moverAtras() {
		this.x += Math.cos(this.angulo)*1;
		//this.y += Math.sin(this.angulo)*2;
		
		//if (this.x > 850) {
			//this.x=0;
		//}
			
		if (this.x > 850) {
			this.x=0;
		}
		if (this.x < -50) {
			this.x=850;
		}	
		
		
	}
	
	
	public void delete() {
		this.y=this.y+5000;
	}
	public boolean tocaPrincesa(Princesa princesa) {
		if(( x >princesa.x-princesa.ancho/2) &&( x < princesa.x+princesa.ancho/2) && (y > princesa.y-princesa.alto/2)&& (y < princesa.y+princesa.alto/2)) {
			this.y=this.y+5000;
			return true;
		}
		else {
			return false;
		}
	
	}
	

public boolean isContacto() {
	return contacto;
}
public void setContacto(boolean contacto) {
	this.contacto = contacto;	
}
public boolean toca(Fuego Fuego) {
	
	return x > Fuego.x - Fuego.ancho/2 && 
			x < Fuego.x + Fuego.ancho/2 &&
			y > Fuego.y - Fuego.alto/2 && 
			y < Fuego.y + Fuego.alto/2 ;
			
}


public void moverAdelante() {
	if(x>0) {
		x-=1.5;
	}
	else {
		x=780;
		this.contacto=false;
	
	}
	
}

}
