package com.example.listainmuebles;

public class Inmueble {
    private int foto;
    private String direccion;
    private String precio;

    public Inmueble(int foto, String direccion, String precio) {
        this.foto = foto;
        this.direccion = direccion;
        this.precio = precio;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
