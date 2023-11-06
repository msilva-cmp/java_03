package com.clase03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Clase03
{
    public static void main(String[] args)
    {
        List<Integer> numeros = new ArrayList();
        
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        
        linea(30, "Mostrar por forEach:");
        numeros.stream()
                .forEach((num) -> System.out.print(num));
        
        linea(30, "Mostrar por for:");
        for(int num: numeros)
            System.out.print(num);
        
        linea(30, "AnyMatch 1:");
        boolean coincide = numeros.stream()
                .anyMatch((num) -> num>2);
        System.out.println(coincide);
        linea(30, "AnyMatch 2:");
        coincide = numeros.stream()
                .anyMatch((num) -> num<2);
        System.out.println(coincide);
        linea(30, "AnyMatch 3:");
        coincide = numeros.stream()
                .anyMatch((num) -> num<1);
        System.out.println(coincide);
        
        linea(30, "AllMatch 1:");
        coincide = numeros.stream()
                .allMatch((num) -> num>2);
        System.out.println(coincide);
        linea(30, "AllMatch 2:");
        coincide = numeros.stream()
                .allMatch((num) -> num<2);
        System.out.println(coincide);
        linea(30, "AllMatch 3:");
        coincide = numeros.stream()
                .allMatch((num) -> num>0);
        System.out.println(coincide);
        
        
        linea(30, "Lista por map - Obj. a String:");
        List<Persona> personas = new ArrayList<>();
        personas.add( new Persona( "José"));
        personas.add( new Persona( "María"));
        personas.add( new Persona( "Carlos" ));
        
        List<String> personas2 = new ArrayList<>();
        personas2.add( "Mike");
        personas2.add("Pepito");
        personas2.add( "Fulano" );
        
        List<String> listaPersonas = personas.stream()
                .map((pers) ->
                pers.getNombre()).collect(Collectors.toList());
        System.out.println(listaPersonas);
        
        List<Persona> listaPersonas2 = personas2.stream()
                .map(pers -> new Persona(pers))
                .collect(Collectors.toList());
        System.out.println(listaPersonas);
        
        linea(30, "Lista por map 1x1:");
        for(String pers: listaPersonas)
            System.out.println(pers);
        linea(30, "Lista por map - String a Obj.:");
        System.out.println(listaPersonas2.toString());
        
        linea(30, "Números duplicados por map:");
        List<Integer> numerosDuplicados = numeros.stream()
                .map(num -> num*2)
                .collect(Collectors.toList());
        System.out.println(numerosDuplicados);
        
        linea(30, "Mínimo:");
        int resultado = Collections.min(numeros);
        System.out.println(resultado);        
        linea(30, "Máximo:");
        resultado = Collections.max(numeros);
        System.out.println(resultado);
        linea(30, "Suma mapToInt:");
        int suma = numeros.stream()
                .mapToInt(Integer::intValue).sum();
        System.out.println(suma);
        linea(30, "Suma con reduce:");
        suma = numeros.stream().reduce(0, (a, b) -> a+b);
        System.out.println(suma);
        
        linea(30, "Cadena con joining:");
        String cadena = personas2.stream()
                .collect(Collectors.joining(" - "));
        System.out.println(cadena);
        
        
        linea(30, "Números pares con filter:");
        List<Integer> pares = numeros.stream()
                .filter(num -> num%2==0)
                .collect(Collectors.toList());
        System.out.println(pares);
        
        
    }
    
    
    static void linea(int cant, String mensaje)
    {
        System.out.println("");
        for(int i=0; i<cant; i++)
            System.out.print("*");
        System.out.println("");
        System.out.println(mensaje);
    }
}
