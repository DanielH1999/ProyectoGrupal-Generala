/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @authores: Alejandra, Daniel, Leon
 */

public class GeneralaCLI
{
	public static void main(String[] args)
	{
				
		int maxJugadores = 5; //Cantidad maxima de jugadores
		
		int cantDados = 5; //Cantidad de dados
		
		int turnos = 3; //Cantidad de turnos por jugador
		
		String[] jugadores = new String[maxJugadores]; //Array de jugadores
		
		jugadores = averiguarJugadores(maxJugadores); //Invocacion del metodo que averigua los nombres de los jugadores y los guarda en jugadores
		
		//Definir una matrix donde guardar los puntajes de todos los jugadores
		//-> Señalizar a que jugador pertenecen los puntajes (ej: por numero de jugador)
		//(HECHO):
		int[][] puntajes = new int[jugadores.length][12];
		//Puntajes[jugador][0] numero de jugador
		//Puntajes[jugador][1~6] cantidad de Dados del mismo numero que el indice
		//Puntajes[jugador][7~10] escalera~generala
		//Puntajes[jugador][11] total del jugador
		
		//INICIO DEL JUEGO
		
		
		//ToDo 2:
		//llevar cuentas de turno por jugador
		//-> Cuando terminen los turnos, pasar al siguiente jugador
		//
		//llevar cuentas de jugador actual
		//
		//llevar cuentas de cuantas veces se jugo por jugador
		//-> Informar el ganador cuando se hayan terminado las jugadas posibles o alguien consiga GENERALA SERVIDA
		
		//ToDo 3:
		//Poner un boton para que el usuario se sienta participe de la tirada de dados
		
		int[] dados = tirarDados(cantDados); //Array de los 5 dados = invocacion del metodo que pone valores al azar
		
		System.out.println(Arrays.toString(dados));//Mostrar los dados en el array
		
		//ToDo 4:
		//Preguntarle al usuario que dados quiere cambiar
		//-> Hacerlo hasta que se terminen sus turno

		//ToDo 5:
		//Averiguar que puede hacer el usuario con los dados que tiene
		//-> Darle a elegir entre las opciones
		
		//ToDo 6:
		//Anotar los puntos elegidos por el usuario en la casilla que corresponda
		//-> Sumar los puntos al total del jugador
		
		//ToDo 7:
		//Pasar al siguiente jugador
		//repetir todos los pasos desde "INICIO DEL JUEGO"
		
		//ToDo 8:
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
}
