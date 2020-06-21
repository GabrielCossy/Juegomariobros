package juego;


import java.awt.Color;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;


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
	private Fuego[] fuegos;
	private Image fondo;
	int Vidas;
	boolean contacto;
	
	private Fuego fuego;
	
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
		this.fondo = Herramientas.cargarImagen("Cielo.png");
		// Inicializar lo que haga falta para el juego
		// ...
		this.fuegos=new Fuego[100];
		this.princesa=new Princesa(100,490,20,40,0);
		this.soldado=new Soldado[1];
		this.obstaculo=new Obstaculo[4];
		
		
		this.soldado[0]=new Soldado(800,490,20,40,0);
		
		this.obstaculo[0]=new Obstaculo(700,480,20,60,0);
		this.obstaculo[1]=new Obstaculo(800,480,20,60,0);
		this.obstaculo[2]=new Obstaculo(950,480,20,60,0);
		this.obstaculo[3]=new Obstaculo(1050,480,20,60,0);
		//this.fondo=new Fondo(200,300,100,60,0);
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
		//this.fondo.dibujarse(entorno);
		this.nube.moverAdelante();
		//movimiento soldados
		for(int i=0;i<soldado.length;i++) {
					for (int j=0; j<obstaculo.length; j++) { //control de colicion
				if (obstaculo[j].x==soldado[i].x) 
					pi = pi + Math.PI*signo;
					signo = signo*-1;
			}
			soldado[i].mover(pi); //se le pasa el angulo a mover para indicar el sentido de mov
		}
				
		//Movimiento "princesa" 
		if (entorno.sePresiono(entorno.TECLA_SHIFT) || princesa.saltando)
			princesa.princesaSaltar(entorno);
		this.entorno.dibujarImagen(this.fondo,400,300, 0);
		for(int f=0;f<this.fuegos.length;f++) {
			if(this.fuegos[f]!=null) {
				this.fuegos[f].dibujarse(entorno);
				this.fuegos[f].lanzar();
			}
		}
		int j=0;
		while(j<this.fuegos.length && this.fuegos[j]!=null) {
			j++;
		}
		if(this.entorno.sePresiono(this.entorno.TECLA_ESPACIO)) {
			this.fuegos[j]=princesa.dispararFuego();
		}
		//fondo
		
		//Movimientos de obstaculos
		
		if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			
			//this.fondo.moverAdelante();
			for(int i=0;i<obstaculo.length;i++) {
				
				obstaculo[i].moverAdelante();
				//control de colicion princesa con obstaculos.
				if(princesa.toca(obstaculo[0]) || princesa.toca(obstaculo[1])  || princesa.toca(obstaculo[3]))
					contVidas--;
	            	entorno.cambiarFont("ARIAL",18,Color.BLACK);
	            	entorno.escribirTexto("Perdiste una vida"+contVidas,500,50);
			}
		}
		
		
		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA))
			
			for(int i=0;i<obstaculo.length;i++) {

				obstaculo[i].moverAdelante(); //hay que cambiar como el cambio de sentido del soldado.
			}
		
		entorno.cambiarFont("Arial", 18, Color.white);
		entorno.escribirTexto("Cantidad de vidas: " + contVidas, 550, 50);
		entorno.cambiarFont("Arial", 18, Color.white);
		entorno.escribirTexto("puntaje: " + puntaje, 550, 25);
		
		
		if(contVidas<=0) {	//control para indicar partida terminada por falta de vidas
			
			entorno.cambiarFont("ARIAL",30,Color.RED);
			entorno.escribirTexto("Perdiste!!!!"+contVidas,entorno.ancho()/2-200,entorno.alto()/2);
			
			princesa.detenerse(); //hay que corregir la inicialización
		}
			
		
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