package com.calculadora.logica;

import com.calculadora.modelo.Matriz;
import java.util.Scanner;

public class CalculadoraAlgebra {

    public static void llenarMatriz(Matriz m, Scanner leer) {
        for (int i = 0; i < m.getFilas(); i++) {
            for (int j = 0; j < m.getColumnas(); j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                double val = leer.nextDouble();
                m.setElemento(i, j, val);
            }
        }
    }

    public static void imprimirMatriz(Matriz m) {
        for (int i = 0; i < m.getFilas(); i++) {
            for (int j = 0; j < m.getColumnas(); j++) {
                System.out.print(m.getElemento(i, j) + "\t");
            }
            System.out.println();
        }
    }

    public static Matriz sumarMatrices(Matriz a, Matriz b) {
        if (a.getFilas() != b.getFilas() || a.getColumnas() != b.getColumnas()) {
            System.out.println("Error: Dimensiones incompatibles para suma.");
            return null;
        }
        Matriz res = new Matriz(a.getFilas(), a.getColumnas());
        for (int i = 0; i < a.getFilas(); i++) {
            for (int j = 0; j < a.getColumnas(); j++) {
                res.setElemento(i, j, a.getElemento(i, j) + b.getElemento(i, j));
            }
        }
        return res;
    }

    public static Matriz multiplicarMatrices(Matriz a, Matriz b) {
        if (a.getColumnas() != b.getFilas()) {
            System.out.println("Error: Columnas de A != Filas de B.");
            return null;
        }
        Matriz res = new Matriz(a.getFilas(), b.getColumnas());
        for (int i = 0; i < a.getFilas(); i++) {
            for (int j = 0; j < b.getColumnas(); j++) {
                double suma = 0;
                for (int k = 0; k < a.getColumnas(); k++) {
                    suma += a.getElemento(i, k) * b.getElemento(k, j);
                }
                res.setElemento(i, j, suma);
            }
        }
        return res;
    }
    public Matriz crearYGenerarMatriz(Scanner leer, String nombre) {
    System.out.println("--- Configurando " + nombre + " ---");
    System.out.print("Introduce el número de filas: ");
    int f = leer.nextInt();
    System.out.print("Introduce el número de columnas: ");
    int c = leer.nextInt();
    
    Matriz m = new Matriz(f, c);
    llenarMatriz(m, leer); // Uso el método que ya tenemos para pedir los números
    return m;
    }



    public void resolverGauss(Matriz m1, Matriz m2) {
    int n = m1.getFilas();
    // Creamos una copia para no destruir la matriz original por si el usuario quiere seguir usándola
    double[][] a = m1.getDatos(); // Asumiendo que getDatos() devuelve el double[][]
    double[][] b = m2.getDatos();

    // --- PROCESO DE ELIMINACIÓN ---
    // el del triangulo we
    for (int i = 0; i < n; i++) {
        // 1. Buscamos el pivote (el número más grande en la columna actual)
        int max = i;
        for (int k = i + 1; k < n; k++) {
            if (Math.abs(a[k][i]) > Math.abs(a[max][i])) {
                max = k;
            }
        }

        // 2. Intercambiamos filas en la matriz A y en la matriz B (Resultados)
        double[] tempA = a[i];
        a[i] = a[max];
        a[max] = tempA;

        double[] tempB = b[i];
        b[i] = b[max];
        b[max] = tempB;

        // 3. Hacer ceros debajo del pivote
        for (int k = i + 1; k < n; k++) {
            double factor = a[k][i] / a[i][i];
            // Actualizamos la fila en B
            b[k][0] -= factor * b[i][0];
            // Actualizamos la fila en A
            for (int j = i; j < n; j++) {
                a[k][j] -= factor * a[i][j];
            }
        }
    }

    // --- SUSTITUCIÓN HACIA ATRÁS ---
    double[] solucion = new double[n];
    for (int i = n - 1; i >= 0; i--) {
        double suma = 0.0;
        for (int j = i + 1; j < n; j++) {
            suma += a[i][j] * solucion[j];
        }
        solucion[i] = (b[i][0] - suma) / a[i][i];
    }

    // --- MOSTRAR RESULTADOS ---
    System.out.println("\nSoluciones del sistema:");
    for (int i = 0; i < n; i++) {
        System.out.printf("x%d = %.4f\n", (i + 1), solucion[i]);
       }
  }

}


