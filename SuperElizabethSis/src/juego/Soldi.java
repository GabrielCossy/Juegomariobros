package juego;

import java.awt.Color;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;



public class Soldi {
	double x;
	double y;
	double ancho;
	double alto;
	double angulo;
	boolean contacto;
	Image img;
	
	
	double pi = Math.PI;
	int signo = -1;
	
	Soldi(double x,double y,double ancho,double alto,double angulo){
	    this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		this.angulo=angulo;
		this.img =  Herramientas.cargarImagen("soldado.png");
	}
	public int getX() {
		return (int) x;
	}
	
	public void delete() {
		this.y=this.y+5000;
	}
	public int getY() {
		return (int) y;
	}
	public void Agente(int x, int y) {
		this.x = x;
		this.y = y;
	}
	Fuego dispararFuego() {
		return new Fuego(this.x,this.y);
	}
	
	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(img, x, y, 0);
	}
	
	public void mover() {
		//con angulo indico el sentido del movimiento con 0 a la izq y 180 a la der
		
		this.x += Math.cos(pi)*2;
		//this.y += Math.sin(this.angulo)*2;
		
		if (this.x > 1600) {
			this.x=950;
			pi = pi + Math.PI*signo;
			signo = signo*-2;
		}
		if (this.x < -50) {
			this.x=950;
		}	
		
	}
	public void moverAtras() {
		this.x += Math.cos(this.angulo)*2;
		
		if (this.x < -50) {
			this.x=850;
		}	
	}	
	
	public boolean rebote(Obstaculo obstaculo) {
		if(( x ==obstaculo.x-obstaculo.ancho/2) ||( x == obstaculo.x+obstaculo.ancho/2) || (y == obstaculo.y-obstaculo.alto/2)|| (y == obstaculo.y+obstaculo.alto/2)) {
			pi = pi + Math.PI*signo;
			signo = signo*-1;
			
			return true;
		}
		else {
			return false;
		}
	
	}	
	
	public boolean rebote(Soldi soldado,Soldi soldado1) {
		if(( soldado.x ==soldado1.x-soldado1.ancho/2) ||( soldado.x == soldado1.x+soldado1.ancho/2) || (soldado.y == soldado1.y-soldado1.alto/2)|| (soldado.y == soldado1.y+soldado1.alto/2)) {
			pi = pi + Math.PI*signo;
			signo = signo*-1;
			
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
		
		
	public boolean tocaPrincesa(Princesa princesa) {
		if(( x >princesa.x-princesa.ancho/2) &&( x < princesa.x+princesa.ancho/2) && (y > princesa.y-princesa.alto/2)&& (y < princesa.y+princesa.alto/2)) {
			return true;
		}
		else {
			return false;
		}
	
	}
	public void moverAdelante() {
		
		this.x -= Math.cos(this.angulo)*1;
		this.y += Math.sin(this.angulo)*2;
		
		
		
	}
	
	}
	
	


