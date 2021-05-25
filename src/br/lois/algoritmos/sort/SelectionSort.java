package br.lois.algoritmos.sort;

import java.util.Arrays;

import br.lois.algoritmos.Algorithm;
import br.lois.algoritmos.Main;

/*
 * Em uma busca por 200000 elementos, no meu teste demorou em média 14789 milissegundos.
 */
public class SelectionSort extends Algorithm implements SortAlgorithm {
	
	public SelectionSort(int[] array) {
		super(array);
	}
	
	@Override
	public int[] sort() {
		int length = array.length;
		int[] sorted = Arrays.copyOf(array, length);
		for(int i = 0; i < length; ++i) {
			int minIndex = i;
			for(int j = i; j < length; ++j) {
				if(sorted[j] < sorted[minIndex]) {
					minIndex = j;
				}
			}
			if(Main.PRINT_PROCESS) {
				System.out.println("index " + i + "(" + sorted[i] + ") > min index " + minIndex + "(" + sorted[minIndex] + "): " + Arrays.toString(sorted));
			}
			if(sorted[minIndex] < sorted[i]) {
				int aux = sorted[i];
				sorted[i] = sorted[minIndex];
				sorted[minIndex] = aux;
			}
		}
		return sorted;
	}
	
}