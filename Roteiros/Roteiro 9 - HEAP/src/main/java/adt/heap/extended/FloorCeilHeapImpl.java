package adt.heap.extended;

import java.util.Arrays;
import java.util.Comparator;

import javax.swing.text.html.parser.Element;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		reset();

		Integer menor = array[0];
		for (Integer i : array) {
			if (i == (int) numero) 
				return i;

			insert(i);
			if (i < menor)
				menor = i;
		}

		if (menor > numero)
			return null;

		while (true) {
			Integer valor = extractRootElement();
			if (valor == null) 
				break; 

			if (valor > numero) 
				continue;
			
			if (valor > menor) 
				menor = valor;
		}

		reset();
		return menor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		reset();

		Integer maior = array[0];
		for (Integer i : array) {
			if (i == Math.ceil(numero)) 
				return i;

			insert(i);
			if (i > maior)
				maior = i;
		}

		if (maior < numero)
			return null;

		while (true) {
			Integer valor = extractRootElement();
			if (valor == null) 
				break; 

			if (valor < numero) 
				continue;
			
			if (valor < maior) 
				maior = valor;
		}

		reset();
		return maior;
	}

}
