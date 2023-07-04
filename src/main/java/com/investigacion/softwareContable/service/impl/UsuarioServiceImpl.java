package com.investigacion.softwareContable.service.impl;

import com.investigacion.softwareContable.persistence.entity.Usuario;
import com.investigacion.softwareContable.persistence.entity.UsuarioRol;
import com.investigacion.softwareContable.persistence.repository.RolRepository;
import com.investigacion.softwareContable.persistence.repository.UsuarioRepository;
import com.investigacion.softwareContable.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RolRepository rolRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioLocal !=null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta creado");
        }else {
            for(UsuarioRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);

    }
}
