package org.bedu.java.backend.s7.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class Usuario {
    @NotBlank(message = " Nombre es obligatorio")
    private String nombre;
    @NotBlank(message = " Correo es obligatorio")
    @Email(message = " Escribe un correo valido")
    private String correo;
    @NotBlank(message = " Usuario es obligatorio")
    @Length(min = 8, max = 20, message = " Usuario debe tener entre 8 y 20 caracteres")
    private String usuario;
    @NotBlank(message = " Contraseña es obligatorio")
    private String contrasenia;
    @NotBlank(message = " Teléfono es obligatorio")
    @Pattern(regexp = "^(\\d{2,4}[- .]?){2}\\d{4}$", message = " El teléfono debe tener formato ##-####-####")
    private String telefono;
    @NotBlank(message = " Rol es obligatorio")
    private String rol;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
