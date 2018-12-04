/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetointegrador.physioevolui.service;

import com.projetointegrador.physioevolui.model.Usuario;
import com.projetointegrador.physioevolui.repository.UsuarioRepository;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * 
 */
@Service
public class UsuarioService implements Services<Usuario> {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    UsuarioRepository repository;

    @Override
    public Usuario buscarPorId(Long id) {
        return this.repository.findOne(id);
    }

    @Override
    public List<Usuario> buscarTodos() {
        return this.repository.findAll();
    }

    @Override
    public Usuario salvarOuAtualizar(Usuario obj) {
        obj.setSenha(this.encoder.encode(obj.getSenha()));
        return this.repository.save(obj);
    }

    @Override
    public void deletarPorId(Long id) {
        this.repository.delete(id);
    }

    @Override
    public void deletar(Usuario obj) {
        this.repository.delete(obj);
    }

    public String encodePassword(String senha) {
        return this.encoder.encode(senha);
    }

    public Usuario pesquisarCredenciais(String login, String senha) {
        List<Usuario> usr = this.repository.findByLogin(login);
        for (Usuario u : usr) {
            if (this.encoder.matches(senha, u.getSenha())) {
                return u;
            }
        }
        System.out.println("Nada encontrado");
        return null;
    }
}
