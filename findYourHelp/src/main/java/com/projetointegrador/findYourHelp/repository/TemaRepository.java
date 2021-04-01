/* Projeto Integrador Find Your Help
 Comentários criados por: Gustavo de Souza Guilhen e Tatiane Tissoni Antunes. 
 */

package com.projetointegrador.findYourHelp.repository;

// Import de Bibliotecas
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrador.findYourHelp.model.Tema;

// Criação de Repositorio Tema
@Repository
public interface TemaRepository extends JpaRepository<Tema,Long>
{
	// Criação de metodo de procura pelo Atributo Categoria Tema usado no controller
		public List<Tema> findAllByCategoriaTemaContainingIgnoreCase(String categoriaTema);
}
