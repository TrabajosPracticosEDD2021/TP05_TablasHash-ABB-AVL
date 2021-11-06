package b_abb;

import ar.edu.uner.fcad.ed.arbolesabbyavl.ArbolABB;
import ar.edu.uner.fcad.ed.arbolesabbyavl.ArbolABBResultadoBusqueda;
import ar.edu.uner.fcad.ed.arbolesabbyavl.NodoABB;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;

public class ArbolABBExt<T extends Comparable<? super T>> extends ArbolABB<T>
		implements ArbolABBExtInterfaz<T> {

	/** Devuelve el valor del nodo con menor valor de clave. */
	public T min() {
		NodoABB<T> nodoAux = raiz;

		while (nodoAux.tieneHijoIzquierdo()) {
			nodoAux = nodoAux.getHijoIzquierdo();
		}

		return nodoAux.getValor();
	}

	/** Devuelve el valor del nodo con mayor valor de clave. */
	public T max() {
		NodoABB<T> nodoAux = raiz;

		while (nodoAux.tieneHijoDerecho()) {
			nodoAux = nodoAux.getHijoDerecho();
		}

		return nodoAux.getValor();
	}

	/**
	 * Elimina la rama del árbol que tiene como raíz el nodo pasado por parámetro.
	 */
	public void eliminarRama(NodoABB<T> nodo) {
		ArbolABBResultadoBusqueda<T> buscado = nodosBuscar(nodo.getValor());

		while (buscado.getNodoBuscado().getCantidadHijos() != 0) {
			if (buscado.getNodoBuscado().tieneHijoIzquierdo()) {
				borrarNodo(buscado.getNodoBuscado(), buscado.getNodoBuscado().getHijoIzquierdo());
			} else if (buscado.getNodoBuscado().tieneHijoDerecho()) {
				borrarNodo(buscado.getNodoBuscado(), buscado.getNodoBuscado().getHijoDerecho());
			}
		}

		borrarNodo(buscado.getPadre(), buscado.getNodoBuscado());
	}

	private ArbolABBResultadoBusqueda<T> nodosBuscar(T valor) {
		ArbolABBResultadoBusqueda<T> resultado = new ArbolABBResultadoBusqueda<T>();

		NodoABB<T> nodoAuxPadre = null;
		NodoABB<T> nodoAux = raiz;

		while (nodoAux != null) {
			if (valor.compareTo(nodoAux.getValor()) == 0) {
				break;
			} else {
				if (valor.compareTo(nodoAux.getValor()) < 0) {
					nodoAuxPadre = nodoAux;
					nodoAux = nodoAux.getHijoIzquierdo();
				} else {
					nodoAuxPadre = nodoAux;
					nodoAux = nodoAux.getHijoDerecho();
				}
			}
		}

		resultado.setPadre(nodoAuxPadre);
		resultado.setNodoBuscado(nodoAux);

		return resultado;
	}

	/**
	 * Devuelve el ancestro compartido por los nodos x e y que se encuentra más
	 * lejos de la raíz (más profundo). En caso que alguno de los nodos no
	 * pertenezca al árbol devuelve null.
	 */
	public NodoABB<T> menorAntecesorComun(NodoABB<T> x, NodoABB<T> y) {

		if (!exists(x.getValor()) || !exists(y.getValor())) {
			return null;
		}

		ListaEnlazadaNoOrdenada<NodoABB<T>> ancestrosX = listAncestros(x);
		ListaEnlazadaNoOrdenada<NodoABB<T>> ancestrosY = listAncestros(y);
		NodoABB<T> resultado = ancestrosX.first();
		boolean encontrado = false;

		while (!encontrado) {
			if (ancestrosY.contains(resultado)) {
				encontrado = true;
			} else {
				ancestrosX.removeFirst();
				resultado = ancestrosX.first();
			}
		}

		return resultado;
	}

	/**
	 * Retorna todos los ancestros del nodo pasado por parametro
	 *
	 */
	private ListaEnlazadaNoOrdenada<NodoABB<T>> listAncestros(NodoABB<T> nodo) {
		ListaEnlazadaNoOrdenada<NodoABB<T>> resultado = new ListaEnlazadaNoOrdenada<NodoABB<T>>();
		NodoABB<T> nodoAux = raiz;
		T valor = nodo.getValor();

		while (nodoAux != null) {
			if (valor.compareTo(nodoAux.getValor()) == 0) {
				break;
			} else {
				if (valor.compareTo(nodoAux.getValor()) < 0) {
					resultado.addToFront(nodoAux);
					nodoAux = nodoAux.getHijoIzquierdo();
				} else {
					resultado.addToFront(nodoAux);
					nodoAux = nodoAux.getHijoDerecho();
				}
			}
		}

		return resultado;
	}
}