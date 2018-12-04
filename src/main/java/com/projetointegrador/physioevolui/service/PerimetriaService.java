/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetointegrador.physioevolui.service;

import com.projetointegrador.physioevolui.model.Perimetria;
import com.projetointegrador.physioevolui.repository.PerimetriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Jonatas
 */

@Service
public class PerimetriaService implements Services<Perimetria> {

    @Autowired
    PerimetriaRepository repository;

    @Override
    public Perimetria buscarPorId(Long id) {
        return this.repository.findOne(id);
    }

    @Override
    public List<Perimetria> buscarTodos() {
        return this.repository.findAll();
    }

    @Override
    public Perimetria salvarOuAtualizar(Perimetria obj) {
        return this.repository.save(obj);
    }

    @Override
    public void deletarPorId(Long id) {
        this.repository.delete(id);
    }

    @Override
    public void deletar(Perimetria obj) {
        this.repository.delete(obj);
    }
}