package benchmark;

import algorithms.BusquedaLineal;

import java.util.Random;

public class MainBusquedaLineal {

    private static final int[] N = {100, 500, 1000, 5000, 10000};

    public static void main(String[] args) {

        System.out.println("============================================================");
        System.out.println("A3 - BUSQUEDA LINEAL");
        System.out.println("============================================================");

        Random random = new Random();

        System.out.println("\nBUSQUEDA LINEAL ITERATIVA  [O(n)]");
        Medidor.imprimirEncabezado();

        for (int n : N) {

            int[] arreglo = new int[n];
            for (int i = 0; i < n; i++) {
                arreglo[i] = random.nextInt(10000);
            }

            int objetivo = arreglo[n - 1];

            double tiempo = Medidor.medir(() -> BusquedaLineal.iterativo(arreglo, objetivo));
            Medidor.imprimirFila("Busqueda", "Iterativo", n, tiempo);
        }

        System.out.println("\nBUSQUEDA LINEAL RECURSIVA  [O(n)]");
        Medidor.imprimirEncabezado();

        for (int n : N) {

            int[] arreglo = new int[n];
            for (int i = 0; i < n; i++) {
                arreglo[i] = random.nextInt(10000);
            }

            int objetivo = arreglo[n - 1];

            double tiempo = Medidor.medir(() -> BusquedaLineal.recursivo(arreglo, objetivo, 0));
            Medidor.imprimirFila("Busqueda", "Recursivo", n, tiempo);
        }
    }
}