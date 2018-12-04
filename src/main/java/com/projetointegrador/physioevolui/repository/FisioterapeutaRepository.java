/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetointegrador.physioevolui.repository;

import com.projetointegrador.physioevolui.model.Fisioterapeuta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * 
 */
@Repository
public interface FisioterapeutaRepository extends JpaRepository<Fisioterapeuta, Long> {

    public List<Fisioterapeuta> findByNome(String nome);
}
