package com.corhuila.ProyectoFinal.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corhuila.ProyectoFinal.Entity.Transporte;

@Repository
public interface ITransporteRepository extends JpaRepository<Transporte, Long>{

}
