package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Superpoder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome não pode ser nulo.")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3V1__criar_tabela_superpoder.sql a 50 caracteres.")
    private String nome;

    @Min(value = 1, message = "A nota mínima é 1.")
    @Max(value = 10, message = "A nota máxima é 10.")
    private String descricao;

    @Size(min = 1, max = 10, message = "A nota do poder deve ser entre 1 a 10.")
    private Integer nota;

    @NotNull(message = "A razão nao pode ser nula")
    @Size(min = 10, max = 200, message = "A razão deve ter entre 10 e 200 caracteres.")
    private String razao;

    @Past(message = "A data de criação não pode ser no futuro.")
    private LocalDate dataCriacao;

}
