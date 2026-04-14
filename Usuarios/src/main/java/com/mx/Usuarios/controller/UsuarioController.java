package com.mx.Usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Usuarios.dto.Respuesta;
import com.mx.Usuarios.entidad.Usuario;
import com.mx.Usuarios.service.UsuarioService;

@RestController
@RequestMapping("usuario")
@CrossOrigin
public class UsuarioController {
	@Autowired
	UsuarioService service;
	
	@GetMapping("listar")
	public ResponseEntity<List<Usuario>> listar(){
		return service.listar();
	}
	
	@PostMapping("guardar")
	public Respuesta guardar(@RequestBody Usuario usuario) {
		return service.guardar(usuario);
	}
	
	@PutMapping("editar/{id}")
	public Respuesta editar(@PathVariable("id")int id, @RequestBody Usuario usuario) {
		usuario.setId(id);
		return service.editar(usuario);
	}
	
	@DeleteMapping("eliminar/{id}")
	public Respuesta eliminar(@PathVariable("id") int id) {
		return service.eliminar(id);
	}
	
	@GetMapping("buscar/{id}")
	public ResponseEntity<Usuario> buscar(@PathVariable("id") int id){
		return service.buscar(id);
	}
}
