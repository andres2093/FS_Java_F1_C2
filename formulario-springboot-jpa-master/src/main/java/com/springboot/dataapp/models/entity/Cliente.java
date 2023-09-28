package com.springboot.dataapp.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/*
* Clase mapeada a una entidad en la base de datos h2.
* Al ser anotada con @Entity. Cada atributo de la clase es tomada como una columna en la tabla
* hay 4 registros pre-armados que se ubican en 'main/resource/import.sql'.
* obligatoriamente, se tiene que llamar asi el archivo
* */
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
    * Mensajes de error predefinidos en 'main/resources/messages.properties'*/
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty
    @Email
    private String email;
    @Column(name = "creado_en")
    @Temporal(TemporalType.DATE)
    private Date creadoEn;
    @DateTimeFormat(pattern = "dd/MM/yyyy")     //Formato de la fecha entrante
    @NotNull(message = "El campo no debe ser nulo")
    @Column(name = "nacimiento")
    @Temporal(TemporalType.DATE)   //Anotacion para indicar que trata de un tipo de dato Fecha
    private Date fecha;

    //Metodo que genera automaticamente la fecha de registro
    @PrePersist
    public void prePersist() {
        creadoEn = new Date();
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Date creadoEn) {
        this.creadoEn = creadoEn;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    private static final long serialVersionUID = 1L;


}
