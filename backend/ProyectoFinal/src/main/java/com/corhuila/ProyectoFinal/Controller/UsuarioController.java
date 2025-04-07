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

import com.corhuila.ProyectoFinal.Entity.Usuario;
import com.corhuila.ProyectoFinal.IService.IUsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/ProyectoFinal/Usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;
	
	@GetMapping()
    public List<Usuario> all() {
        return service.all();
    }
	 
	 @GetMapping("{id}")
    public Optional<Usuario> findById(@PathVariable Long id) {
        return service.findById(id);
    }
	 
	 @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Usuario save(@RequestBody Usuario usuario) {
        return service.save(usuario);
    }
	 
	 @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@RequestBody Usuario usuario, @PathVariable Long id) {
        service.update(usuario, id);
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
