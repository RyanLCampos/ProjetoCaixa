package com.projeto.supermercado_api.controller;

import com.projeto.supermercado_api.controller.dto.UsuarioDTO;
import com.projeto.supermercado_api.controller.mappers.UsuarioMapper;
import com.projeto.supermercado_api.model.Usuario;
import com.projeto.supermercado_api.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
@Tag(name = "Usuarios")
public class UsuarioController implements GenericController{

    private final UsuarioService usuarioService;
    private final UsuarioMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Salvar", description = "Cadastrar novo usuário.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cadastrado com sucesso."),
            @ApiResponse(responseCode = "422", description = "Erro de validação."),
            @ApiResponse(responseCode = "409", description = "Usuário já cadastrado.")
    })
    public ResponseEntity<Void> salvar(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        log.info("Cadastrando novo usuário: {}", usuarioDTO.nome());

        Usuario usuario = mapper.toEntity(usuarioDTO);

        usuarioService.salvar(usuario);

        URI location = gerarHeaderLocation(usuario.getId());

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar", description = "Deleta autor existente por ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado.")
    })
    public ResponseEntity<Void> excluirUsuario(@PathVariable String id){
        log.info("Deletando usuário de ID: {}", id);

        Optional<Usuario> usuarioOptional = usuarioService.obterPorId(UUID.fromString(id));

        if(usuarioOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Usuario usuario = usuarioOptional.get();

        usuarioService.deletar(usuario);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar", description = "Atualiza usuário existente.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado."),
            @ApiResponse(responseCode = "409", description = "Usuário já cadastrado.")
    })
    public ResponseEntity<Void> atualizar(@PathVariable("id") String id, @RequestBody @Valid UsuarioDTO usuarioDTO){
        Optional<Usuario> optionalUsuario = usuarioService.obterPorId(UUID.fromString(id));

        if(optionalUsuario.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        var usuario = optionalUsuario.get();

        usuarioService.atualizar(usuario);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter Detalhes", description = "Retorna os dados do usuário pelo ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário encontrado."),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado.")
    })
    public ResponseEntity<UsuarioDTO> obterDetalhes(@PathVariable("id") String id){
        var idUsuario = UUID.fromString(id);

        return usuarioService
                .obterPorId(idUsuario)
                .map(usuario -> {
                    UsuarioDTO dto = mapper.toDTO(usuario);
                    return ResponseEntity.ok(dto);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
