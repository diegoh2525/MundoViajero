package com.corhuila.ProyectoFinal.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.ProyectoFinal.Entity.Reserva;
import com.corhuila.ProyectoFinal.IRepository.IReservaRepository;
import com.corhuila.ProyectoFinal.IService.IReservaService;

@Service
public class ReservaService implements IReservaService {

	@Autowired
	private IReservaRepository repository;
	
	@Override
	public List<Reserva> all() {
		return repository.findAll();
	}

	@Override
	public Optional<Reserva> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Reserva save(Reserva reserva) {
		reserva.setFechaCreacion(LocalDateTime.now());
		return repository.save(reserva);
	}

	@Override
	public void update(Reserva reserva, Long id) {
		//validar si existe.            
        Optional<Reserva> op = repository.findById(id);		
        
        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else {
        	 //Crear nuevo objeto que va a contener los datos que se van actualizar
            Reserva reservaUpdate = op.get();
            reservaUpdate.setUsuarioId(reserva.getUsuarioId());
            reservaUpdate.setTransporteId(reserva.getTransporteId());
            reservaUpdate.setAlojamientoId(reserva.getAlojamientoId());
            reservaUpdate.setActividadesId(reserva.getActividadesId());
            reservaUpdate.setEstado(reserva.getEstado());
            reservaUpdate.setFechaModificacion(LocalDateTime.now());
            
            //Actualizar el objeto
            repository.save(reservaUpdate);
        }
        
        
	}

	@Override
	public void deletePhysical(Long id) {
		repository.deleteById(id);	
	}

	@Override
	public void deleteLogical(Long id) {
		//validar si existe.            
        Optional<Reserva> op = repository.findById(id);		
        
        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else {
        	 //Crear nuevo objeto que va a contener los datos que se van actualizar
            Reserva reservaUpdate = op.get();
            reservaUpdate.setFechaEliminacion(LocalDateTime.now());
            
            //Actualizar el objeto
            repository.save(reservaUpdate);
        }		
	}	
}
