package c_avl;

import ar.edu.uner.fcad.ed.arbolesabbyavl.NodoABB;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;
import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;

public class ArbolABBIteradorPosordenInverso<T extends Comparable<? super T>>
		implements Iterador<T> {
	private final Iterador<T> iterador;

	public ArbolABBIteradorPosordenInverso(NodoABB<T> raiz) {
		this.iterador = generarRecorrido(raiz).iterador();
	}
	
	private ListaEnlazadaNoOrdenada<T> generarRecorrido(NodoABB<T> nodo) {
		ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada<T>();

		resultado.addAll(agregarSubArbol(nodo));

		return resultado;
	}

	private ListaEnlazadaNoOrdenada<T> agregarSubArbol(NodoABB<T> nodoActual) {
		ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada<T>();

		if (nodoActual.tieneHijoDerecho())
			resultado.addAll(agregarSubArbol(nodoActual.getHijoDerecho()));

		if (nodoActual.tieneHijoIzquierdo())
			resultado.addAll(agregarSubArbol(nodoActual.getHijoIzquierdo()));

		resultado.addToRear(nodoActual.getValor());

		return resultado;
	}
	
	public boolean existeSiguiente() {
		return iterador.existeSiguiente();
	}

	public T siguiente() {
		return iterador.siguiente();
	}

}
