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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
@Tag(name = "Usuarios")
public class UsuarioController {

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
    public void salvar(@RequestBody @Valid UsuarioDTO usuarioDTO){
        Usuario usuario = mapper.toEntity(usuarioDTO);

        usuarioService.salvar(usuario);
    }
}
