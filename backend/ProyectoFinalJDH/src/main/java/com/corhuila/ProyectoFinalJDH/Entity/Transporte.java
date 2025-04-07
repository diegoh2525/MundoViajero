package com.corhuila.ProyectoFinalJDH.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
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

}