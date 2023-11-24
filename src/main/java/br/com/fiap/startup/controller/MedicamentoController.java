package br.com.fiap.startup.controller;

import br.com.fiap.startup.exception.NotContent;
import br.com.fiap.startup.exception.NotFound;
import br.com.fiap.startup.model.Medicamento;
import br.com.fiap.startup.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @GetMapping
    public List<Medicamento> listar() {
        return medicamentoRepository.findAll();
    }

    @GetMapping("filtros")
    public List<Medicamento> listarfiltrado(@RequestParam List<String> filtros) {
        List<Medicamento> medicamentos = new ArrayList<>();
        filtros.forEach(filtro -> {
            medicamentos.addAll(medicamentoRepository.findByPatologia(filtro));
        });
        return medicamentos;
    }

    @GetMapping("{id}")
    public Medicamento buscarPorId(@PathVariable int id) {
        Optional<Medicamento> medicamento = medicamentoRepository.findById(id);
        if (medicamento.isPresent()) {
            return medicamento.get();
        } else {
            throw new NotContent("Medicamento não encontrado.");
        }
    }

    @GetMapping("nome/{nome}")
    public List<Medicamento> buscarPeloNome(@PathVariable String nome) {
        return medicamentoRepository.findByNome(nome);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Medicamento cadastrar(@RequestBody Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    @PutMapping("{id}")
    public Medicamento atualizar(@RequestBody Medicamento medicamento, @PathVariable int id) {
        medicamento.setId(id);
        return medicamentoRepository.save(medicamento);
    }

    @DeleteMapping("{id}")
    public void remover(@PathVariable int id) {
        try{
            medicamentoRepository.deleteById(id);
        } catch (Exception e) {
            throw new NotFound("Não existe medicamento com este id.");
        }
    }

    @DeleteMapping
    public void limpaMedicamentos() {
        try{
            medicamentoRepository.deleteAll();
        } catch (Exception e) {
            throw new NotFound("Não existe medicamento com este id.");
        }
    }
}