package benchmark;

import algorithms.OrdenamientoBurbuja;
import java.util.Random;

public class MainBurbuja {

    private static final int[] N = {100, 500, 1000, 5000, 10000};

    public static void main(String[] args) {

        System.out.println("============================================================");
        System.out.println("ORDENAMIENTO BURBUJA");
        System.out.println("============================================================");

        Random random = new Random();

        // ------------------------------------------------------------
        // BURBUJA ITERATIVO
        // ------------------------------------------------------------
        System.out.println("\nORDENAMIENTO BURBUJA ITERATIVO  [O(n²)]");
        Medidor.imprimirEncabezado();

        for (int n : N) {

            int[] arreglo = new int[n];

            for (int i = 0; i < n; i++) {
                arreglo[i] = random.nextInt(10000);
            }

            double tiempo = Medidor.medir(() -> OrdenamientoBurbuja.iterativo(arreglo.clone()));
            Medidor.imprimirFila("Burbuja", "Iterativo", n, tiempo);
        }

        // ------------------------------------------------------------
        // BURBUJA RECURSIVO
        // ------------------------------------------------------------
        System.out.println("\nORDENAMIENTO BURBUJA RECURSIVO  [O(n²)]");
        Medidor.imprimirEncabezado();

        for (int n : N) {

            int[] arreglo = new int[n];

            for (int i = 0; i < n; i++) {
                arreglo[i] = random.nextInt(10000);
            }

            double tiempo = Medidor.medir(() -> 
                OrdenamientoBurbuja.recursivo(arreglo.clone(), arreglo.length)
            );

            Medidor.imprimirFila("Burbuja", "Recursivo", n, tiempo);
        }
    }
}