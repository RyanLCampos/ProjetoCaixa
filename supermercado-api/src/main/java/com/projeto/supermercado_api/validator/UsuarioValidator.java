package com.projeto.supermercado_api.validator;

import com.projeto.supermercado_api.exceptions.RegistroDuplicadoException;
import com.projeto.supermercado_api.model.Usuario;
import com.projeto.supermercado_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsuarioValidator {

    private final UsuarioRepository usuarioRepository;

    public void validar(Usuario usuario){
        if(existeUsuarioComEmail(usuario)){
            throw new RegistroDuplicadoException("E-mail já cadastrado!");
        }
    }

    private boolean existeUsuarioComEmail(Usuario usuario) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(usuario.getEmail());

        if(usuario.getId() == null){
            return optionalUsuario.isPresent();
        }

        return optionalUsuario
                .map(Usuario::getId)
                .filter(id -> !id.equals(usuario.getId()))
                .isPresent();

    }

}
