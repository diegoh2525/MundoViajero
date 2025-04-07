package com.corhuila.ProyectoFinal.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.corhuila.ProyectoFinal.DTO.CostosReservaDTO;
import com.corhuila.ProyectoFinal.Entity.Reserva;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Long>{
	
	@Query("SELECT t.costo AS costoTransporte, a.costo AS costoAlojamiento, ac.costo AS costoActividad " +
		   "FROM Reserva r " +
		   "INNER JOIN r.transporte t " +
		   "INNER JOIN r.alojamiento a " +
		   "INNER JOIN r.actividad ac " +
		   "WHERE r.id = :reservaId")
	CostosReservaDTO findCostosByReservaId(@Param("reservaId") Long reservaId);

}
