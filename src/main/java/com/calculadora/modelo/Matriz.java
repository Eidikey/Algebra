package com.calculadora.modelo;

public class Matriz {
  private final double[][] datos;
  private final int filas;
  private final int columnas;

  public Matriz(int filas, int columnas) {
    if (filas <= 0 || columnas <= 0) {
      throw new IllegalArgumentException("Las dimensiones de la matriz deben ser mayores a cero.");
    }
    this.filas = filas;
    this.columnas = columnas;
    this.datos = new double[filas][columnas];
  }

  public int getFilas() {
    return filas;
  }

  public int getColumnas() {
    return columnas;
  }

  public double getElemento(int f, int c) {
    validarIndices(f, c);
    return datos[f][c];
  }

  public void setElemento(int f, int c, double valor) {
    validarIndices(f, c);
    this.datos[f][c] = valor;
  }

  private void validarIndices(int f, int c) {
    if (f < 0 || f >= filas || c < 0 || c >= columnas) {
      throw new IndexOutOfBoundsException("Índices fuera de rango: [" + f + "][" + c + "]");
    }
  }
}
