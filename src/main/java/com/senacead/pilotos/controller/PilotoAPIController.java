/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senacead.pilotos.controller;

import com.senacead.pilotos.model.Piloto;
import com.senacead.pilotos.service.PilotoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/piloto")
public class PilotoAPIController {
   
    @Autowired
    PilotoService pilotoService;
    
    @PostMapping("/adicionar")
    public ResponseEntity<Piloto> criar (@RequestBody Piloto piloto){
        Piloto novoPiloto = pilotoService.criarPiloto(piloto);
        return new ResponseEntity<>(novoPiloto, HttpStatus.CREATED);
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Piloto> pesquisar (@PathVariable Integer id){
        Piloto pilitoEncontrado = pilotoService.buscarPorId(id);
        return new ResponseEntity<>(pilitoEncontrado, HttpStatus.OK);
    }
    
    @GetMapping("/listar-todos")
    public ResponseEntity<List> listar (){
        List <Piloto> pilotoL = pilotoService.listarTodos();
        return new ResponseEntity<>(pilotoL, HttpStatus.OK);
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Piloto> editarPiloto(@PathVariable Integer id, @RequestBody Piloto piloto){
        Piloto pilotoAtualizado = pilotoService.atualizar(id, piloto);
        return new ResponseEntity<>(pilotoAtualizado, HttpStatus.OK);
    }
    
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        pilotoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
