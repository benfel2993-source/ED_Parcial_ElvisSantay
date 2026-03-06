package benchmark;

/**
 * ============================================================
 * MEDIDOR DE TIEMPO
 * ============================================================
 * Mide cuántos milisegundos tarda en ejecutarse un algoritmo.
 * Ejecuta el algoritmo REPETICIONES veces y calcula el promedio
 * para reducir el ruido de la JVM (JIT, GC, cache warming, etc.)
 *
 * USO:
 *   double tiempo = Medidor.medir(() -> Fibonacci.iterativo(n));
 * ============================================================
 */
public class Medidor {

    /** Número de repeticiones para promediar */
    private static final int REPETICIONES = 10;

    // ------------------------------------------------------------
    // INTERFAZ FUNCIONAL
    // ------------------------------------------------------------
    /**
     * Permite pasar un bloque de código como parámetro usando lambdas.
     */
    @FunctionalInterface
    public interface Algoritmo {
        void ejecutar();
    }

    // ------------------------------------------------------------
    // MÉTODO PRINCIPAL DE MEDICIÓN
    // ------------------------------------------------------------
    /**
     * Mide el tiempo promedio de ejecución de un algoritmo.
     *
     * @param algoritmo bloque de código a medir
     * @return tiempo promedio en milisegundos (ms)
     */
    public static double medir(Algoritmo algoritmo) {

        long totalNanos = 0;

        for (int i = 0; i < REPETICIONES; i++) {

            long inicio = System.nanoTime();   // reloj de alta precisión
            algoritmo.ejecutar();
            long fin    = System.nanoTime();

            totalNanos += (fin - inicio);
        }

        double promedioNanos = (double) totalNanos / REPETICIONES;

        return promedioNanos / 1_000_000.0;   // nanosegundos → milisegundos
    }

    // ------------------------------------------------------------
    // UTILIDADES DE IMPRESIÓN
    // ------------------------------------------------------------
    public static void imprimirEncabezado() {

        System.out.println("-".repeat(60));
        System.out.printf("%-14s | %-12s | %-8s | %s%n",
                "Algoritmo", "Versión", "n", "Tiempo (ms)");
        System.out.println("-".repeat(60));
    }

    public static void imprimirFila(String algoritmo,
                                     String version,
                                     int n,
                                     double tiempoMs) {

        System.out.printf("%-14s | %-12s | n=%-5d | %.6f ms%n",
                algoritmo, version, n, tiempoMs);
    }
}