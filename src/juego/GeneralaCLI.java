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
			//tirar dados por primera vez para cada jugador
			int[] dados = tirarDados(5); //Array de dados = return del metodo que pone valores al azar
			
			for (int turno = 0; turno < cantTurnos; turno++) //llevar cuentas de turno por jugador
			{
				//llevar cuentas de las jugadas que faltan hacer
				//-> Informar el ganador cuando se hayan terminado las jugadas posibles o alguien consiga GENERALA SERVIDA
				

				mostrarDados(dados);//Mostrar los dados en el array

				//ToDo 4 (HECHO):
				cambiarDados(dados, turno);//-> Hacerlo hasta que se terminen sus turno
				
				Arrays.sort(dados);
				
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
	
	private static int[] tirarDados(int cantDados) //metodo que toma como parametro int dados.length y devuelve int[] dados
	{	
		Random azar = new Random(); //Una clase del paquete java.util que genera numeros pseudo-aleatorios
		
		int[] dados = new int[cantDados]; //Declaro un array para poner los dados
		
		for (int i = 0; i < dados.length; i++) //Iterar por la cantidad de dados del array
		{
			dados[i] = 1 + azar.nextInt(6); //Poner un valor aleatorio en el dado actual
		}
		return dados; //Devuelvo el int[] dados
	}

	private static void mostrarDados(int[] dados) {
		System.out.print("[");
		
		for (int j = 0; j < dados.length; j++)
		{
			if (j > 0 && j < dados.length) //si no es el valor inicial o final
			{
				System.out.print(", ");
			}
			
			if (dados[j] == 7) //si el dado fue marcado para un cambio
			{
				System.out.print("x");
			}
			else
			{
				System.out.print(dados[j]);
			}
		}
		
		System.out.println("]");
	}

	private static void cambiarDados(int[] dados, int turno)
	{
		Scanner leer = new Scanner(System.in);
		Random azar = new Random();

		//Preguntarle al usuario si quiere cambiar algun dado
		System.out.println("¿Quiere cambiar algún dado? (S/N)");
		//tomar un si o un no y en base a eso ejecutar los siguientes pasos

		String respuesta; //tomar respuesta
		boolean cambiar = false; //si el usuario quiere cambiar dados o no

		do
		{
			respuesta = leer.next();

			if (respuesta.equalsIgnoreCase("S"))
			{
				cambiar = true;
			}
			else if (respuesta.equalsIgnoreCase("N"))
			{
				cambiar = false;
			}
		}
		while (!(respuesta.equalsIgnoreCase("S")) && !(respuesta.equalsIgnoreCase("N")));

		if (cambiar)
		{
			//repetir la toma de elecciones hasta alcanzar cantidad de dados o eleccion = 0
			int eleccion = 1;

			while (eleccion != 0)
			{
				//Dejar que el usuario seleccione los dados que quiere cambiar


				System.out.println("Seleccione el dado a cambiar [1~5], [0] para terminar de cambiar");

				do
				{	
					eleccion = leer.nextInt();

					if (eleccion > 5 || eleccion < 0)
					{
						System.out.println("ese dado no existe, ingrese 0 para dejar de cambiar");
					}
				}
				while (eleccion > 5 || eleccion < 0);

				//si eleccion es 0, dejar de marcar dados
				if (eleccion == 0)
				{
					break;
				}

				//marcar dados para volver a tirar
				dados[eleccion -1] = 7;

				//mostrar los dados cambiando
				mostrarDados(dados);
			}

			//Iterar por la cantidad de dados del array
			for (int i = 0; i < dados.length; i++)
			{
				//Volver a tirar los dados a cambiar
				if (dados[i] == 7)
				{
					dados[i] = 1 + azar.nextInt(6);
				}
			}

			turno++;

			mostrarDados(dados);
		}
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
