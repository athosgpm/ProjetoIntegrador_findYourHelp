package com.projetointegrador.findYourHelp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrador.findYourHelp.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema,Long>
{
		public List<Tema> findAllByCategoriaTemaContainingIgnoreCase(String categoriaTema); 
}
