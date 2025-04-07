package com.corhuila.ProyectoFinalJDH.Entity;


import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "reserva")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

	@ManyToMany
	@JoinTable(
			name = "reserva_transporte",
			joinColumns = @JoinColumn(name = "reserva_id"),
			inverseJoinColumns = @JoinColumn(name = "transporte_id")
	)
	private List<Transporte> transportes;

	@ManyToMany
	@JoinTable(
			name = "reserva_alojamiento",
			joinColumns = @JoinColumn(name = "reserva_id"),
			inverseJoinColumns = @JoinColumn(name = "alojamiento_id")
	)
	private List<Alojamiento> alojamientos;

	@ManyToMany
	@JoinTable(
			name = "reserva_actividades",
			joinColumns = @JoinColumn(name = "reserva_id"),
			inverseJoinColumns = @JoinColumn(name = "actividades_id")
	)
	private List<Actividades> actividades;

	@Column(name = "estado")
	private Boolean estado;

	@Column(name = "fecha_creacion")
	private LocalDateTime fechaCreacion;

	@Column(name = "fecha_modificacion")
	private LocalDateTime fechaModificacion;

	@Column(name = "fecha_eliminacion")
	private LocalDateTime fechaEliminacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Transporte> getTransportes() {
		return transportes;
	}

	public void setTransportes(List<Transporte> transportes) {
		this.transportes = transportes;
	}

	public List<Alojamiento> getAlojamientos() {
		return alojamientos;
	}

	public void setAlojamientos(List<Alojamiento> alojamientos) {
		this.alojamientos = alojamientos;
	}

	public List<Actividades> getActividades() {
		return actividades;
	}

	public void setActividades(List<Actividades> actividades) {
		this.actividades = actividades;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public LocalDateTime getFechaEliminacion() {
		return fechaEliminacion;
	}

	public void setFechaEliminacion(LocalDateTime fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}
}
