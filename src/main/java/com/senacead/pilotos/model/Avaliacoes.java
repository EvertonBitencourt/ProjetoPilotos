package com.senacead.pilotos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //com construtores
@NoArgsConstructor //sem construtor
public class Avaliacoes {
        private Integer id;
	private Piloto piloto;
	private String avaliacao;
}
