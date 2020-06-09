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

}
