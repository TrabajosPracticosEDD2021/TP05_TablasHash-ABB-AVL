package b_abb;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;

public class ClienteArbolABBExt {
	public static void main(String[] args) {
		ArbolABBExt<Integer> arbolito = new ArbolABBExt<Integer>();
		arbolito.add(12);
		arbolito.add(7);
		arbolito.add(21);
		arbolito.add(4);
		arbolito.add(9);
		arbolito.add(16);
		arbolito.add(25);
		arbolito.add(2);
		arbolito.add(8);
		Iterador <Integer> itedarorcito = arbolito.iteradorPorNiveles();
		while (itedarorcito.existeSiguiente()) {
			System.out.println(itedarorcito.siguiente());
		}
		
		
	}
}
