package c_avl;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;

public class ClienteArbolAVLExt {

	public static void main(String[] args) {
		ArbolAVLExt<Integer> arbolitoAVL = new ArbolAVLExt<Integer>();
		// Arbol dado en la filmina 29 de ABB.
		arbolitoAVL.add(5);
		arbolitoAVL.add(3);
		arbolitoAVL.add(7);
		arbolitoAVL.add(1);
		arbolitoAVL.add(4);
		arbolitoAVL.add(6);
		arbolitoAVL.add(2);

		Iterador<Integer> iteradorcito;

		System.out.println("\nIterador en PREORDEN INVERSO: ");
		iteradorcito = arbolitoAVL.iteradorPreOrdenInverso(); // 5, 7, 6, 3, 4, 1, 2
		while (iteradorcito.existeSiguiente()) {
			System.out.print("[" + iteradorcito.siguiente().toString() + "] ");
		}

		System.out.println("\nIterador en POSORDEN INVERSO: ");
		iteradorcito = arbolitoAVL.iteradorPosordenInverso(); // 6, 7, 4, 2, 1, 3, 5
		while (iteradorcito.existeSiguiente()) {
			System.out.print("[" + iteradorcito.siguiente().toString() + "] ");
		}

		System.out.println("\nIterador en INORDEN INVERSO: ");
		iteradorcito = arbolitoAVL.iteradorInordenInverso(); // 7, 6, 5, 4, 3, 2, 1
		while (iteradorcito.existeSiguiente()) {
			System.out.print("[" + iteradorcito.siguiente().toString() + "] ");
		}
	}
}
