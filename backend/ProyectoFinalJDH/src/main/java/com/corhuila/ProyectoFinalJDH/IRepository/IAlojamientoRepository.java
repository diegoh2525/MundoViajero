package com.corhuila.ProyectoFinalJDH.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corhuila.ProyectoFinalJDH.Entity.Alojamiento;

@Repository
public interface IAlojamientoRepository extends JpaRepository<Alojamiento, Long>{

}
