/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetointegrador.physioevolui.service;

import com.projetointegrador.physioevolui.model.FaixaAtendimento;
import com.projetointegrador.physioevolui.model.Unidade;
import com.projetointegrador.physioevolui.repository.FaixaAtendimentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 *
 */
@Service
public class FaixaAtendimentoService implements Services<FaixaAtendimento> {

    @Autowired
    FaixaAtendimentoRepository repository;

    @Override
    public FaixaAtendimento buscarPorId(Long id) {
        return this.repository.findOne(id);
    }

    @Override
    public List<FaixaAtendimento> buscarTodos() {
        return this.repository.findAll();
    }

    @Override
    public FaixaAtendimento salvarOuAtualizar(FaixaAtendimento obj) {
        return this.repository.save(obj);
    }

    @Override
    public void deletarPorId(Long id) {
        this.repository.delete(id);
    }

    @Override
    public void deletar(FaixaAtendimento obj) {
        this.repository.delete(obj);
    }

    public List<FaixaAtendimento> filtarCep(String cep) {
//        Integer num = Integer.parseInt(cep);
//        System.out.println("CEP " + num + " - " + cep);
        return this.repository.findByCepFinalGreaterThanEqualAndCepInicialLessThanEqual(cep, cep);
    }

    public long contarRegistros() {
        return this.repository.count();
    }

    public Page<FaixaAtendimento> buscarPaginacao(Pageable p) {
        return this.repository.findAll(p);
    }

}
