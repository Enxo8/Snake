package views;

import javax.swing.JFrame;

import models.Serpiente;

public class MySnakeFrame extends JFrame{

	//***** estado
	
		//Nuestra serpiente
		private Serpiente snake;
		
		//semáforos para indicar que estamos jugando o no
		private boolean jugando;
		private boolean pausado;
		
		//semáforos para mostrar mensaje al final, sólo una vez.
		private boolean mostrarFinal;
		private boolean mostrado;
		
		
		//**** Comportamientos
		
		//Constructor
		public MySnakeFrame() {
			snake = new Serpiente();
			jugando = false;
			mostrarFinal = false;
			mostrado = false;
			pausado = false;
		}
		
		
		//si alguien necesita nuestra serpiente, se la proporcionamos.
		public Serpiente getSerpiente() {
			return snake;
		}
		
		
		//tenemos que mostrar la ventanita de final de partida??? Sólo una vez...
		public boolean mostrarFin() {
			boolean resultado;
			
			resultado = false;
			if (mostrarFinal && !mostrado) { //estamos al final de una partida y no hemos mostrado nada
				resultado = true;  //activamos el resultado para que se muestre la ventana
				mostrado = true;   //ya no dejamos que se muestre más la próxima vez...
			}
			
			return resultado;
		}
		
		
		//toca crecer sólo si estamos en una partida activa y no estamos pausados...
		public void tocaCrecer() {
			if (jugando && !pausado)
				snake.crecer();
		}
		
		//toca moverse sólo si estamos en una partida activa y no estamos pausados...
		public void tocaMoverse() {
			if (jugando && !pausado)
				snake.moverse();
		}
		
		
		//han pulsado el botón de start, hay que ponerlo todo en orden.
		public void empezarDeNuevo() {
			snake = new Serpiente();  //nueva y flamante serpiente
			jugando = true;           //estamos jugando a partir de ¡YA!
			mostrarFinal = false;     //ni estamos al final ni mucho menos
			mostrado = false;         //hemos mostrado el msg de final
			pausado = false;          //Y todavía nadie ha pulsado el pause, todavía...
		}
		
		
		//Hay que ver si la serpiente sigue viva, pero sólo si estamos jugando y no en modo pausa...
		public void comprobarEstado(int iAlto, int iAncho) {//Comentar esto para no morir
			if (jugando && !pausado) {
				if (snake.estaMuerta()) {
					//acabamos de matarnos. Hay que mostrar msg al final y ya no jugamos...
					jugando = false;
					mostrarFinal = true;
					mostrado = false;
				}
			}
		}
		
		
		//sólo pausamos / continuamos si estamos jugando.
		public void pausaContinuaJuego() {
			if (jugando) {
				pausado = !pausado;
			}
		}
		
		//nos han pulsado tecla, cambiamos de dirección.
		public void cambiaDireccion(int key) {
			snake.cambiaDireccion(key);
		}
}
