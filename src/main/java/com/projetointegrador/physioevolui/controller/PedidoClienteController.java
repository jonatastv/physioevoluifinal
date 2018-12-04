/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetointegrador.physioevolui.controller;

import com.projetointegrador.physioevolui.mensagem.FormMensagem;
import com.projetointegrador.physioevolui.mensagem.TipoMensagem;
import com.projetointegrador.physioevolui.model.EstoqueUnidade;
import com.projetointegrador.physioevolui.model.ItensPedido;
import com.projetointegrador.physioevolui.model.Pedido;
import com.projetointegrador.physioevolui.model.Produto;
import com.projetointegrador.physioevolui.model.StatusPedido;
import com.projetointegrador.physioevolui.model.Usuario;
import com.projetointegrador.physioevolui.service.EstoqueUnidadeService;
import com.projetointegrador.physioevolui.service.FormaEntregaService;
import com.projetointegrador.physioevolui.service.ItensPedidoService;
import com.projetointegrador.physioevolui.service.PedidoService;
import com.projetointegrador.physioevolui.service.ProdutoService;
import com.projetointegrador.physioevolui.service.TransportadoraService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 *
 */
@Controller
@RequestMapping("/pedidos")
public class PedidoClienteController {

    FormMensagem msg = null;

    @Autowired
    PedidoService pedidoService;

    @Autowired
    ItensPedidoService itensPedidoService;

    @Autowired
    ProdutoService produtoService;

    @Autowired
    EstoqueUnidadeService estoqueUnidadeService;
    
    @Autowired
    FormaEntregaService formaEntregaService;
    
    @Autowired
    TransportadoraService transportadoraService;

    @GetMapping
    public ModelAndView form(@AuthenticationPrincipal Usuario usuarioLogado, @RequestParam(defaultValue = "0") Integer page) {

        ModelAndView model = new ModelAndView("pedido/form-pedido");

        model.addObject("pedidos", this.pedidoService.buscarAbertosEFinalizadosPorUnidade(usuarioLogado.getUnidade(), page, 10));

        model.addObject("user", usuarioLogado);

        return model;
    }

    @GetMapping("/{id}")
    public ModelAndView visualizar(@PathVariable Long id, @AuthenticationPrincipal Usuario usuarioLogado) {
        ModelAndView model = new ModelAndView("pedido/visualiza-pedido");

        List<ItensPedido> itens = this.itensPedidoService.buscarPorPedido(id);

//        for (ItensPedido ip : itens) {
//            Produto p = this.produtoService.buscarPorId(ip.getIdProduto());
//            ProdutoUnidade produtoSelecao = new ProdutoUnidade(p, ip.getQtde().intValue());
//            if (p != null) {
//                produtos.add(produtoSelecao);
//            }
//        }
        System.out.println("Buscando pedido numero " + id);
        model.addObject("pedido", this.pedidoService.buscarPorId(id));
        model.addObject("produtos", itens);
        model.addObject("user", usuarioLogado);
        model.addObject("formasEntrega", this.formaEntregaService.buscarTodos());
        model.addObject("transportadoras", this.transportadoraService.buscarTodos());
        return model;
    }

    @PostMapping("/finalizar/{id}")
    public ModelAndView finalizarPedido(Pedido pedidoForm, @PathVariable Long id, RedirectAttributes attributes, @AuthenticationPrincipal Usuario usuarioLogado) {
        ModelAndView model = new ModelAndView("redirect:/pedidos");
        List<EstoqueUnidade> itensAlterados = new ArrayList<>();

        try {
            
            
            List<ItensPedido> itens = this.itensPedidoService.buscarPorPedido(id);

            for (ItensPedido i : itens) {
                Produto produto = this.produtoService.buscarPorId(i.getIdProduto());
                EstoqueUnidade estoque = this.estoqueUnidadeService.buscarPorProdutoEUnidade(produto, usuarioLogado.getUnidade());
                if (estoque != null && estoque.getEstoqueFisico() >= i.getQtde()) {
                    // se for maior, decrementar e salvar
                    estoque.setEstoqueFisico(estoque.getEstoqueFisico() - i.getQtde().intValue());
                    itensAlterados.add(estoque);
                } else {
                    // nao tem estoque para finalizar o pedido
                    this.msg = new FormMensagem(TipoMensagem.ERRO).addMensagem("Não foi possível finalizar o pedido").addMensagem("Produto " + produto.getNome() + " não possui estoque suficiente para dar saída");
                    attributes.addFlashAttribute("msg", msg);
                    return model;
                }
            }
            for (EstoqueUnidade eu : itensAlterados) {
                this.estoqueUnidadeService.salvarOuAtualizar(eu);
            }
            
            Pedido pedidoLocal = this.pedidoService.buscarPorId(id);
            pedidoLocal.setFormaEntrega(pedidoForm.getFormaEntrega());
            if(pedidoForm.getFormaEntrega().equals("1")) {
                pedidoLocal.setCodigoRastreio(pedidoForm.getCodigoRastreio());                
                pedidoLocal.setTransportadora(null);
                pedidoLocal.setNomeEntrega(null);
                pedidoLocal.setRgEntrega(null);
                pedidoLocal.setOrdemColetaEntrega(null);
            } else if(pedidoForm.getFormaEntrega().equals("2")) {
                pedidoLocal.setCodigoRastreio(null);                
                pedidoLocal.setTransportadora(pedidoForm.getTransportadora());
                pedidoLocal.setNomeEntrega(pedidoForm.getNomeEntrega());
                pedidoLocal.setRgEntrega(pedidoForm.getRgEntrega());
                pedidoLocal.setOrdemColetaEntrega(pedidoForm.getOrdemColetaEntrega());
            } else if(pedidoForm.getFormaEntrega().equals("3")) {
                pedidoLocal.setCodigoRastreio(null);                
                pedidoLocal.setTransportadora(null);
                pedidoLocal.setNomeEntrega(pedidoForm.getNomeEntrega());
                pedidoLocal.setRgEntrega(pedidoForm.getRgEntrega());
                pedidoLocal.setOrdemColetaEntrega(null);
            }
            
            this.pedidoService.atualizarStatus(id, StatusPedido.FINALIZADO.toString());
            this.msg = new FormMensagem(TipoMensagem.SUCESSO).addMensagem("Pedido número #" + id + " finalizado com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro " + e);
            msg = new FormMensagem(TipoMensagem.ERRO).addMensagem("Não foi possível finalizar este pedido");
        }
        attributes.addFlashAttribute("msg", msg);
        return model;
    }
}
