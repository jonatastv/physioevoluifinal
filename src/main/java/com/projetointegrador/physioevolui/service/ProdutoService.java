/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetointegrador.physioevolui.service;

import com.projetointegrador.physioevolui.model.Produto;
import com.projetointegrador.physioevolui.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 *
 */
@Service
public class ProdutoService implements Services<Produto> {

    @Autowired
    ProdutoRepository repository;

    @Override
    public Produto buscarPorId(Long id) {
        return this.repository.findOne(id);
    }

    @Override
    public List<Produto> buscarTodos() {
        Sort sort = new Sort(Sort.Direction.ASC, "nome");
        return this.repository.findAll(sort);
    }

    @Override
    public Produto salvarOuAtualizar(Produto obj) {
        return this.repository.save(obj);
    }

    @Override
    public void deletarPorId(Long id) {
        this.repository.delete(id);
    }

    @Override
    public void deletar(Produto obj) {
        this.repository.delete(obj);
    }

    public long contarRegistros() {
        return this.repository.count();
    }

    public Page<Produto> buscarPaginacao(PageRequest page) {
        return this.repository.findAll(page);
    }

//    public void atualizar(Produto produto) {
//        this.repository.updateProduto(produto.getCategoria(),
//                produto.getCodigo(),
//                produto.getNome(),
//                produto.getDescricao(),
//                produto.getProfissional(),
//                produto.getPublicar(),
//                produto.getPreco(),
//                produto.getPeso(),
//                produto.getCubagem(),
//                produto.getPrecoSDC(),
//                produto.getPrecoCDM(),
//                produto.getPrecoDLOG(),
//                produto.getQtdcaixa(),
//                produto.getId());
//    }

}
