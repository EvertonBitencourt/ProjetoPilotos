
package com.senacead.pilotos.controller;

import com.senacead.pilotos.model.Piloto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PilotoController {
    
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
    
    @GetMapping("/listagem")
    public String listar(){
        return "listagem";
    }
}
