package br.com.fiap.startup.model;

import br.com.fiap.startup.Enums.Sexo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "usuario")
@SequenceGenerator(name = "usuario", sequenceName = "SQ_T_USUARIO", allocationSize = 1)
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
    private int id;

    @NotBlank(message = "Nome obrigatório!")
    private String nome;

    @Column(unique = true)
    @NotBlank(message = "email obrigatório!")
    private String email;

    @NotBlank(message = "senha obrigatória!")
    private String senha;

    private Sexo sexo;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
}
