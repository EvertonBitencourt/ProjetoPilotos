package com.senacead.pilotos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor //com construtores
@NoArgsConstructor //sem construtor
@Table(name = "avaliacoes")
public class Avaliacoes {
    
        @Id
        @GeneratedValue (strategy = GenerationType.AUTO)
        private Integer id;
        @ManyToOne
        @JoinColumn(name = "id_avaliacoes")
	private Piloto piloto;
	private String avaliacao;
}
