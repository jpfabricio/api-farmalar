package br.com.fiap.startup.repository;

import br.com.fiap.startup.model.Medicamento;
import br.com.fiap.startup.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findByEmail(String email);

}
