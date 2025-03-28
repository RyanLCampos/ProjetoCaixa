package com.projeto.supermercado_api.controller;

import com.projeto.supermercado_api.controller.dto.LoginRequestDTO;
import com.projeto.supermercado_api.controller.dto.ResponseDTO;
import com.projeto.supermercado_api.controller.dto.UsuarioDTO;
import com.projeto.supermercado_api.controller.mappers.UsuarioMapper;
import com.projeto.supermercado_api.model.Usuario;
import com.projeto.supermercado_api.repository.UsuarioRepository;
import com.projeto.supermercado_api.security.TokenService;
import com.projeto.supermercado_api.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController implements GenericController{

    private final UsuarioService usuarioService;
    private final PasswordEncoder encoder;
    private final TokenService tokenService;
    private final UsuarioMapper mapper;

    @PostMapping("/login")
    @Operation(summary = "Autenticar Usuário", description = "Realiza o login de um usuário e retorna o token JWT")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Login realizado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Credenciais inválidas."),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado.")
    })
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginRequestDTO dto){

        log.info("Iniciando processo de login para o usuário: {}", dto.email());

        Usuario usuario = usuarioService.obterPorEmail(dto.email())
                .orElseThrow(() -> {
                    log.error("Usuário com email {} não encontrado.", dto.email());
                    return new RuntimeException("Usuário não encontrado");
                });

        if(encoder.matches(dto.senha(), usuario.getSenha())){

            log.info("Login bem-sucedido para o usuário: {}", dto.email());

            String token = tokenService.generateToken(usuario);
            return ResponseEntity.ok(new ResponseDTO(usuario.getNome(), token));
        }

        log.warn("Falha na autenticação para o usuário: {}", dto.email());
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    @Operation(summary = "Registrar Novo Usuário", description = "Cadastra um novo usuário no sistema e retorna um token JWT.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário registrado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro ao cadastrar usuário."),
            @ApiResponse(responseCode = "409", description = "Usuário já existente.")
    })
    public ResponseEntity<ResponseDTO> register(@RequestBody @Valid UsuarioDTO dto){

        log.info("Iniciando processo de cadastro para o usuário: {} {}", dto.email(), dto.nome());

        Optional<Usuario> usuarioOptional = usuarioService.obterPorEmail(dto.email());

        if(usuarioOptional.isEmpty()){

            log.info("DTO recebido para cadastro: {}", dto);

            Usuario usuario = mapper.toEntity(dto);

            log.info("Entidade convertida para cadastro: {}", usuario);

            usuarioService.salvar(usuario);

            String token = tokenService.generateToken(usuario);
            log.info("Usuário registrado com sucesso. Token gerado para o usuário: {}", dto.email());

            URI location = gerarHeaderLocation(usuario.getId());

            return ResponseEntity.created(location).body(new ResponseDTO(usuario.getNome(), token));
        }

        log.warn("Usuário com o email {} já está cadastrado.", dto.email());

        return ResponseEntity.status(409).build();
    }
}
