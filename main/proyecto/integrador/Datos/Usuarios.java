/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Luis Hernández
 */
package main.proyecto.integrador.Datos;

public class Usuarios {
    private int id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String email;
    private String login;
    private String contrasena;
    private String direccion;

    public Usuarios(String cedula, String nombre, String apellido, String email, String login, String contrasena, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.login = login;
        this.contrasena = contrasena;
        this.direccion = direccion;
    }

    public Usuarios(String cedula, String nombre, String apellido, String email, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.direccion = direccion;
    }

    public Usuarios(int id, String cedula, String nombre, String apellido, String email, String direccion) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.direccion = direccion;
    }

    public Usuarios() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido +  ", email=" + email + ", direccion=" + direccion + '}';
    }
    
}