package br.lois.algoritmos;

import java.util.Random;

public class Main {
	
	/*
	 * Isso irá prejudicar muito o desempenho!
	 */
	public static final boolean PRINT_PROCESS = false;
	
	public static void main(String[] args) {
		
	}
	
	static int[] generateRandomArray(int length) {
		Random random = new Random();
		int[] array = new int[length];
		for(int i = 0; i < length; ++i) {
			array[i] = random.nextInt(length * 5);
		}
		return array;
	}
	
}