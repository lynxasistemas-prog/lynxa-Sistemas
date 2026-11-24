package com.ebano.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Un trabajo hecho para un cliente (seccion "Proyectos" del Inicio).
 * Ej: cliente "Fenix Gym", rubro "Gimnasio", trabajo "Landing page".
 * La tabla "proyecto" se crea sola al desplegar (ddl-auto=update).
 */
@Entity
@Table(name = "proyecto")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El proyecto necesita el nombre del cliente.")
    @Size(max = 120)
    @Column(nullable = false, length = 120)
    private String cliente;

    @Size(max = 80)
    @Column(length = 80)
    private String rubro;

    /** Que le hicimos: "Landing page", "Sistema de gestion", etc. */
    @Size(max = 80)
    @Column(length = 80)
    private String trabajo;

    @Size(max = 400)
    @Column(length = 400)
    private String descripcion;

    /** Link al trabajo publicado (opcional). */
    @Size(max = 300)
    @Column(length = 300)
    private String url;

    /** Foto o video del trabajo: ruta devuelta por /api/admin/upload (ej. /uploads/xxx.jpg). */
    @Size(max = 300)
    @Column(length = 300)
    private String imagen;

    @Column(nullable = false)
    private Integer orden = 0;

    @Column(nullable = false)
    private boolean visible = true;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public String getRubro() { return rubro; }
    public void setRubro(String rubro) { this.rubro = rubro; }
    public String getTrabajo() { return trabajo; }
    public void setTrabajo(String trabajo) { this.trabajo = trabajo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }
    public Integer getOrden() { return orden; }
    public void setOrden(Integer orden) { this.orden = orden == null ? 0 : orden; }
    public boolean isVisible() { return visible; }
    public void setVisible(boolean visible) { this.visible = visible; }
}
