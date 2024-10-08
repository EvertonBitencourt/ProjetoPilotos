
package com.senacead.pilotos.controller;

import com.senacead.pilotos.model.Piloto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PilotoController {
    
    private List<Piloto> listaPilotos = new ArrayList();
    
    @GetMapping("/")
    public String inicio(){
        return "index";
    }
    
    @GetMapping("/tela-inicio")
    public String inicio2(){
        return "index";
    }
    
    @GetMapping("/cadastro")
    public String cadastro(Model model){
        model.addAttribute("piloto", new Piloto());
        return "cadastro";
    }
    
    @PostMapping("/guardar-piloto")
    public String processarformulario(Model model, @ModelAttribute Piloto piloto){
        piloto.setId(listaPilotos.size()+1);
        piloto.setStatus(true);
        listaPilotos.add(piloto);
        return "redirect:/listagem";
    }
    
    @GetMapping("/listagem")
    public String listar(Model model){
        model.addAttribute("pilotos", listaPilotos);
        return "listagem";
    }
}
