package adt.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import org.hamcrest.core.IsInstanceOf;

/**
 * O comportamento de qualquer heap é definido pelo heapify. Neste caso o
 * heapify dessa heap deve comparar os elementos e colocar o menor sempre no
 * topo. Ou seja, admitindo um comparador normal (responde corretamente 2 < 3),
 * essa heap deixa os elementos menores no topo. Essa comparação não é feita
 * diretamente com os elementos armazenados, mas sim usando um comparator. 
 * Dessa forma, dependendo do comparator, a heap pode funcionar como uma max-heap 
 * ou min-heap.
 */
public class HeapImpl<T extends Comparable<T>> implements Heap<T> {

	protected T[] heap;
	protected int index = -1;
	/**
	 * O comparador é utilizado para fazer as comparações da heap. O ideal é
	 * mudar apenas o comparator e mandar reordenar a heap usando esse
	 * comparator. Assim os metodos da heap não precisam saber se vai funcionar
	 * como max-heap ou min-heap.
	 */
	protected Comparator<T> comparator;

	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;

	/**
	 * Construtor da classe. Note que de inicio a heap funciona como uma
	 * min-heap. OU seja, voce deve considerar que a heap usa o comparator
	 * interno e se o comparator responde compare(x,y) < 0 entao o x eh menor
	 * e sobe na heap.
	 */
	@SuppressWarnings("unchecked")
	public HeapImpl(Comparator<T> comparator) {
		this.heap = (T[]) (new Comparable[INITIAL_SIZE]);
		this.comparator = comparator;
	}

	// /////////////////// METODOS IMPLEMENTADOS
	private int parent(int i) {
		return (i - 1) / 2;
	}

	/**
	 * Deve retornar o indice que representa o filho a esquerda do elemento
	 * indexado pela posicao i no vetor
	 */
	private int left(int i) {
		return (i * 2 + 1);
	}

	/**
	 * Deve retornar o indice que representa o filho a direita do elemento
	 * indexado pela posicao i no vetor
	 */
	private int right(int i) {
		return (i * 2 + 1) + 1;
	}

	@Override
	public boolean isEmpty() {
		return (index == -1);
	}

	@Override
	public T[] toArray() {
		ArrayList<T> resp = new ArrayList<T>();
		for (int i = 0; i <= this.index; i++) {
			resp.add(this.heap[i]);
		}
		return (T[])resp.toArray(new Comparable[0]);
	}

	// ///////////// METODOS A IMPLEMENTAR

	private int compare(T i1, T i2) {
		return this.comparator.compare(i1, i2);
	}

	private void swap(int p1, int p2) {
		T sup = this.heap[p1];
		this.heap[p1] = this.heap[p2];
		this.heap[p2] = sup;
	}

	private boolean moveUp(int p) {
		int indiceSuperior = parent(p); 
		if (compare(this.heap[indiceSuperior], this.heap[p]) < 0) {
			swap(p, indiceSuperior);
			return true;
		}
		return false;
	}

	/**
	 * Valida o invariante de uma heap a partir de determinada posicao, que pode
	 * ser a raiz da heap ou de uma sub-heap. O heapify deve usar o comparator
	 * para subir os elementos na heap.
	 */
	private void heapify(int position) {
		while (true) {
			int iLeft = this.left(position);
			int iRight = this.right(position);
			T valorPos = this.heap[position];

			if (iLeft < this.index && iRight <= this.index) {
				T vl = this.heap[iLeft];
				T vr = this.heap[iRight];

				if (compare(vl, vr) >= 0 && compare(vl, valorPos) > 0) {
					swap(iLeft, position);
					position = iLeft;
				} else if (compare(vr, vl) > 0 && compare(vr, valorPos) > 0) {
					swap(iRight, position);
					position = iRight;
				} else {
					return;
				}
			} else if (iLeft <= this.index && compare(this.heap[iLeft], valorPos) > 0) {
				swap(iLeft, position);
				position = iLeft;
			} else if (iRight <= this.index && compare(this.heap[iRight], valorPos)  > 0) {
				swap(iRight, position);
				position = iRight;
			} else {
				return;
			}
		}
	}

	@Override
	public void insert(T element) {
		// ESSE CODIGO E PARA A HEAP CRESCER SE FOR PRECISO. NAO MODIFIQUE
		if (index == heap.length - 1) {
			heap = Arrays.copyOf(heap, heap.length + INCREASING_FACTOR);
		}
		// /////////////////////////////////////////////////////////////////
		// TODO Implemente a insercao na heap aqui.
		this.heap[++this.index] = element;
		
		int sup = this.index;
		while (moveUp(sup)) 
			sup = parent(sup);
	}

	@Override
	public void buildHeap(T[] array) {
		reset();
		for (T valor : array)
			this.insert(valor);
	}

	@Override
	public T extractRootElement() {
		if (this.index == -1) 
			return null;
			
		T sup = this.rootElement();
		swap(0, this.index--);
		heapify(0);
		return sup;
	}

	@Override
	public T rootElement() {
		return this.heap[0];
	}

	protected void reset() {
		this.heap = (T[]) (new Comparable[INITIAL_SIZE]);
		this.index = -1;
	}

	@Override
	public T[] heapsort(T[] array) {
		this.buildHeap(array);

		int sup = this.index;
		while (this.index != -1)
			this.extractRootElement(); 
		this.index = sup;

		if (comparator instanceof ComparatorMinHeap) 
			for (int i = 0; i <= (this.index / 2); i++) 
				swap(i, this.index - i);
		
		T[] result = this.toArray();
		
		reset();
		return result;
	}

	@Override
	public int size() {
		return this.index + 1;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public T[] getHeap() {
		return heap;
	}

}
