package br.com.fiap.startup.model;

import br.com.fiap.startup.Enums.FormasPagamento;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "farmacia")
@SequenceGenerator(name = "farmacia", sequenceName = "SQ_T_FARMACIA", allocationSize = 1)
public class Farmacia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "farmacia")
    private int id;

    @NotBlank(message = "razaoSocial obrigatória!")
    private String razaoSocial;

    @Size(max = 18)
    @NotBlank(message = "cnpj obrigatório!")
    private String cnpj;

    @NotBlank(message = "Endereco obrigatório!")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    private String horarioFuncionamento;

    @ElementCollection(targetClass = FormasPagamento.class)
    @Enumerated(EnumType.STRING)
    private List<FormasPagamento> formasPagamento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public List<FormasPagamento> getFormasPagamento() {
        return formasPagamento;
    }

    public void setFormasPagamento(List<FormasPagamento> formasPagamento) {
        this.formasPagamento = formasPagamento;
    }
}
