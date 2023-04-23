package org.example;

public class producto implements Comparable<producto> //creacion de la clase producto
{
    int codigo = 0; //creacion de la variable codigo
    String descripcion = ""; //creacion de la variable descripcion
    float precio = 0.f; //creacion de la variable precio
    int unidades = 0; //creacion de la variable unidades

    public producto(int codigo, String descripcion, float precio, int unidades) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.unidades = unidades;
    } //constructor de la clase producto

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    //metodo para modificar la variable unidades

    @Override
    public int compareTo(producto x) {
        return this.descripcion.compareTo(x.descripcion);
    }
    //metodo para comparar la variable descripcion

    @Override
    public String toString() {
        return this.descripcion;
    }
}
    //metodo para mostrar la variable descripcion
    //fin de la clase producto
