package br.com.fiap.startup.repository;

import br.com.fiap.startup.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer> {

    List<Medicamento> findByNome(String nome);

    List<Medicamento> findByPatologia(String patologia);

}
