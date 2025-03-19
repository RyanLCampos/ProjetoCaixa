package com.projeto.supermercado_api.service;

import com.projeto.supermercado_api.model.Usuario;
import com.projeto.supermercado_api.repository.UsuarioRepository;
import com.projeto.supermercado_api.validator.UsuarioValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioValidator validator;
    private final PasswordEncoder encoder;

    public void salvar(Usuario usuario){
        validator.validar(usuario);

        var senha = usuario.getSenha();

        usuario.setSenha(encoder.encode(senha));

        usuarioRepository.save(usuario);
    }

    public Optional<Usuario> obterPorId(UUID id){
        return usuarioRepository.findById(id);
    }

    public void deletar(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    public void atualizar(Usuario usuario) {
        if(usuario.getId() == null){
            throw new IllegalArgumentException("É necessário que o usuário já esteja cadastrado.");
        }

        validator.validar(usuario);
        usuarioRepository.save(usuario);
    }
}
