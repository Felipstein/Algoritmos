package br.lois.algoritmos;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import br.lois.algoritmos.search.DupleSequentialSearch;
import br.lois.algoritmos.search.SearchAlgorithm;
import br.lois.algoritmos.search.SequentialSearch;
import br.lois.algoritmos.sort.BubbleSort;
import br.lois.algoritmos.sort.SortAlgorithm;
import br.lois.algoritmos.sort.SortType;

public class Main {
	
	/*
	 * Isso irá prejudicar muito o desempenho!
	 */
	public static final boolean PRINT_PROCESS = false;
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		
		int[] array = generateRandomArray(50000000);
	//	System.out.println("Array: \n" + Arrays.toString(array) + "\n");
		System.out.println("Array gerada.");
		
		System.out.print("Procurar o valor: ");
		int value = s.nextInt();
		
		System.out.println("Procurando o valor \"" + value + "\" em " + array.length + " elementos desordenados.");
		
		SearchAlgorithm search = new SequentialSearch(array);
		
		long initTime = System.currentTimeMillis();
		System.out.println("Busca sequencial: \n" + (search.has(value) ? "encontrado!" : "não encontrado...") + "\n");
		long finalTime = System.currentTimeMillis() - initTime;
		
		search = new DupleSequentialSearch(array);
		
		long initTime2 = System.currentTimeMillis();
		System.out.println("Busca sequencial dupla: \n" + (search.has(value) ? "encontrado!" : "não encontrado...") + "\n");
		long finalTime2 = System.currentTimeMillis() - initTime2;
		
		if(finalTime < 1000) {
			System.out.println("Tempo busca sequencial: " + finalTime + " milissegundo(s)");
		} else {
			System.out.println("Tempo aprox. busca sequencial: " + Math.round(finalTime / 1000.0d) + " segundo(s) (" + finalTime + "ms)");
		}
		
		if(finalTime2 < 1000) {
			System.out.println("Tempo busca sequencial dupla: " + finalTime2 + " milissegundo(s)");
		} else {
			System.out.println("Tempo aprox. busca sequencial dupla: " + Math.round(finalTime2 / 1000.0d) + " segundo(s) (" + finalTime2 + "ms)");
		}
		
		initTime = System.currentTimeMillis();
		
		finalTime = System.currentTimeMillis() - initTime;
		
	}
	
	static void sortAlgorithmTest() {
		int[] array = generateRandomArray(300);
		System.out.println("Desordenado: \n" + Arrays.toString(array) + "\n");
		System.out.println("Array gerada.");
		
		SortAlgorithm sort = new BubbleSort(array);
		
		long initTime = System.currentTimeMillis();
		System.out.println("Bubble Sort: \n" + Arrays.toString(sort.sort(SortType.ASCENDING)) + "\n");
		
		long finalTime = System.currentTimeMillis() - initTime;
		if(finalTime < 1000) {
			System.out.println("Tempo: " + finalTime + " milissegundo(s)");
		} else {
			System.out.println("Tempo aprox.: " + Math.round(finalTime / 1000.0d) + " segundo(s) (" + finalTime + "ms)");
		}
	}
	
	private static int[] generateRandomArray(int length) {
		Random random = new Random();
		int[] array = new int[length];
		for(int i = 0; i < length; ++i) {
			array[i] = random.nextInt(length * 5);
		}
		return array;
	}
	
}