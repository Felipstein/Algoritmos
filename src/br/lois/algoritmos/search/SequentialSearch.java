package br.lois.algoritmos.search;

import br.lois.algoritmos.Main;

public class SequentialSearch implements SearchAlgorithm {
	
	private int[] array;
	
	public SequentialSearch(int[] array) {
		this.array = array;
	}
	
	@Override
	public boolean has(int value) {
		int length = array.length;
		for(int i = 0; i < length; ++i) {
			if(Main.PRINT_PROCESS) {
				System.out.println("[" + (i + 1) + "/" + length + "] valor " + array[i] + " == " + value + " ? " + (value == array[i] ? "encontrado" : "continuando"));
			}
			if(array[i] == value) {
				return true;
			}
		}
		return false;
	}
	
	public int[] getArray() {
		return array;
	}
	
}