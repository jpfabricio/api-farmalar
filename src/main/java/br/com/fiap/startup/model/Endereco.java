package br.com.fiap.startup.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "endereco")
@SequenceGenerator(name = "endereco", sequenceName = "SQ_T_ENDERECO", allocationSize = 1)
@Getter
@Setter
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco")
    private int id;

    @NotBlank(message = "rua obrigatória!")
    private String rua;

    @NotBlank(message = "bairro obrigatório!")
    private String bairro;

    @NotBlank(message = "cep obrigatório!")
    private String cep;

    private int numero;

    @Size(max = 2)
    private String estado;
}
