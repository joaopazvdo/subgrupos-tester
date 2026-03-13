package conversor;

import java.util.*;

public class ConversorTest{

	public static void main(String[] args) {
		

		Conversor conversor = new Conversor();

		/**
		 * Essa Parte é para testa matrixes
		 * */
		 String matrizA = "{2, 5, 6, 7}, {7, 8, 4, 1}, {8, 0, 1, 4}";
		 String matriB = "{2, 4, 5, 6}, {4, 5, 6}, {4, 4, 8, 6}";

		System.out.println("Para matrizes: ");
		HashSet<Double[][]> a = conversor.paraConjuntoMatriz(matrizA);
		HashSet<Double[][]> b = conversor.paraConjuntoMatriz(matriB);
		for(Double[][] matriA: a){
			System.out.println(Arrays.deepToString(matriA));
		}
		for (Double[][] matrizB : b) {
		    System.out.println(Arrays.deepToString(matrizB));
		}
		System.out.println();

		/**
		 * Essa parte para testar conjuntos numericos
		 * */
		System.out.println("Para Conjuntos Numericos:");
		String numerosA = "2, 6, 9, 78, 55, 5.9, 1.0";
		String numerosB = "5, 6, 0, 0, 0, 0, 0";
		String num = "6";

		HashSet<Double> numA = conversor.paraConjuntoNumerico(numerosA);
		HashSet<Double> numB = conversor.paraConjuntoNumerico(numerosB);
		HashSet<Double> numC = conversor.paraConjuntoNumerico(num);

		System.out.println(numA);
		System.out.println(numB);
		System.out.println(numC);
		System.out.println();

		/**
		 * Para Binarios
		 * */
		 System.out.println("Para Binarios: ");
		 String bi = "110 100 110";
		 String biA = "1101010010101";
		 System.out.println(conversor.paraConjuntoBinario(bi));
		 System.out.println(conversor.paraConjuntoBinario(biA));
		 System.out.println();
		 

		 /**
		  * Para Mod
		  * */

		  System.out.println("Para Mod: ");
		  String z6 = "6";
		  String z9 = "9";

		  System.out.println(conversor.paraConjuntoMod(z6));
		  System.out.println(conversor.paraConjuntoMod(z9));
	}
}