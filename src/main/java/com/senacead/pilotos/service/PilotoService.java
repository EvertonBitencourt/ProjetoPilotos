/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senacead.pilotos.service;

import com.senacead.pilotos.model.Piloto;
import com.senacead.pilotos.repository.PilotoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PilotoService {

    @Autowired
    PilotoRepository pilotoRepository;

    public Piloto criarPiloto(Piloto piloto) {
        piloto.setId(null);
        pilotoRepository.save(piloto);
        return piloto;
    }

    public Piloto buscarPorId(Integer id) {
        return pilotoRepository.findById(id).orElseThrow();
    }

    public List<Piloto> listarTodos() {
        return pilotoRepository.findAll();
    }

    public Piloto atualizar(Integer id, Piloto piloto) {
        Piloto pilotoEncontrado = buscarPorId(id);

        pilotoEncontrado.setNome(piloto.getNome());
        pilotoEncontrado.setEquipe(piloto.getEquipe());
        pilotoRepository.save(pilotoEncontrado);
        return pilotoEncontrado;
    }
    
    public void excluir(Integer id) {
        Piloto pilotoEncontrado = buscarPorId(id);
        pilotoRepository.deleteById(pilotoEncontrado.getId());
    }
}
