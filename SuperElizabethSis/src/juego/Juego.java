package juego;


import java.awt.Color;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

//import java.math;


public class Juego extends InterfaceJuego
{
	Princesa princesa;	
	
	
	public static final String Princesa = null;
	private static final String Puntaje = null;
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Obstaculo[] obstaculo;
	private Soldado[] soldado;
	private Nube nube;
	int contVidas = 3;
	int puntaje = 0;
	double pi = Math.PI;
	int signo = -1;
	
	public Object x;
	
	// Variables y métodos propios de cada grupo
	// ...
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Super Elizabeth Sis - Grupo ... - v1", 800, 600);
		
		// Inicializar lo que haga falta para el juego
		// ...
		
		this.princesa=new Princesa(100,480,20,40,0);
		this.soldado=new Soldado[1];
		this.obstaculo=new Obstaculo[4];
		
		this.soldado[0]=new Soldado(800,480,20,40,0);
		
		this.obstaculo[0]=new Obstaculo(700,480,20,60,0);
		this.obstaculo[1]=new Obstaculo(800,480,20,60,0);
		this.obstaculo[2]=new Obstaculo(950,480,20,60,0);
		this.obstaculo[3]=new Obstaculo(1050,480,20,60,0);
		
		this.nube=new Nube(200,100,100,60,0);

		
		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	
	public void tick()
	{
		
		// Procesamiento de un instante de tiempo
		// ...

		this.nube.moverAdelante();
		
		
		//movimiento soldados
		
		
		
		//Movimiento "princesa" 
		if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
				
			for(int i=0;i<obstaculo.length;i++) {

				obstaculo[i].moverAdelante();

				}
		}
		for(int i=0;i<soldado.length;i++) {
			
			for (int j=0; j<obstaculo.length; j++) { //control de colicion
				if (obstaculo[j].x==soldado[i].x) 
					pi = pi + Math.PI*signo;
					signo = signo*-1;
											
			}
			
				soldado[i].mover(pi); //se le pasa el angulo a mover para indicar el sentido de mov
		}

		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA))
			this.princesa.moverAdelante();
		
		
		//if (entorno.estaPresionada(entorno.TECLA_ARRIBA))
		//	this.princesa.moverArriba(); no me salio pa q salte
			
		
		
		entorno.cambiarFont("Arial", 18, Color.white);
		entorno.escribirTexto("Cantidad de vidas: " + contVidas, 550, 50);
		entorno.cambiarFont("Arial", 18, Color.white);
		entorno.escribirTexto("puntaje: " + puntaje, 550, 25);
		
		entorno.cambiarFont("Arial", 18, Color.white);
		entorno.escribirTexto("posicion soldado: " + soldado[0].x, 550, 65);
		entorno.cambiarFont("Arial", 18, Color.white);
		entorno.escribirTexto("posicion obs1: " + obstaculo[0].x, 550, 85);
		entorno.cambiarFont("Arial", 18, Color.white);
		entorno.escribirTexto("posicion obs2: " + obstaculo[1].x, 550, 105);
		entorno.cambiarFont("Arial", 18, Color.white);
		entorno.escribirTexto("posicion obs3: " + obstaculo[2].x, 550, 125);
		entorno.cambiarFont("Arial", 18, Color.white);
		entorno.escribirTexto("posicion obs4: " + obstaculo[3].x, 550, 145);
		
		
			
		
		//dibujos
		this.princesa.dibujarse(this.entorno);

		for(int i=0;i<obstaculo.length;i++) {
			this.obstaculo[i].dibujarse(this.entorno);
		}
		for(int i=0;i<soldado.length;i++) {
			this.soldado[i].dibujarse(this.entorno);
		}
		this.nube.dibujarse(entorno);
		
		
		

	}
	

	private void obstaculo(Entorno entorno2) {
		// TODO Apéndice de método generado automáticamente
				
	}
	
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}