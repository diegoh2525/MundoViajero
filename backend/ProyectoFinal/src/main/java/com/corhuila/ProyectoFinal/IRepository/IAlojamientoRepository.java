package com.corhuila.ProyectoFinal.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corhuila.ProyectoFinal.Entity.Alojamiento;

@Repository
public interface IAlojamientoRepository extends JpaRepository<Alojamiento, Long>{

}
