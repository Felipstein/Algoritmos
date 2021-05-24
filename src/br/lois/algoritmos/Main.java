package br.lois.algoritmos;

import java.util.Arrays;
import java.util.Random;

import br.lois.algoritmos.sort.BubbleSort;
import br.lois.algoritmos.sort.SortType;

public class Main {
	
	/*
	 * Isso pode prejudicar muito o desempenho!
	 */
	public static final boolean PRINT_PROCESS = false;
	
	public static void main(String[] args) {
		
		int[] array = generateRandomArray(200);
		System.out.println("Desordenado: \n" + Arrays.toString(array) + "\n");
		
		BubbleSort sort = new BubbleSort(array);
		
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