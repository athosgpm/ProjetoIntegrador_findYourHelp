/* Projeto Integrador Find Your Help
 Comentários criados por: Gustavo de Souza Guilhen e Tatiane Tissoni Antunes. 
 */

package com.projetointegrador.findYourHelp.repository;

// Import de Bibliotecas
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrador.findYourHelp.model.Postagem;

// Criação de Repositorio Postagem
@Repository
public interface PostagemRepository extends JpaRepository<Postagem,Long>
{
	// Criação de metodo de procura pelo Atributo Titulo Postagem usado no controller
		public List<Postagem> findAllByTituloPostagemContainingIgnoreCase(String tituloPostagem); 
}
