package org.example;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Main
{
    public static void main(String[] args) //creacion del metodo main
    {
        var categorias = new TreeSet<categoria>(); //creacion de la variable categorias

        var scanner = new Scanner(System.in);   //creacion de la variable scanner

        for (int seleccion = 0; seleccion != 7; ) //creacion del bucle for
        {
            System.out.print(
                    "1.agregar categoría\n" +
                    "2.agregar producto a categoría\n" +
                    "3.mostrar categorías\n" +
                    "4.mostrar productos de categoría\n" +
                    "5.extraer producto\n" +
                    "6.mostrar productos agotados\n" +
                    "7.precio total del catálogo\n" +
                    "8.\n" +
                    "9.\n" +
                    "10.\n" +
                    "11.salir\n" +
                    "seleccion:"
            ); //impresion de las opciones del menu

            seleccion = scanner.nextInt(); //asignacion de la variable seleccion

            if (seleccion == 1)
            {
                System.out.print("nombre de la categoría:"); //impresion de la opcion 1

                var nombre_categoria = scanner.next(); //asignacion de la variable nombre_categoria

                categorias.add(new categoria(nombre_categoria)); //agregar la variable nombre_categoria a la variable categorias
            }

            if (seleccion == 2)
            {
                System.out.print("nombre de la categoría:"); //impresion de la opcion 2

                var nombre_categoria = scanner.next(); //asignacion de la variable nombre_categoria

                var categoria_encontrada = false; //asignacion de la variable categoria_encontrada

                for (var x : categorias)  //creacion del bucle for
                {
                    if (x.nombre.equals(nombre_categoria)) //comparacion de la variable nombre_categoria con la variable x.nombre
                    {
                        System.out.print("codigo de el producto:"); //impresion de la opcion 2

                        var codigo_producto = scanner.nextInt(); //asignacion de la variable codigo_producto

                        System.out.print("nombre de el producto:"); //impresion de la opcion 2

                        var nombre_producto = scanner.next(); //asignacion de la variable nombre_producto

                        System.out.print("precio de el producto:"); //impresion de la opcion 2

                        var precio_producto = scanner.nextFloat();

                        System.out.print("número de unidades de el producto:"); //impresion de la opcion 2

                        var numero_unidades_producto = scanner.nextInt(); //asignacion de la variable numero_unidades_producto

                        x.productos.add(
                                new producto(
                                        codigo_producto,
                                        nombre_producto,
                                        precio_producto,
                                        numero_unidades_producto
                                )
                        ); //agregar la variable nombre_producto a la variable x.productos

                        System.out.print("producto " + nombre_producto + " agregado a la categoría " + nombre_categoria);
                        //impresion de la opcion 2

                        categoria_encontrada = true; //asignacion de la variable categoria_encontrada

                        break; //salida del bucle for
                    }
                }

                if (!categoria_encontrada) //comparacion de la variable categoria_encontrada

                {
                    System.out.println("la categoría " + nombre_categoria + " no existe"); //impresion de la opcion 2
                }
            }

            if (seleccion == 3) //comparacion de la variable seleccion
            {
                for (var x : categorias) //creacion del bucle for
                {
                    System.out.println(x.nombre); //impresion de la opcion 3
                }
            }

            if (seleccion == 4) //comparacion de la variable seleccion
            {
                System.out.print("nombre de la categoría:"); //impresion de la opcion 4

                var nombre_categoria = scanner.next(); //asignacion de la variable nombre_categoria

                var categoria_encontrada = false; //asignacion de la variable categoria_encontrada

                for (var x : categorias) //creacion del bucle for
                {
                    if (x.nombre.equals(nombre_categoria)) //comparacion de la variable nombre_categoria con la variable x.nombre
                    {
                        Collections.sort(x.productos); //ordenar la variable x.productos

                        System.out.println(x.productos); //impresion de la opcion 4

                        categoria_encontrada = true; //asignacion de la variable categoria_encontrada

                        break; //salida del bucle for
                    }

                }

                if (!categoria_encontrada) //comparacion de la variable categoria_encontrada
                {
                    System.out.println("la categoría " + nombre_categoria + " no existe"); //impresion de la opcion 4
                }

            }

            if (seleccion == 5) //comparacion de la variable seleccion
            {
                System.out.print("nombre de la categoría:"); //impresion de la opcion 5

                var nombre_categoria = scanner.next(); //asignacion de la variable nombre_categoria

                var categoria_encontrada = false; //asignacion de la variable categoria_encontrada

                for (var x : categorias) //creacion del bucle for
                {
                    if (x.nombre.equals(nombre_categoria)) //comparacion de la variable nombre_categoria con la variable x.nombre
                    {
                        System.out.print("codigo de el producto:"); //impresion de la opcion 5

                        var codigo_producto = scanner.nextInt(); //asignacion de la variable codigo_producto

                        var producto_encontrado = false; //asignacion de la variable producto_encontrado

                        for (var y : x.productos) //creacion del bucle for
                        {
                            if (y.codigo == codigo_producto) //comparacion de la variable codigo_producto con la variable y.codigo
                            {
                                System.out.print("número de unidades a extraer:"); //impresion de la opcion 5

                                var unidades_a_extraer = scanner.nextInt(); //asignacion de la variable unidades_a_extraer

                                if (y.unidades < unidades_a_extraer) //comparacion de la variable y.unidades con la variable unidades_a_extraer
                                {
                                    System.out.print("número de unidades insuficientes"); //impresion de la opcion 5
                                }
                                else
                                {
                                    y.setUnidades(y.unidades - unidades_a_extraer); //asignacion de la variable y.unidades
                                }

                                producto_encontrado = true; //asignacion de la variable producto_encontrado

                                break; //salida del bucle for
                            }
                        }

                        if (!producto_encontrado) //comparacion de la variable producto_encontrado
                        {
                            System.out.println("el producto con código " + codigo_producto + " no existe"); //impresion de la opcion 5
                        }

                        categoria_encontrada = true; //asignacion de la variable categoria_encontrada

                        break; //salida del bucle for
                    }
                }


                if (!categoria_encontrada) //comparacion de la variable categoria_encontrada
                {
                    System.out.println("la categoría " + nombre_categoria + " no existe"); //impresion de la opcion 5
                }
            }

            if (seleccion == 6) //comparacion de la variable seleccion
            {
                for (var x : categorias) //creacion del bucle for
                {
                    for (var y : x.productos) //creacion del bucle for
                    {
                        if (y.unidades == 0) //comparacion de la variable y.unidades
                        {
                            System.out.println(y); //impresion de la opcion 6
                        }
                    }
                }
            }

            if (seleccion == 7) //comparacion de la variable seleccion
            {
                float precio_total = 0.f; //asignacion de la variable precio_total

                for (var x : categorias) //creacion del bucle for
                {
                    for (var y : x.productos) //creacion del bucle for
                    {
                        precio_total += y.precio * y.unidades; //asignacion de la variable precio_total
                    }
                }

                System.out.println("El precio total del catálogo es " + precio_total + " €"); //impresion de la opcion 7
            }

            if (seleccion == 8) //comparacion de la variable seleccion
            {
                int productos_totales = 0; //asignacion de la variable productos_totales
                float precio_total = 0.f; //asignacion de la variable precio_total

                for (var x : categorias) //creacion del bucle for
                {
                    for (var y : x.productos) //creacion del bucle for
                    {
                        ++productos_totales; //asignacion de la variable productos_totales
                        precio_total += y.precio; //asignacion de la variable precio_total
                    }
                }

                System.out.println("El precio promedio del catálogo es " + precio_total / productos_totales + " €"); //impresion de la opcion 8
            }

            if (seleccion == 9) //comparacion de la variable seleccion
            {
                int productos_totales = 0; //asignacion de la variable productos_totales
                float precio_total = 0.f; //asignacion de la variable precio_total

                System.out.print("nombre de la categoría:"); //impresion de la opcion 9

                var nombre_categoria = scanner.next(); //asignacion de la variable nombre_categoria

                var categoria_encontrada = false; //asignacion de la variable categoria_encontrada

                for (var x : categorias) //creacion del bucle for
                {
                    if (x.nombre.equals(nombre_categoria)) //comparacion de la variable nombre_categoria con la variable x.nombre
                    {
                        for (var y : x.productos) //creacion del bucle for
                        {
                            ++productos_totales; //asignacion de la variable productos_totales
                            precio_total += y.precio; //asignacion de la variable precio_total
                        }

                        System.out.println("El precio promedio de la categoría es " + precio_total / productos_totales + " €"); //impresion de la opcion 9

                        categoria_encontrada = true; //asignacion de la variable categoria_encontrada

                        break;  //salida del bucle for
                    }
                }

                if (!categoria_encontrada)  //comparacion de la variable categoria_encontrada
                {
                    System.out.println("la categoría " + nombre_categoria + " no existe"); //impresion de la opcion 9
                }
            }

            if (seleccion == 10) //comparacion de la variable seleccion
            {
                producto producto_mas_caro = null; //asignacion de la variable producto_mas_caro

                for (var x : categorias) //creacion del bucle for
                {
                    for (var y : x.productos) //creacion del bucle for
                    {
                       if (producto_mas_caro == null || y.precio > producto_mas_caro.precio)
                           producto_mas_caro = y; //asignacion de la variable producto_mas_caro
                    }
                }

                System.out.println("El producto más caro es " + producto_mas_caro); //impresion de la opcion 10

            }

            if (seleccion == 11) //comparacion de la variable seleccion
                break; //salida del bucle while
        }

        categorias.clear(); //limpieza de la variable categorias

        scanner.close(); //cierre del scanner
    } //fin del metodo main
} //fin de la clase principal