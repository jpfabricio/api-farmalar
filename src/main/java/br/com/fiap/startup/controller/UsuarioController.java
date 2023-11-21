package br.com.fiap.startup.controller;

import br.com.fiap.startup.exception.BadRequest;
import br.com.fiap.startup.exception.NotContent;
import br.com.fiap.startup.exception.NotFound;
import br.com.fiap.startup.model.Usuario;
import br.com.fiap.startup.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listar(){
       return  usuarioRepository.findAll();
    }

    @GetMapping("{id}")
    public Usuario buscarPorId(@PathVariable int id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            throw new NotContent("Usuario não encontrado.");
        }
    }

    @GetMapping("email/{email}")
    public List<Usuario> buscarPeloEmail(@PathVariable String email) {
        return usuarioRepository.findByEmail(email);
    }

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }


    @PutMapping("{id}")
    public Usuario atualizar(@RequestBody Usuario usuario, @PathVariable int id) {
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("{id}")
    public void remover(@PathVariable int id) {
        try{
            usuarioRepository.deleteById(id);
        } catch (Exception e) {
            throw new NotFound("Não existe usuario com este id.");
        }
    }

    public void verificaCpf(String cpf){
        if (!cpf.contains(".") || !cpf.contains("-")){
            System.out.println("O cpf deve estar no padrão xxx.xxx.xxx-xx");
            throw new BadRequest("O cpf deve estar no padrão xxx.xxx.xxx-xx");
        }
    }

}