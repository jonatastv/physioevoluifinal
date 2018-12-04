/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetointegrador.physioevolui.service;

import com.projetointegrador.physioevolui.model.Unidade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetointegrador.physioevolui.repository.UnidadeRepository;

/**
 *
 *
 */
@Service
public class UnidadeService implements Services<Unidade> {

    @Autowired
    UnidadeRepository repository;

    @Override
    public Unidade buscarPorId(Long id) {
        return this.repository.findOne(id);
    }

    @Override
    public List<Unidade> buscarTodos() {
        return this.repository.findAll();
    }

    @Override
    public Unidade salvarOuAtualizar(Unidade obj) {
        return this.repository.save(obj);
    }

    @Override
    public void deletarPorId(Long id) {
        this.repository.delete(id);
    }

    @Override
    public void deletar(Unidade obj) {
        this.repository.delete(obj);
    }

    List<Unidade> buscarAtendePedidoEspecial(Boolean pedidoEspecial) {
        return this.repository.findByPedidoEspecial(pedidoEspecial);
    }

    public List<Unidade> buscarAtendimentoEspecial() {
        return this.repository.findByPedidoEspecial(true);
    }

}
