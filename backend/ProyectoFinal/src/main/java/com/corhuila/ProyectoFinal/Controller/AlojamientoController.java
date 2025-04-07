package com.corhuila.ProyectoFinal.Controller;

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

import com.corhuila.ProyectoFinal.Entity.Alojamiento;
import com.corhuila.ProyectoFinal.IService.IAlojamientoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/ProyectoFinal/Alojamiento")
public class AlojamientoController {
	
	@Autowired
	private IAlojamientoService service;
	
	@GetMapping()
    public List<Alojamiento> all() {
        return service.all();
    }
	 
	 @GetMapping("{id}")
    public Optional<Alojamiento> findById(@PathVariable Long id) {
        return service.findById(id);
    }
	 
	 @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Alojamiento save(@RequestBody Alojamiento alojamiento) {
        return service.save(alojamiento);
    }
	 
	 @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@RequestBody Alojamiento alojamiento, @PathVariable Long id) {
        service.update(alojamiento, id);
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
