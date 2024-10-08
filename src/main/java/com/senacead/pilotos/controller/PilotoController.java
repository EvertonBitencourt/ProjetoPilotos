
package com.senacead.pilotos.controller;

import org.springframework.stereotype.Controller;
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
    public String cadastro(){
        return "cadastro";
    }
}
