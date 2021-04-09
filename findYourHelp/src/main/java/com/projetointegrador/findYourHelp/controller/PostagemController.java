/* Projeto Integrador Find Your Help
 Comentários criados por: Maria Nazaré Cortez e Andressa Ferreira. 
 */
package com.projetointegrador.findYourHelp.controller;

//Import de Bibliotecas.
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

//Anotações.
@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {

	//Acha todas as postagens pelo metodo criado no repository: tituloPostagem.
	@Autowired
	private PostagemRepository repository;
    
	//Acha todas as postagens. 
	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	//Acha postagens pelo atributo idPostagem.
	@GetMapping("/{idPostagem}")
	public ResponseEntity<Postagem> GetById(@PathVariable long idPostagem) {
		return repository.findById(idPostagem).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());

	}

	//Acha postagens por palavras chaves contidas no atributo tituloPostagem. 
	@GetMapping("/tituloPostagem/{tituloPostagem}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String tituloPostagem) {
		return ResponseEntity.ok(repository.findAllByTituloPostagemContainingIgnoreCase(tituloPostagem));
	}
	
	@GetMapping("/tipo/postagem/portipo/{tipoAjudaPostagem}")
	public ResponseEntity<List<Postagem>> GetByTipo(@PathVariable String tipoAjudaPostagem) {
		return ResponseEntity.ok(repository.getPostagensByTipo(tipoAjudaPostagem));
	}

	//Insere uma postagem.
	@PostMapping
	public ResponseEntity<Postagem> post(@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}

	//Atualiza uma postagem.
	@PutMapping
	public ResponseEntity<Postagem> put(@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}

	//Deleta uma postagem através do atributo idPostagem.
	@DeleteMapping("/{idPostagem}")
	public void delete(@PathVariable long idPostagem) {
		repository.deleteById(idPostagem);

	}

}
