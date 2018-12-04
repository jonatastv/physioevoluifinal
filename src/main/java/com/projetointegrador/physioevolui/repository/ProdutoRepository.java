/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetointegrador.physioevolui.repository;

import com.projetointegrador.physioevolui.model.Produto;
import javax.transaction.Transactional;
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
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

//    @Transactional
//    @Modifying
//    @Query("UPDATE produto p SET p.codigo = :codigo "
//            + "AND p.categoria = :categoria "
//            + "AND p.nome = :nome "
//            + "AND P.descricao = :descricao "
//            + "AND p.profissional = :profissional "
//            + "AND p.publicar = :publicar "
//            + "AND p.preco = :preco "
//            + "AND p.peso = :peso"
//            + "AND  p.cubagem = :cubagem "
//            + "AND p.precoSDC = :precoSDC "
//            + "AND p.precoCDM = :precoCDM "
//            + "AND p.precoDLOG = :precoDLOG "
//            + "AND p.qtdcaixa = :qtdcaixa "
//            + "WHERE p = :id")
//    public void updateProduto(@Param("categoria") Long categoria,
//            @Param("codigo") String codigo,
//            @Param("nome") String nome,
//            @Param("descricao") String descricao,
//            @Param("profissional") Boolean profissional,
//            @Param("publicar") Boolean publicar,
//            @Param("preco") Double preco,
//            @Param("peso") Double peso,
//            @Param("cubagem") Double cubagem,
//            @Param("precoSDC") Double precoSDC,
//            @Param("precoCDM") Double precoCDM,
//            @Param("precoDLOG") Double precoDLOG,
//            @Param("qtdcaixa") Integer qtdcaixa,
//            @Param("id") Long id);
}
