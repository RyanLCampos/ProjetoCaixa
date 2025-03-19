package com.projeto.supermercado_api.service;

import com.projeto.supermercado_api.model.Usuario;
import com.projeto.supermercado_api.repository.UsuarioRepository;
import com.projeto.supermercado_api.validator.UsuarioValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
}
