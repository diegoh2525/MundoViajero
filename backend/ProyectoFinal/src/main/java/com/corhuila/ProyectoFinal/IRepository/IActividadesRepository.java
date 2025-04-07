package com.corhuila.ProyectoFinal.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corhuila.ProyectoFinal.Entity.Actividades;

@Repository
public interface IActividadesRepository extends JpaRepository<Actividades, Long>{

}
