
package com.evolution.libreria.model;

import jakarta.persistence.*;

@Entity @Table(name="libro")
public class libro{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="titulo", nullable=false, length=200)
    private String titulo;

    @Column(name="autor", nullable=false)
    private Integer autorId;

    @Column(name="categoria", nullable=false, length=100)
    private String categoria;

    @Column(name= "cantidad_disponible", nullable=false)
    private Integer cantidadDisponible;

    // --- getters y setters ---
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Integer getAutorId() { return autorId; }
    public void setAutorId(Integer autorId) { this.autorId = autorId; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Integer getCantidadDisponible() { return cantidadDisponible; }
    public void setCantidadDisponible(Integer cantidadDisponible) { this.cantidadDisponible = cantidadDisponible; }
}
