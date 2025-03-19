package com.projeto.supermercado_api.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(name = "Usuario")
public record UsuarioDTO(
        @NotBlank(message = "campo obrigatório")
        String nome,
        @Email(message = "inválido")
        @NotBlank(message = "campo obrigatório")
        String email,
        @NotBlank(message = "campo obrigatório")
        String senha

) {
}
