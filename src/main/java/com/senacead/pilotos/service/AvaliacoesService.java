
package com.senacead.pilotos.service;


import com.senacead.pilotos.model.Avaliacoes;
import com.senacead.pilotos.model.Piloto;
import com.senacead.pilotos.repository.AvaliacoesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacoesService {
    
    @Autowired
    AvaliacoesRepository avaliacoesRepository;
    
    public List<Avaliacoes> listarTodos() {
        return avaliacoesRepository.findAll();
    }
    
    public Avaliacoes buscarPorId(Integer id) {
        return avaliacoesRepository.findById(id).orElseThrow();
    }
    
    public void excluir(Integer id) {
        Avaliacoes avaliacoesEncontrada = buscarPorId(id);
        avaliacoesRepository.deleteById(avaliacoesEncontrada.getId());
    }
    
    public Avaliacoes criarAvaliacoes(Avaliacoes avaliacoes) {
        avaliacoes.setId(null);
        avaliacoesRepository.save(avaliacoes);
        return avaliacoes;
    }
    
    public List<Avaliacoes> buscarPorIdPiloto(Integer id){
        return avaliacoesRepository.findByPilotoId(id);
    }
}
