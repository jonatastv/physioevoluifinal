/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetointegrador.physioevolui.controller;

import com.projetointegrador.physioevolui.model.Pedido;
import com.projetointegrador.physioevolui.model.Relatorio;
import com.projetointegrador.physioevolui.model.StatusPedido;
import com.projetointegrador.physioevolui.model.Usuario;
import com.projetointegrador.physioevolui.service.PedidoService;
import com.projetointegrador.physioevolui.service.UnidadeService;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Murilo Oliveira
 */
@Controller
@RequestMapping("/relatorio")
public class RelatorioController {

    @Autowired
    PedidoService pedidoService;

    @Autowired
    UnidadeService unidadeService;

    @GetMapping
    public ModelAndView form(Relatorio relatorio, @AuthenticationPrincipal Usuario usuarioLogado) {
        ModelAndView model = new ModelAndView("relatorio/form-relatorio");

        model.addObject("user", usuarioLogado);
        model.addObject("relatorio", relatorio);
        model.addObject("unidades", this.unidadeService.buscarTodos());
        model.addObject("status", StatusPedido.values());

        return model;
    }

    @PostMapping
    public ModelAndView gerar(Relatorio relatorio) {
        ModelAndView model = new ModelAndView("relatorio/form-relatorio-resultado");

        try {
            List<Pedido> pedidos = this.pedidoService.gerarRelatorio(relatorio);
            Double total = 0D;
            for (Pedido p : pedidos) {
                total += p.getValorFinal();
            }
            String dtInicial = relatorio.getDataInicial();
            String dtFinal = relatorio.getDataFinal();
            // 2017-12-05
            relatorio.setDataInicial(dtInicial.substring(8, 10) + "/" + dtInicial.substring(5, 7) + "/" + dtInicial.substring(0, 4));
            relatorio.setDataFinal(dtFinal.substring(8, 10) + "/" + dtFinal.substring(5, 7) + "/" + dtFinal.substring(0, 4));

            model.addObject("pedidos", pedidos);
            model.addObject("relatorio", relatorio);
            model.addObject("total", total);

        } catch (ParseException e) {
            System.out.println("Erro POST Relatorio: " + e);
        }

        return model;
    }
}
