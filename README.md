Examen Parcial - Iterativo vs Recursivo — Análisis de Algoritmos
---------------------------------
Nombre: Elvis Santay
---------------------------------
Descripción

Este proyecto compara el rendimiento entre implementaciones iterativas y recursivas de varios algoritmos en Java.

Algoritmos implementados:

- Factorial
- Fibonacci
- Búsqueda Lineal
- Ordenamiento Burbuja

Se midieron los tiempos de ejecución utilizando System.nanoTime() para analizar cómo cambia el rendimiento según el tamaño de entrada.
---------------------------------
Compilar

Desde la carpeta raíz del proyecto ejecutar:
javac -d out src/algorithms/*.java src/benchmark/*.java
---------------------------------
Ejecutar

Cada algoritmo tiene su propio main.

java -cp out benchmark.MainFibonacci
java -cp out benchmark.MainFactorial
java -cp out benchmark.MainBusquedaLineal
java -cp out benchmark.MainBurbuja
---------------------------------
Video del proyecto

Enlace al video:
