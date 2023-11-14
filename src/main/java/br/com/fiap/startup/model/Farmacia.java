package br.com.fiap.startup.model;

import br.com.fiap.startup.Enums.FormasPagamento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "farmacia")
@SequenceGenerator(name = "farmacia", sequenceName = "SQ_T_FARMACIA", allocationSize = 1)
@Getter
@Setter
public class Farmacia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "farmacia")
    private int id;

    @NotBlank(message = "razaoSocial obrigatória!")
    @Column(name = "razao_social")
    private String razaoSocial;

    @Size(max = 18)
    @NotBlank(message = "cnpj obrigatório!")
    private String cnpj;

    @NotBlank(message = "Endereco obrigatório!")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @Column(name = "horario_funcionamento")
    private String horarioFuncionamento;

    @ElementCollection(targetClass = FormasPagamento.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "formas_pagamento")
    private List<FormasPagamento> formasPagamento;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy = "farmacia")
    private List<Medicamento> medicamentos;

}
