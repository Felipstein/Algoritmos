package br.lois.algoritmos.sort;

import java.util.Arrays;

import br.lois.algoritmos.Algorithm;
import br.lois.algoritmos.Main;

/*
 * Em uma busca por 200000 elementos, no meu teste demorou em média 59172 milissegundos.
 */
public class BubbleSort extends Algorithm implements SortAlgorithm {
	
	public BubbleSort(int[] array) {
		super(array);
	}
	
	@Override
	public int[] sort() {
		int[] sorted = Arrays.copyOf(array, array.length);
		this.doubleForModel(sorted);
		return sorted;
	}
	
	/*
	 * Utiliza o modelo de duplo fores para trabalhar na operação.
	 */
	void doubleForModel(int[] sorted) {
		int length;
		int flexibleLength = length = sorted.length;
		for(int i = 0; i < length; ++i) {
			boolean swapped = false;
			flexibleLength--; // Para aumentar o desempenho.
			for(int j = 0; j < flexibleLength; ++j) {
				if(sorted[j] > sorted[j + 1]) {
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
	void whileModel(int[] sorted) {
		boolean swapped = false;
		int length = sorted.length;
		do {
			length--; // Para aumentar o desempenho.
			swapped = false;
			for(int i = 0; i < length; ++i) {
				if(sorted[i] > sorted[i + 1]) {
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
	
}