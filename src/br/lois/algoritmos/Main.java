package br.lois.algoritmos;

import java.util.Arrays;
import java.util.Random;

import br.lois.algoritmos.sort.*;

public class Main {
	
	/*
	 * Isso irá prejudicar muito o desempenho!
	 */
	public static final boolean PRINT_PROCESS = false;
	
	public static void main(String[] args) {
		
		System.out.println("Gerando array...");
		int[] array1 = generateRandomArray(200000);
		int[] array2 = Arrays.copyOf(array1, array1.length);
		int[] array3 = Arrays.copyOf(array1, array1.length);
		int[] array4 = Arrays.copyOf(array1, array1.length);
		int[] array5 = Arrays.copyOf(array1, array1.length);
		SortAlgorithm sort;
		
		sort = new SelectionSort(array1);
		System.out.println("Ordenando array com a operação Selection Sort...");
		long time1 = System.currentTimeMillis();
		sort.sort();
		long ftime1 = System.currentTimeMillis() - time1;
		
		sort = new BubbleSort(array2);
		System.out.println("Ordenando array com a operação Bubble Sort...");
		long time2 = System.currentTimeMillis();
		sort.sort();
		long ftime2 = System.currentTimeMillis() - time2;
		
		sort = new InsertionSort(array2);
		System.out.println("Ordenando array com a operação Insertion Sort...");
		long time3 = System.currentTimeMillis();
		sort.sort();
		long ftime3 = System.currentTimeMillis() - time3;
		
		System.out.println("Tempo: " + ftime1 + " milissegundo(s)");
		System.out.println("Tempo: " + ftime2 + " milissegundo(s)");
		System.out.println("Tempo: " + ftime3 + " milissegundo(s)");
		
	}
	
	static int[] generateRandomArray(int length) {
		Random random = new Random();
		int[] array = new int[length];
		for(int i = 0; i < length; ++i) {
			array[i] = random.nextInt(length * 5);
		}
		return array;
	}
	
}