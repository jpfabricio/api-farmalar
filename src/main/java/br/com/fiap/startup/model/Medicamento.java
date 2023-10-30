package br.com.fiap.startup.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "medicamento")
@SequenceGenerator(name = "medicamento", sequenceName = "SQ_T_MEDICAMENTO", allocationSize = 1)
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicamento")
    private int id;

    @NotBlank(message = "Nome obrigatório!")
    private String nome;

    private String descricao;

    @NotBlank(message = "Precisa passar quantidade disponível!")
    private int quantidadeDisponivel;

    @NotBlank(message = "Valor obrigatório!")
    private double valor;

    private boolean precisaReceita;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isPrecisaReceita() {
        return precisaReceita;
    }

    public void setPrecisaReceita(boolean precisaReceita) {
        this.precisaReceita = precisaReceita;
    }
}
