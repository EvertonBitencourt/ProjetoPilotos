package com.senacead.pilotos.controller;

import com.senacead.pilotos.model.Avaliacoes;
import com.senacead.pilotos.model.Piloto;
import com.senacead.pilotos.service.AvaliacoesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacoesAPIController {

    @Autowired
    AvaliacoesService avaliacoesService;

    @PostMapping("/adicionar")
    public ResponseEntity<Avaliacoes> criar(@RequestBody Avaliacoes avaliacoes) {
        Avaliacoes novaAvaliacao = avaliacoesService.criarAvaliacoes(avaliacoes);
        return new ResponseEntity<>(novaAvaliacao, HttpStatus.CREATED);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        avaliacoesService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{idAvaliacao}")
    public ResponseEntity<List> listarAvaliacoes(@PathVariable Integer idAvaliacao) {
        List<Avaliacoes> lista = avaliacoesService.buscarPorIdPiloto(idAvaliacao);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
