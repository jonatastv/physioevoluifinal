package com.projetointegrador.physioevolui.model;

public enum FormaPagamento {
     
	BOLETOBANCARIO("Boleto Bancário"), //na tabela tem o número 1 em metodo_pagamento
	CARTAOCREDITO("Cartão de crédito"), //2
	CARTEIRAFINANCEIRA("Carteira Financeira"), //3
	CARTEIRANEGOCIOS("Carteira de Negócios"), //4
	DINHEIRO("Dinheiro"); //5
	
	
	private String descricao;
	
	FormaPagamento(String descricao) {
		this.descricao = descricao;		
	}
		
	public String getDescricao() {
		return descricao;
	}
	
}

