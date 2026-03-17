package com.calculadora.logica:
import com.calculadora.modelo.Matriz;

public class CalculadoraAlgebra(){

  public void llenarMatriz(Matriz m, Scanner cf){
    for (int i = 0; i < m.obtenerFilas(); i++) {
      for (int j = 0; j < m.obtenerColumnas();j++){
        System.out.println("Elemento [" + i + "][" + j + "]");
        double val = sc.nextDouble();
        m.setElemento(i, j, val);


      }
    }
  }

    public void resolverGauss(Matriz m){
     //se supone que aqui deberia ir el codigo de gauss pero mientras le deje un mensaje chico
     System.out.println("algoritmo de gauss en las Matrices");
   }

   public void sumarMatrices(Matriz a, Matriz b){
     //logica de la suma
   }
}
