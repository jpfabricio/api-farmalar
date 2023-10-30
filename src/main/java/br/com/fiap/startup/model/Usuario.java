package br.com.fiap.startup.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "usuario")
@SequenceGenerator(name = "usuario", sequenceName = "SQ_T_USUARIO", allocationSize = 1)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
    private int id;

    @NotBlank(message = "Nome obrigatório!")
    private String nome;

    @Size(max = 14)
    @NotBlank(message = "cpf obrigatório!")
    private String cpf;

    @NotBlank(message = "email obrigatório!")
    private String email;

    @NotBlank(message = "senha obrigatória!")
    private String senha;

    private boolean usaMedicamentoDiariamente;

    private LocalDate dataNascimento;

    private String tratamento;

    @NotBlank(message = "cnpj obrigatório!")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isUsaMedicamentoDiariamente() {
        return usaMedicamentoDiariamente;
    }

    public void setUsaMedicamentoDiariamente(boolean usaMedicamentoDiariamente) {
        this.usaMedicamentoDiariamente = usaMedicamentoDiariamente;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }
}
