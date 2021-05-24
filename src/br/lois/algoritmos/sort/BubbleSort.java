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
		int[] sorted = Arrays.copyOf(array, array.length);
		this.doubleForModel(sortType, sorted);
		return sorted;
	}
	
	/*
	 * Utiliza o modelo de duplo fores para trabalhar na operação.
	 */
	void doubleForModel(SortType sortType, int[] sorted) {
		int length;
		int flexibleLength = length = sorted.length;
		for(int i = 0; i < length; ++i) {
			boolean swapped = false;
			flexibleLength--; // Para aumentar o desempenho.
			for(int j = 0; j < flexibleLength; ++j) {
				if(sortType == SortType.ASCENDING ? sorted[j] > sorted[j + 1] : sorted[j] < sorted[j + 1]) {
					int aux = sorted[j];
					sorted[j] = sorted[j + 1];
					sorted[j + 1] = aux;
					swapped = true; // Para aumentar o desempenho².
				}
				if(Main.PRINT_PROCESS) {
					System.out.println("index " + i + "/" + (length - 1) + "|" + j + ": " + Arrays.toString(sorted));
				}
			}
			if(!swapped) {
				break;
			}
		}
	}
	
	/*
	 * Utiliza o modelo de um do...while e um for para trabalhar na operação.
	 */
	void whileModel(SortType sortType, int[] sorted) {
		boolean swapped = false;
		int length = sorted.length;
		do {
			length--; // Para aumentar o desempenho.
			swapped = false;
			for(int i = 0; i < length; ++i) {
				if(sortType == SortType.ASCENDING ? sorted[i] > sorted[i + 1] : sorted[i] < sorted[i + 1]) {
					int aux = sorted[i];
					sorted[i] = sorted[i + 1];
					sorted[i + 1] = aux;
					swapped = true; // Para aumentar o desempenho².
				}
				if(Main.PRINT_PROCESS) {
					System.out.println("[" + length + "] index " + i + "/" + (length - 1) + ": " + Arrays.toString(sorted));
				}
			}
		} while(swapped);
	}
	
	public int[] getArray() {
		return array;
	}
	
}