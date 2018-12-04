/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetointegrador.physioevolui.repository;

import com.projetointegrador.physioevolui.model.EstoqueUnidade;
import com.projetointegrador.physioevolui.model.Produto;
import com.projetointegrador.physioevolui.model.Unidade;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 *
 */
@Repository
public interface EstoqueUnidadeRepository extends JpaRepository<EstoqueUnidade, Long> {

    public List<EstoqueUnidade> findByUnidade(Unidade unidade);

    public EstoqueUnidade findByProdutoAndUnidade(Produto produto, Unidade unidade);
}
