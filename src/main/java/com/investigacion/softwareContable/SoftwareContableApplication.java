package com.investigacion.softwareContable;

import com.investigacion.softwareContable.persistence.entity.Rol;
import com.investigacion.softwareContable.persistence.entity.Usuario;
import com.investigacion.softwareContable.persistence.entity.UsuarioRol;
import com.investigacion.softwareContable.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SoftwareContableApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(SoftwareContableApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Usuario usuario = new Usuario();

		usuario.setNombre("Carlos");
		usuario.setApellido("Pedraza");
		usuario.setUsername("carlosP");
		usuario.setPassword("123456");
		usuario.setEmail("carlos1@gmail.com");
		usuario.setTelefono("3259857421");

		Rol rol = new Rol();
		rol.setRolId(1L);
		rol.setNombre("ADMIN");

		Set<UsuarioRol> usuarioRoles = new HashSet<>();
		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setRol(rol);
		usuarioRol.setUsuario(usuario);
		usuarioRoles.add(usuarioRol);

		Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario, usuarioRoles);
		System.out.println(usuarioGuardado.getUsername());*/
	}
}
