
package com.senacead.pilotos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@AllArgsConstructor //com construtores
@NoArgsConstructor //sem construtor
public class Piloto {
        private Integer id;
	private String nome;
	private String equipe;
	private Double peso;
	private Double altura;
	private boolean status;
}
