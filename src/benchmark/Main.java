package benchmark;

import algorithms.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Main {

    private static final int[] TAMANOS_PEQUENOS = {5, 10, 15, 20, 25, 30};
    private static final int[] TAMANOS_GRANDES  = {100, 500, 1000, 5000, 10000};

    private static final String CSV_PATH = "resultados/tiempos.csv";

    public static void main(String[] args) {

        imprimirBanner();

        StringBuilder csv = new StringBuilder();
        csv.append("Algoritmo,Version,n,Tiempo_ms\n");

        ejecutarFactorial(csv);
        ejecutarFibonacci(csv);
        ejecutarBusqueda(csv);
        ejecutarBurbuja(csv);

        exportarCSV(csv.toString());
    }

    // ============================================================
    // FACTORIAL
    // ============================================================
    private static void ejecutarFactorial(StringBuilder csv) {

        System.out.println("\nFACTORIAL ITERATIVO  [O(n)]");
        imprimirEncabezado();

        for (int n : TAMANOS_PEQUENOS) {

            try {
                double t = Medidor.medir(() -> Factorial.iterativo(n));
                imprimirFila("Factorial", "Iterativo", n, t);
                csv.append(String.format("Factorial,Iterativo,%d,%.6f%n", n, t));
            } catch (Exception e) {
                System.out.printf("Factorial     | Iterativo    | n=%-5d | Fuera de rango%n", n);
            }
        }

        System.out.println("\nFACTORIAL RECURSIVO  [O(n)]");
        imprimirEncabezado();

        for (int n : TAMANOS_PEQUENOS) {

            try {
                double t = Medidor.medir(() -> Factorial.recursivo(n));
                imprimirFila("Factorial", "Recursivo", n, t);
                csv.append(String.format("Factorial,Recursivo,%d,%.6f%n", n, t));
            } catch (Exception e) {
                System.out.printf("Factorial     | Recursivo    | n=%-5d | Fuera de rango%n", n);
            }
        }
    }

    // ============================================================
    // FIBONACCI
    // ============================================================
    private static void ejecutarFibonacci(StringBuilder csv) {

        System.out.println("\nFIBONACCI ITERATIVO  [O(n)]");
        imprimirEncabezado();

        for (int n : TAMANOS_PEQUENOS) {

            double t = Medidor.medir(() -> Fibonacci.iterativo(n));
            imprimirFila("Fibonacci", "Iterativo", n, t);
            csv.append(String.format("Fibonacci,Iterativo,%d,%.6f%n", n, t));
        }

        System.out.println("\nFIBONACCI RECURSIVO  [O(2^n)]");
        imprimirEncabezado();

        for (int n : TAMANOS_PEQUENOS) {

            double t = Medidor.medir(() -> Fibonacci.recursivo(n));
            imprimirFila("Fibonacci", "Recursivo", n, t);
            csv.append(String.format("Fibonacci,Recursivo,%d,%.6f%n", n, t));
        }
    }

    // ============================================================
    // BUSQUEDA LINEAL
    // ============================================================
    private static void ejecutarBusqueda(StringBuilder csv) {

        System.out.println("\nBUSQUEDA LINEAL ITERATIVA  [O(n)]");
        imprimirEncabezado();

        for (int n : TAMANOS_GRANDES) {

            int[] arr = new Random().ints(n, 0, n).toArray();
            int target = arr[n / 2];

            double t = Medidor.medir(() ->
                    BusquedaLineal.iterativo(arr, target));

            imprimirFila("Busqueda", "Iterativo", n, t);
            csv.append(String.format("Busqueda,Iterativo,%d,%.6f%n", n, t));
        }

        System.out.println("\nBUSQUEDA LINEAL RECURSIVA  [O(n)]");
        imprimirEncabezado();

        for (int n : TAMANOS_GRANDES) {

            int[] arr = new Random().ints(n, 0, n).toArray();
            int target = arr[n / 2];

            double t = Medidor.medir(() ->
                    BusquedaLineal.recursivo(arr, target, 0));

            imprimirFila("Busqueda", "Recursivo", n, t);
            csv.append(String.format("Busqueda,Recursivo,%d,%.6f%n", n, t));
        }
    }

    // ============================================================
    // BURBUJA
    // ============================================================
    private static void ejecutarBurbuja(StringBuilder csv) {

        System.out.println("\nORDENAMIENTO BURBUJA ITERATIVO  [O(n^2)]");
        imprimirEncabezado();

        for (int n : TAMANOS_GRANDES) {

            int[] arr = new Random().ints(n, 0, n).toArray();

            double t = Medidor.medir(() ->
                    OrdenamientoBurbuja.iterativo(arr.clone()));

            imprimirFila("Burbuja", "Iterativo", n, t);
            csv.append(String.format("Burbuja,Iterativo,%d,%.6f%n", n, t));
        }

        System.out.println("\nORDENAMIENTO BURBUJA RECURSIVO  [O(n^2)]");
        imprimirEncabezado();

        for (int n : TAMANOS_GRANDES) {

            int[] arr = new Random().ints(n, 0, n).toArray();

            double t = Medidor.medir(() ->
                    OrdenamientoBurbuja.recursivo(arr.clone(), n));

            imprimirFila("Burbuja", "Recursivo", n, t);
            csv.append(String.format("Burbuja,Recursivo,%d,%.6f%n", n, t));
        }
    }

    // ============================================================
    // FORMATO
    // ============================================================
    private static void imprimirEncabezado() {

        System.out.println("============================================================");
        System.out.printf("%-14s | %-12s | %-6s | %s%n",
                "Algoritmo", "Versión", "n", "Tiempo (ms)");
        System.out.println("------------------------------------------------------------");
    }

    private static void imprimirFila(String algoritmo,
                                      String version,
                                      int n,
                                      double tiempo) {

        System.out.printf("%-14s | %-12s | n=%-5d | %.6f ms%n",
                algoritmo, version, n, tiempo);
    }

    private static void imprimirBanner() {

        System.out.println("============================================================");
        System.out.println("  ESTRUCTURA DE DATOS — BENCHMARK GENERAL");
        System.out.println("  Universidad Da Vinci de Guatemala");
        System.out.println("  Ing. Brandon Chitay");
        System.out.println("============================================================");
    }

    private static void exportarCSV(String contenido) {

        try {
            new File("resultados").mkdirs();
            PrintWriter pw = new PrintWriter(new FileWriter(CSV_PATH));
            pw.print(contenido);
            pw.close();

            System.out.println("\n✓ CSV generado exitosamente en: " + CSV_PATH);
            System.out.println("Resultados exportados → " + CSV_PATH);

        } catch (IOException e) {
            System.err.println("Error al escribir CSV: " + e.getMessage());
        }
    }
}