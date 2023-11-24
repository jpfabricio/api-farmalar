package br.com.fiap.startup.controller;

import br.com.fiap.startup.DTO.UsuarioLoginDTO;
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
    public Usuario buscarPeloEmail(@PathVariable String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(() -> new NotContent("Usuario não encontrado."));
    }

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario){
        verificaSeJaExiste(usuario);
        return usuarioRepository.save(usuario);
    }

    @PostMapping("login")
    public void login(@RequestBody UsuarioLoginDTO usuarioLoginDTO){
        Usuario usuario = usuarioRepository.findByEmail(usuarioLoginDTO.getEmail())
                .orElseThrow(() -> new NotContent("Usuario não encontrado."));
        if (!usuarioLoginDTO.getSenha().equals(usuario.getSenha())){
            throw new BadRequest("Senha incorreta.");
        }

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

    private void verificaSeJaExiste(Usuario usuario){
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()){
            throw new BadRequest("Usuario ja cadastrado");
        }
    }

}