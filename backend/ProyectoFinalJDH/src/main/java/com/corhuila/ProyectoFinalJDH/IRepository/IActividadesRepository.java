package com.corhuila.ProyectoFinalJDH.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corhuila.ProyectoFinalJDH.Entity.Actividades;

@Repository
public interface IActividadesRepository extends JpaRepository<Actividades, Long>{

}