/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetointegrador.physioevolui.controller;

import com.projetointegrador.physioevolui.mensagem.FormMensagem;
import com.projetointegrador.physioevolui.mensagem.TipoMensagem;
import com.projetointegrador.physioevolui.model.FaixaAtendimento;
import com.projetointegrador.physioevolui.model.Usuario;
import com.projetointegrador.physioevolui.service.CidadeService;
import com.projetointegrador.physioevolui.service.FaixaAtendimentoService;
import com.projetointegrador.physioevolui.service.UnidadeService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * 
 */
@Controller
@RequestMapping("/faixaatendimento")
public class FaixaAtendimentoController {

    int paginacao = 50;

    FormMensagem msg;

    @Autowired
    FaixaAtendimentoService atendimentoService;

    @Autowired
    UnidadeService unidadeService;
    
    @Autowired
    CidadeService cidadeService;

    @GetMapping(value = {"", "/", "/{pagina}"})
    public ModelAndView form(@PathVariable(value = "pagina", required = false) Integer pagina,
            FaixaAtendimento faixaAtendimento, @AuthenticationPrincipal Usuario usuarioLogado) {

        ModelAndView model = new ModelAndView("faixaatendimento/form-faixaatendimento");

        long registros = this.atendimentoService.contarRegistros();
        ArrayList<Integer> pgn = new ArrayList<Integer>();
        int j = 1;
        for (int i = 0; i < registros; i += paginacao) {
            pgn.add(j);
            j++;
        }
        PageRequest page = null;
        if (pagina == null) {
            page = new PageRequest(0, paginacao);
        } else {
            page = new PageRequest(pagina, paginacao);
        }

        List<FaixaAtendimento> fa = new ArrayList<>();
        Page<FaixaAtendimento> faixas = this.atendimentoService.buscarPaginacao(page);
        faixas.forEach(p -> {
            fa.add(p);
        });

        model.addObject("atendimento", faixaAtendimento);
        model.addObject("atendimentos", fa);
        model.addObject("unidades", this.unidadeService.buscarTodos());
        model.addObject("paginas", pgn);
        model.addObject("unidades", this.unidadeService.buscarTodos());
        model.addObject("user", usuarioLogado);
        model.addObject("cidades", this.cidadeService.buscarTodos());

        return model;
    }

    @PostMapping
    public ModelAndView salvar(@Valid FaixaAtendimento faixaAtendimento, RedirectAttributes attributes) {

        try {
            this.atendimentoService.salvarOuAtualizar(faixaAtendimento);
            msg = new FormMensagem(TipoMensagem.SUCESSO);
            msg.addMensagem("Faixa de atendimento registrada com sucesso");
        } catch (Exception e) {
            msg = new FormMensagem(TipoMensagem.ERRO);
            msg.addMensagem("Não foi possível registrar");
        }
        attributes.addFlashAttribute("msg", this.msg);
        return new ModelAndView("redirect:/faixaatendimento");
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable Long id, @AuthenticationPrincipal Usuario usuarioLogado) {

        return this.form(0, this.atendimentoService.buscarPorId(id), usuarioLogado);
    }

    @DeleteMapping("/{id}")
    public ModelAndView deletar(@PathVariable Long id, RedirectAttributes attributes) {

        try {
            this.atendimentoService.deletarPorId(id);
            msg = new FormMensagem(TipoMensagem.SUCESSO);
            msg.addMensagem("Faixa de atendimento deletada com sucesso");
        } catch (Exception e) {
            msg = new FormMensagem(TipoMensagem.ERRO);
            msg.addMensagem("Não foi possível deletar");
        }
        attributes.addFlashAttribute("msg", this.msg);
        return new ModelAndView("redirect:/faixaatendimento");
    }
}
