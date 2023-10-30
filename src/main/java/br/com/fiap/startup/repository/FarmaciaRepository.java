package br.com.fiap.startup.repository;

import br.com.fiap.startup.model.Farmacia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmaciaRepository extends JpaRepository<Farmacia, Integer> {

    List<Farmacia> findByCnpj(String cnpj);

}
