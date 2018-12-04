/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetointegrador.physioevolui.service;

import com.projetointegrador.physioevolui.model.FaixaAtendimento;
import com.projetointegrador.physioevolui.model.Pedido;
import com.projetointegrador.physioevolui.model.Relatorio;
import com.projetointegrador.physioevolui.model.StatusPedido;
import com.projetointegrador.physioevolui.model.Unidade;
import com.projetointegrador.physioevolui.repository.PedidoRepository;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 *
 */
@Service
public class PedidoService implements Services<Pedido> {

    @Autowired
    PedidoRepository repository;

    @Autowired
    FaixaAtendimentoService atendimentoService;

    @Autowired
    UnidadeService unidadeService;

    @Override
    public Pedido buscarPorId(Long id) {
        return this.repository.findOne(id);
    }

    @Override
    public List<Pedido> buscarTodos() {
        return this.repository.findAll();
    }

    @Override
    public Pedido salvarOuAtualizar(Pedido obj) {
        return this.repository.save(obj);
    }

    @Override
    public void deletarPorId(Long id) {
        this.repository.delete(id);
    }

    @Override
    public void deletar(Pedido obj) {
        this.repository.delete(obj);
    }

    public void registrarUnidadeEmNovosPedidos() {
        List<Pedido> pedidos = this.repository.findByUnidade(null);
        System.out.println(pedidos.size() + " pedidos sem unidade");
        for (Pedido p : pedidos) {
            List<FaixaAtendimento> faixa = this.atendimentoService.filtarCep(p.getCliente().getCep());
            if (faixa != null && (!faixa.isEmpty())) {
                // achou um cdm pra essa região
                if (faixa.get(0).getUnidade().getAtivo()) {
                    this.repository.setUnidadeWhere(faixa.get(0).getUnidade(), p);
                } else {
                    System.out.println("Unidade que atende esta região está desativada");
                }
            } else {
                // nao achou cdm
                List<Unidade> cdm = this.unidadeService.buscarAtendePedidoEspecial(true);
                if (cdm != null && (!cdm.isEmpty())) {
                    // achou cdm atende pedido especial
                    if (cdm.get(0).getAtivo()) {
                        this.repository.setUnidadeWhere(cdm.get(0), p);
                    } else {
                        System.out.println("Unidade que atende esta região está desativada");
                    }
                } else {
                    System.out.println("Nenhuma unidade para atender o pedido " + p.getId());
                }
            }
        }
    }

//    public List<Pedido> buscarPorUnidade(Unidade unidade) {
//        return this.repository.findByUnidade(unidade);
//    }
    public void atualizarStatus(Long id, String statusPedido) {
        this.repository.updateStatusWhereId(statusPedido, id);
    }

    public void atualizarUnidade(Long idPedido, Unidade get) {
        this.repository.updateUnidadeWhereId(get, idPedido);
    }

    public Page<Pedido> buscarPorUnidade(Unidade unidade, Integer page, int size) {
        return this.repository.findByUnidade(unidade, new PageRequest(page, size));
    }

    public Page<Pedido> buscarAbertosEFinalizadosPorUnidade(Unidade unidade, Integer page, int size) {
        ArrayList<String> status = new ArrayList<>();
        status.add(StatusPedido.ABERTO.toString());
        status.add(StatusPedido.FINALIZADO.toString());
        return this.repository.findByUnidadeAndStatus(unidade, status, new PageRequest(page, size));
    }

    public void atualizarUnidadeStatus(Long idPedido, Unidade get, String status) {
        this.repository.updateUnidadeWhereId(get, idPedido, status);
    }

    public List<Pedido> gerarRelatorio(Relatorio relatorio) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Timestamp dataInicial = new Timestamp(sdf.parse(relatorio.getDataInicial()).getTime());
        Timestamp dataFinal = new Timestamp(sdf.parse(relatorio.getDataFinal()).getTime());

        return this.repository.findByDataPedidoAndUnidadeAndStatus(relatorio.getUnidade(), relatorio.getStatus(), dataInicial, dataFinal);
    }
}
