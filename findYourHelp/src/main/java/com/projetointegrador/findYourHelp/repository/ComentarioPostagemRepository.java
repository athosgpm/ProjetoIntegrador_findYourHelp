/* Projeto Integrador Find Your Help
 Comentários criados por: Tatiane Tissoni Antunes. 
 */

package com.projetointegrador.findYourHelp.repository;

//Import de Bibliotecas
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrador.findYourHelp.model.ComentarioPostagem;

//Criação de Repositorio Comentario
@Repository
public interface ComentarioPostagemRepository extends JpaRepository<ComentarioPostagem, Long> 
{	
	// Criação de metodo de procura pelo Atributo comentario usado no controller
	public List<ComentarioPostagem> findAllByComentarioContainingIgnoreCase (String comentario); 
}
