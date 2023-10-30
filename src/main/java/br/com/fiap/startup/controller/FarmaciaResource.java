package br.com.fiap.startup.controller;

import br.com.fiap.startup.exception.BadRequest;
import br.com.fiap.startup.exception.NotContent;
import br.com.fiap.startup.exception.NotFound;
import br.com.fiap.startup.model.Farmacia;
import br.com.fiap.startup.repository.FarmaciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("farmacias")
public class FarmaciaResource {
    
    @Autowired
    FarmaciaRepository farmaciaRepository;

    @GetMapping
    public List<Farmacia> listar(){
        return  farmaciaRepository.findAll();
    }

    @GetMapping("{id}")
    public Farmacia buscarPorId(@PathVariable int id) {
        Optional<Farmacia> farmacia = farmaciaRepository.findById(id);
        if (farmacia.isPresent()) {
            return farmacia.get();
        } else {
            throw new NotContent("Farmacia não encontrada.");
        }
    }

    @PostMapping
    public Farmacia cadastrar(@RequestBody Farmacia farmacia){
        verificaCnpj(farmacia.getCnpj());
        return farmaciaRepository.save(farmacia);
    }


    @PutMapping("{id}")
    public Farmacia atualizar(@RequestBody Farmacia farmacia, @PathVariable int id) {
        farmacia.setId(id);
        return farmaciaRepository.save(farmacia);
    }

    @DeleteMapping("{id}")
    public void remover(@PathVariable int id) {
        try{
            farmaciaRepository.deleteById(id);
        } catch (Exception e) {
            throw new NotFound("Não existe farmacia com este id.");
        }
    }

    public void verificaCnpj(String cnpj){
        if (!cnpj.contains(".") || !cnpj.contains("-") || !cnpj.contains("/")){
            System.out.println("O cnpj deve estar no padrão xx.xxx.xxx/xxxx-xx");
            throw new BadRequest("O cnpj deve estar no padrão xx.xxx.xxx/xxxx-xx");
        }
    }
}
