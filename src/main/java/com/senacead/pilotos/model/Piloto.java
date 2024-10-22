
package com.senacead.pilotos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Data
@AllArgsConstructor //com construtores
@NoArgsConstructor //sem construtor
@Table(name = "piloto")
public class Piloto {
        
        @Id
        @GeneratedValue (strategy = GenerationType.AUTO)
        private Integer id;
	private String nome;
	private String equipe;
	private Double peso;
	private Double altura;
	private boolean status;
}
