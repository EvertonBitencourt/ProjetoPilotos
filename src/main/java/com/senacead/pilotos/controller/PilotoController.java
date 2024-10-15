package com.senacead.pilotos.controller;

import com.senacead.pilotos.model.Piloto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PilotoController {

    private List<Piloto> listaPilotos = new ArrayList();

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
            for (Piloto p : listaPilotos) {
                if (p.getId() == piloto.getId()) {
                    p.setNome(piloto.getNome());
                    p.setEquipe(piloto.getEquipe());
                    break;
                }
            }
        } else {
            piloto.setId(listaPilotos.size() + 1);
            piloto.setStatus(true);
            listaPilotos.add(piloto);
        }
        return "redirect:/listagem";
    }

    @GetMapping("/listagem")
    public String listar(Model model) {
        model.addAttribute("pilotos", listaPilotos);
        return "listagem";
    }

    @GetMapping("/exibir")
    public String mostrarDetalhesPiloto(Model model, @RequestParam String id) {
        Integer idPiloto = Integer.parseInt(id); // converter o string
        Piloto pilotoEncontrado = new Piloto(); // criar o objeto
        for (Piloto p : listaPilotos) {
            if (p.getId() == idPiloto) {
                pilotoEncontrado = p;
                break;
            }
        }
        model.addAttribute("piloto", pilotoEncontrado); // adicionar o objeto encontrado
        return "detalhes";
    }

    @GetMapping("/excluir-piloto")
    public String excluirPiloto(Model model, @RequestParam String id) {
        Integer idPiloto = Integer.parseInt(id); // converter o string
        Piloto pilotoEncontrado = new Piloto(); // criar o objeto
        for (Piloto p : listaPilotos) {
            if (p.getId() == idPiloto) {
                pilotoEncontrado = p;
                break;
            }
        }

        listaPilotos.remove(pilotoEncontrado);
        return "redirect:/listagem";
    }

    @GetMapping("/alterar-piloto")
    public String alterarPiloto(Model model, @RequestParam String id) {
        Integer idPiloto = Integer.parseInt(id); // converter o string
        Piloto pilotoEncontrado = new Piloto(); // criar o objeto
        for (Piloto p : listaPilotos) {
            if (p.getId() == idPiloto) {
                pilotoEncontrado = p;
                break;
            }
        }
        model.addAttribute("piloto", pilotoEncontrado);
        return "cadastro";
    }

}
