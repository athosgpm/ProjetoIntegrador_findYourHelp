/* Projeto Integrador Find Your Help
 Comentários criados por: Tatiane Tissoni
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

import com.projetointegrador.findYourHelp.model.ComentarioPostagem;
import com.projetointegrador.findYourHelp.repository.ComentarioPostagemRepository;


	@RestController
	@RequestMapping("/comentarios")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public class ComentarioPostagemController {
		
		//Chama o repository e seu metodo
		@Autowired
		private ComentarioPostagemRepository repository;
		
		//Acha todos os comentarios
		@GetMapping
		public ResponseEntity<List<ComentarioPostagem>> GetAll(){
			return ResponseEntity.ok(repository.findAll());
		}
		
		//Acha comentarios pelo atributo idComentario
		@GetMapping("/{id}")
		public ResponseEntity<ComentarioPostagem> GetById(@PathVariable long idComentario){
			return repository.findById(idComentario)
					.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
		}
		
		//insere um comentario
		@PostMapping
		public ResponseEntity<ComentarioPostagem> post(@RequestBody ComentarioPostagem comentario){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(comentario));
		}
		
		//atualiza um comentario
		@PutMapping
		public ResponseEntity<ComentarioPostagem> put(@RequestBody ComentarioPostagem comentario){
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(comentario));
		}
		
		//deleta um comentario
		@DeleteMapping("/{id}")
		public void delete(@PathVariable long id) {
			repository.deleteById(id);
		}	
		
	}