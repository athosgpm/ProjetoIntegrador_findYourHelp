/* Projeto Integrador Find Your Help
 Comentários criados por: Gustavo de Souza Guilhen e Tatiane Tissoni Antunes. 
 */

package com.projetointegrador.findYourHelp.repository;

// Import de Bibliotecas
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrador.findYourHelp.model.Usuario;

// Criação de Repositorio Usuario
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> 
{
	// Criação de metodo de procura pelo Atributo EmailUsuario usado no controller
	public Optional<Usuario> findByEmailUsuario(String emailUsuario);
}