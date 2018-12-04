package com.projetointegrador.physioevolui.service;


import com.projetointegrador.physioevolui.model.Paciente;
import com.projetointegrador.physioevolui.repository.PacienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Jonatas
 */

@Service
public class PacienteService implements Services<Paciente> {

    @Autowired
    PacienteRepository repository;

    @Override
    public Paciente buscarPorId(Long id) {
        return this.repository.findOne(id);
    }

    @Override
    public List<Paciente> buscarTodos() {
        return this.repository.findAll();
    }

    @Override
    public Paciente salvarOuAtualizar(Paciente obj) {
        return this.repository.save(obj);
    }

    @Override
    public void deletarPorId(Long id) {
        this.repository.delete(id);
    }

    @Override
    public void deletar(Paciente obj) {
        this.repository.delete(obj);
    }
}