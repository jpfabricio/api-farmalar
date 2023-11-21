package br.com.fiap.startup.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "medicamento")
@SequenceGenerator(name = "medicamento", sequenceName = "SQ_T_MEDICAMENTO", allocationSize = 1)
@Getter
@Setter
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicamento")
    private int id;

    @NotBlank(message = "Nome obrigatório!")
    private String nome;

    private String descricao;

    @NotBlank(message = "Precisa passar quantidade disponível!")
    @Column(name = "quantidade_disponivel")
    private int quantidadeDisponivel;

    @NotBlank(message = "Valor obrigatório!")
    private double valor;

    @Column(name = "precisa_receita")
    private boolean precisaReceita;

    private String patologia;

    @ManyToOne
    @JoinColumn(name = "farmacia_id", referencedColumnName = "id")
    private Farmacia farmacia;
}
