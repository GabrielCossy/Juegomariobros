package juego;



import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	Princesa princesa;	
	//asdtrhyt
	//dsfsdfsdfsdf
	//sdasdasd
	public static final String Princesa = null;
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Obstaculo obstaculo;
	private Soldado soldado;
	private Nube nube;
	
	
	public Object x;
	
	// Variables y métodos propios de cada grupo
	// ...
	//Image fondo;
	//fondo=Herramientas.cargarImagen("fondo.png");
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Super Elizabeth Sis - Grupo ... - v1", 800, 600);
		
		// Inicializar lo que haga falta para el juego
		// ...
		this.princesa=new Princesa(100,480,20,40,0);
		this.soldado=new Soldado(800,480,20,40,0);
		this.obstaculo=new Obstaculo(700,480,20,60,0);
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
		this.soldado.moverAdelante();
		this.obstaculo.moverAdelante();
		this.nube.moverAdelante();
		
		
		this.princesa.dibujarse(this.entorno);
		this.soldado.dibujarse(entorno);
		this.obstaculo.dibujarse(entorno);
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