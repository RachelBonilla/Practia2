

package com.practica1.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "arbol")
public class Arbol implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre_comun")
    private String nombre_comun;

    @Column(name = "tipo_flor")
    private String tipo_flor;

    @Column(name = "dureza_madera")
    private String dureza_madera;

    @Column(name = "altura_promedio")
    private double altura_promedio;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "ruta_imagen")
    private String rutaImagen;

    @Column(name = "activo")
    private boolean activo;

    // Constructor vacío
    public Arbol() {}

    // Constructor con parámetros
    public Arbol(Long id) {
        this.id = id;
    }

    public Arbol(String nombreComun, String tipoFlor, String durezaMadera, double alturaPromedio,
                 String descripcion, String rutaImagen, boolean activo) {
        this.nombre_comun = nombreComun;
        this.tipo_flor = tipoFlor;
        this.dureza_madera = durezaMadera;
        this.altura_promedio = alturaPromedio;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
    }
}
