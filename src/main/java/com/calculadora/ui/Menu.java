package com.calculadora.ui;

import com.calculadora.modelo.Matriz;
import com.calculadora.logica.CalculadoraAlgebra;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        CalculadoraAlgebra cerebro = new CalculadoraAlgebra();

        Matriz m1 = null;
        matriz m2 = null;
        
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- CALCULADORA DE MATRICES ---");
            ystem.out.println("M1: " + (m1 == null ? "[Vacía]" : "Configurada"));
            System.out.println("M2: " + (m2 == null ? "[Vacía]" : "Configurada"));
            System.out.println("---------------------------------------------------");
            System.out.println("1. Configurar/Cambiar Matriz 1");
            System.out.println("2. Configurar/Cambiar Matriz 2");
            System.out.println("3. Sumar M1 + M2");
            System.out.println("4. Resolver Gauss (M1 y M2)");
            System.out.println("5. Borrar Matriz (M1, M2 o ambas)");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            
            int opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    m1 = cerebro.crearyGenerarMatriz(leer, "Matriz 1");
                      break;
                case 2:
                    m2 = cerebro.crearyGenerarMatriz(leer, "Matriz 2")
                    break;
                case 3:
                    if (miMatriz != null) {
                        Matriz res = CalculadoraAlgebra.sumarMatrices(miMatriz, miMatriz);
                        CalculadoraAlgebra.imprimirMatriz(res);
                    } else System.out.println("No hay matriz cargada.");
                    break;
                case 4:
                    if (m1 != null && m2 != null) {
                    System.out.println("Aplicando Gauss a sistema (M1 | M2)...");
                    cerebro.resolverGauss(m1, m2);
                        } else if (m1 != null) {
                        System.out.println("Aplicando Gauss solo a M1...");
                              cerebro.resolverGauss(m1);
                              } else {
                          System.out.println("Error: No hay matrices para procesar.");
                          }
                      break;
                case 5:
                    System.out.println("¿Cuál borrar? 1:M1, 2:M2, 3:Ambas");
                    int borrar = leer.nextInt();
                    if (borrar == 1) m1 = null;
                    else if (borrar == 2) m2 = null;
                    else { m1 = null; m2 = null; }
                    System.out.println("¡Borrado con éxito!");
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        leer.close();
    }
}
