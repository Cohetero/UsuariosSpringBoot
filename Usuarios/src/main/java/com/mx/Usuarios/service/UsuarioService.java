package com.mx.Usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mx.Usuarios.dao.UsuarioDao;
import com.mx.Usuarios.dto.Respuesta;
import com.mx.Usuarios.entidad.Usuario;

@Service
public class UsuarioService {
	@Autowired
	UsuarioDao usuarioDao;
	
	public ResponseEntity<List<Usuario>> listar(){
		if(usuarioDao.findAll().isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(usuarioDao.findAll());
	}
	
	public Respuesta guardar(Usuario usuario) {
		Respuesta rs = new Respuesta();
		for(Usuario u : usuarioDao.findAll()) {
			if(usuario.getEmail().equals(u.getEmail())) {
				rs.setMensaje("No se guardo el usuario porque ya existe el email");
				rs.setSuccess(false);
				rs.setObj(u.getEmail());
				return rs;
			}
		}
		
		usuarioDao.save(usuario);
		rs.setMensaje("Se ha guardado con exito el usuario");
		rs.setSuccess(true);
		rs.setObj(usuario);
		
		return rs;
	}
	
	public Respuesta editar(Usuario usuario) {
		Respuesta rs = new Respuesta();
		if(usuarioDao.existsById(usuario.getId())) {
			for(Usuario u: usuarioDao.findAll()) {
				if(usuario.getId() != u.getId() && usuario.getEmail().equals(u.getEmail())) {
					rs.setMensaje("No se puede editar porque el correo ya existe");
					rs.setSuccess(false);
					rs.setObj(u.getEmail());
					return rs;
				}
			}
			
			usuarioDao.save(usuario);
			rs.setMensaje("El usuario se ha editado");
			rs.setSuccess(true);
			rs.setObj(usuario);
			return rs;
		}
		
		rs.setMensaje("El usuario que trata de editar no existe");
		rs.setSuccess(false);
		rs.setObj(usuario.getId());
		return rs;
	}
	
	public Respuesta eliminar(int id) {
		Respuesta rs = new Respuesta();
		Usuario usuario = usuarioDao.findById(id).orElse(null);
		if(usuario == null) {
			rs.setMensaje("El usuario que trata de eliminar no existe");
			rs.setSuccess(false);
			rs.setObj(id);
			return rs;
		}
		
		rs.setObj(usuario);
		usuarioDao.delete(usuario);
		rs.setMensaje("El usuario ha sido eliminado");
		rs.setSuccess(true);
		return rs;
	}
	
	public ResponseEntity<Usuario> buscar(int id){
		Usuario usuario = usuarioDao.findById(id).orElse(null);
		if(usuario == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(usuario);
	}
}
