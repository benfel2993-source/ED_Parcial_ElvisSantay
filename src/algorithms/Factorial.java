package algorithms;

import java.math.BigInteger;

public class Factorial {

    // ----------------------------------------------------------
    // ITERATIVO
    // ----------------------------------------------------------
    public static BigInteger iterativo(int n) {

        if (n < 0)
            throw new IllegalArgumentException("n debe ser >= 0");

        BigInteger resultado = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }

        return resultado;
    }

    // ----------------------------------------------------------
    // RECURSIVO
    // ----------------------------------------------------------
    public static BigInteger recursivo(int n) {

        if (n < 0)
            throw new IllegalArgumentException("n debe ser >= 0");

        if (n == 0 || n == 1)
            return BigInteger.ONE;

        return BigInteger.valueOf(n).multiply(recursivo(n - 1));
    }
}