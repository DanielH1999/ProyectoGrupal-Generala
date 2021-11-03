/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author danielh
 */
public class GeneralaCLI
{
	public static void main(String[] args)
	{
				
		int maxJugadores = 4;
		
		int cantDados = 5;
		
		String[] jugadores = new String[maxJugadores];
		
		jugadores = averiguarJugadores(maxJugadores);
		
		int[] dados = new int[cantDados];
		
		dados = tirarDados(cantDados);
		
				
		//revisar resultados de dados y determinar que 
	}
	
	private static String[] averiguarJugadores(int maxJugadores)
	{
		//averiguar jugadores
	
		Scanner leer = new Scanner(System.in);
		
		String[] Jugadores = new String[maxJugadores];
		
		for (int cantJugadores = 0; cantJugadores < maxJugadores; cantJugadores++)
		{
			System.out.print("Jugador " + cantJugadores + ": ");
			
			Jugadores[cantJugadores] = leer.next();
		}
		return Jugadores;
	}
	
	private static int[] tirarDados(int cantDados)
	{
		//tirar dados
		
		Random azar = new Random();
		
		int[] dados = new int[cantDados]; //declaro un array para poner los dados
		
		for (int i = 0; i < cantDados; i++)
		{
			int dado = 1 + azar.nextInt(6);
		}
		return dados; //devuelvo el array dados
	}
}
