package com.corhuila.ProyectoFinal.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transporte")
public class Transporte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tipo", length = 20, nullable = false)
	private String tipo;
	
	@Column(name = "empresa", length = 20, nullable = false)
	private String empresa;
	
	@Column(name = "origen", length = 20, nullable = false)
	private String origen;
	
	@Column(name = "destino", length = 20, nullable = false)
	private String destino;
	
	@Column(name = "fecha_inicio", length = 50, nullable = false)
	private String fechaInicio;
	
	@Column(name = "fecha_final", length = 50, nullable = false)
	private String fechaFinal;
	
	@Column(name = "hora_viaje_ida", length = 50, nullable = false)
	private String horaViajeida;
	
	@Column(name = "hora_viaje_vuelta", length = 50, nullable = false)
	private String horaViajevuelta;
	
	@Column(name = "costo", nullable = false)
	private int costo;
	
	@Column(name = "fecha_creacion", nullable = true)
	private LocalDateTime fechaCreacion;
	
	@Column(name = "fecha_modificacion", nullable = true)
	private LocalDateTime fechaModificacion;
	
	@Column(name = "fecha_eliminacion", nullable = true)
	private LocalDateTime fechaEliminacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getHoraViajeida() {
		return horaViajeida;
	}

	public void setHoraViajeida(String horaViajeida) {
		this.horaViajeida = horaViajeida;
	}

	public String getHoraViajevuelta() {
		return horaViajevuelta;
	}

	public void setHoraViajevuelta(String horaViajevuelta) {
		this.horaViajevuelta = horaViajevuelta;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
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
