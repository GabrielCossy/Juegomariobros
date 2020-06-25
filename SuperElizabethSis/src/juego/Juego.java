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
	private Fuego[] fuegos;
	private Image fondo;
	
	boolean contacto;
	
	private Fuego fuego;
	
	int Vidas = 3;
	int puntaje = 0;
	double pi = Math.PI;
	int signo = -1;	
	public Object x;
	private Image img;	
	// Variables y métodos propios de cada grupo
	// ...	
	
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
		this.soldado=new Soldado[4];
		this.obstaculo=new Obstaculo[4];
		this.nube=new Nube[3];
		
		
		
		this.soldado[0]=new Soldado(850,490,20,40,0);
		this.soldado[1]=new Soldado(750,480,20,60,0);
		this.soldado[2]=new Soldado(850,480,20,60,0);
		this.soldado[3]=new Soldado(900,480,20,60,0);
		this.obstaculo[3]=new Obstaculo(1050,480,20,60,0);
		this.obstaculo[0]=new Obstaculo(700,480,20,60,0);
		this.obstaculo[1]=new Obstaculo(800,480,20,60,0);
		this.obstaculo[2]=new Obstaculo(950,480,20,60,0);
		this.obstaculo[3]=new Obstaculo(1050,480,20,60,0);
		//this.fondo=new Fondo(200,300,100,60,0);
		this.nube[0]=new Nube(200,100,100,60,0);
		this.nube[1]=new Nube(200,200,100,60,0);
		this.nube[2]=new Nube(300,100,100,60,0);
		
		
		
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
		this.nube[0].moverAdelante();
		this.nube[1].moverAdelante();
		this.nube[2].moverAdelante();
		this.obstaculo[0].moverAdelante();
		this.obstaculo[1].moverAdelante();
		this.obstaculo[2].moverAdelante();
		this.obstaculo[3].moverAdelante();
		this.soldado[0].moverAdelante();
		this.soldado[1].moverAdelante();
		this.soldado[2].moverAdelante();
		this.soldado[3].moverAdelante();
															//movimiento soldados
		for(int i=0;i<soldado.length;i++) {
					for (int j=0; j<obstaculo.length; j++) { //control de colicion
				if (obstaculo[j].x==soldado[i].x) 
					pi = pi + Math.PI*signo;
					signo = signo*-1;
			}
			soldado[i].mover(); //se le pasa el angulo a mover para indicar el sentido de mov
}
			
		//Movimiento "princesa" 
		if (entorno.sePresiono(entorno.TECLA_SHIFT) || princesa.saltando)
			princesa.princesaSaltar(entorno);
		this.entorno.dibujarImagen(this.fondo,400,300, 0);
		for(int f=0;f<this.fuegos.length;f++) {
			if(this.fuegos[f]!=null) {
				this.fuegos[f].dibujarse(entorno);
				this.fuegos[f].lanzar();
				for(int i=0;i<soldado.length;i++) {
				if(fuegos[f].Quema(soldado[i])){	 
					soldado[i].delete();
					fuegos[f].delete();
					
						}
				
			}
		}}
		int j=0;
		while(j<this.fuegos.length && this.fuegos[j]!=null) {
			j++;
		}
		if(this.entorno.sePresiono(this.entorno.TECLA_ESPACIO)) {
			this.fuegos[j]=princesa.dispararFuego();
			
		}
		//fondo
		
				
		
		if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			
			princesa.moverAdelante();
			
		}
		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			
			princesa.moverAtras();
		
		}
		
		
				
		 //hay que corregir la inicialización
		
		for(int i=0;i<obstaculo.length;i++) {
			//for(int l=0;l<fuegos.length;l++) {
				
		
		
				if(princesa.toca(obstaculo[i]) && !obstaculo[i].contacto && Vidas!=0){	 
					obstaculo[i].setContacto(true);
					obstaculo[i].delete();
					Vidas--;
					}
			
				/*if(fuegos[l].toca(soldado[i]) && !soldado[i].contacto ){
					fuegos[l].setContacto(true);
					fuegos[l].delete();
					soldado[i].setContacto(true);
					soldado[i].delete();
					
					}
					*/
			}
		
		
		for(int i=0;i<soldado.length;i++) {
			
			
		
			if(princesa.toca(soldado[i]) && !soldado[i].contacto && Vidas!=0){	 
				soldado[i].setContacto(true);
				soldado[i].delete();
					Vidas--;
					}
			}
		
		if (Vidas==0) {
			this.entorno.dibujarImagen(this.img,400,300, 0);
			
			fuego.delete();
			
			
		}	
		
		
		
		
		//dibujos
		
		

		
		
			
		
		
		this.princesa.dibujarse(this.entorno);
		
		this.nube[0].dibujarse(entorno);
		this.nube[1].dibujarse(entorno);
		this.nube[2].dibujarse(entorno);
		
		this.entorno.cambiarFont("Arial", 18, Color.white);
		this.entorno.escribirTexto("Cantidad de vidas: " + Vidas, 550, 50);
		this.entorno.cambiarFont("Arial", 18, Color.white);
		this.entorno.escribirTexto("puntaje: " + puntaje, 550, 25);
		

	
		
			for(int i=0;i<obstaculo.length;i++) {
				
				this.obstaculo[i].dibujarse(this.entorno);
				
			
			}
			
		
		
		
		for(int i=0;i<soldado.length;i++) {
			
			
			soldado[i].dibujarse(entorno);
			
				
			
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