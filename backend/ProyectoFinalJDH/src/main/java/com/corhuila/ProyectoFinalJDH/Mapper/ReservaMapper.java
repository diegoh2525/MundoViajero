package com.corhuila.ProyectoFinalJDH.Mapper;

import com.corhuila.ProyectoFinalJDH.DTO.ReservaDTO;
import com.corhuila.ProyectoFinalJDH.Entity.Reserva;
import com.corhuila.ProyectoFinalJDH.Entity.Alojamiento;
import com.corhuila.ProyectoFinalJDH.Entity.Actividades;

import java.util.stream.Collectors;

public class ReservaMapper {

    public static ReservaDTO convertirReservaAReservaDTO(Reserva reserva, int costoTotal) {
        ReservaDTO dto = new ReservaDTO();
        dto.setId(reserva.getId());
        dto.setUsuarioNombre(reserva.getUsuario().getNombre());

        dto.setTransportes(
                reserva.getTransportes().stream()
                        .map(t -> t.getTipo() + " - " + t.getEmpresa())
                        .collect(Collectors.toList())
        );

        dto.setAlojamientos(
                reserva.getAlojamientos().stream()
                        .map(Alojamiento::getNombre)
                        .collect(Collectors.toList())
        );

        dto.setActividades(
                reserva.getActividades().stream()
                        .map(Actividades::getNombre)
                        .collect(Collectors.toList())
        );

        dto.setCostoTotal(costoTotal);
        return dto;
    }
}
