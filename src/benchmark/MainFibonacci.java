package benchmark;

import algorithms.Fibonacci;

public class MainFibonacci {

    private static final int[] N = {5, 10, 15, 20, 25, 30};

    public static void main(String[] args) {

        System.out.println("============================================================");
        System.out.println("A2 - SERIE DE FIBONACCI");
        System.out.println("============================================================");

        System.out.println("\nFIBONACCI ITERATIVO  [O(n)]");
        Medidor.imprimirEncabezado();

        for (int n : N) {
            double tiempo = Medidor.medir(() -> Fibonacci.iterativo(n));
            Medidor.imprimirFila("Fibonacci", "Iterativo", n, tiempo);
        }

        System.out.println("\nFIBONACCI RECURSIVO  [O(2^n)]");
        Medidor.imprimirEncabezado();

        for (int n : N) {
            double tiempo = Medidor.medir(() -> Fibonacci.recursivo(n));
            Medidor.imprimirFila("Fibonacci", "Recursivo", n, tiempo);
        }
    }
}