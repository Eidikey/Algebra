package com.calculadora.ui;
import com.calculadora.modelo.Matriz;
import com.calculadora.logica.CalculadoraAlgebra;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
      
       CalculadoraAlgebra cerebro = new CalculadoraAlgebra();
       System.out.println("=== CONFIGURACIÓN DE MATRIZ ===");
        System.out.print("Introduce el número de filas: ");
        int f = leer.nextInt();
        
        System.out.print("Introduce el número de columnas: ");
        int c = leer.nextInt();
        //instanciamos la Matriz con los datos que se meten
       Matriz miMatriz = new Matriz(f,c);
       //los mandamos a que se llenen 
       cerebro.llenarMatriz(miMatriz, leer);
    // ahora si mostramos las opciones que hay para esas matrices
       System.out.println("\n¿Que deseas ahcer con esa matriz?:")
       System.out.println("1.- resolver por metodo de gauss");
       System.out.println("2.-sumar");
       System.out.println("3.- mostar Matriz actual");
       //demas opciones, deja me chingo un cafe mrd 
       System.out.println("4.-salir");
       int opcion = new leer.nextInt();


          switch (opcion) {
            case 1:
                cerebro.resolverGauss(miMatriz);
                break;
            case 2:
                cerebro.sumarMtrices(miMatriz, miMatriz);
              break;

            case 3:
              cerebro.imprimirMatriz(miMatriz);
              break;

            default:
                System.out.println("Saliendo.");
        }
    }
}
