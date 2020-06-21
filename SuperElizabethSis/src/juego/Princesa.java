package juego;
import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
import jdk.internal.org.jline.reader.impl.DefaultParser.ArgumentList;





public class Princesa {
	double x;
	double y;
	double ancho;
	double alto;
	double angulo;
	Image img;
		
	
	
	Princesa(double x,double y,double ancho,double alto,double angulo){
	    this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		this.angulo=angulo;
		this.img =  Herramientas.cargarImagen("princesa_cam.png");
	}
	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(img, x, y, 0);
	}
	
	public void subir() {
		this.y-=0.5;
		this.y=300;
	}	
	public void mover(int dx) {
			this.x = this.x + dx;
		}

	public void subir(int dy) {
			this.y = this.y + dy;
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
	
	Fuego dispararFuego() {
		return new Fuego(this.x,this.y);
	}
	private final int ALTURA_MAX_SALTO = 150;
	private boolean saltandoArriba = true;
	private int alturaSalto = 0;
	public boolean saltando = false;
	

	public void princesaSaltar(Entorno entorno) {
		if (!saltando)
			saltando = true;
		this.img =  Herramientas.cargarImagen("princesa_cam.png");

		if (alturaSalto < ALTURA_MAX_SALTO && saltandoArriba) {
			this.subir(-3);
			alturaSalto += 3;
			if (alturaSalto >= ALTURA_MAX_SALTO)
				saltandoArriba = false;
		}
		if (saltando && !saltandoArriba) {
			this.img =  Herramientas.cargarImagen("princesa_sal.png");
			this.subir(3);
			alturaSalto -= 3;
			if (alturaSalto <= 0) {
				this.img =  Herramientas.cargarImagen("princesa_cam.png");
				saltandoArriba = true;
				saltando = false;
				alturaSalto = 0;
			}
		}
	}

	
	}
	
	
