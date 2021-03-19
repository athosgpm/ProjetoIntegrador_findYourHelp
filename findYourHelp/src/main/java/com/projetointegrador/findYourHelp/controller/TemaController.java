/* Projeto Integrador Find Your Help
 Comentários criados por: Maria Nazaré Cortez e Andressa Ferreira. 
 */
package com.projetointegrador.findYourHelp.controller;

//Import de Bibliotecas.
import java.util.List;

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

import com.projetointegrador.findYourHelp.model.Tema;
import com.projetointegrador.findYourHelp.repository.TemaRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/tema")
public class TemaController {

	//Acha todos os temas pelo método criado no repository: categoriaTema.
	@Autowired
	private TemaRepository repository;

	//Acha todos os temas.
	@GetMapping
	public ResponseEntity<List<Tema>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	//Acha temas pelo atributo idTema.
	@GetMapping("/{idTema}")
	public ResponseEntity<Tema> getById(@PathVariable long idTema) {
		return repository.findById(idTema).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	//Acha temas por palavras chaves contidas no atributo categoriaTema. 
	@GetMapping("/categoriaTema/{categoriaTema}")
	public ResponseEntity<List<Tema>> getByName(@PathVariable String categoriaTema)

	{
		return ResponseEntity.ok(repository.findAllByCategoriaTemaContainingIgnoreCase(categoriaTema));

	}

	//Insere um tema.
	@PostMapping
	public ResponseEntity<Tema> post(@RequestBody Tema tema) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}

	//Atualiza um tema.
	@PutMapping
	public ResponseEntity<Tema> put(@RequestBody Tema tema) {
		return ResponseEntity.ok(repository.save(tema));
	}

	//Deleta um tema pelo método idTema.
	@DeleteMapping("/{idTema}")
	public void delete(@PathVariable long idTema) {
		repository.deleteById(idTema);
	}
}
