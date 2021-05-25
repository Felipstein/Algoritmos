package br.lois.algoritmos.sort;

import java.util.Arrays;

import br.lois.algoritmos.Algorithm;
import br.lois.algoritmos.Main;

/*
 * Em uma busca por 200000 elementos, no meu teste demorou em média 16918 milissegundos.
 */
public class InsertionSort extends Algorithm implements SortAlgorithm {
	
	public InsertionSort(int[] array) {
		super(array);
	}
	
	@Override
	public int[] sort() {
		int length = array.length;
		int[] sorted = Arrays.copyOf(array, array.length);
		for(int i = 1; i < length; ++i) {
			int key = sorted[i];
			int j = i - 1;
			for(; j >= 0 && sorted[j] > key; --j) {
				sorted[j + 1] = sorted[j];
			}
			sorted[j + 1] = key;
			if(Main.PRINT_PROCESS) {
				System.out.println("index " + i + "/" + length + ": sub-index " + j + ": " + Arrays.toString(sorted));
			}
		}
		return sorted;
	}
	
}