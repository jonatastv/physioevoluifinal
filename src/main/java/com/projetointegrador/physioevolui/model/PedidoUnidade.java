/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetointegrador.physioevolui.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * 
 */
@Entity(name = "tb_pedido_unidade")
public class PedidoUnidade implements Serializable {

//  idpedido serial NOT NULL,
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idpedido", columnDefinition = "serial")
    Long id;

//      idusuario integer NOT NULL,
    @NotNull
    @ManyToOne
    @JoinColumn(columnDefinition = "integer", name = "idusuario")
    Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idunidade", columnDefinition = "integer")
    Unidade unidade;

    @OneToMany
    List<ProdutoUnidade> produtos;

//  dataPedido Date,    
    @Column(name = "data_pedido")
    @Temporal(javax.persistence.TemporalType.DATE)
    Calendar dataPedido;

    // dt_baixa_entrega timestamp without time zone,
    @Column(name = "dt_baixa_entrega")
    @Temporal(javax.persistence.TemporalType.DATE)
    Calendar dataBaixa;

//    situacao character varying(1) NOT NULL,
//    @Enumerated(EnumType.STRING)
//    @Column(columnDefinition = "character varying(1)")
    String status;

//  valor_total numeric(10,2) NOT NULL,
    @NotNull
    @Column(name = "valor_total", columnDefinition = "numeric(10,2)")
    Double valorTotal;

//    @NotNull
    @Column(name = "valor_frete", columnDefinition = "numeric(10,2)")
    Double valorFrete;

//    @NotNull
    @ManyToOne
    @JoinColumn(columnDefinition = "integer", name = "idformaentrega")
    FormaEntrega formaEntrega;
    
    @ManyToOne
    @JoinColumn(columnDefinition = "integer", name = "idtransportadora")
    Transportadora transportadora;
    
    @Column(name = "nome_entrega")
    String nomeEntrega;
    
    @Column(name = "rg_entrega")
    String rgEntrega;
    
    @Column(name = "ordem_coleta_entrega")
    String ordemColetaEntrega;

//    codigo_rastreio character varying(50),
    @Column(name = "codigo_rastreio", columnDefinition = "character varying(50)")
    String codigoRastreio;

//  endereco_alt text,  
    @Column(name = "endereco_alt", columnDefinition = "text")
    String endereco;

    public PedidoUnidade() {
        this.produtos = new ArrayList<>();
        this.valorTotal = 0D;
    }

    public List<ProdutoUnidade> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoUnidade> produtos) {
        this.produtos = produtos;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Calendar getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Calendar dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Calendar getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(Calendar dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public FormaEntrega getFormaEntrega() {
        return formaEntrega;
    }

    public void setFormaEntrega(FormaEntrega formaEntrega) {
        this.formaEntrega = formaEntrega;
    }

    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public void setCodigoRastreio(String codigoRastreio) {
        this.codigoRastreio = codigoRastreio;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PedidoUnidade other = (PedidoUnidade) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public void atualizarValor() {
        this.valorTotal = 0D;
        for (ProdutoUnidade p : this.produtos) {
            this.valorTotal += p.getPrecoTotal();
        }
    }

    public Transportadora getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(Transportadora transportadora) {
        this.transportadora = transportadora;
    }

    public String getNomeEntrega() {
        return nomeEntrega;
    }

    public void setNomeEntrega(String nomeEntrega) {
        this.nomeEntrega = nomeEntrega;
    }

    public String getRgEntrega() {
        return rgEntrega;
    }

    public void setRgEntrega(String rgEntrega) {
        this.rgEntrega = rgEntrega;
    }

    public String getOrdemColetaEntrega() {
        return ordemColetaEntrega;
    }

    public void setOrdemColetaEntrega(String ordemColetaEntrega) {
        this.ordemColetaEntrega = ordemColetaEntrega;
    }

    
}
