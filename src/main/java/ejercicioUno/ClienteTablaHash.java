package ejercicioUno;

public class ClienteTablaHash {

    public static void main(String[] args) {
        TablaHash<Integer, String> tablaUno = new TablaHash(10);

        tablaUno.put(2, "Facundo");
        tablaUno.put(5, "Perro");
        tablaUno.put(4, "Elefante");
        tablaUno.put(6, "Barco");
        tablaUno.put(1, "Computadora");
        tablaUno.put(3, "Billetera");
        tablaUno.put(9, "Mate");
        tablaUno.put(25, "Espejo");
        tablaUno.put(75, "Teclado");
        tablaUno.put(11, "Pc");

        TablaHash<Integer, String> tablaDos = new TablaHash(10, 1);

        tablaDos.put(2, "Facundo");
        tablaDos.put(5, "Perro");
        tablaDos.put(4, "Elefante");
        tablaDos.put(6, "Barco");
        tablaDos.put(1, "Computadora");
        tablaDos.put(3, "Billetera");
        tablaDos.put(9, "Mate");
        tablaDos.put(25, "Espejo");
        tablaDos.put(75, "Teclado");
        tablaDos.put(11, "Pc");

        System.out.println("\n TABLA UNO: ");
        System.out.println(tablaUno);
        System.out.println("LLena " + tablaUno.isFull());
        System.out.println("Contiene 9: " + tablaUno.contains(9));
        System.out.println("Valor clave 6: " + tablaUno.get(6));
        System.out.println("Tamaño: " + tablaUno.size());
        tablaUno.remove(6);
        System.out.println("Removido: 6");
        System.out.println("\n TABLA UNO: ");
        System.out.println(tablaUno);
        tablaUno.makeEmpty();
        System.out.println("Vaciar Tabla Uno");
        System.out.println("\n TABLA UNO: ");
        System.out.println(tablaUno);

        System.out.println("\n TABLA DOS: ");
        System.out.println(tablaDos);
        System.out.println("LLena " + tablaDos.isFull());
        System.out.println("Contiene 9: " + tablaDos.contains(25));
        System.out.println("Valor clave 5: " + tablaDos.get(5));
        System.out.println("Tamaño: " + tablaDos.size());
        tablaDos.remove(6);
        System.out.println("Removido: 6");
        System.out.println("\n TABLA DOS: ");
        System.out.println(tablaDos);
        tablaDos.makeEmpty();
        System.out.println("Vaciar Tabla Dos");
        System.out.println("\n TABLA DOS: ");
        System.out.println(tablaDos);
    }
}
