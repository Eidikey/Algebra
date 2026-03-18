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
}
