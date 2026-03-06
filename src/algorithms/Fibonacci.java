package algorithms;

/**
 * ============================================================
 * A2 - SERIE DE FIBONACCI
 * ============================================================
 * Calcula el n-ésimo término de la serie:
 *   0, 1, 1, 2, 3, 5, 8, 13, 21, ...
 *
 * Definición matemática:
 *   fib(0) = 0
 *   fib(1) = 1
 *   fib(n) = fib(n-1) + fib(n-2)
 *
 * Complejidad temporal:
 *   - Iterativo:  O(n)
 *   - Recursivo:  O(2^n)  → crecimiento exponencial
 *
 * Complejidad espacial:
 *   - Iterativo:  O(1)
 *   - Recursivo:  O(n)  → profundidad del call stack
 *
 * ADVERTENCIA:
 *   La versión recursiva sin memoización es intencionalmente
 *   ineficiente para demostrar el crecimiento exponencial.
 *   Limitar n ≤ 30.
 * ============================================================
 */
public class Fibonacci {

    // ------------------------------------------------------------
    // VERSIÓN ITERATIVA
    // ------------------------------------------------------------
    /**
     * Calcula Fibonacci usando dos variables deslizantes.
     *
     * @param n índice del término (0-indexado)
     * @return n-ésimo número de Fibonacci
     */
    public static long iterativo(int n) {

        if (n < 0)
            throw new IllegalArgumentException("n no puede ser negativo");

        if (n == 0) return 0;
        if (n == 1) return 1;

        long anterior = 0;
        long actual   = 1;

        for (int i = 2; i <= n; i++) {

            long siguiente = anterior + actual;
            anterior = actual;
            actual   = siguiente;
        }

        return actual;
    }

    // ------------------------------------------------------------
    // VERSIÓN RECURSIVA (SIN MEMOIZACIÓN)
    // ------------------------------------------------------------
    /**
     * Implementación directa de la definición matemática.
     *
     * Genera un árbol binario de llamadas:
     *
     *        fib(n)
     *       /      \
     *  fib(n-1)   fib(n-2)
     *
     * Subproblemas repetidos → O(2^n)
     *
     * @param n índice del término (0 ≤ n ≤ 30 recomendado)
     * @return n-ésimo número de Fibonacci
     */
    public static long recursivo(int n) {

        if (n < 0)
            throw new IllegalArgumentException("n no puede ser negativo");

        if (n > 30)
            throw new IllegalArgumentException("Limitar n ≤ 30 (O(2^n))");

        // --- CASOS BASE ---
        if (n == 0) return 0;
        if (n == 1) return 1;

        // --- DOS LLAMADAS RECURSIVAS ---
        return recursivo(n - 1) + recursivo(n - 2);
    }
}