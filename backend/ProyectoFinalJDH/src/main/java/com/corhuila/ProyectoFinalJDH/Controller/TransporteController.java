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

import com.corhuila.ProyectoFinalJDH.Entity.Transporte;
import com.corhuila.ProyectoFinalJDH.IService.ITransporteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/ProyectoFinalJDH/Transporte")
public class TransporteController {
	
	@Autowired
	private ITransporteService service;
	
	@GetMapping()
    public List<Transporte> all() {
        return service.all();
    }
	 
	 @GetMapping("{id}")
    public Optional<Transporte> findById(@PathVariable Long id) {
        return service.findById(id);
    }
	 
	 @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Transporte save(@RequestBody Transporte transporte) {
        return service.save(transporte);
    }
	 
	 @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@RequestBody Transporte transporte, @PathVariable Long id) {
        service.update(transporte, id);
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