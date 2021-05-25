package br.lois.algoritmos.sort;

import java.util.Arrays;

import br.lois.algoritmos.Algorithm;

public class QuickSort extends Algorithm implements SortAlgorithm {
	
	public QuickSort(int[] array) {
		super(array);
	}
	
	@Override
	public int[] sort() {
		int[] sorted = Arrays.copyOf(array, array.length);
		this.quicksort(sorted, 0, array.length - 1);
		return sorted;
	}
	
	private void quicksort(int[] array, int initIndex, int endIndex) {
		if(initIndex < endIndex) {
			int p = this.partition(array, initIndex, endIndex);
			this.quicksort(array, initIndex, p - 1);
			this.quicksort(array, p + 1, endIndex);
		}
	}
	
	private int partition(int[] array, int initIndex, int endIndex) {
		int i = initIndex;
		for(int j = initIndex; j < endIndex; ++j) {
			if(array[j] <= array[endIndex]) {
				int aux = array[j];
				array[j] = array[i];
				array[i] = aux;
				i++;
			}
		}
		int aux = array[i];
		array[i] = array[endIndex];
		array[endIndex] = aux;
		return i;
	}
	
}