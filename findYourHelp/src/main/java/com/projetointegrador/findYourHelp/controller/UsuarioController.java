/* Projeto Integrador Find Your Help
 Comentários criados por: Maria Nazaré Cortez Lima e Andressa Ferreira. 
 */

package com.projetointegrador.findYourHelp.controller;

import java.util.List;
//Import de bibliotecas.
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetointegrador.findYourHelp.model.UserLogin;
import com.projetointegrador.findYourHelp.model.Usuario;
import com.projetointegrador.findYourHelp.repository.UsuarioRepository;
import com.projetointegrador.findYourHelp.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
    private UsuarioRepository repository;
	
	//Acha todas as postagens pelo metodo criado no Repository: usuarioRepository.
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }
	
	//Insere um tema, nesse caso para logar.
	@PostMapping("/logar")
	public ResponseEntity<UserLogin> Autentication(@RequestBody Optional<UserLogin> user) {
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	//Insere um tema, nesse caso para logar.
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario) {
		Optional<Usuario> user = usuarioService.CadastrarUsuario(usuario);
		try {
			return ResponseEntity.ok(user.get());
		} catch (Exception e) {
			return null;
		}

	}
	
	@PutMapping
    public ResponseEntity<Usuario> put(@RequestBody Usuario usuario) {
        Optional<Usuario> user = usuarioService.atualizaUsuario(usuario);
        try {
            return ResponseEntity.ok(user.get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
	
}
