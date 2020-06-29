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
	private Nube[] nube;
	private Coin[] coin;
	private Fuego[] fuegos;
	private Image fondo;
	
	boolean contacto;
	
	private Fuego fuego;
	int posc=850;
	int Vidas = 3;
	int puntaje = 0;
	int posc1 =0;
	double pi = Math.PI;
	int signo = -1;	
	public Object x;
	private Image img;
	int cont=350;
	
	
	
	// Variables y métodos propios de cada grupo
	// ...	
	Soldado[] solant;
	Juego()
	{
		
		
		
		
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Super Elizabeth Sis - Grupo ... - v1", 800, 600);	
		this.fondo = Herramientas.cargarImagen("Cielo.png");
		this.img = Herramientas.cargarImagen("fin.png");
		
		

		
		
		// Inicializar lo que haga falta para el juego
		// ...
		this.fuegos=new Fuego[100];
		this.princesa=new Princesa(100,490,20,40,0);
		this.soldado=new Soldado[3];
		this.obstaculo=new Obstaculo[3];
		this.nube=new Nube[3];
		this.coin=new Coin[2];
		
		
		//soldados iniciales
		
		this.soldado[0]=new Soldado(800,490,20,40,0);
		this.soldado[1]=new Soldado(900,480,20,60,0);
		this.soldado[2]=new Soldado(1000,480,20,60,0);
		
		
		//obstaculos iniciales
		
		
		this.obstaculo[0]=new Obstaculo(700,480,20,60,0);
		this.obstaculo[1]=new Obstaculo(900,480,20,60,0);
		this.obstaculo[2]=new Obstaculo(1200,480,20,60,0);
		
		
		//elementos
		
		this.nube[0]=new Nube(900,50,100,60,0);
		this.nube[1]=new Nube(600,200,100,60,0);
		this.nube[2]=new Nube(300,100,100,60,0);
		
		this.coin[0]=new Coin(800,350,100,60,0);
		this.coin[1]=new Coin(500,400,100,60,0);
		
		
		
		
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
		//fondo
		this.entorno.dibujarImagen(this.fondo,400,300, 0);
		
		
		for(int f=0;f<this.fuegos.length;f++) {
			if(this.fuegos[f]!=null) {
				this.fuegos[f].dibujarse(entorno);
				this.fuegos[f].lanzar();
				for(int i=0;i<soldado.length;i++) {
				if(fuegos[f].Quema(soldado[i])){
					posc1=posc;
					this.soldado[i]=new Soldado(posc,480,20,60,0);
					if (soldado[i].toca(soldado[i]));
					this.x=950;
					if (posc>1100) {
						 posc=1000 ;
					 }
					if (posc1==posc){
						 posc=posc+50;
					 }
					puntaje=puntaje+5;					
					fuegos[f].delete();
						}
			}
		}
			}
		int j=0;
		while(j<this.fuegos.length && this.fuegos[j]!=null) {
			j++;
		}
		
		//Movimiento "princesa" 
		
		if (entorno.sePresiono(entorno.TECLA_ARRIBA) || princesa.saltando)
			princesa.princesaSaltar(entorno);

		if(this.entorno.sePresiono(this.entorno.TECLA_ESPACIO)) {
			this.fuegos[j]=princesa.dispararFuego();
		}
		if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			princesa.moverAdelante();
			
		}
		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			princesa.moverAtras();
		
		}
		
		//Colision
		
		for(int i=0;i<obstaculo.length;i++) {
			if(princesa.toca(obstaculo[i]) && !obstaculo[i].contacto && Vidas!=0){	 
					obstaculo[i].setContacto(true);
					this.obstaculo[i]=new Obstaculo(850,480,20,60,0);
					Vidas--;
					}
			}
		for(int i=0;i<soldado.length;i++) {
		if(princesa.toca(soldado[i]) && !soldado[i].contacto && Vidas!=0){	 
			soldado[i].setContacto(true);
			this.soldado[i]=new Soldado(850,480,20,60,0);
			if (soldado[i].toca(soldado[i]));
			this.x=950;
			Vidas--;
				}
		}
		for(int i=0;i<coin.length;i++) {
				if(princesa.toca(coin[i]) ){	 
				this.coin[i]=new Coin(850,cont,100,60,0);
					cont=cont+50;
					puntaje=puntaje+5;
				}
				if (cont==450) {
					cont=350;
				}
		}
		
		if (Vidas==0) {
			this.entorno.dibujarImagen(this.img,400,300, 0);
			this.entorno.cambiarFont("Arial", 30, Color.white);
			this.entorno.escribirTexto("Puntaje: " + puntaje, 550, 200);
			fuego.delete();
			
		}	
		//dibujos
		
		
		this.princesa.dibujarse(this.entorno);
		
		this.entorno.cambiarFont("Arial", 18, Color.white);
		this.entorno.escribirTexto("Cantidad de vidas: " + Vidas, 550, 50);
		this.entorno.cambiarFont("Arial", 18, Color.white);
		this.entorno.escribirTexto("puntaje: " + puntaje, 550, 25);
		
		for(int i=0;i<nube.length;i++) {
			this.nube[i].dibujarse(this.entorno);
		}
		for(int i=0;i<coin.length;i++) {
			this.coin[i].dibujarse(this.entorno);
		}
		for(int i=0;i<obstaculo.length;i++) {
			this.obstaculo[i].dibujarse(this.entorno);
					
		}
		//movimientos para adelante
		
		for(int i=0;i<soldado.length;i++) {
			soldado[i].dibujarse(entorno);
		}
		for(int i=0;i<nube.length;i++) {
			this.nube[i].moverAdelante();
		}for(int i=0;i<coin.length;i++) {
			this.coin[i].moverAdelante();
		}for(int i=0;i<obstaculo.length;i++) {
			this.obstaculo[i].moverAdelante();
		}
		for(int i=0;i<soldado.length;i++) {
			this.soldado[i].moverAdelante();
						
		}
		
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