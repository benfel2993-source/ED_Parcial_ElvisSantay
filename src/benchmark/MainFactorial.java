package benchmark;

import algorithms.Factorial;

public class MainFactorial {

    private static final int[] N = {5, 10, 15, 20, 25, 30};

    public static void main(String[] args) {

        System.out.println("============================================================");
        System.out.println("FACTORIAL");
        System.out.println("============================================================");

        System.out.println("\nFACTORIAL ITERATIVO  [O(n)]");
        Medidor.imprimirEncabezado();

        for (int n : N) {
            double tiempo = Medidor.medir(() -> Factorial.iterativo(n));
            Medidor.imprimirFila("Factorial", "Iterativo", n, tiempo);
        }

        System.out.println("\nFACTORIAL RECURSIVO  [O(n)]");
        Medidor.imprimirEncabezado();

        for (int n : N) {
            double tiempo = Medidor.medir(() -> Factorial.recursivo(n));
            Medidor.imprimirFila("Factorial", "Recursivo", n, tiempo);
        }
    }
}