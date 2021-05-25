package br.lois.algoritmos;

import java.util.Arrays;
import java.util.Random;

import br.lois.algoritmos.sort.MergeSort;
import br.lois.algoritmos.sort.QuickSort;
import br.lois.algoritmos.sort.SortAlgorithm;

public class Main {
	
	/*
	 * Isso irá prejudicar muito o desempenho!
	 */
	public static final boolean PRINT_PROCESS = false;
	
	public static void main(String[] args) {
		
		System.out.println("Gerando array...");
		int[] array = generateRandomArray(10);
		
		SortAlgorithm sort = new MergeSort(array);
		
		System.out.println("Ordenando array com Merge Sort...");
		long time1 = System.currentTimeMillis();
		System.out.println("Resultado: " + Arrays.toString(sort.sort()) + "\n");
		long ftime1 = System.currentTimeMillis() - time1;
		
		sort = new QuickSort(array);
		
		System.out.println("Ordenando array com Quick Sort...");
		long time2 = System.currentTimeMillis();
		System.out.println("Resultado: " + Arrays.toString(sort.sort()) + "\n");
		long ftime2 = System.currentTimeMillis() - time2;
		
		System.out.println("Ordenando array com Quick Sort do Java...");
		long time3 = System.currentTimeMillis();
		Arrays.sort(array);
		System.out.println("Resultado: " + Arrays.toString(array) + "\n");
		long ftime3 = System.currentTimeMillis() - time3;
		
		System.out.println("[Merge Sort]\t\tTempo aprox.: " + ftime1 + " milissegundo(s)");
		System.out.println("[Quick Sort]\t\tTempo aprox.: " + ftime2 + " milissegundo(s)");
		System.out.println("[Quick Sort/Java]\t\tTempo aprox.: " + ftime3 + " milissegundo(s)");
		
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