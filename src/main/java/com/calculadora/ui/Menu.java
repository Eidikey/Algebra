package com.calculadora.ui;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n--- CALCULADORA DE ÁLGEBRA ---");
            System.out.println("1. Ingresar Matrices");
            System.out.println("2. Ver Matriz actual");
            System.out.println("3. Resolver Sistema (Gauss)");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                procesarOpcion(opcion);
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingresa un número válido.");
            }
        }
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("->  para ingresar datos de la matriz...");
                break;
            case 2:
                System.out.println("-> Mostrando matriz...");
                break;
            case 3:
                System.out.println("-> Resolviendo sistema...");
                break;
            case 0:
                System.out.println("Saliendo del programa. ¡Suerte en Álgebra!");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}
