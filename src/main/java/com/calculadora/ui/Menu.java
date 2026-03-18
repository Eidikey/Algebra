package com.calculadora.ui;

import com.calculadora.modelo.Matriz;
import com.calculadora.logica.CalculadoraAlgebra;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        CalculadoraAlgebra cerebro = new CalculadoraAlgebra();

        Matriz m1 = null;
        Matriz m2 = null;
        
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- CALCULADORA DE MATRICES ---");
            System.out.println("M1: " + (m1 == null ? "[Vacía]" : "Configurada"));
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
                    m1 = cerebro.crearYGenerarMatriz(leer, "Matriz 1");
                      break;
                case 2:
                    m2 = cerebro.crearYGenerarMatriz(leer, "Matriz 2");
                    break;
                case 3:
                    if (m1 != null) {
                     Matriz res = cerebro.sumarMatrices(m1, m2);
                      cerebro.imprimirMatriz(res);
                    } else System.out.println("No hay matriz cargada.");
                    break;
                case 4:
                    if (m1 != null && m2 != null) {
                    // Validamos que el sistema sea cuadrado para Gauss simple
                    if (m1.getFilas() == m1.getColumnas() && m1.getFilas() == m2.getFilas()) {
                    cerebro.resolverGauss(m1, m2);
                        } else {
                      System.out.println("Error: Para Gauss, M1 debe ser cuadrada y M2 debe tener las mismas filas.");
                      }
                        } else {
                          System.out.println("Error: Necesitas configurar M1 (coeficientes) y M2 (resultados).");
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
