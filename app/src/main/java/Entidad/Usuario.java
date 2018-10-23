package Entidad;

import java.io.Serializable;

public class Usuario implements Serializable {
    private Integer id;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;

    public Usuario(Integer id, String nombre, String apellido, String direccion, String telefono) {
        this.id = id;
        this.nombres = nombre;
        this.apellidos = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombres;
    }

    public void setNombre(String nombre) {
        this.nombres = nombre;
    }

    public String getApellido() {
        return apellidos;
    }

    public void setApellido(String apellido) {
        this.apellidos = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
