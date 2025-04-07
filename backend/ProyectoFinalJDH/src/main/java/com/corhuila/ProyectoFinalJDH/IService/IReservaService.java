package com.corhuila.ProyectoFinalJDH.IService;

import java.util.List;
import java.util.Optional;

import com.corhuila.ProyectoFinalJDH.DTO.ReservaDTO;
import com.corhuila.ProyectoFinalJDH.Entity.Reserva;

public interface IReservaService {
	
	//Obtener todo
	public List<Reserva> all();
		
	//Obtener por ID
	public Optional<Reserva> findById(Long id);
	 	
	//Crear
	public Reserva save(Reserva reserva);
		
	//Modificar
	public void update(Reserva reserva, Long id);
		
	//Eliminar Físico
	public void deletePhysical(Long id);
			
	// Eliminar lógico
	public void deleteLogical(Long id);

	ReservaDTO obtenerReservaDTO(Long id);
}
