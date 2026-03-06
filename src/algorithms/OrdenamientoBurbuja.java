package algorithms;

/**
 * ============================================================
 * A4 - ORDENAMIENTO BURBUJA
 * ============================================================
 * Ordena un arreglo de menor a mayor usando el método burbuja.
 *
 * Complejidad temporal:
 *   - Iterativo: O(n²)
 *   - Recursivo: O(n²)
 *
 * Complejidad espacial:
 *   - Ambas versiones: O(1)
 * ============================================================
 */
public class OrdenamientoBurbuja {

    // ------------------------------------------------------------
    // VERSIÓN ITERATIVA
    // ------------------------------------------------------------
    public static void iterativo(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // ------------------------------------------------------------
    // VERSIÓN RECURSIVA
    // ------------------------------------------------------------
    public static void recursivo(int[] arr, int n) {

        if (n == 1) return;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {

                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        recursivo(arr, n - 1);
    }
}