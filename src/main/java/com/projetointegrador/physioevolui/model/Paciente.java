/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetointegrador.physioevolui.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Jonatas
 */
@Entity(name = "paciente")
public class Paciente implements Serializable {
    
//    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "idpaciente")
    private Long idpaciente;
 
    @Column(name = "str_nome_paciente")
    private String str_nome_paciente; 
     
    @Column(name = "date_data_nascimento_paciente")
    private String data_nascimento_paciente; 
    
    @Column(name = "str_cpf_paciente")
    private String str_cpf_paciente; 
    
    @Column(name = "str_rg_paciente")
    private String str_rg_paciente; 
    
    @Column(name = "int_sexo_paciente")
    private Long int_sexo_paciente; 
    
    @Column(name = "int_estado_civil_paciente")
    private Long int_estado_civil_paciente; 
    
    @Column(name = "str_email_paciente")
    private String str_email_paciente;
    
    @Column(name = "str_telefone_paciente")
    private String str_telefone_paciente; 
    
    @Column(name = "str_convenio_paciente")
    private String str_convenio_paciente; 
    
    @Column(name = "str_profissao_paciente")
    private String str_profissao_paciente; 
    
    @Column(name = "str_endereco_paciente")
    private String str_endereco_paciente; 
    
    @Column(name = "int_cep_paciente")
    private Long int_cep_paciente; 
      
    @Column(name = "str_bairro_paciente")
    private String str_bairro_paciente; 

    
    public Paciente() {
    }
    
    

    public Paciente(String str_nome_paciente, String data_nascimento_paciente, String str_cpf_paciente, String str_rg_paciente, Long int_sexo_paciente, Long int_estado_civil_paciente, String str_email_paciente, String str_telefone_paciente, String str_convenio_paciente, String str_profissao_paciente, String str_endereco_paciente, Long int_cep_paciente, String str_bairro_paciente) {
        this.str_nome_paciente = str_nome_paciente;
        this.data_nascimento_paciente = data_nascimento_paciente;
        this.str_cpf_paciente = str_cpf_paciente;
        this.str_rg_paciente = str_rg_paciente;
        this.int_sexo_paciente = int_sexo_paciente;
        this.int_estado_civil_paciente = int_estado_civil_paciente;
        this.str_email_paciente = str_email_paciente;
        this.str_telefone_paciente = str_telefone_paciente;
        this.str_convenio_paciente = str_convenio_paciente;
        this.str_profissao_paciente = str_profissao_paciente;
        this.str_endereco_paciente = str_endereco_paciente;
        this.int_cep_paciente = int_cep_paciente;
        this.str_bairro_paciente = str_bairro_paciente;
    }

    public Long getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Long idpaciente) {
        this.idpaciente = idpaciente;
    }

    public String getStr_nome_paciente() {
        return str_nome_paciente;
    }

    public void setStr_nome_paciente(String str_nome_paciente) {
        this.str_nome_paciente = str_nome_paciente;
    }

    public String getData_nascimento_paciente() {
        return data_nascimento_paciente;
    }

    public void setData_nascimento_paciente(String data_nascimento_paciente) {
        this.data_nascimento_paciente = data_nascimento_paciente;
    }

    public String getStr_cpf_paciente() {
        return str_cpf_paciente;
    }

    public void setStr_cpf_paciente(String str_cpf_paciente) {
        this.str_cpf_paciente = str_cpf_paciente;
    }

    public String getStr_rg_paciente() {
        return str_rg_paciente;
    }

    public void setStr_rg_paciente(String str_rg_paciente) {
        this.str_rg_paciente = str_rg_paciente;
    }

    public Long getInt_sexo_paciente() {
        return int_sexo_paciente;
    }

    public void setInt_sexo_paciente(Long int_sexo_paciente) {
        this.int_sexo_paciente = int_sexo_paciente;
    }

    public Long getInt_estado_civil_paciente() {
        return int_estado_civil_paciente;
    }

    public void setInt_estado_civil_paciente(Long int_estado_civil_paciente) {
        this.int_estado_civil_paciente = int_estado_civil_paciente;
    }

    public String getStr_email_paciente() {
        return str_email_paciente;
    }

    public void setStr_email_paciente(String str_email_paciente) {
        this.str_email_paciente = str_email_paciente;
    }

    public String getStr_telefone_paciente() {
        return str_telefone_paciente;
    }

    public void setStr_telefone_paciente(String str_telefone_paciente) {
        this.str_telefone_paciente = str_telefone_paciente;
    }

    public String getStr_convenio_paciente() {
        return str_convenio_paciente;
    }

    public void setStr_convenio_paciente(String str_convenio_paciente) {
        this.str_convenio_paciente = str_convenio_paciente;
    }

    public String getStr_profissao_paciente() {
        return str_profissao_paciente;
    }

    public void setStr_profissao_paciente(String str_profissao_paciente) {
        this.str_profissao_paciente = str_profissao_paciente;
    }

    public String getStr_endereco_paciente() {
        return str_endereco_paciente;
    }

    public void setStr_endereco_paciente(String str_endereco_paciente) {
        this.str_endereco_paciente = str_endereco_paciente;
    }

    public Long getInt_cep_paciente() {
        return int_cep_paciente;
    }

    public void setInt_cep_paciente(Long int_cep_paciente) {
        this.int_cep_paciente = int_cep_paciente;
    }

    public String getStr_bairro_paciente() {
        return str_bairro_paciente;
    }

    public void setStr_bairro_paciente(String str_bairro_paciente) {
        this.str_bairro_paciente = str_bairro_paciente;
    }
    
        @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.idpaciente);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.idpaciente, other.idpaciente)) {
            return false;
        }
        return true;
    }

}
