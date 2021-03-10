package com.projetointegrador.findYourHelp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrador.findYourHelp.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem,Long>
{
		public List<Postagem> findAllByTituloPostagemContainingIgnoreCase(String tituloPostagem); 
}
