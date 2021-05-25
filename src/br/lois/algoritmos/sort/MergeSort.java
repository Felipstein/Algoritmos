package br.lois.algoritmos.sort;

import java.util.Arrays;

import br.lois.algoritmos.Algorithm;
import br.lois.algoritmos.Main;

public class MergeSort extends Algorithm implements SortAlgorithm {
	
	public MergeSort(int[] array) {
		super(array);
	}
	
	@Override
	public int[] sort() {
		int[] sorted = Arrays.copyOf(array, array.length);
		this.mergesort(sorted, 0, array.length - 1);
		return sorted;
	}
	
	private void mergesort(int[] array, int initIndex, int endIndex) {
		if(endIndex - initIndex > 1) {
			int mid = (initIndex + endIndex) / 2;
			this.mergesort(array, initIndex, mid);
			this.mergesort(array, mid, endIndex);
			this.merge(array, initIndex, mid, endIndex);
		}
	}
	
	private void merge(int[] array, int initIndex, int midIndex, int endIndex) {
		int[] leftArray = Arrays.copyOfRange(array, initIndex, midIndex);
		int[] rightArray = Arrays.copyOfRange(array, midIndex, endIndex);
		int topLeft, topRight;
		topLeft = topRight = 0;
		for(int i = initIndex; i < endIndex; ++i) {
			if(Main.PRINT_PROCESS) {
				System.out.println("[" + i + "/" + endIndex + "]: " + Arrays.toString(array) + "\nLEFT: " + Arrays.toString(leftArray) + "\nRIGHT: " + Arrays.toString(rightArray));
			}
			if(topLeft >= leftArray.length) {
				array[i] = rightArray[topRight];
				topRight++;
			} else if(topRight >= rightArray.length) {
				array[i] = leftArray[topLeft];
				topLeft++;
			} else if(leftArray[topLeft] < rightArray[topRight]) {
				array[i] = leftArray[topLeft];
				topLeft++;
			} else {
				array[i] = rightArray[topRight];
				topRight++;
			}
		}
	}
	
}