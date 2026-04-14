package com.mx.Usuarios.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Usuarios.entidad.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Integer>{

}
