/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetointegrador.physioevolui.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jonatas
 */

@Entity(name = "fisioterapeuta")
public class Fisioterapeuta implements Serializable {
     
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfisioterapeuta")
    private Long idfisioterapeuta;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "rg")
    private String rg;

    @Column(name = "cretito")
    private String cretito;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

   // @OneToOne(mappedBy = "fisioterapeutaEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  //  private UsuarioEntity usuarioEntity;

    public Fisioterapeuta() {
    }

    
    
    public Fisioterapeuta(String nome, String cpf, String rg, String cretito, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.cretito = cretito;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getIdfisioterapeuta() {
        return idfisioterapeuta;
    }

    public void setIdfisioterapeuta(Long idfisioterapeuta) {
        this.idfisioterapeuta = idfisioterapeuta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCretito() {
        return cretito;
    }

    public void setCretito(String cretito) {
        this.cretito = cretito;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.idfisioterapeuta);
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
        final Fisioterapeuta other = (Fisioterapeuta) obj;
        if (!Objects.equals(this.idfisioterapeuta, other.idfisioterapeuta)) {
            return false;
        }
        return true;
    }
    
    

}
