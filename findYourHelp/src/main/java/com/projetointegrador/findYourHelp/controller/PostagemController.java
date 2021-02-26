package com.projetointegrador.findYourHelp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.projetointegrador.findYourHelp.model.Postagem;
import com.projetointegrador.findYourHelp.repository.PostagemRepository;

import java.util.List;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {

	@Autowired
	private PostagemRepository repository;

	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{idPostagem}")
	public ResponseEntity<Postagem> GetById(@PathVariable long idPostagem) {
		return repository.findById(idPostagem).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());

	}

	@GetMapping("/tituloPostagem/{tituloPostagem}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String tituloPostagem) {
		return ResponseEntity.ok(repository.findAllByTituloPostagemContainingIgnoreCase(tituloPostagem));
	}

	@PostMapping
	public ResponseEntity<Postagem> post(@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}

	@PutMapping
	public ResponseEntity<Postagem> put(@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}

	@DeleteMapping("/{idPostagem}")
	public void delete(@PathVariable long idPostagem) {
		repository.deleteById(idPostagem);

	}

}
