/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetointegrador.physioevolui.controller;

import com.projetointegrador.physioevolui.model.Usuario;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * 
 */
@Controller
@RequestMapping(value = {"", "/", "/home", "/index"})
public class IndexController {

    @GetMapping
    public String form(@AuthenticationPrincipal Usuario usuarioLogado) {
        return "redirect:/pedidos";
    }
}
