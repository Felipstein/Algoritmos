package br.lois.algoritmos.search;

import br.lois.algoritmos.Algorithm;
import br.lois.algoritmos.Main;

public class DupleSequentialSearch extends Algorithm implements SearchAlgorithm {
	
	public DupleSequentialSearch(int[] array) {
		super(array);
	}
	
	@Override
	public int indexOf(int value) {
		int length = array.length;
		int i = 0, j = length - 1;
		int pivot = length / 2;
		do {
			if(Main.PRINT_PROCESS) {
				System.out.print("A:(" + i + " -> " + array[i] + " == " + value + " ? " + (array[i] == value ? "encontrado" : "não") + ")\t\t\t");
				System.out.println("B:(" + j + " -> " + array[j] + " == " + value + " ? " + (array[j] == value ? "encontrado" : "não") + ")");
			}
			if(array[i] == value) {
				return i;
			} else if(array[j] == value) {
				return j;
			}
			++i;
			--j;
		} while(i < pivot && j >= pivot);
		return -1;
	}
	
}