package com.calculadora.ui;

import com.calculadora.modelo.Matriz;
import com.calculadora.logica.CalculadoraAlgebra;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Matriz miMatriz = null;
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- CALCULADORA DE MATRICES ---");
            System.out.println("1. Configurar/Ingresar Matriz");
            System.out.println("2. Ver Matriz actual");
            System.out.println("3. Sumar (con ella misma)");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            
            int opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Filas: ");
                    int f = leer.nextInt();
                    System.out.print("Columnas: ");
                    int c = leer.nextInt();
                    miMatriz = new Matriz(f, c);
                    CalculadoraAlgebra.llenarMatriz(miMatriz, leer);
                    break;
                case 2:
                    if (miMatriz != null) CalculadoraAlgebra.imprimirMatriz(miMatriz);
                    else System.out.println("No hay matriz cargada.");
                    break;
                case 3:
                    if (miMatriz != null) {
                        Matriz res = CalculadoraAlgebra.sumarMatrices(miMatriz, miMatriz);
                        CalculadoraAlgebra.imprimirMatriz(res);
                    } else System.out.println("No hay matriz cargada.");
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        leer.close();
    }
}
