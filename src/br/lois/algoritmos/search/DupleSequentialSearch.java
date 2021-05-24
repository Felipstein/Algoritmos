package br.lois.algoritmos.search;

import br.lois.algoritmos.Main;

public class DupleSequentialSearch implements SearchAlgorithm {
	
	private int[] array;
	
	public DupleSequentialSearch(int[] array) {
		this.array = array;
	}
	
	@Override
	public boolean has(int value) {
		int length = array.length;
		int i = 0, j = length - 1;
		int pivot = length / 2;
		do {
			if(Main.PRINT_PROCESS) {
				System.out.print("A:(" + i + " -> " + array[i] + " == " + value + " ? " + (array[i] == value ? "encontrado" : "não") + ")\t\t\t");
				System.out.println("B:(" + j + " -> " + array[j] + " == " + value + " ? " + (array[j] == value ? "encontrado" : "não") + ")");
			}
			if(array[i] == value || array[j] == value) {
				return true;
			}
			++i;
			--j;
		} while(i < pivot && j >= pivot);
		return false;
	}
	
	public int[] getArray() {
		return array;
	}
	
}