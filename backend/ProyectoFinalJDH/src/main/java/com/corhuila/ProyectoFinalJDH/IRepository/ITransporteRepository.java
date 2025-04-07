package com.corhuila.ProyectoFinalJDH.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corhuila.ProyectoFinalJDH.Entity.Transporte;

@Repository
public interface ITransporteRepository extends JpaRepository<Transporte, Long>{

}
