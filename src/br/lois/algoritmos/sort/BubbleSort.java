package br.lois.algoritmos.sort;

import java.util.Arrays;

import br.lois.algoritmos.Main;

public class BubbleSort implements SortAlgorithm {
	
	private int[] array;
	
	public BubbleSort(int[] array) {
		this.array = array;
	}
	
	@Override
	public int[] sort(SortType sortType) {
		int length = array.length;
		int[] sorted = Arrays.copyOf(array, length);
		for(int i = 0; i < length; ++i) {
			boolean swapped = false;
			for(int j = 0; j < length - 1; ++j) {
				if(sortType == SortType.ASCENDING ? sorted[j] > sorted[j + 1] : sorted[j] < sorted[j + 1]) {
					int aux = sorted[j];
					sorted[j] = sorted[j + 1];
					sorted[j + 1] = aux;
					swapped = true;
				}
				if(Main.PRINT_PROCESS) {
					System.out.println("index " + i + "/" + (length - 1) + "|" + j + ": " + Arrays.toString(sorted));
				}
			}
			if(!swapped) {
				break;
			}
		}
		return sorted;
	}
	
	public int[] getArray() {
		return array;
	}
	
}