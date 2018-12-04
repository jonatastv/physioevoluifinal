/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetointegrador.physioevolui.controller;


import com.projetointegrador.physioevolui.mensagem.FormMensagem;
import com.projetointegrador.physioevolui.mensagem.TipoMensagem;
import com.projetointegrador.physioevolui.model.Perimetria;
import com.projetointegrador.physioevolui.model.Usuario;
import com.projetointegrador.physioevolui.service.PerimetriaService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/perimetria")
public class PerimetriaController {

    FormMensagem msg;

    @Autowired
    PerimetriaService perimetriaService;

    //@Autowired
    //PerfilAcessoService perfilAcessoService;

   // @Autowired
    //UnidadeService unidadeService;

    @GetMapping
    public ModelAndView form(Perimetria perimetria, @AuthenticationPrincipal Usuario usuarioLogado) {
        ModelAndView model = new ModelAndView("perimetria/form-perimetria");

        model.addObject("perimetria", perimetria);
        model.addObject("perimetrias", this.perimetriaService.buscarTodos());
     //   model.addObject("perfils", this.perfilAcessoService.buscarTodos());
      //  model.addObject("unidades", this.unidadeService.buscarTodos());
        model.addObject("user", usuarioLogado);

        return model;
    }

    @PostMapping
    public ModelAndView salvar(@Valid Perimetria perimetria, RedirectAttributes attributes) {
    ModelAndView model = new ModelAndView("redirect:/perimetria");

        try {
            this.perimetriaService.salvarOuAtualizar(perimetria);
            msg = new FormMensagem(TipoMensagem.SUCESSO);
            msg.addMensagem("Perimetria registrado com sucesso");
        } catch (Exception e) {
            msg = new FormMensagem(TipoMensagem.ERRO);
            msg.addMensagem("Não foi possível registrar");
        }
        attributes.addFlashAttribute("msg", this.msg);
        return model;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable Long id, @AuthenticationPrincipal Usuario usuarioLogado) {

        return this.form(this.perimetriaService.buscarPorId(id), usuarioLogado);
    }

    @DeleteMapping("/{id}")
    public ModelAndView deletar(@PathVariable Long id, RedirectAttributes attributes) {

        try {
            this.perimetriaService.deletarPorId(id);
            msg = new FormMensagem(TipoMensagem.SUCESSO);
            msg.addMensagem("Perimetria deletado com sucesso");
        } catch (Exception e) {
            msg = new FormMensagem(TipoMensagem.ERRO);
            msg.addMensagem("Não foi possível deletar");
        }
        attributes.addFlashAttribute("msg", this.msg);
        return new ModelAndView("redirect:/perimetria");
    }
}
