/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetointegrador.physioevolui.repository;

import com.projetointegrador.physioevolui.model.RegistroPerda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * 
 */
@Repository
public interface RegistroPerdaRepository extends JpaRepository<RegistroPerda, Long> {

}
