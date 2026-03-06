package algorithms;

/**
 * ============================================================
 * A3 - BÚSQUEDA LINEAL
 * ============================================================
 * Busca un valor dentro de un arreglo recorriéndolo secuencialmente.
 *
 * Complejidad temporal:
 *   - Iterativo: O(n)
 *   - Recursivo: O(n)
 *
 * Complejidad espacial:
 *   - Iterativo: O(1)
 *   - Recursivo: O(n)
 * ============================================================
 */
public class BusquedaLineal {

    // ------------------------------------------------------------
    // VERSIÓN ITERATIVA
    // ------------------------------------------------------------
    public static int iterativo(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }

        return -1;
    }

    // ------------------------------------------------------------
    // VERSIÓN RECURSIVA
    // ------------------------------------------------------------
    public static int recursivo(int[] arr, int target, int index) {

        if (index >= arr.length)
            return -1;

        if (arr[index] == target)
            return index;

        return recursivo(arr, target, index + 1);
    }
}