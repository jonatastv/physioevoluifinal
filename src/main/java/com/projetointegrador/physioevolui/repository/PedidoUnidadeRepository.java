/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetointegrador.physioevolui.repository;

import com.projetointegrador.physioevolui.model.PedidoUnidade;
import com.projetointegrador.physioevolui.model.Unidade;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * 
 */
@Repository
public interface PedidoUnidadeRepository extends JpaRepository<PedidoUnidade, Long> {

    public List<PedidoUnidade> findByUnidade(Unidade unidade);

    @Modifying
    @Transactional
    @Query("UPDATE tb_pedido_unidade u SET u.status = :status WHERE u.id = :id")
    public int updateStatusWhereId(@Param("status") String status, @Param("id") Long id);
    
    public Page<PedidoUnidade> findByUnidade(Unidade unidade, Pageable pageable);
}
