package com.projetointegrador.physioevolui;

import com.projetointegrador.physioevolui.converters.DoubleConverter;
import com.projetointegrador.physioevolui.model.PerfilAcesso;
import com.projetointegrador.physioevolui.model.Unidade;
import com.projetointegrador.physioevolui.model.Usuario;
import com.projetointegrador.physioevolui.service.PerfilAcessoService;
import com.projetointegrador.physioevolui.service.UnidadeService;
import com.projetointegrador.physioevolui.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class CdmApplication extends WebMvcConfigurerAdapter{

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DoubleConverter());
//        registry.addConverter(new StringDoubleConverter());
    }

    
    @Autowired
    UsuarioService service;

    @Autowired
    PerfilAcessoService perfilAcesso;

    @Autowired
    UnidadeService unidadeService;

    public static void main(String[] args) {
        SpringApplication.run(CdmApplication.class, args);
    }

    @Bean
    CommandLineRunner init() {
        return (args) -> {

            PerfilAcesso p = new PerfilAcesso();
            Unidade u = new Unidade();

            List<PerfilAcesso> perfils = this.perfilAcesso.buscarTodos();
            if (perfils == null || perfils.isEmpty()) {
                p.setAdm(true);
                p.setDescricao("Teste");
                p = this.perfilAcesso.salvarOuAtualizar(p);
            }

            List<Unidade> unidades = this.unidadeService.buscarTodos();
            if (unidades == null || unidades.isEmpty()) {
                u.setAtivo(true);
                u.setCnpj("04292234000100");
                u.setNome("Teste");
                u.setPedidoEspecial(true);
                u = this.unidadeService.salvarOuAtualizar(u);
            }

            List<Usuario> usuarios = this.service.buscarTodos();
            if (usuarios == null || usuarios.isEmpty()) {
                Usuario user = new Usuario("ROOT", p, u, "root", "root");
                this.service.salvarOuAtualizar(user);
            }

        };
    }
}
