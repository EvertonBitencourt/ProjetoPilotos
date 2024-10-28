
package com.senacead.pilotos.repository;

import com.senacead.pilotos.model.Avaliacoes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacoesRepository extends JpaRepository<Avaliacoes, Integer>{
    List<Avaliacoes> findByPilotoId(Integer id);
}
