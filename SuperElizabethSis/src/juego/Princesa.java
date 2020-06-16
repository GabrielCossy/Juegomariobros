package juego;
import java.awt.Color;
import entorno.Entorno;

public class Princesa {
	double x;
	double y;
	double ancho;
	double alto;
	double angulo;
	
	
	Princesa(double x,double y,double ancho,double alto,double angulo){
	    this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		this.angulo=angulo;
	}
	public void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(x, y,ancho,alto,angulo,Color.GREEN);
	}
	
	public void subir() {
		this.y-=0.5;
		this.y=300;
		
	
	}
	public void bajar() {
		this.y+=0.5;
		this.y=480;
	}
	public boolean toca(Obstaculo obstaculo) {
		return x > obstaculo.x - obstaculo.ancho/2 && 
				x < obstaculo.x + obstaculo.ancho/2 &&
				y > obstaculo.y - obstaculo.alto/2 && 
				y < obstaculo.y + obstaculo.alto/2 ;
	}
	public int detenerse() {
		this.x=0;
		this.y=0;
		return 0;
				
				
	}
	
	}
	
	
