/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetointegrador.physioevolui.service;

import com.projetointegrador.physioevolui.model.Fisioterapeuta;
import com.projetointegrador.physioevolui.repository.FisioterapeutaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * 
 */
@Service
public class FisioterapeutaService implements Services<Fisioterapeuta> {

    @Autowired
    FisioterapeutaRepository repository;

    @Override
    public Fisioterapeuta buscarPorId(Long id) {
        return this.repository.findOne(id);
    }

    @Override
    public List<Fisioterapeuta> buscarTodos() {
        return this.repository.findAll();
    }

    @Override
    public Fisioterapeuta salvarOuAtualizar(Fisioterapeuta obj) {
        return this.repository.save(obj);
    }

    @Override
    public void deletarPorId(Long id) {
        this.repository.delete(id);
    }

    @Override
    public void deletar(Fisioterapeuta obj) {
        this.repository.delete(obj);
    }
    
        List<Fisioterapeuta> buscarNome(String nome) {
        return this.repository.findByNome(nome);
    }



}
