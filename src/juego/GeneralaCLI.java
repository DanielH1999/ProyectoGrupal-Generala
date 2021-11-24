/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//Hecho por Alejandra, Daniel, Leon.

public class GeneralaCLI
{
	public static void main(String[] args)
	{
		//los siguientes valores fueron inicializados en 1 para facilidad de pruebas: maxJugadores, cantTurnos
		int maxJugadores = 1; //Cantidad maxima de jugadores
		
		int cantTurnos = 1; //Cantidad de turnos por jugador (DEFAULT: 3)
		
		int cantDados = 5; //Cantidad de dados
		
		
		String[] jugadores = new String[maxJugadores]; //Array de jugadores
		
		jugadores = averiguarJugadores(maxJugadores); //Invocacion del metodo que averigua los nombres de los jugadores y los guarda en jugadores
		
		//(ToDo 1 HECHO):
		int[][] puntajes = new int[jugadores.length][12];
		//puntajes[jugador][0] numero de jugador
		//puntajes[jugador][1~6] cantidad de puntos en el dado ej: puntajes[jugador][4] es el puntaje que el jugador anoto al 4
		//puntajes[jugador][7] escalera
		//puntajes[jugador][8] full
		//puntajes[jugador][9] poker
		//puntajes[jugador][10] generala
		//puntajes[jugador][11] total del jugador
		
		//pongo el numero de jugador en la columna inicial de cada fila:
		for (int jugador = 0; jugador < jugadores.length; jugador++) //por cada jugador en la lista
		{
			puntajes[jugador][0] = jugador; //agregar el numero de jugador en fila,columna=(jugador,0)
	    }
		
		//INICIO DEL JUEGO
		for (int jugador = 0; jugador < jugadores.length; jugador++) //llevar cuentas de jugador actual
		{
			for (int turno = 0; turno < cantTurnos; turno++) //llevar cuentas de turno por jugador
			{
				//llevar cuentas de las jugadas que faltan hacer
				//-> Informar el ganador cuando se hayan terminado las jugadas posibles o alguien consiga GENERALA SERVIDA
				
				
				int[] dados = tirarDados(cantDados); //Array de los 5 dados = invocacion del metodo que pone valores al azar

				System.out.println(Arrays.toString(dados));//Mostrar los dados en el array

				//ToDo 4 (tomado por Alejandra):
				//Preguntarle al usuario si quiere cambiar algun dado
				//Dejar que el usuario seleccione los dados que quiere cambiar
				//Volver a tirar los dados a cambiar
				//-> Hacerlo hasta que se terminen sus turno

				//ToDo 5:
				//Revisar la lista de dados y comparar con las posibles jugadas especiales
				//Informarle al usuario donde puede anotar puntos
				//Hacer que el usuario gane automaticamente si saca una generala en el primer turno 
				//-> Darle a elegir entre las opciones

				//ToDo 6:
				//Anotar los puntos elegidos por el usuario en puntajes[jugador][lo que corresponda]
				//-> Sumar los puntos al total del jugador (puntajes[jugador][11])

			} //-> Cuando terminen los turnos, pasar al siguiente jugador (fin del for que cuenta turnos)
		} //fin del for de seleccion de jugador
		
		//Cuando se termine de jugar

		//ToDo 7:
			//Al terminar de jugar, informar ganador
			//-> Posiblemente imprimir una tabla de puntuaciones
	}
	
	//una declaracion de funcion o metodo:
	private static String[] averiguarJugadores(int maxJugadores) //metodo que toma como parametro maxJugadores y devuelve String[]
	{	
		Scanner leer = new Scanner(System.in);
		
		String[] Jugadores = new String[maxJugadores]; //Lista de jugadores tiene maxJugadores elementos
		
		for (int cantJugadores = 0; cantJugadores < maxJugadores; cantJugadores++) //Iterar por toda la lista Jugadores
		{
			System.out.print("Jugador " + (cantJugadores+1) + "/" + maxJugadores + ": "); //Indicar numero de jugador a agregar
			
			Jugadores[cantJugadores] = leer.next(); //Pedir nombre de jugador al usuario
		}
		return Jugadores; //Devolver la lista de jugadores al metodo main()
	}
	
	private static int[] tirarDados(int cantDados) //metodo que toma como parametro int cantDados y devuelve int[] dados
	{	
		Random azar = new Random(); //Una clase del paquete java.util que genera numeros pseudo-aleatorios
		
		int[] dados = new int[cantDados]; //Declaro un array para poner los dados
		
		for (int i = 0; i < cantDados; i++) //Iterar por la cantidad de dados del array
		{
			dados[i] = 1 + azar.nextInt(6); //Poner un valor aleatorio en el dado actual
		}
		return dados; //Devuelvo el int[] dados
	}
	
	private int/*<-tipo de dato que devuelve*/ metodoDeEjemplo(int parametro, int otroParametro)
	{
		//un parametro o argumento es un dato que toma un metodo o funcion para usar
		//en este caso, todos los argumentos son de tipo entero
		
		//devolver un valor significa agarrar una variable y pasarsela a la funcion invocadora, generalmente main()
		int resultado = parametro + otroParametro;
		
		return resultado; //devolver resultado
		//el valor devuelto puede ser asignado a una variable o usado al momento de la llamada en la funcion invocadora
		
		//ej mivariable = funcionX();
		
		//ej if (tengoDosOjos()) donde tengoDosOjos devuelve boolean (true o false)
		
	}
}
