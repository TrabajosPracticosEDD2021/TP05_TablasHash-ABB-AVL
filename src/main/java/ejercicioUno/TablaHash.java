package ejercicioUno;

import ar.edu.uner.fcad.ed.mapeosdiccionarios.Entrada;
import java.util.NoSuchElementException;
import java.util.Objects;

public class TablaHash<K extends Object, V extends Object> implements TablaHashInterfaz<K, V> {

    private final int tamanioInicial;
    private final Entrada<K, V>[] tabla;
    private int metodo;

    /**
     * Constructor
     *
     * @param tamanioInicial, capacidad de la tabla (metodo de resolucion de
     * colisiones: prueba lineal)
     */
    public TablaHash(int tamanioInicial) {
        if (tamanioInicial < 1) {
            throw new IllegalArgumentException("Capacidad no valida");
        }
        this.tamanioInicial = tamanioInicial;
        this.tabla = new Entrada[tamanioInicial];
        this.metodo = 0;
    }

    /**
     * Constructor
     *
     * @param tamanioInicial, capacidad de la tabla
     * @param metodo, metodo de resolucion de colisiones metodo = 0: prueba
     * lineal metodo = 1: prueba cuadratica
     */
    public TablaHash(int tamanioInicial, int metodo) {
        this(tamanioInicial);

        if (metodo > 1 || metodo < 0) {
            throw new IllegalArgumentException("Metodo no valido");
        }

        if (metodo == 1) {
            this.metodo = 1;
        }
    }

    @Override
    public void put(K clave, V valor) {

        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("Tabla llena");
        }

        if (clave == null) {
            throw new IllegalArgumentException("Clave nula");
        }

        if (contains(clave)) {
            throw new IllegalArgumentException("Clave Existente: " + clave);
        }

        int posicion = funcionHash(clave);

        if (tabla[posicion] == null) {
            tabla[posicion] = new Entrada(clave, valor);
        } else {
            if (metodo == 1) {
                tabla[pruebaCuadratica(posicion)] = new Entrada(clave, valor);
            } else {
                tabla[pruebaLineal(posicion)] = new Entrada(clave, valor);
            }
        }

    }

    @Override
    public void remove(K clave) {
        if (clave == null) {
            throw new IllegalArgumentException("Clave nula");
        }

        if (!contains(clave)) {
            throw new ArrayIndexOutOfBoundsException("Clave No Existe");
        }

        if (metodo == 1) {
            pruebaCuadraticaBusqueda(clave, true);
            return;
        }

        pruebaLinealBusqueda(clave, true);
    }

    @Override
    public V get(K clave) {
        if (clave == null) {
            throw new IllegalArgumentException("Clave nula");
        }

        if (!contains(clave)) {
            throw new NoSuchElementException("Clave No Existe");
        }

        if (metodo == 1) {
            return pruebaCuadraticaBusqueda(clave);
        }

        return pruebaLinealBusqueda(clave);
    }

    @Override
    public boolean contains(K clave) {
        if (clave == null) {
            throw new IllegalArgumentException("Clave nula");
        }

        while (true) {
            if (tabla[funcionHash(clave)] == null) {
                return false;
            } else {
                if (tabla[funcionHash(clave)].getKey().equals(clave)) {
                    return true;
                } else {
                    if (metodo == 0) {
                        return pruebaLinealBusqueda(clave) != null;
                    } else {
                        return pruebaCuadraticaBusqueda(clave) != null;
                    }
                }
            }
        }//FIN WHILE

    }

    @Override
    public void makeEmpty() {
        for (int i = 0; i < tabla.length; i++) {
            tabla[i] = null;
        }
    }

    @Override
    public int size() {
        return tamanioInicial;
    }

    @Override
    public boolean isFull() {
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] == null) {
                return false;
            }
        }
        return true;
    }

    private int funcionHash(K clave) {
        int hash = Objects.hashCode(clave) % tamanioInicial;
        return hash;
    }

    private int pruebaLineal(int posicion) {
        int i = 0;
        int resultado = 0;

        do {
            i++;
            resultado = posicion + i;
            resultado = resultado % tamanioInicial;
        } while (!(tabla[resultado] == null));

        return resultado;
    }

    private V pruebaLinealBusqueda(K clave) {
        return pruebaLinealBusqueda(clave, false);
    }

    private V pruebaLinealBusqueda(K clave, boolean remove) {
        int posicion = funcionHash(clave);
        int i = 0;
        int resultado = 0;

        do {
            if (i > 0) {
                if (tabla[resultado].getKey().equals(clave)) {
                    if (remove) {
                        tabla[resultado] = null;
                        break;
                    } else {
                        return tabla[resultado].getValue();
                    }
                }
            }
            i++;
            resultado = posicion + i;
            resultado = resultado % tamanioInicial;
        } while (!(tabla[resultado] == null));

        return null;
    }

    private int pruebaCuadratica(int posicion) {
        int i = 0;
        int resultado = 0;

        do {
            i++;
            resultado = posicion + (int) Math.pow(-1, i) + (i * i);
            resultado = resultado % tamanioInicial;
            if (resultado < 0) {
                resultado *= -1;
            }
        } while (!(tabla[resultado] == null));

        return resultado;
    }

    private V pruebaCuadraticaBusqueda(K clave) {
        return pruebaCuadraticaBusqueda(clave, false);
    }

    private V pruebaCuadraticaBusqueda(K clave, boolean remove) {
        int posicion = funcionHash(clave);
        int i = 0;
        int resultado = 0;

        do {
            if (i > 0) {
                if (tabla[resultado].getKey().equals(clave)) {
                    if (remove) {
                        tabla[resultado] = null;
                        break;
                    } else {
                        return tabla[resultado].getValue();
                    }
                }
            }
            i++;
            resultado = posicion + (((int) Math.pow(-1, i)) * (i * i));
            resultado = resultado % tamanioInicial;
            if (resultado < 0) {
                resultado *= -1;
            }
        } while (!(tabla[resultado] == null));

        return null;
    }

    @Override
    public String toString() {
        String res = "";

        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] != null) {
                Entrada<K, V> entrada = tabla[i];
                res += entrada.toString() + "\n";
            }
        }

        return res;
    }

}
