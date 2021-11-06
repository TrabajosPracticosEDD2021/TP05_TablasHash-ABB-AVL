package b_abb;

import ar.edu.uner.fcad.ed.arbolesabbyavl.NodoABB;
import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;

public class ClienteArbolABBExt {
	public static void main(String[] args) {
		ArbolABBExt<Integer> arbolito = new ArbolABBExt<Integer>();
		// Arbol que esta en la filmina 12 de ABB.
		arbolito.add(12);
		arbolito.add(7);
		arbolito.add(21);
		arbolito.add(4);
		arbolito.add(9);
		arbolito.add(16);
		arbolito.add(25);
		arbolito.add(2);
		arbolito.add(8);
		arbolito.add(13);
		arbolito.add(19);

//		 Imprime por niveles
		Iterador<Integer> itedarorcito1 = arbolito.iteradorPorNiveles();
		while (itedarorcito1.existeSiguiente()) {
			System.out.println(itedarorcito1.siguiente());
		}

		System.out.println("\narbolito.min() : " + arbolito.min());

		System.out.println("\narbolito.max() : " + arbolito.max());

		System.out.println("\nmenorAntecesorComun(13, 25): "
				+ arbolito.menorAntecesorComun(new NodoABB<Integer>(13), new NodoABB<Integer>(25))
						.getValor());

		System.out.println("\narbolito.eliminarRama(21):");
		arbolito.eliminarRama(new NodoABB<Integer>(21));
//		 Imprime por niveles
		Iterador<Integer> itedarorcito = arbolito.iteradorPorNiveles();
		while (itedarorcito.existeSiguiente()) {
			System.out.println(itedarorcito.siguiente());
		}
	}
}
