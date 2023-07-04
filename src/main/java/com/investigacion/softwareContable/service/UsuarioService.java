package com.investigacion.softwareContable.service;

import com.investigacion.softwareContable.persistence.entity.Usuario;
import com.investigacion.softwareContable.persistence.entity.UsuarioRol;

import java.util.Set;

public interface UsuarioService {
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;
    public Usuario obtenerUsuario(String username);
    public void eliminarUsuario(Long usuarioId);
}
