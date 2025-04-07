package com.corhuila.ProyectoFinalJDH.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.corhuila.ProyectoFinalJDH.Entity.Actividades;
import com.corhuila.ProyectoFinalJDH.IService.IActividadesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/ProyectoFinalJDH/Actividades")
public class ActividadesController {
	
	@Autowired
	private IActividadesService service;
	
	@GetMapping()
    public List<Actividades> all() {
        return service.all();
    }
	 
	 @GetMapping("{id}")
    public Optional<Actividades> findById(@PathVariable Long id) {
        return service.findById(id);
    }
	 
	 @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Actividades save(@RequestBody Actividades actividades) {
        return service.save(actividades);
    }
	 
	 @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@RequestBody Actividades actividades, @PathVariable Long id) {
        service.update(actividades, id);
    }
	 
	 @PutMapping("deleteLogical/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteLogical(@PathVariable Long id) {
        service.deleteLogical(id);
    }
	 
	 @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletePhysical(@PathVariable Long id) {
        service.deletePhysical(id);
    }

}