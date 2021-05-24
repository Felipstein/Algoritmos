package br.lois.algoritmos.search;

import br.lois.algoritmos.Algorithm;
import br.lois.algoritmos.Main;

public class SequentialSearch extends Algorithm implements SearchAlgorithm {
	
	public SequentialSearch(int[] array) {
		super(array);
	}
	
	@Override
	public int indexOf(int value) {
		int length = array.length;
		for(int i = 0; i < length; ++i) {
			if(Main.PRINT_PROCESS) {
				System.out.println("[" + (i + 1) + "/" + length + "] valor " + array[i] + " == " + value + " ? " + (value == array[i] ? "encontrado" : "continuando"));
			}
			if(array[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
}