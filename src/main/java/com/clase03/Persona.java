package com.clase03;

class Persona
{
    private String nombre;

    public Persona() { }
    public Persona(String nombre){ this.nombre = nombre; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
}
