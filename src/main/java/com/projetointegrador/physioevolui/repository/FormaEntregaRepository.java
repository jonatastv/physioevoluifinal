package com.projetointegrador.physioevolui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrador.physioevolui.model.FormaEntrega;

@Repository
public interface FormaEntregaRepository extends JpaRepository<FormaEntrega, Integer>{

}
