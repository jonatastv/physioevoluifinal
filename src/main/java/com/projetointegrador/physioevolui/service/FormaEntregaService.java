package com.projetointegrador.physioevolui.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetointegrador.physioevolui.model.FormaEntrega;
import com.projetointegrador.physioevolui.repository.FormaEntregaRepository;

@Service
public class FormaEntregaService implements Services<FormaEntrega>{
	
	@Autowired
	FormaEntregaRepository repository;

	@Override
	public FormaEntrega buscarPorId(Long id) {
		return repository.findOne(id.intValue());
	}

	@Override
	public List<FormaEntrega> buscarTodos() {
		return repository.findAll();
	}

	@Override
	public FormaEntrega salvarOuAtualizar(FormaEntrega obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletarPorId(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(FormaEntrega obj) {
		// TODO Auto-generated method stub
		
	}

}
