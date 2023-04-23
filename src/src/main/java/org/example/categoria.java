package org.example;

import java.util.List;
import java.util.ArrayList;

public class categoria implements Comparable<categoria> //creacion de la clase categoria
{
    String nombre = ""; //creacion de la variable nombre
    List<producto> productos; //creacion de la variable productos

    public categoria(String nombre)
    {
        this.nombre = nombre;
        this.productos = new ArrayList<producto>();
    }
    //constructor de la clase categoria



    @Override public int compareTo(categoria x)
    {
        return this.nombre.compareTo(x.nombre);
    }
}   //metodo para comparar la variable nombre
    //fin de la clase categoria
