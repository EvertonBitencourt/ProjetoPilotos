/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senacead.pilotos.controller;

import com.senacead.pilotos.model.Avaliacoes;
import com.senacead.pilotos.model.ListaDados;
import com.senacead.pilotos.model.Piloto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AvaliacaoController {
    
    @PostMapping("/guardar-avaliacao")
    public String processarform(Model model, @ModelAttribute Piloto piloto, @ModelAttribute Avaliacoes avaliacao) {
        
        avaliacao.setPiloto(piloto);
        ListaDados.adicionarAvaliacao(avaliacao);
        return "redirect:/listagem";
    }
    
    @GetMapping("/excluir-avaliacao")
    public String excluirAvaliacao(Model model, @RequestParam String id) {
        Integer idComentario = Integer.parseInt(id); // converter o string
        
        ListaDados.excluirAvaliacao(idComentario);
        return "redirect:/listagem";
    }
}
