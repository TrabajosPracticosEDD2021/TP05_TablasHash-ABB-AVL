package c_avl;

import ar.edu.uner.fcad.ed.arbolesabbyavl.ArbolAVL;
import ar.edu.uner.fcad.ed.arbolesabbyavl.NodoABB;
import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;

public class ArbolAVLExt<T extends Comparable<? super T>> extends ArbolAVL<T>
		implements ArbolAVLExtInterfaz<T> {

	public NodoABB<T> getRaiz() {
		return this.raiz;
	}

	/**
	 * Define un iterador en preorden inverso para el árbol AVL. Para el ejemplo el
	 * iterador en preorden inverso devuelve: A, C, B.
	 * 
	 * @return
	 */
	public Iterador<T> iteradorPreOrdenInverso() {
		if (isEmpty())
			throw new IllegalStateException("Arbol vacio");

		Iterador<T> resultado = new ArbolABBIteratorPreordenInverso<T>(this);
		return resultado;
	}

	/**
	 * Define un iterador en inorden inverso para el árbol AVL. Para el ejemplo el
	 * iterador en inorden inverso devolverá: C, A, B.
	 * 
	 * @return
	 */
	public Iterador<T> iteradorInordenInverso() {
		if (isEmpty())
			throw new IllegalStateException("Arbol vacio");

		Iterador<T> resultado = new ArbolABBIteradorInordenInverso<T>(this);
		return resultado;
	}

	/**
	 * Define un iterador en posorden inverso para el árbol AVL. Para el ejemplo el
	 * iterador en posorden inverso devuelve: C, B, A.
	 * 
	 * @return
	 */
	public Iterador<T> iteradorPosordenInverso() {
		if (isEmpty())
			throw new IllegalStateException("Arbol vacio");

		Iterador<T> resultado = new ArbolABBIteradorPosordenInverso<T>(this);

		return resultado;
	}
}
