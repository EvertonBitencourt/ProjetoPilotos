package com.senacead.pilotos.controller;

import com.senacead.pilotos.model.Avaliacoes;
import com.senacead.pilotos.model.ListaDados;
import com.senacead.pilotos.model.Piloto;
import com.senacead.pilotos.service.AvaliacoesService;
import com.senacead.pilotos.service.PilotoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PilotoController {

    @Autowired
    PilotoService pilotoService;
    
    @Autowired
    AvaliacoesService avaliacoesService;
    
    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/tela-inicio")
    public String inicio2() {
        return "index";
    } 

    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("piloto", new Piloto());
        return "cadastro";
    }

    @PostMapping("/guardar-piloto")
    public String processarformulario(Model model, @ModelAttribute Piloto piloto) {
        if (piloto.getId() != null) {
            pilotoService.atualizar(piloto.getId(), piloto);
        } else {
            pilotoService.criarPiloto(piloto);
        }
        return "redirect:/listagem";
    }

    @GetMapping("/listagem")
    public String listar(Model model) {
        model.addAttribute("pilotos", pilotoService.listarTodos());
        return "listagem";
    }

    @GetMapping("/exibir")
    public String mostrarDetalhesPiloto(Model model, @RequestParam String id) {
        Integer idPiloto = Integer.parseInt(id); // converter o string
        Piloto pilotoEncontrado = new Piloto(); // criar o objeto
        pilotoEncontrado = pilotoService.buscarPorId(idPiloto);    
        List<Avaliacoes> avaliacaoEncontrada = new ArrayList();
	avaliacaoEncontrada = avaliacoesService.buscarPorIdPiloto(idPiloto);
        model.addAttribute("piloto", pilotoEncontrado); // adicionar o objeto encontrado
        model.addAttribute("avaliacoes", avaliacaoEncontrada);
        model.addAttribute("avaliacao", new Avaliacoes());
        return "detalhes";
    }

    @GetMapping("/excluir-piloto")
    public String excluirPiloto(Model model, @RequestParam String id) {
        Integer idPiloto = Integer.parseInt(id); // converter o string
        pilotoService.excluir(idPiloto);
        return "redirect:/listagem";
    }

    @GetMapping("/alterar-piloto")
    public String alterarPiloto(Model model, @RequestParam String id) {
        Integer idPiloto = Integer.parseInt(id); // converter o string
        
        model.addAttribute("piloto", pilotoService.buscarPorId(idPiloto));
        return "cadastro";
    }
    
}
