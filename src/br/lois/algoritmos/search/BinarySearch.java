package br.lois.algoritmos.search;

import br.lois.algoritmos.Algorithm;

// Fonte: https://www.youtube.com/watch?v=EgLE5HwRy_M
public class BinarySearch extends Algorithm implements SearchAlgorithm {
	
	/**
	 * É importantíssimo que a array esteja ordenada para utilizar essa operação.
	 */
	public BinarySearch(int[] array) {
		super(array);
	}
	
	@Override
	public int indexOf(int value) {
		return repercusiveMode(value, 0, array.length - 1);
	}
	
	/*
	 * Modelo repecursivo.
	 */
	int repercusiveMode(int value, int initIndex, int finalIndex) {
		if(initIndex <= finalIndex) {
			int midIndex = (initIndex + finalIndex) / 2;
			int midValue = array[midIndex];
			System.out.println("[Repercusivo] init index: " + initIndex + " - final index: " + finalIndex + " - mid index: " + midIndex + " - value: " + midValue + " == " + value + " ? " + (midValue == value));
			if(new Integer(value).compareTo(midValue) < 0) {
				return repercusiveMode(value, initIndex, midIndex - 1);
			} else if(new Integer(value).compareTo(midValue) > 0) {
				return repercusiveMode(value, midIndex + 1, finalIndex);
			} else {
				return midIndex;
			}
		} else {
			return -1;
		}
	}
	
	/*
	 * Modelo while.
	 */
	int whileMode(int value, int initIndex, int finalIndex) {
		while(initIndex <= finalIndex) {
			int midIndex = (initIndex + finalIndex) / 2;
			int midValue = array[midIndex];
			System.out.println("[While] init index: " + initIndex + " - final index: " + finalIndex + " - mid index: " + midIndex + " - value: " + midValue + " == " + value + " ? " + (midValue == value));
			if(new Integer(value).compareTo(midValue) < 0) {
				finalIndex = midIndex - 1;
			} else if(new Integer(value).compareTo(midValue) > 0) {
				initIndex = midIndex + 1;
			} else {
				return midIndex;
			}
		}
		return -1;
	}
	
}